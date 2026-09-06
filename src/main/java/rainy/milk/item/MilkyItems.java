package rainy.milk.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.milk.Milk;

public class MilkyItems {

    public static final Item MILKER = registerItem("milker", new MilkerAbility(new Item.Settings()));

    public static final Item MILK = registerItem("milk", new MilkItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(Milk.MOD_ID, name), item);
    }





    public static void RegisterMilkyItems() {
        Milk.LOGGER.info("Registering MilkyItems for " + Milk.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MILKER);
            entries.add(MILK);
        });
    }
}
