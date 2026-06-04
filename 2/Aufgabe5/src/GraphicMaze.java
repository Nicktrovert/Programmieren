import javax.swing.*;
import java.awt.*;

public class GraphicMaze extends JFrame {
    private Graphic g;
    private Maze m;

    public GraphicMaze(int width, int height) {
        g = new Graphic(width, height);
        add(g);
    }

    public void drawMaze(){
        int cell_size = g.width / m.maze.length;

        for (int i = 0; i < m.maze.length; i++){
            for (int j = 0; j < m.maze[i].length; j++){
                char x = m.maze[i][j];
                if (x == '#'){
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * cell_size, i*cell_size, cell_size+4, cell_size+4);
            }
        }

        for (Point p : this.m.solution){
            g.setColor(Color.BLUE);
            g.fillOval(2+p.x * cell_size + cell_size/4, 2+p.y * cell_size + cell_size/4, cell_size/2, cell_size/2);
        }

        g.redraw();
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

        frame.m = new Maze(mazeData);
        frame.m.canExit(0, 1);

        frame.drawMaze();
    }
}
