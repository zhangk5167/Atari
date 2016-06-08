package Atari;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
//	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int rightScore, leftScore;
	private ArrayList<Paddle> blocks = new ArrayList<>();
	public int blockCount = 0;
	public boolean cheatCode = false;
	
	public int waitTime;
	public Pong()
	{
		//set up all variables related to the game
//		leftPaddle = new Paddle(10, 770, 20, 40, Color.GREEN);
//		rightPaddle = new Paddle(540, 770, 20, 40, Color.GREEN);

		//instantiate a left Paddle
		leftPaddle = new Paddle(300, 500, 80, 10, Color.GREEN);
//win code		
		if(cheatCode)
		{
			blocks.add(new Paddle(0,0,800,30, new Color ((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
			blockCount++;
		}
else{
		for(int i = 0; i < 750; i+=85)
		{
			blocks.add(new Paddle(i,0,80,30, new Color ((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
			blockCount++;
		}
		
		for(int i = 0; i < 750; i+=75)
		{
			blocks.add(new Paddle(i,35,70,30, new Color ((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
			blockCount++;
		}
		
		for(int i = 0; i < 750; i+=65)
		{
			blocks.add(new Paddle(i,70,60,30, new Color ((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
			blockCount++;
		}
		
		for(int i = 0; i < 750; i+=55)
		{
			blocks.add(new Paddle(i,105,50,30, new Color ((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255))));
			blockCount++;
		}
		
		//instantiate a right Paddle
//		rightPaddle = new Paddle(765, 10, 5, 40, Color.GREEN);
		
		//ball = new Ball();
		ball = new BlinkyBall();
		//ball = new SpeedUpBall();

		keys = new boolean[4];
		
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
//		rightPaddle.draw(graphToBack);
		graphToBack.drawString("Right Score: " + rightScore + " " + "Left Score: " + leftScore, 10, 10);
		for(Paddle i: blocks)
		{
			i.draw(graphToBack);
		}

		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10))
		{
//			ball.setXSpeed(0);
//			ball.setYSpeed(0);
			
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
			//cover the old score with a white version
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Right Score: " + rightScore + " " + "Left Score: " + leftScore, 250, 250);
			rightScore++;
		}
		if(!(ball.getX() <= 780))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(ball.getYSpeed());
			//cover the old score with a white version
//			graphToBack.setColor(Color.WHITE);
//			graphToBack.drawString("Right Score: " + rightScore + " " + "Left Score: " + leftScore, 250, 250);
//			leftScore++;
		}
		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=10 && ball.getY()<=550))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(!(ball.getY()<=550))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			leftPaddle.setSpeed(0);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Game Over!!", 250, 250);
		}
		if(blockCount == 0)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			leftPaddle.setSpeed(0);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("You Have Won!!!", 250, 250);
		}

		//see if the ball hits the left paddle
		
		//attempt 1:
//		if(ball.getY() + ball.getHeight() <= leftPaddle.getY() + leftPaddle.getHeight() && ball.getY() + ball.getHeight() >= leftPaddle.getY()
//			&& ball.getX() + ball.getWidth() <= leftPaddle.getX() + leftPaddle.getWidth() && ball.getX() + ball.getWidth() >= leftPaddle.getX())
//		{
//			ball.setXSpeed(-ball.getYSpeed());
//		}
		
		
		//attempt 2:
//		if((ball.getX() <= leftPaddle.getX() +leftPaddle.getWidth() + Math.abs(ball.getXSpeed())
//        &&
//        (ball.getY() >= leftPaddle.getY() &&
//        ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()  ||
//        ball.getY() + ball.getHeight() >= leftPaddle.getY() &&
//        ball.getY() + ball.getHeight()  < leftPaddle.getY() + leftPaddle.getHeight() )))
//			{
//			  if(ball.getX() <= leftPaddle.getX() +leftPaddle.getWidth() - Math.abs(ball.getXSpeed()))
//			      ball.setYSpeed(-ball.getYSpeed());
//			  //set Y speed to negative of current speed
//			  else
//				  ball.setXSpeed(-ball.getXSpeed());
//			     // set X speed to negative of current speed
//			}
		
		deflect(leftPaddle);
		for(Paddle i: blocks)
		{
			deflectAndRemove(i, graphToBack);
		}
//		if(ball.didCollideLeft(leftPaddle))
//			ball.setXSpeed(-ball.getXSpeed());
//		if(ball.didCollideRight(leftPaddle))
//			ball.setXSpeed(-ball.getXSpeed());
//		if(ball.didCollideTop(leftPaddle))
//			ball.setYSpeed(-ball.getYSpeed());
//		if(ball.didCollideBottom(leftPaddle))
//			ball.setYSpeed(-ball.getYSpeed());
		
		//see if the ball hits the right paddle
//		if((ball.getX() + ball.getWidth()<= rightPaddle.getX() + Math.abs(ball.getXSpeed())&&
//        (ball.getY() >= rightPaddle.getY() &&
//        ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()  ||
//        
//        ball.getY() + ball.getHeight() >= rightPaddle.getY() &&
//        ball.getY() + ball.getHeight()  < rightPaddle.getY() + rightPaddle.getHeight() )))
//			{
//			  if(ball.getX() + ball.getWidth()<= rightPaddle.getX() - Math.abs(ball.getXSpeed()))
//			      ball.setYSpeed(-ball.getYSpeed());
//			  //set Y speed to negative of current speed
//			  else
//				  ball.setXSpeed(-ball.getXSpeed());
//			     // set X speed to negative of current speed
//   		}
		
		//6-6-16
//		if(ball.didCollideRight(rightPaddle))
//			ball.setXSpeed(-ball.getXSpeed());
//		
//		if(ball.didCollideTop(rightPaddle))
//			ball.setYSpeed(-ball.getYSpeed());
//		if(ball.didCollideBottom(rightPaddle))
//			ball.setYSpeed(-ball.getYSpeed());
	
		//see if the paddles need to be moved
		
		//if paddle goes off on one end, it reappears on the other
		if(!(leftPaddle.getX()<=780))
			leftPaddle.setX(0);
//		if(!(rightPaddle.getY()<=560))
//			rightPaddle.setY(0);
		if(!(leftPaddle.getX()>=-80))
			leftPaddle.setX(750);
//		if(!(rightPaddle.getY()>=-50))
//			rightPaddle.setY(500);
		
		if(keys[0] == true)
		{
			leftPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveRightAndDraw(graphToBack);
		}
//		if(keys[2] == true)
//		{
//			rightPaddle.moveUpAndDraw(graphToBack);
//		}
//		if(keys[3] == true)
//		{
//			rightPaddle.moveDownAndDraw(graphToBack);
//		}

		twoDGraph.drawImage(back, null, 0, 0);
	}
   	private void deflect(Paddle i)
   	{
   		if(ball.didCollideLeft(i))
   		{
   			ball.setXSpeed(-ball.getXSpeed());
   			//ball.setYSpeed(-ball.getYSpeed());
   		}
			
   		if(ball.didCollideRight(i))
   		{
   			ball.setXSpeed(-ball.getXSpeed());
   		}
			
   		if(ball.didCollideTop(i))
   		{
   			ball.setYSpeed(-ball.getYSpeed());
   		}
			
   		if(ball.didCollideBottom(i))
   		{
   			ball.setYSpeed(-ball.getYSpeed());
   		//ball.setXSpeed(-ball.getXSpeed());
   		}
			
   	}
   	private void deflectAndRemove(Paddle i, Graphics window)
   	{
   		if(ball.didCollideLeft(i))
   		{
   			ball.setXSpeed(-ball.getXSpeed());
   			window.setColor(Color.WHITE);
   			window.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
   			i.setY(-30);
   			blockCount--;
   		}
		if(ball.didCollideRight(i))
		{
			ball.setXSpeed(-ball.getXSpeed());
			window.setColor(Color.WHITE);
   			window.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
			i.setY(-30);
			blockCount--;
		}
			
		if(ball.didCollideTop(i))
		{
			ball.setYSpeed(-ball.getYSpeed());
			window.setColor(Color.WHITE);
   			window.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
			i.setY(-30);
			blockCount--;
		}
			
		if(ball.didCollideBottom(i))
		{
			ball.setYSpeed(-ball.getYSpeed());
			//ball.setXSpeed(-ball.getXSpeed());
			window.setColor(Color.WHITE);
   			window.fillRect(i.getX(), i.getY(), i.getWidth(), i.getHeight());
			i.setY(-30);
			blockCount--;
		}
   	}
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case ',' : keys[0]=true; break;
			case '.' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case ',' : keys[0]=false; break;
			case '.' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(waitTime);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}