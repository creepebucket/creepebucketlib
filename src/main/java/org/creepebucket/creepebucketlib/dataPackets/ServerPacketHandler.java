package org.creepebucket.creepebucketlib.dataPackets;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.creepebucket.creepebucketlib.lib.ui.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerPacketHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("ProgrammableMagic:ServerPacketHandler");

    public static void handleWandMenuKV(final SimpleKvPacket packet, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof SimpleKvC2SHandler handler) {
                handler.handleSimpleKvC2S(packet.key(), packet.value());
            }
        });
    }

    public static void handleHookTrigger(final HookTriggerPacket packet, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof Menu menu) {
                menu.hooks.handleOnServer(packet.hookId(), context.player(), packet.args());
            }
        });
    }
} 
