/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("C:\\Users\\MHDSA\\Desktop\\MIU\\FALL 2018\\OOP\\Challenge\\Challange 3 ThreadsTankGame\\2Player Tank Game\\TankBlueS.jpg","C:\\Users\\MHDSA\\Desktop\\MIU\\FALL 2018\\OOP\\Challenge\\Challange 3 ThreadsTankGame\\2Player Tank Game\\rocket.gif");
   public Tank Tank2=new Tank(("C:\\Users\\MHDSA\\Desktop\\MIU\\FALL 2018\\OOP\\Challenge\\Challange 3 ThreadsTankGame\\2Player Tank Game\\Tank2.jpg"),"C:\\Users\\MHDSA\\Desktop\\MIU\\FALL 2018\\OOP\\Challenge\\Challange 3 ThreadsTankGame\\2Player Tank Game\\rocket2.jpeg");
  
   public MovingBalls()
    {
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=220;
        BlueTank.pos.y=500;
        Tank2.pos.x=220;
        Tank2.pos.y=0;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
            
              if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                Tank2.movel();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                Tank2.mover();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_W)
            {
                
                Tank2.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        
        
        BufferedImage imgtank2 = ImageIO.read(new File(Tank2.ImagePath));
        BufferedImage imgrocket2 = ImageIO.read(new File(Tank2.Rocket.imgPath));
        g.drawImage(imgrocket2, Tank2.Rocket.pos.x-55, Tank2.Rocket.pos.y,null);
        g.drawImage(imgtank2, Tank2.pos.x, Tank2.pos.y,null);

        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                BlueTank.points+=1;
                Balls.remove(OneBall);
                break;
                
            }
            if (Tank2.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Tank2.points+=1;
                Balls.remove(OneBall);
                break;
                
            }                       
        }  
 }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
        }
        
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
