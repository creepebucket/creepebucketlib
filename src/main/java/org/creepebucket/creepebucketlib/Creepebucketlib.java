package org.creepebucket.creepebucketlib;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.creepebucket.creepebucketlib.registries.ModNetworkPackets;
import org.slf4j.Logger;

@Mod(Creepebucketlib.MODID)
public class Creepebucketlib {
    public static final String MODID = "creepebucketlib";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Creepebucketlib(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(ModNetworkPackets::registerPayloadHandlers);
        LOGGER.info("creepebucketlib_loaded");
    }
}
