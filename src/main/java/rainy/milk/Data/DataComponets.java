package rainy.milk.Data;

import com.mojang.serialization.Codec;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.milk.Milk;

public class DataComponets {

    public static final ComponentType<String> SOURCE_ENTITY = Registry.register(
            Registries.DATA_COMPONENT_TYPE, Identifier.of("milk", "source_entity"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
    public static void registerData() {}

}
