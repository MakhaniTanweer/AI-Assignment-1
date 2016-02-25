/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hikmat
 */
public class State {
    private RGBPuzzle puzzle;
    private State parent;
    private String move;

    public State(RGBPuzzle puzzle, State parent, String move) {
        this.puzzle = puzzle;
        this.parent = parent;
        this.move = move;
    }
    
    public String getMove()
    {
        return move;
    }
    
    public State getParent()
    {
        return this.parent;
    }
    
    @Override
    public State clone()
    {
        return new State(puzzle, parent, move);
    }
    public State(RGBPuzzle puzz) {
        puzzle = puzz;
        move = "N";
        parent = null;
    }
    
    
    public RGBPuzzle getPuzzle()
    {
        return puzzle;
    }
    
    public State[] generateSuccessors() 
    {
        RGBPuzzle temp = puzzle;
        int idx = 0;
        State [] arr = new State[4];
        
        if(temp.Up())
        {
            arr[idx++] = new State(new RGBPuzzle(temp.getBoxes()));
            arr[idx-1].parent = this;
            arr[idx-1].move = "U";
           temp.Down();
        }
        
        if(temp.Down())
        {
            arr[idx++] = new State(new RGBPuzzle(temp.getBoxes()));
            arr[idx-1].parent = this;
            arr[idx-1].move = "D";
            temp.Up();
        }
        
        
        if(temp.Left())
        {
            arr[idx++] = new State(new RGBPuzzle(temp.getBoxes()));
            arr[idx-1].parent = this;
            arr[idx-1].move = "L";
            temp.Right();
        }
        
        
        if(temp.Right())
        {
            arr[idx++] = new State(new RGBPuzzle(temp.getBoxes()));
            arr[idx-1].parent = this;
            arr[idx-1].move = "R";
            temp.Left();
        }
        return arr;
    }
}
