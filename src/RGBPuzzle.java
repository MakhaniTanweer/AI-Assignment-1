
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hikmat
 */
public class RGBPuzzle {
    private ArrayList<String> Boxes = new ArrayList<>(25);
    
    
    public RGBPuzzle(ArrayList<String> Input)
    {
        Boxes = (ArrayList<String>) Input.clone();
    }
    public boolean equals(RGBPuzzle R)
    {
        return Boxes.equals(R.Boxes);
    }
    public RGBPuzzle(String filePath) throws FileNotFoundException
    {
        String [] str;
        int idx = -1;
        Scanner Scan = new Scanner(new File(filePath));
        while(Scan.hasNext())
        {
            str = Scan.nextLine().split(" ");
            for (String st : str)
            {
                Boxes.add(++idx, st);
            }
        }
    }
    
    public void printRGB()
    {
        int count = -1;
        for (String str : Boxes)
        {
            ++count;
            System.out.print(str+" ");
            
            if((count+1) % 5 == 0 && count != 0)
            { 
                System.out.println("");
            }
        }
    }
    
    public ArrayList getBoxes()
    {
        return Boxes;
    }
    
    public int getX(int pos)
    {
        return pos % 5;
    }
    
    public int getY(int pos)
    {
        return pos / 5;
    }
    
    public int convertToOneD(int x,int y)
    {
        return y*5 + x;
    }
    
    public int searchBlank()
    {
        int count = -1;
        for (String X : Boxes)
        {
            ++count;
            if("B".equals(X))
                return count;
        }
        //this wont happen if the given input is always valid
        return -1;
    }
   
    
    //check for legality should be done first
    
    
    public void changePosBlank(int oldpos,int newpos)
    {
        String temp = Boxes.get(newpos);
        Boxes.set(newpos,"B");
        Boxes.set(oldpos,temp);
    }
    
    public boolean Up()
    {
        int pos = searchBlank();
        int Y = getY(pos);
        
        if (Y >0)
            Y--;
        else
            return false;
        
        int newpos = convertToOneD(getX(pos),Y);
        changePosBlank(pos, newpos);
        
        return true;
    }
    
    public boolean Down()
    {
        int pos = searchBlank();
        int Y = getY(pos);
        
        if (Y <4)
            Y++;
        else
            return false;
        
        int newpos = convertToOneD(getX(pos),Y);
        changePosBlank(pos, newpos);
        
        return true;
    }
 
    public boolean Left()
    {
        int pos = searchBlank();
        int X = getX(pos);
        
        if (X >0)
            X--;
        else
            return false;
        
        int newpos = convertToOneD(X,getY(pos));
        changePosBlank(pos, newpos);
        
        return true;
    }
    
    public boolean Right()
    {
        int pos = searchBlank();
        int X = getX(pos);
        
        if (X <4)
            X++;
        else
            return false;
        
        int newpos = convertToOneD(X,getY(pos));
        changePosBlank(pos, newpos);
        
        return true;
    }
}
