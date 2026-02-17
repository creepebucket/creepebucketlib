package org.creepebucket.creepebucketlib.lib.widgets;

import net.minecraft.client.gui.GuiGraphics;
import org.creepebucket.creepebucketlib.lib.api.Coordinate;
import org.creepebucket.creepebucketlib.lib.api.Widget;
import org.creepebucket.creepebucketlib.lib.api.widgets.Renderable;

public class RectangleWidget extends Widget implements Renderable {

    public RectangleWidget(Coordinate pos, Coordinate size) {
        super(pos, size);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        graphics.fill(left(), top(), right(), bottom(), mainColor());
    }
}
