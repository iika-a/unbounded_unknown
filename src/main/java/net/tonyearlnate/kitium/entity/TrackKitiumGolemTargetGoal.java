package net.tonyearlnate.kitium.entity;

import java.util.EnumSet;
import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import org.jetbrains.annotations.Nullable;

public class TrackKitiumGolemTargetGoal extends TrackTargetGoal {
    private final KitiumGolemEntity golem;
    @Nullable
    private LivingEntity target;
    private final TargetPredicate targetPredicate = TargetPredicate.createAttackable().setBaseMaxDistance(64.0);

    public TrackKitiumGolemTargetGoal(KitiumGolemEntity golem) {
        super(golem, false, true);
        this.golem = golem;
        this.setControls(EnumSet.of(Goal.Control.TARGET));
    }

    @Override
    public boolean canStart() {
        Box box = this.golem.getBoundingBox().expand(10.0, 8.0, 10.0);
        ServerWorld serverWorld = getServerWorld(this.golem);
        List<? extends LivingEntity> list = serverWorld.getTargets(VillagerEntity.class, this.targetPredicate, this.golem, box);
        List<PlayerEntity> list2 = serverWorld.getPlayers(this.targetPredicate, this.golem, box);

        for (LivingEntity livingEntity : list) {
            VillagerEntity villagerEntity = (VillagerEntity)livingEntity;

            for (PlayerEntity playerEntity : list2) {
                int i = villagerEntity.getReputation(playerEntity);
                if (i <= -100) {
                    this.target = playerEntity;
                }
            }
        }

        return this.target == null ? false : !(this.target instanceof PlayerEntity) || !this.target.isSpectator() && !((PlayerEntity)this.target).isCreative();
    }

    @Override
    public void start() {
        this.golem.setTarget(this.target);
        super.start();
    }
}
