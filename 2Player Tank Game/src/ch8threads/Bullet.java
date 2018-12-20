/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Bullet implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public int id;
    public static int counter=0;
    public String imgPath;
    public Bullet()
    {
        id=counter;
        Speed=1;
        counter++;
    }
    public  void  move()
    {
        if(id==0)
        pos.y-=Speed;
        else if(id==1)
            pos.y+=Speed;
    }
    


    @Override
    public void run() {
        for (int i=0;i<400;i++)
        {            
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
}
