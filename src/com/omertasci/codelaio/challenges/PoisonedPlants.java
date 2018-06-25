package com.omertasci.codelaio.challenges;

import org.apache.commons.lang3.ArrayUtils;

public class PoisonedPlants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr ={6, 5, 8, 4, 7, 10, 9};
		int[] arr ={1,2,3,4,5};
		int countDay = 0;
		boolean sameAsTomarrow =false;
		while(arr.length > 0 && !sameAsTomarrow){
			
			int [] arr2 = arr.clone();
			for(int i=0; i<arr.length; i++){
				
				if(i > 0 && arr[i] > arr[i-1] ){
//					arr2 = ArrayUtils.removeElement(arr2, arr[i]);
					
					int[] arr3 = new int[arr2.length-1];
					int arr3Index=0;
					
					for(int j=0; j< arr2.length ;j++){
						if(arr2[j] != arr[i] && arr3Index <= arr3.length){
							arr3[arr3Index] = arr2[j];
							arr3Index++;
						}
					}
					arr2 = arr3;
				}				
			}
			sameAsTomarrow = arr.length == arr2.length ? true: false; 
			
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n------------------------------------");
			
			arr = arr2;				
			if(!sameAsTomarrow){
				countDay++;
			}
			
		}
		System.out.println(countDay);
	}

}
