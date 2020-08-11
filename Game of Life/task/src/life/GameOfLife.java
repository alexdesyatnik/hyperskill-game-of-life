package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private final JToggleButton playToggleButton;
    private final JButton resetButton;
    private final JSlider speedSlider;

    WorldView worldView;
    World world;

    boolean isPaused = false;
    int speed;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);

        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");

        playToggleButton = new JToggleButton("Pause");
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.addActionListener((event) -> {
            isPaused = !isPaused;
            System.out.println(isPaused);
        });

        resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener((event) -> {
            world.populate();
            updateLabels();
            worldView.repaint();
        });

        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speed = speedSlider.getValue();
        speedSlider.addChangeListener((event) -> speed = speedSlider.getValue());

        world = new World(50);
        world.populate();
        worldView = new WorldView(world);
        updateLabels();

        add(generationLabel);
        add(aliveLabel);
        add(playToggleButton);
        add(resetButton);
        add(speedSlider);

        add(worldView);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void updateLabels() {
        generationLabel.setText(String.format("Generation #%d", world.currentGeneration));
        aliveLabel.setText((String.format("Alive: %d", world.aliveCount)));
    }
}
