package ipodproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class NewShape {
    protected double x;
    protected double y;
    protected double xsize;
    protected double ysize;
    
    public NewShape(double xpoint, double ypoint, double xSize, double ySize){
        x = xpoint;
        y = ypoint;
        xsize = xSize;
        ysize = ySize;
    }
    
    abstract void Fill(Graphics g); 
}

