package Atari;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class TheGame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static int gameSpeed = 10;
	private static boolean cheatCode = false;
	
	public TheGame()
	{
		super("PONG");
		setSize(WIDTH,HEIGHT);
		
		Pong game = new Pong();
		game.waitTime = gameSpeed;
		game.cheatCode = cheatCode;
		((Component)game).setFocusable(true);			
		getContentPane().add(game);
		
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		int input = 0;
		
		Scanner starter = new Scanner(System.in);
		System.out.println("Tail's Atari \nKevin Zhang \nPeriod 3 AP Computer Science 2016");
		
		System.out.println("This game is a colorful version of the famous game atari.\nThe goal of the game to remove all blocks without"
				+ "ever letting the ball touch the bottom of the screen. Good luck and have fun! :)");

//		System.out.println("Choose a speed, from 0 to 20. Game will start right when number is entered.");
//		input = starter.nextInt();
//		if(input == -1)
//		{
//			cheatCode = true;
//			System.out.println("Cheat code: easyWinner activated");
//		}
		System.out.println("Choose a speed, from 0 to 20. Game will start right when number is entered.");
		input = starter.nextInt();
		if(input>=0)
		{
			gameSpeed = 20-input;
			TheGame run = new TheGame();
		}
	}
}