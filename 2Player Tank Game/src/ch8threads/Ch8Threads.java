/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ch8Threads {


    public static void main(String[] args) {
      
        JFrame jf=new JFrame();
        jf.setSize(600, 640);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,100,20,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,15,Color.red));
        mb.Balls.add(new Ball(180,180,10,Color.CYAN));
        mb.Balls.add(new Ball(100, 250, 25, Color.yellow));
        mb.Balls.add(new Ball(200, 300, 30, Color.BLACK));
        mb.Balls.add(new Ball(350,350,35, Color.PINK));
        mb.Balls.add(new Ball(450, 400, 40, Color.orange));
                
        
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
         
    }
}
