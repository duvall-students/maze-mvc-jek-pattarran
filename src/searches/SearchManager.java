package searches;

import application.Maze;
import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class SearchManager {

	/*
	 * SEARCH MANAGER CLASS - selects a search algorithm, given a search title
	 * 
	 */
	
    public Search executeSearch(String title, Maze maze, Point start, Point goal) {
       
    	if (title.equals("BFS")) {
    		return new BFS(maze, start, goal);
    	}
    	if (title.equals("DFS")) {
    		return new DFS(maze, start, goal);
    	}
    	if (title.equals("Greedy")) {
    		return new Greedy(maze, start, goal);
    	}
    	if (title.equals("Magic")) {
    		return new Magic(maze, start, goal);
    	}
    	return new RandomWalk(maze, start, goal); 
    }
}