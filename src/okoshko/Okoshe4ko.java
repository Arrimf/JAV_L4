package okoshko;
import com.sun.prism.*;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

public class Okoshe4ko extends JFrame{
    //private JPanel PicPanel;
    //private Container contentPane;
    public Okoshe4ko() {
        super("Okoshe4ko");
        Container contentPane = getContentPane();

        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int x=screenSize.width;
        int y=screenSize.height;
        setLocation(x/4,y/4);
        setSize (x/2,y/2);


        PicPanel  Kartinka = new PicPanel();
        Kartinka.setBackground(SystemColor.desktop);

        ButtPanel Knopo4ki = new ButtPanel();
        Knopo4ki.but1.addActionListener(Kartinka);
        Knopo4ki.but2.addActionListener(Kartinka);
        Knopo4ki.but3.addActionListener(Kartinka);
        Knopo4ki.but4.addActionListener(Kartinka);
        Knopo4ki.but10.addActionListener(Kartinka);
        Knopo4ki.but11.addActionListener(Kartinka);

        contentPane.setLayout(new BorderLayout());
        contentPane.add(Kartinka,BorderLayout.CENTER);
        contentPane.add(Knopo4ki,BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class PicPanel extends JPanel implements ActionListener{

    private Line2D Liniya ;
    private double theta = 0;

    public PicPanel(){
        Liniya = new Line2D.Double();

    }


    public void paintComponent(Graphics g)   {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int x1 = (int)(getWidth()/4 + Liniya.getX1());
        int y1 = (int)(getHeight()/4 + Liniya.getY1());
        int x2 = (int)(getWidth()/4*3 + Liniya.getX2());
        int y2 = (int)(getHeight()/4*3 + Liniya.getY2());

        g2d.setColor(Color.BLACK);
        g2d.rotate(theta,(x1+x2)/2,(y1+y2)/2);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x1,y1,x2,y2);


//        Circle cent =
//                new Circle((int)(Liniya.getX1()+Liniya.getX2())/2,(int)(Liniya.getY1()+Liniya.getY2())/2,1);
//        g2d.setColor(Color.YELLOW);
//        g2d.setStroke(new BasicStroke(15));
//        g2d.draw(cent);
    }

    public void actionPerformed (ActionEvent event){
        switch (event.getActionCommand()){
            case "rght":
                Liniya.setLine(Liniya.getX1()+10,Liniya.getY1(),Liniya.getX2()+10,Liniya.getY2());
                break;
            case "left":
                Liniya.setLine(Liniya.getX1()-10,Liniya.getY1(),Liniya.getX2()-10,Liniya.getY2());
                break;
            case "doun":
                Liniya.setLine(Liniya.getX1(),Liniya.getY1()+10,Liniya.getX2(),Liniya.getY2()+10);
                break;
            case "up":
                Liniya.setLine(Liniya.getX1(),Liniya.getY1()-10,Liniya.getX2(),Liniya.getY2()-10);
                break;
            case "rot":
                //AffineTransform.(Liniya);
                theta += 0.08;
                break;
            case "rot-":
                theta -= 0.08;
                break;
        }
        repaint();
    }
}
class ButtPanel extends JPanel{
    public JButton but1 = new JButton("rght");
    public JButton but2 = new JButton("left");
    public JButton but3 = new JButton("up");
    public JButton but4 = new JButton("doun");
    public JButton but10 = new JButton("rot");
    public JButton but11 = new JButton("rot-");
    public ButtPanel(){
       this.add(but1);
       this.add(but2);
       this.add(but3);
       this.add(but4);
       this.add(but10);
       this.add(but11);
   }
}