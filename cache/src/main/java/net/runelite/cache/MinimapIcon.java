package net.runelite.cache;

import net.runelite.cache.region.Position;

public class MinimapIcon {
    Position position;
    int spriteId;

    public MinimapIcon(Position position, int spriteId) {
        this.position = position;
        this.spriteId = spriteId;
    }
}
