
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hikmat
 */
public class NewClass {
    
    public static void main(String [] args) throws FileNotFoundException, CloneNotSupportedException
    {
        RGBPuzzle Init = new RGBPuzzle("INP.txt");
        RGBPuzzle Goal = new RGBPuzzle("GOAL.txt");
        BFS BFSRUNNER = new BFS(new State(Init),new State(Goal));
        BFSRUNNER.performBFS();
        //DFS DFSRUNNER = new DFS(new State(Init),new State(Goal));
        //DFSRUNNER.performDFS();
        
        
    }
    
}
