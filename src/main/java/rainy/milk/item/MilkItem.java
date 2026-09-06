package rainy.milk.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import rainy.milk.Data.DataComponets;

import java.util.List;

public class MilkItem extends Item {
     public MilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        String entityName = stack.get(DataComponets.SOURCE_ENTITY);
        if (entityName != null) {
                return Text.literal(entityName + "'s ")
                        .formatted(Formatting.GOLD, Formatting.BOLD)
                        .append(Text.literal("Special Milk ")
                                .formatted(Formatting.LIGHT_PURPLE, Formatting.ITALIC))
                        .append(Text.literal("Yummy!")
                                .formatted(Formatting.AQUA, Formatting.BOLD));
            }
            return super.getName(stack);
        }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        String entityName = stack.get(DataComponets.SOURCE_ENTITY);

        if (Screen.hasShiftDown()) {

            if (entityName != null) {
                tooltip.add(Text.literal("Freshly milked from " + entityName)
                        .formatted(Formatting.AQUA, Formatting.ITALIC));
            }
            tooltip.add(Text.literal("A rare delicacy, blessed by Rainy Himself.")
                    .formatted(Formatting.GOLD, Formatting.BOLD));
        } else {
            tooltip.add(Text.literal("Hold ")
                    .formatted(Formatting.GRAY)
                    .append(Text.literal("[Shift]").formatted(Formatting.YELLOW, Formatting.BOLD))
                            .append(Text.literal("for more info").formatted(Formatting.GRAY)));
        }
    }
}