package edu.wit.dcsn.comp1050.lab01;
import java.util.Scanner;
/*
 * Vincent Jodice
 * Comp 1050-09
 * Lab 1 
 */
public class CreditCardValidator {

// asks the user for a credit card number and prints out if it is valid or not
	public static void main(String[] args) {
		int sum = 0;
		Scanner scanIt = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer. ");
		long ccn = scanIt.nextLong();
			if(getSize(ccn) < 13 || getSize(ccn) > 16) {
				System.out.println("This is not a valid size for a credit card number");
				System.exit(0);
				
			}
				if(isValid(ccn)) {
					System.out.println("This is a valid credit card" );
				}
				else {
					System.out.println("This is not a valid credit card" );
					}
		scanIt.close();
	}
	// check whether the sum of double even place and sum of odd place is divisible by 10 and checks if the prefix's match
	public static boolean isValid(long number) {
		Boolean check;
		int resultSum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
			if (resultSum % 10 == 0 && prefixMatched(number)) {
				check = true;
			}
			else {
				check = false;
			}  
	    return check;
	}
	
//takes a look at all the even places of the credit card and doubles them, after it doubles them it adds all of the single digits
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		String creditCard = String.valueOf(number);
			if (getSize(number) % 2 == 0) {
				
				for(int i = getSize(number); i < 0 ; i -= 2 ) {
					char doubling = creditCard.charAt(i);
					String add = String.valueOf(doubling);
					int num = Integer.parseInt(add);
					int value = num*2;
					int total = getDigit(value);
					sum += total;
					}
			}
			else if (getSize(number) % 2 != 0){
				for(int i = getSize(number) - 1; i < 0 ; i -= 2 ) {
					char doubling = creditCard.charAt(i);
					String add = String.valueOf(doubling);
					int num = Integer.parseInt(add);
					int value = num*2;
					int total = getDigit(value);
					sum += total;
					}
			}
			return sum;
		
	}
// takes values that are greater than 9 from the evens place and seperates them into 2 digits
// returns the sum of the 2 digits
	public static int getDigit(int number) {
		if (number > 10) {
			String dDigits = String.valueOf(number);
			char digit1 = dDigits.charAt(dDigits.length() -1);
			char digit2 = dDigits.charAt(dDigits.length() -2);
			String digita = String.valueOf(digit1);
			String digitb = String.valueOf(digit2);
			Integer oneNum = Integer.parseInt(digita);
			Integer twoNum = Integer.parseInt(digitb);
			number = twoNum + oneNum;
		}
		return number;
	}
	// takes all of the values in the odd place of the credit card number and adds up all of those single digits
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		String creditCard = String.valueOf(number);
			if(getSize(number) % 2 == 0) {
				for(int i = getSize(number) - 1; i < 0; i -= 2 ) {
					char doubling = creditCard.charAt(i - 1);
					String add = String.valueOf(doubling);
					int value = Integer.parseInt(add);
					int num = value;
					sum += num;
				}
			}
			else if (getSize(number) % 2 != 0){
				for(int i = getSize(number); i < 0; i -= 2 ) {
					char doubling = creditCard.charAt(i - 1);
					String add = String.valueOf(doubling);
					int value = Integer.parseInt(add);
					int num = value;
					sum += num;
				}
				
			}
			return sum;
		
	}
 // finds the size of a long variable
	public static int getSize(long d) {
	  String a = String.valueOf(d);
	  return a.length();
    }
	
	
	public static boolean prefixMatched(long number) {
		boolean a = false;
		String pre = String.valueOf(number);
	    char start = pre.charAt(0);
	    	if(getPrefixNum(number,pre) == 1) {
	    	  if(getPrefix(number,start) == 37) {
	    		  a = true;
	    	  }
	    	}
	    	if(getPrefixNum(number,pre) == 0) {
	    		if(getPrefix(number, start) == start) {	
	    	a = true;
	    }
	    	}
	  return a; 
	}
// checks the first character of the credit card number to see if it starts with 4, 5, 6, or 37
	public static long getPrefix(long number, char d) {
	    long finalValue;
		String pre = String.valueOf(number);
	     char k = pre.charAt(0);
	     	if (k == '4' || k == '5' || k == '6') {
	           finalValue  = Long.valueOf(k);
	     	}
	     	else if(pre.charAt(0) == '3' && pre.charAt(1) == '7'){
	     			String value1 = String.valueOf(pre.charAt(0));
	     			String value2 = String.valueOf(pre.charAt(1));
	     			String totalValue = value1 + value2;
	     			finalValue = Long.valueOf(totalValue);
	     		}
	     	else {
	     		return 0;
	     	}
	     		
		return finalValue;
	  }
// determines if a credit card starts with the numbers 37
	public static int getPrefixNum(long number, String a) {
		int num = 0;
		if(a.charAt(0) == '3' && a.charAt(1) == '7'){
	       num = 1;
		}
	return num;
	
	}
	    
}
