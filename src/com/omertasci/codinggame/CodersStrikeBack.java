package com.omertasci.codinggame;

import java.util.Scanner;

public class CodersStrikeBack {

	public static void main(String[] args) {
		
		int[][] map = {{4000, 3000}, {13000, 3000}, {13000, 7000}, {4000, 7000}};
		Scanner in = new Scanner(System.in);
		int x = in.nextInt(); // x position of your pod
        int y = in.nextInt(); // y position of your pod
        
        
        // game loop
        while (true) {
        	
            for(int i=0; i<map.length; i++){
            	int thrust = in.nextInt();
            }
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Edit this line to output the target position
            // and thrust (0 <= thrust <= 100)
            // i.e.: "x y thrust"
            while( x != nextCheckpointX || y != nextCheckpointY ){
                 System.out.println(nextCheckpointY + " " + nextCheckpointY + " 50");
            }
           


        }

	}

}
