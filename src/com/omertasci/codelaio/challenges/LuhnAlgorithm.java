package com.omertasci.codelaio.challenges;

public class LuhnAlgorithm {

	public static void main(String[] args) throws Exception {
		boolean isValid = false;
		String input = "1322 4231 4332 2312";
		input = input.replace(" ", "");
//		1x2=2, 2x2=4, 3x2=6, 4x2=8, 3x2=6, 4x2=8, 2x2=4, 1x2=2
//		2+2+3+4+2+6+3+8+1+6+2+8+2+4+3+2 = 58
//		58 % 10 = 8, thus this CC is not valid!
		if(input.length()!=16 ){
			throw new Exception("Input length is not valid!");
		}
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < input.length(); i++){
			if(i%2 == 0){
				int doubleOfChar = Integer.parseInt(input.charAt(i)+"")*2;
				int digitVal = doubleOfChar > 9 ? (doubleOfChar-9) : doubleOfChar;
				sum1 += digitVal;
			}
			else{
				int valOfChar = Integer.parseInt(input.charAt(i)+"");
				sum2 += valOfChar;
			}
		}
		
		isValid = (sum1+sum2)% 10 == 0;
		
		
		System.out.println("sum1:" + sum1);
		System.out.println("sum2:" + sum2);
		System.out.println("isValid:" + isValid);
	}

}
