package life;

class GameOfLifeController extends Thread {

    private final GameOfLife window;

    public GameOfLifeController(GameOfLife window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            if (!window.isPaused) {
                window.world.nextGeneration();
                window.updateLabels();
                window.worldView.repaint();
            }
            try {
                int sleepTime = (10 - window.speed) * 100;
                sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
