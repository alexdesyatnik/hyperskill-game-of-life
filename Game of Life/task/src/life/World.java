package life;

import java.util.Random;

class World {
    final int size;
    int[][] world;
    int aliveCount = 0;
    int currentGeneration = 1;

    World(int size) {
        this.size = size;
        world = new int[size][size];
    }

    void populate() {
        var rnd = new Random();
        aliveCount = 0;
        currentGeneration = 1;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                world[x][y] = rnd.nextBoolean() ? 1 : 0;
                aliveCount += world[x][y];
            }
        }
    }

    void nextGeneration() {
        var nextWorld = new int[size][size];
        int nextAlive = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                // Relative coordinates of neighbors from the top left one
                final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
                final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
                int neighbors = 0;
                // sum all neighbors clockwise starting from the top left
                for (int i = 0; i < dx.length; i++) {
                    neighbors += world
                            [(x + dx[i] + size) % size]
                            [(y + dy[i] + size) % size];
                }
                // All cells in the next world are dead by default,
                // so only copy the ones which survived or were born
                if ((world[x][y] == 1 && neighbors >= 2 && neighbors <= 3)
                        || (world[x][y] == 0 && neighbors == 3)) {
                    nextWorld[x][y] = 1;
                    nextAlive++;
                }
            }
        }
        world = nextWorld;
        aliveCount = nextAlive;
        currentGeneration++;
    }
}
