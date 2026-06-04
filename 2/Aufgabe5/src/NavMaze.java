import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NavMaze extends JFrame {
    private Graphic g;
    private Maze m;

    private int currentStep = 0;

    private JButton nextButton;
    private JButton prevButton;

    public NavMaze(int width, int height) {
        setLayout(new BorderLayout());

        g = new Graphic(width, height);

        add(g, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        prevButton = new JButton("Zurück");

        prevButton.addActionListener(e -> {
            if (currentStep > 0){
                currentStep--;
                redrawScene();
            }
        });

        nextButton = new JButton("Vor");

        nextButton.addActionListener(e -> {
            if (currentStep < m.solution.size()-1){
                currentStep++;
                redrawScene();
            }
        });

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void redrawScene(){
        g.clear();
        g.drawMaze(g, m);
        g.drawSolution(g, m, currentStep);
    }

    public static void main(String[] args){
        NavMaze frame = new NavMaze(500, 500);

        frame.setTitle("NavMaze");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        char[][] mazeData = {
                {'#', ' ', '#', ' ', ' ', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        frame.m = frame.g.SolveMaze(mazeData, new Point(1, 0));

        frame.redrawScene();
    }
}
