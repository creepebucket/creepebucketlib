package org.creepebucket.creepebucketlib.lib.widgets;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.creepebucket.creepebucketlib.lib.api.Coordinate;
import org.creepebucket.creepebucketlib.lib.api.Widget;

public class CullAreaWidget extends Widget {
    public CullAreaWidget(Coordinate pos, Coordinate size) {
        super(pos, size);
    }

    @Override
    public void renderWidget(GuiGraphicsExtractor graphics, int mx, int my, float partialTick, double dt, boolean isForeground) {
        graphics.enableScissor(left(), top(), right(), bottom());
        super.renderWidget(graphics, mx, my, partialTick, dt, isForeground);
        graphics.disableScissor();
    }
}
