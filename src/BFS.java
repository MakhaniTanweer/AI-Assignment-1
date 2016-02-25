
import com.sun.org.apache.xml.internal.security.transforms.params.XPath2FilterContainer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hikmat
 */
public class BFS {
    
    Queue<State> Frontier = new LinkedList();
    State InitialState = null;
    ArrayList<State> Visited = new ArrayList();
    State GoalState = null;
    
    public BFS (State Init,State Goal)
    {
        InitialState = Init;
        Frontier.add(Init);
        GoalState = Goal;
    }
    
    public void performBFS() throws CloneNotSupportedException
    {
        boolean flag = false;
        State [] arr = null; 
        while(!Frontier.isEmpty() && !flag)
        {
            State temp = Frontier.remove();
            Visited.add(temp.clone());
            arr = temp.generateSuccessors();
            for (State S : arr)
            {
                if(S == null)
                    continue;
                
                boolean flag_int = true;
                for(int i = 0;i<Visited.size();i++)
                {
                    if(Visited.get(i).getPuzzle().equals(S.getPuzzle()))
                        flag_int = false;
                }
                if(flag_int)
                {
                    S.getPuzzle().printRGB();
                    //S.getPuzzle().printRGB();
                    //System.out.println("sadfsa");
                    //GoalState.getPuzzle().printRGB();
                    if(S.getPuzzle().equals(GoalState.getPuzzle()))
                    {
                        flag = true;
                        Visited.add(S);
                        Stack st =  TrackSteps();
                        st.pop();
                        while(!st.isEmpty())
                        {
                            System.out.println(""+st.pop());
                        }
                        break;
                    }
                    else
                    {
                        Frontier.add(S);
                    }
                }
            }
        }
        
        
    }
    
    public Stack TrackSteps()
    {
        State Last = Visited.get(Visited.size()-1);
        Stack<String> Moves = new Stack<>();
        while(Last != null)
        {
            Moves.push(Last.getMove());
            Last = Last.getParent();
        }
        return Moves;
    }
    
}
