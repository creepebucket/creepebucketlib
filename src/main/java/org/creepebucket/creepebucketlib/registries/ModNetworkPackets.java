package org.creepebucket.creepebucketlib.registries;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.creepebucket.creepebucketlib.dataPackets.*;

import static org.creepebucket.creepebucketlib.Creepebucketlib.MODID;

public class ModNetworkPackets {
    @SubscribeEvent
    public static void registerPayloadHandlers(final RegisterPayloadHandlersEvent event) {
        // 获取注册器，"yourmodid" 应该换成你的 Mod ID
        final PayloadRegistrar registrar = event.registrar(MODID);

        // Screen -> Menu: 传递一个键值对（k=string, v=object）
        registrar.playToServer(
                SimpleKvPacket.TYPE,
                SimpleKvPacket.STREAM_CODEC,
                ServerPacketHandler::handleWandMenuKV
        );

        registrar.playToServer(
                HookTriggerPacket.TYPE,
                HookTriggerPacket.STREAM_CODEC,
                ServerPacketHandler::handleHookTrigger
        );

        registrar.playToClient(
                SimpleKvS2cPacket.TYPE,
                SimpleKvS2cPacket.STREAM_CODEC,
                ClientPacketHandler::handleSimpleKvS2C
        );

        // 如果你还有其他数据包，可以在这里继续注册...
        // registrar.playToClient(...); // 注册从服务端到客户端的数据包
        // registrar.playBidirectional(...); // 注册双向数据包
    }
}
