package Atari;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed = 5;

   public Paddle()
   {
		super(10,10);
   }

   //add the other Paddle constructors
   	public Paddle(int x, int y)
	{
		super(x,y);
	}
   	public Paddle(int x, int y, int spd)
	{
		super(x,y);
		speed = spd;
	}
	public Paddle(int x, int y, int width, int height)
	{
		super(x,y, width, height);
	}
	public Paddle(int x, int y, int width, int height, int spd)
	{
		super(x,y, width, height);
		speed = spd;
	}
	public Paddle(int x, int y, int width, int height, Color col)
	{
		super(x,y, width, height, col);
	}
	public Paddle(int x, int y, int width, int height, Color col, int spd)
	{
		super(x,y, width, height, col);
		speed = spd;
	}


   public void moveLeftAndDraw(Graphics window)
   {
//	   if(getY() < Tester.WIDTH)
	   
//	   if(!(getY() <= 10 && getY()>= 450))
//	   {
		   window.setColor(Color.WHITE);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setX(getX()- speed);
		   
		   window.setColor(getColor());
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
//	   }
	   
   }

   public void offScreen()
   {
	   setX(1000);
   }
   public void moveRightAndDraw(Graphics window)
   {
//	   if(!(getY() <= 10 && getY()>= 450))
//	   {
		   window.setColor(Color.WHITE);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
		   setX(getX() + speed);
		   
		   window.setColor(getColor());
		   window.fillRect(getX(), getY(), getWidth(), getHeight());
//	   }
   }

   //add get methods
   
   public void setSpeed(int s)
   {
	   speed = s;
   }
   public int getSpeed()
   {
	   return speed;
   }

   //add a toString() method
   public String toString()
	{
		String output = "";
		output = getX() + " " + getY() + " " +getWidth() +" " + getHeight() 
				+ " " +getColor() + " " + getSpeed();
		return output;
	}
}