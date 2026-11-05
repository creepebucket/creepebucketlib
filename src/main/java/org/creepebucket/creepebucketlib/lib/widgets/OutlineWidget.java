package org.creepebucket.creepebucketlib.lib.widgets;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.creepebucket.creepebucketlib.lib.api.Coordinate;
import org.creepebucket.creepebucketlib.lib.api.Widget;
import org.creepebucket.creepebucketlib.lib.api.widgets.Renderable;

public class OutlineWidget extends Widget implements Renderable {
    public OutlineWidget(Coordinate pos, Coordinate size) {
        super(pos, size);
    }

    @Override
    public void render(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        graphics.outline(x(), y(), w(), h(), mainColorInt());
    }
}
