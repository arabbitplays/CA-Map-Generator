package Util;

import Model.Tile;

import java.awt.*;

public class ColorUtil {
    private ColorUtil() {}

    public static Color getColorOfTile(Tile tile) {
        if (tile == null)
            return Color.BLACK;

        if (tile.isWater()) {
            return tile.isDeap() ? new Color(0, 0, 100) : new Color(0, 0, 250);
        }

        switch(tile.getTemperature()) {
            case WARM -> { return Color.RED; }
            case COLD -> { return Color.ORANGE; }
            case FREEZING -> { return Color.WHITE; }
            default -> { return Color.GREEN; }
        }
    }
}
