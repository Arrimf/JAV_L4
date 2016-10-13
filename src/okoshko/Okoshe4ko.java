package okoshko;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
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
    private int Dx = 0;
    private int Dy = 0;
    private int Dw = 0;
    private int Dh = 0;
    private double theta = 0;

    public PicPanel(){
        Liniya = new Line2D.Double();

    }

    public void paintComponent(Graphics g)   {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
            int x = getWidth()/4 + Dx;
            int y = getHeight()/4 + Dy;
            int w = getWidth()/4*3 + Dw;
            int h = getHeight()/4*3 + Dh;
        Liniya.setLine(x,y,w,h);
        g2d.setColor(Color.BLACK);
        g2d.rotate(theta,(Liniya.getX1()+Liniya.getX2())/2,(Liniya.getY1()+Liniya.getY2())/2);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(Liniya);

//        Circle cent =
//                new Circle((int)(Liniya.getX1()+Liniya.getX2())/2,(int)(Liniya.getY1()+Liniya.getY2())/2,1);
//        g2d.setColor(Color.YELLOW);
//        g2d.setStroke(new BasicStroke(15));
//        g2d.draw(cent);
    }

    public void actionPerformed (ActionEvent event){
        switch (event.getActionCommand()){
            case "rght":
                Dx +=10;
                Dw += 10;
                break;
            case "left":
                Dx -=10;
                Dw -= 10;
                break;
            case "doun":
                Dy +=10;
                Dh += 10;
                break;
            case "up":
                Dy -=10;
                Dh -= 10;
                break;
            case "rot":
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