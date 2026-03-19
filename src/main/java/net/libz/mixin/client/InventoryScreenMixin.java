package net.libz.mixin.client;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.libz.api.Tab;
import net.libz.util.DrawTabHelper;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends HandledScreen<PlayerScreenHandler> implements Tab {

    public InventoryScreenMixin(PlayerScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }


    @Inject(method = "drawBackground", at = @At("TAIL"))
    protected void drawBackgroundMixin(DrawContext context, float delta, int mouseX, int mouseY, CallbackInfo info) {
        DrawTabHelper.drawTab(client, context, this, x, y, mouseX, mouseY);
    }
}
