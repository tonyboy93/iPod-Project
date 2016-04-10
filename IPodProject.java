package ipodproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class IPodProject { //Start of Class
    static NewShape[] type = new NewShape[1];

 public static void main(String[] args)
   { //Start of Main
       type[0] = new RectangleDraw(0,0,377,629); 
       
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               iPodFrame frame = new iPodFrame(type);
               frame.setTitle("iPod Classic v0.1");
               frame.getContentPane().setBackground(Color.GRAY);
               frame.setSize(390,668);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   } //End of Main
} //End of Class

class iPodFrame extends JFrame
{//Start of iPodFrame
    public iPodFrame(NewShape[] shps)
    {
    
    add(new iPodComponent(shps));
    pack();
    }

    class iPodComponent extends JComponent
{//Start of iPodComponent
    Image image1 = null;
    NewShape[] theShapes;
    NewShape curr;
    
    public iPodComponent(NewShape[] shps)
    {//Constructor
        image1 = new ImageIcon("iPod.png").getImage();
        theShapes = shps;
        curr = null;
        addMouseListener(new MouseHandler());
    }//End of Constructor
    
    public NewShape find(Point2D p){
       Rectangle2D bb; 
       for (NewShape d: theShapes){
           bb = new Rectangle2D.Double(d.x, d.y, d.xsize, d.ysize);
           if (bb.contains(p)) 
               return d;
       }
       return null;
   }
    
    private class MouseHandler extends MouseAdapter
    {
        private Player player;
        public void mouseClicked(MouseEvent event)
        {
            curr = find(event.getPoint());
            if (curr != null){
                //JOptionPane.showMessageDialog(null, "You just clicked the iPod",null,JOptionPane.WARNING_MESSAGE);
                Object[] possibilities = {"What is Love","Never Gonna Give You Up","Don't Stop Till You Get Enough"};
                String s = (String)JOptionPane.showInputDialog(null,"What song would you like to play?:","Song List",JOptionPane.PLAIN_MESSAGE,null,possibilities,"What is Love");
//                if(s.equals("What is Love")){
//                   try{
//                       player = Manager.createPlayer(new URL(getCodeBase(),"Rick.wav"));
//                       player.addControllerListener(this);
//                       player.start();
//                   }
//                   catch(Exception ex){
//                       ex.printStackTrace();
//                   }
//                }
//                else if(s.equals("Never Gonna Give You Up")){
//                       
//                }
//                else if(s.equals("Don't Stop Till You Get Enough")){
//                   
//                }
            }
        }
    }
    
    public void paintComponent(Graphics g)
   {//Start of PaintComponent
      Graphics2D g2 = (Graphics2D) g;
      double cw = this.getWidth();
      double ch = this.getHeight();
      double cx = this.getX();
      double cy = this.getY();
      NewShape sh;
      int n = theShapes.length;
      
      for(int i = 0; i < n; i++){
          sh = theShapes[i];
          sh.Fill(g2);
      } 
      
      if (image1 != null)
          g.drawImage(image1,(int)(0),(int)(0),null);
   }//End of PaintComponent
    
}//End of iPodComponent
}//End of iPodFrame

class iPodPanel extends JPanel
{//Start of iPodPanel
   private JButton display;

   public iPodPanel()
   {
      setLayout(new BorderLayout());
      
      Border etched = BorderFactory.createEtchedBorder();
      Border titled = BorderFactory.createTitledBorder(etched, "Menu");
      display.setBorder(titled);
      // add some controls here 
      add(display,BorderLayout.SOUTH);
   }
   
   class ControlPanel extends JPanel{
       
       JButton menu;
       JButton playp;
       
       public ControlPanel(){
           
           menu = new JButton("Menu");
           menu.setEnabled(true);
           add(menu);
           
           playp = new JButton("Play/Pause");
           playp.setEnabled(true);
           add(playp);
       }
   }//End of iPodPanel
}