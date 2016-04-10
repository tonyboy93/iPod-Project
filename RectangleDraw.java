package ipodproject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectangleDraw extends NewShape {
    
    public RectangleDraw(double xpoint, double ypoint, double xSize, double ySize){
        super(xpoint, ypoint, xSize, ySize);
    }
    
     public void Fill(Graphics g){
         Graphics2D g2 = (Graphics2D)g;
         Rectangle2D rect = new Rectangle2D.Double();
         rect.setFrame(x, y, xsize, ysize);
         g2.setPaint(Color.GRAY); //make outline of rectangle
         g2.draw(rect);
         g2.fill(rect);
     }
    
}
