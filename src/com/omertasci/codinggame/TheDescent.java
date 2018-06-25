package com.omertasci.codinggame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class TheDescent {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);

	        int[] mountainArr = new int[8];
	        // game loop
	        while (true) {
	            for (int i = 0; i < 8; i++) {
	                int mountainH = in.nextInt(); // represents the height of one mountain.
	                mountainArr[i] = mountainH;
	            }

	            // Write an action using System.out.println()
	            // To debug: System.err.println("Debug messages...");
	            int max = mountainArr[0];
	            int maxIndex = 0;
	            for(int i=0; i<mountainArr.length;i++){
	            	if(max < mountainArr[i]){
	            		max = mountainArr[i];
	            		maxIndex = i;
	            	}
	            }
	            System.out.println(maxIndex);

//	            System.out.println("4"); // The index of the mountain to fire on.
	        }	    
	}
}
