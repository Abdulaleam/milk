package rainy.milk.item;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import rainy.milk.Data.DataComponets;
import rainy.milk.Data.MilkedState;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MilkerAbility extends Item {

    private static final Map<LivingEntity, Long> tracked = new HashMap<>();

    public MilkerAbility(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getWorld().isClient) {
            return ActionResult.SUCCESS;
        }

        ItemStack milkStack = new ItemStack(MilkyItems.MILK);
        milkStack.set(DataComponets.SOURCE_ENTITY, entity.getName().getString());

        if (!user.getInventory().insertStack(milkStack)) {
            user.dropItem(milkStack, false);
        }

        entity.setAttached(MilkedState.MILKED,true);
        long endTick = entity.getWorld().getTime() + 100;
        tracked.put(entity, endTick);

        return ActionResult.SUCCESS;
    }

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            long currentTick = world.getTime();
            Iterator<Map.Entry<LivingEntity, Long>> it = tracked.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<LivingEntity, Long> entry = it.next();
                LivingEntity entity = entry.getKey();
                if (currentTick >= entry.getValue()) {
                    it.remove();
                    continue;
                }

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.HEART,
                        entity.getX(), entity.getBodyY(0.6), entity.getZ(),
                        3, 0.3, 0.3, 0.3, 0.01
                );

            }
        });
    }
}