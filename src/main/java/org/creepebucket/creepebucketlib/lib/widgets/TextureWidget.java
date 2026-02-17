package org.creepebucket.creepebucketlib.lib.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import org.creepebucket.creepebucketlib.lib.api.Coordinate;
import org.creepebucket.creepebucketlib.lib.api.Widget;
import org.creepebucket.creepebucketlib.lib.api.widgets.Renderable;

/**
 * 纹理控件：在指定坐标绘制一张 GUI 纹理。
 */
public class TextureWidget extends Widget implements Renderable {
    /**
     * 纹理资源标识
     */
    public final Identifier texture;

    /**
     * 创建一个纹理控件。
     */
    public TextureWidget(Coordinate pos, Identifier texture, Coordinate size) {
        super(pos, size);
        this.texture = texture;
    }

    /**
     * 按当前坐标渲染纹理。
     */
    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, texture, x(), y(), 0, 0, w(), h(), w(), h(), w(), h(), mainColor());
    }
}
