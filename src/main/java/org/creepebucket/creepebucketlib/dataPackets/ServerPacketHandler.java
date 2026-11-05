package org.creepebucket.creepebucketlib.dataPackets;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.creepebucket.creepebucketlib.lib.ui.Menu;

public class ServerPacketHandler {
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
