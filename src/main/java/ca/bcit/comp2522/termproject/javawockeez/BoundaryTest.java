//package ca.bcit.comp2522.termproject.javawockeez;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
//////import javafx.scene.input.KeyEvent;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
//
//
//public class BoundaryTest extends JPanel implements ActionListener, KeyListener {
//    //    private static final int MOVEMENT_SIZE = 20;
//    Timer tm = new Timer(5, this);
//    // x and y are starting positions.
//    int x = 150, y = 150, velX = 0, velY = 0;
//
//    public BoundaryTest()
//    {
//        tm.start();
//        addKeyListener(this);
//        setFocusable(true);
//        setFocusTraversalKeysEnabled(false);
//    }
//
//    public void paintComponent(Graphics g)
//    {
//        // Creates the shape for you to move. Can be changed to a image.
//        super.paintComponent(g);
//        g.setColor(Color.blue);
//        g.fillRect(x, y, 50, 30);
//    }
//
//    public void actionPerformed(ActionEvent e){
//        // If the shape touches the minimum/maximum size of the game border. It will stop the shape.
//        if (x < 0) {
//            velX = 0;
//            x = 0;
//        }
//        if (x > 600) {
//            velX = 0;
//            x = 600;
//        }
//        if (y < 0) {
//            velY = 0;
//            y = 0;
//        }
//        if (y > 700) {
//            velY = 0;
//            y = 700;
//        }
//        x = x + velX;
//        y = y + velY;
//        repaint();
//    }
//
//    public void keyPressed(KeyEvent e) {
//        // Different key event function.
//
//        int c = e.getKeyCode();
//
//        if (c == KeyEvent.VK_LEFT){
//            velX -= 1; // Speed adjust
//            velY = 0;
//        }
//        if (c == KeyEvent.VK_UP){
//            velX = 0;
//            velY -= 1;
//        }
//        if (c == KeyEvent.VK_RIGHT){
//            velX += 1;
//            velY = 0;
//        }
//        if (c == KeyEvent.VK_DOWN){
//            velX = 0;
//            velY += 1;
//        }
//    }
//
//    public void keyTyped(KeyEvent e) {}
//    public void keyReleased(KeyEvent e) {
//        // When the key is released, the character stops moving.
//        velX = 0;
//        velY = 0;
//    }
//
//    public static void main(String[] args) {
//        BoundaryTest t = new BoundaryTest();
//        JFrame jf = new JFrame();
//        jf.setTitle("Boundary Test");
//        jf.setSize(600, 700);
//        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.add(t);
//    }
//
//
//}