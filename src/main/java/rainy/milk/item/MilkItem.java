package rainy.milk.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import rainy.milk.Data.DataComponets;

public class MilkItem extends Item {
     public MilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        String entityName = stack.get(DataComponets.SOURCE_ENTITY);
        if (entityName != null) {
            return Text.translatable("item.milk.milk", entityName);
        }
        return super.getName(stack);
    }
}