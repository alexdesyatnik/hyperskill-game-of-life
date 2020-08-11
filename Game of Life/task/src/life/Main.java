package life;

public class Main {
    public static void main(String[] args) {
        var gameOfLife = new GameOfLife();
        var gameOfLifeController = new GameOfLifeController(gameOfLife);
        gameOfLifeController.run();
    }
}
