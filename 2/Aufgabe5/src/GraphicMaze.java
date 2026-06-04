import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicMaze extends JFrame {
    private Graphic graphic;
    private Maze maze;

    public GraphicMaze(int width, int height) {
        graphic = new Graphic(width, height);
        add(graphic);
    }

    public void drawMaze(){
        int cell_size = 30;

        for (Point p : this.maze.floor){
            graphic.setColor(Color.WHITE);
            graphic.fillRect(p.x * cell_size, p.y * cell_size, cell_size, cell_size);
        }

        for (Point p : this.maze.walls){
            graphic.setColor(Color.BLACK);
            graphic.fillRect(p.x * cell_size, p.y * cell_size, cell_size, cell_size);
        }

        for (Point p : this.maze.solution){
            graphic.setColor(Color.BLUE);
            graphic.fillOval(p.x * cell_size, p.y * cell_size, cell_size, cell_size);
        }

        graphic.redraw();
    }

    public static void main(String[] args){
        GraphicMaze frame = new GraphicMaze(500, 500);

        frame.setTitle("GraphicMaze");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        char[][] mazeData = {
                {' ', '#', ' ', ' '},
                {' ', '#', ' ', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', ' ', ' '}
        };

        frame.maze = new Maze(mazeData);
        frame.maze.canExit(0, 0);

        frame.drawMaze();
    }
}
