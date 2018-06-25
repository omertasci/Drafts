package com.omertasci.codelaio.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

//https://www.codela.io/challenges/5a82ba8c1c999b884fc5c852/find-the-unique-element
public class FindTheUniqueElement {

	public static void main(String[] args) {
		
		int [] nums = {1, 1, 2, 2, 3,3 ,4,5,6,7,7,9,6,7,9};
		
		for(int i=0; i< nums.length ; i++){
			int [] nums2 = nums.clone();
			nums2 = ArrayUtils.removeElement(nums2, nums[i]);
			
			if(!ArrayUtils.contains(nums2, nums[i])){
				System.out.println(nums[i]);
			}
		}
	}

}
