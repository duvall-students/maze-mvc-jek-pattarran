package application;

import searches.*;

import java.awt.*;

public class MazeController {
    /*
     * Logic of the program
     */
	
    // initialize search instance variable
    private Search search;		
    
    // initialize start and end points
    private Point start;
    private Point end;

    // The maze to search
    private Maze maze;
    
    // CLASS INSTANCE VARIABLES:
    private MazeDisplay mazeDisplay;
    private SearchManager searchManager;

    public MazeController(int numRows, int numCols, MazeDisplay mazeDisplay) {
        
    	searchManager = new SearchManager();
    	
    	start = new Point(1, 1);
        end = new Point(numRows - 2, numCols - 2);
        maze = new Maze(numRows, numCols);
        
        this.mazeDisplay = mazeDisplay;
    }

    /*
     * Re-create the maze from scratch.
     * When this happens, we should also stop the search.
     */
    public void newMaze() {
        
    	maze.createMaze(maze.getNumRows(),maze.getNumCols());
    	mazeDisplay.redraw();
    }

    public int getCellState(Point position) {
        return maze.get(position);
    }

    /*
     * Does a step in the search regardless of pause status
     */
    public void doOneStep(double elapsedTime){
        
    	if (search != null) search.step();
    	mazeDisplay.redraw();
    }

    public void startSearch(String title) {
        
    	maze.reColorMaze();
        search = searchManager.executeSearch(title, maze, start, end);
    }

}