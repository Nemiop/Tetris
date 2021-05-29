package com.example.tetrisnoactivity.storage.models;
import android.graphics.Color;
import android.graphics.Point;
import com.example.tetrisnoactivity.storage.models.FieldConstants;

import java.util.Random;

public class Block {
    private int shapeIndex;
    private int frameNumber;
    private BlockColor color;
    private Point position;

    private Block(int shapeIndex, BlockColor blockColor){
        this.frameNumber = 0;
        this.shapeIndex = shapeIndex;
        this.color = blockColor;
        this.position = new Point(FieldConstants.COLUMN_COUNT.getValue()/2, 0);

    }

    public static Block createBlock() {
        Random random = new Random();
        int shapeIndex = random.nextInt(Shape.values().length);
        BlockColor blockColor = BlockColor.values()[random.nextInt(BlockColor.values().length)];

        Block block = new Block(shapeIndex, blockColor);
        block.position.x = block.position.x - Shape.values()[shapeIndex].getStartPosition();

        return block;
    }

    public enum BlockColor {
        PINK(Color.rgb(255, 105, 180), (byte)2),
        GREEN(Color.rgb(0, 128, 0), (byte)2),
        ORANGE(Color.rgb(255, 140, 0), (byte)2),
        YELLOW(Color.rgb(255, 255, 0), (byte)2),
        CYAN(Color.rgb(0, 255, 180), (byte)2);

        BlockColor(int rgbValue, byte value) {
            this.rgbValue = rgbValue;
            this.byteValue = value;
        }

        private final int rgbValue;
        private final int byteValue;
    }
}
