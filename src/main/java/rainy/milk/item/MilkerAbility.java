package rainy.milk.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import rainy.milk.Data.DataComponets;

public class MilkerAbility extends Item {
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
        return ActionResult.SUCCESS;
    }
}
