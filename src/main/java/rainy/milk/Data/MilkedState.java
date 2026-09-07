package rainy.milk.Data;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.util.Identifier;

public class MilkedState {
    public static  final AttachmentType<Boolean> MILKED = AttachmentRegistry.create(
            Identifier.of("milk", "milked"),
            builder -> builder
                    .initializer(() -> false)
                    .persistent(Codec.BOOL)
    );
}
