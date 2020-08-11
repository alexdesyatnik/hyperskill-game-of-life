package life;

import javax.swing.*;
import java.awt.*;

class WorldView extends JPanel {
    private final int CELL_SIZE = 7;
    private final int pixelSize;
    final World world;

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, pixelSize, pixelSize);
        g2d.setColor(Color.LIGHT_GRAY);
        for (int col = 0; col < world.size; col++) {
            int x = col * (CELL_SIZE + 1);
            g2d.drawLine(x, 0, x, pixelSize - 1);
            // Grid is square, so reuse coordinates for horizontal lines
            g2d.drawLine(0, x, pixelSize - 1, x);
        }
        g2d.drawLine(pixelSize - 1, 0, pixelSize - 1, pixelSize - 1);
        g2d.drawLine(0, pixelSize - 1, pixelSize - 1, pixelSize - 1);
    }

    private void drawCell(Graphics2D g2d, int row, int col) {
        int x = col * (CELL_SIZE + 1) + 1;
        int y = row * (CELL_SIZE + 1) + 1;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
    }

    private void drawCells(Graphics2D g2d) {
        for (int row = 0; row < world.size; row++) {
            for (int col = 0; col < world.size; col++) {
                if (world.world[row][col] > 0) {
                    drawCell(g2d, row, col);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
        drawCells(g2d);
    }

    public int getCurrentGeneration() {
        return world.currentGeneration;
    }

    public int getAliveCount() {
        return world.aliveCount;
    }

    public WorldView(World world) {
        this.world = world;
        // assuming 1-pixel grid between cells
        pixelSize = world.size * (CELL_SIZE + 1) + 1;
        setPreferredSize(new Dimension(pixelSize, pixelSize));
    }
}
