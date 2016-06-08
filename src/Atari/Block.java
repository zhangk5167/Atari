package Atari;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos = 150;
	private int yPos = 150;
	private int width = 10;
	private int height = 10;
	private Color color = Color.BLACK;

	public Block()
	{


	}
	
	//add other Block constructors - x , y , width, height, color

	public Block(int x, int y, int width, int height, Color color)
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(color);
	}
	
	public Block(int x, int y, int width, int height)
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}
	public Block(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	
	
   //add the other set methods
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setColor(Color col){
		this.color = col;
	}

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }
   
	public boolean equals(Object obj)
	{
		Block x = (Block)obj;
		if(getX() == x.getX() 
				&& getY() == x.getY() 
				&& getWidth() == x.getWidth() 
				&& getHeight() == x.getHeight()
				&& getColor().equals(x.getColor()))
			return true;
		return false;
	}

   //add the other get methods
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}

	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.xPos = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.yPos = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

   //add a toString() method  - x , y , width, height, color
	@Override
	public String toString()
	{
		String output = "";
		output = getX() + " " + getY() + " " +getWidth() +" " + getHeight() + " " +getColor();
		return output;
	}
}