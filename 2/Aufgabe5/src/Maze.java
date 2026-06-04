import java.util.ArrayList;
import java.util.List;

//todo: Rewrite class for Task
public class Maze {

	char[][] maze;
	public List<Point> solution = new ArrayList<Point>();
	public List<Point> walls = new ArrayList<Point>();
	public List<Point> floor = new ArrayList<Point>();
	
	public Maze(char[][] maze) {
		this.maze = maze;
	}

	public boolean canExit(int i, int j) {
		
		int n = maze.length;
		
		if (i < 0 || j < 0 || i >= n || j >= n)
			return false;
		
		if (maze[i][j] != ' '){
			walls.add(new Point(i, j));
			return false;
		}

		maze[i][j] = '.';
		
		if ((i == n-1 && j == n-1) 
			|| canExit(i+1, j) || canExit(i, j+1)
			|| canExit(i-1, j) || canExit(i, j-1)) {
			maze[i][j] = '+';
			solution.addFirst(new Point(i, j));
			return true;
		}

		floor.add(new Point(i, j));
		
		return false;
		
	}
	
	public void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++)
				System.out.print(maze[i][j] + " ");
			System.out.println();
		}
	}

}
