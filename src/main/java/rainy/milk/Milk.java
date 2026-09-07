package rainy.milk;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rainy.milk.Data.DataComponets;
import rainy.milk.item.MilkerAbility;
import rainy.milk.item.MilkyItems;

public class Milk implements ModInitializer {
	public static final String MOD_ID = "milk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MilkyItems.RegisterMilkyItems();
		DataComponets.registerData();
		MilkerAbility.register();


	}

}
