import javax.swing.*;
import java.awt.*;

public class GraphicMaze extends JFrame {
    private Graphic g;
    private Maze m;

    public GraphicMaze(int width, int height) {
        g = new Graphic(width, height);
        add(g);
    }

    public static void main(String[] args){
        GraphicMaze frame = new GraphicMaze(500, 500);

        frame.setTitle("GraphicMaze");
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

        frame.g.drawMaze(frame.g, frame.m);
        frame.g.drawSolution(frame.g, frame.m);
    }
}
