
import javax.swing.*;
import java.awt.*;

public class NepalFlag extends JPanel {
    public void paint(Graphics g){

    /* For Left bar of Flag*/
    g.setColor(Color.BLACK);
    g.fillRect(10,20,10,400);

    /*For the outer blue polygon*/
    int x[]={20,200,100,240,20,20};
    int y[]={20,150,150,300,300,20};
    g.setColor(Color.BLUE);
    g.fillPolygon(x,y,6);

    /*For inner red polygon */
    int xx[]={30,170,75,215,30,30};
    int yy[]={40,140,140,290,290,35};
    g.setColor(Color.red);
    g.fillPolygon(xx,yy,6);

    /*for the sun shape */
    g.setColor(Color.WHITE);
    g.fillArc(50,80,40,40,0,-180);

    /*for the moon shape */
    g.fillOval(50,200,50,50);

    Font f1 = new Font("Times New Roman",Font.BOLD,30);
    g.setFont(f1);
    g.setColor(Color.BLACK);
    g.drawString("NEPALI FLAG", 150, 400);
    }


    public static void main(String [] args)
    {
        JFrame frame = new JFrame("NEPALI FLAG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NepalFlag nepal = new NepalFlag();
        frame.add(nepal);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}