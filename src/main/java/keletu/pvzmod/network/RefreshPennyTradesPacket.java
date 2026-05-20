package keletu.pvzmod.network;

import keletu.pvzmod.penny.PennyTradeMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RefreshPennyTradesPacket {
    public static void encode(RefreshPennyTradesPacket packet, FriendlyByteBuf buffer) {
    }

    public static RefreshPennyTradesPacket decode(FriendlyByteBuf buffer) {
        return new RefreshPennyTradesPacket();
    }

    public static void handle(RefreshPennyTradesPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null && player.containerMenu instanceof PennyTradeMenu menu) {
                menu.refresh(player);
            }
        });
        context.setPacketHandled(true);
    }
}
