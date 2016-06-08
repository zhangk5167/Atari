package Atari;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed = 3;
	private int ySpeed = 1;

	public Ball()
	{
		super(200,200);
	}
	//add the other Ball constructors
	public Ball(int x, int y)
	{
		super(x,y);
	}
	public Ball(int x, int y, int width, int height)
	{
		super(x,y, width, height);
	}
	public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd)
	{
		super(x, y, wid, ht);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	public Ball(int x, int y, int width, int height, Color col)
	{
		super(x,y, width, height, col);
	}
	public Ball(int x, int y, int width, int height, Color col, int xVelocity, int yVelocity)
	{
		super(x, y, width, height, col);
		xSpeed = xVelocity;
		ySpeed = yVelocity;
	}


   //add the set methods
   public void setXSpeed(int x)
   {
	   xSpeed = x;
   }
   public void setYSpeed(int y)
   {
	   ySpeed = y;
   }

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  window.setColor(Color.WHITE);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      window.setColor(Color.BLUE);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Ball x = (Ball)obj;
		if(getX() == x.getX() 
				&& getY() == x.getY() 
				&& getWidth() == x.getWidth() 
				&& getHeight() == x.getHeight()
				&& getColor().equals(x.getColor())
				&& getXSpeed() == x.getXSpeed()
				&& getYSpeed() == x.getYSpeed())
			return true;
		return false;
	}   

	//add the get methods
	 public int getXSpeed()
	   {
		   return xSpeed;
	   }
	   public int getYSpeed()
	   {
		   return ySpeed;
	   }
	//add a toString() method
	public String toString()
	{
		String output = "";
		output = getX() + " " + getY() + " " +getWidth() +" " + getHeight() 
				+ " " +getColor() + " " + getXSpeed() + " " + getYSpeed();
		return output;
	}
	
//interface
	@Override
	public boolean didCollideTop(Object obj) {
		// TODO Auto-generated method stub
		Block other = (Block)obj;
		
//		boolean xCheck = ((getX()+ getWidth() <= other.getX() + other.getWidth() && getX() >= other.getX()));
//		boolean yCheck = (getY() - getYSpeed() <= other.getY() + other.getHeight()&& getY() > other.getY());

//		boolean xCheck = ((getX() + getWidth() <= other.getX()
//				&& getX() > other.getX() + other.getWidth()));
//		boolean yCheck = (getY() -getYSpeed() >= other.getY() &&
//		        getY() <= other.getY() + other.getHeight()  ||
//		        getY() + getHeight() >= other.getY() &&
//		        getY() + getHeight()  <= other.getY() + other.getHeight());
		
		boolean xCheck = getX() < other.getX() + other.getWidth() && getX() + getWidth() > other.getX();
		boolean yCheck = getY() <= other.getY() + other.getHeight() && getY() > other.getY();
		return xCheck&&yCheck;
	}
	@Override
	public boolean didCollideBottom(Object obj) {
		// TODO Auto-generated method stub
		Block other = (Block)obj;
		boolean xCheck = getX() < other.getX() + other.getWidth() && getX() + getWidth() > other.getX();
		boolean yCheck = getY() + getHeight() >= other.getY() && getY() < other.getY();

//		boolean xCheck = ((getX()+ getWidth() <= other.getX() + other.getWidth() && getX() >= other.getX()));
//		boolean yCheck = (getY() + getHeight() + getYSpeed() <= other.getY() && getY() < other.getY() + other.getHeight());

//		boolean xCheck = (getX() + getWidth() >= other.getX()
//				&& getX() < other.getX() + other.getWidth());
//		
//		boolean yCheck = 
//				(
//				//getY() >= other.getY() &&
////		        getY() <= other.getY() + other.getHeight()  ||
//		        getY() + getHeight() >= other.getY() &&
//		        getY() + getHeight()  <= other.getY() + other.getHeight());
		return xCheck&&yCheck;
	}
	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		Block other = (Block)obj;
//		boolean yCheck = ((getY()+ getHeight() <= other.getY() + other.getHeight() && getY() >= other.getY()));
//
//		//boolean yCheck = ((getY()+ getHeight() >= other.getY() && getY() <= other.getY() + other.getHeight()));
//		boolean xCheck = (getX() -getXSpeed() <= other.getX() + other.getWidth() && getX() > other.getX());
//			boolean yCheck = ((getY() + getHeight() <= other.getY()
//				&& getY() > other.getY() + other.getHeight()));
//		boolean xCheck = (getX() >= other.getX() &&
//		        getX() <= other.getX() + other.getWidth()  ||
//		        getX() + getWidth() >= other.getX() &&
//		        getX() + getWidth()  <= other.getX() + other.getWidth());
		
		boolean xCheck = (getX() <= other.getX() + other.getWidth() && getX() > other.getX());
		boolean yCheck = (getY() < other.getY()+ other.getHeight() && getY()+ getHeight() > other.getY());
		
		return xCheck&&yCheck;
	}
	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		Block other = (Block)obj;
//		boolean yCheck = ((getY()+ getHeight() <= other.getY() + other.getHeight() && getY() >= other.getY()));

//		boolean yCheck = ((getY()+ getHeight() >= other.getY() && getY() <= other.getY() + other.getHeight()));
//		boolean xCheck = (getX() + getWidth()+ getXSpeed() == other.getX());
//		boolean xCheck =  (getX() + getWidth() + getXSpeed() == other.getX() && getX() < other.getX() + other.getWidth());
		
//		boolean yCheck = (getY() + getHeight() >= other.getY()
//				
//				&& getY() < other.getY() + other.getHeight());
//		boolean xCheck = (getX() >= other.getX() &&
//		        getX() <= other.getX() + other.getWidth()  ||
//		        getX() + getWidth() >= other.getX() &&
//		        getX() + getWidth()  <= other.getX() + other.getWidth());
		
		boolean xCheck = (getX() + getWidth() >= other.getX() && getX() < other.getX());
		boolean yCheck = (getY() < other.getY()+ other.getHeight() && getY()+ getHeight() > other.getY());

		return xCheck&&yCheck;
	}
}