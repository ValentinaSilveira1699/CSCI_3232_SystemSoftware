/*
Write a Java program A1p1.java with a public class A1p1 and no named packages that accepts one command line argument a which is assumed to be positive integer at least 2. Calculate and print an integer list starting from a and ending with 1 by iteratively applying a math function f to the value of a. The math function f is defined as f(x)=(3x+1)/2 if x is odd and f(x)=x/2 if x is even. The iteration will stop when the value 1 is reached. For example: When a is 6, the integer list should be 6,3,5,8,4,2,1 and the length of this list is 7. The length of the list should also be printed. You program can, but does not have to, store all elements of the list in memory at once. A sample run can look like the following (those shown in blue color are typed by the user):
[kwang@computer][~/temp]$java A1p1 14
Iterated list for 14 is:
14,7,11,17,26,13,20,10,5,8,4,2,1
Length of the list: 13
*/

import java.util.*;

public class A1p1 {
	public static void main(String[] args) {
		//Scanner
		Scanner s = new Scanner(System.in);
		int x = Integer.parseInt(args[0]);
		System.out.println("Iterated list for "+x+" is:");
		System.out.print(x+",");
		int count=1;
		//loop till x not equals to 1 
		while(x != 1) {
    			// even condition 
    			if(x % 2 == 0) {
        			x = x / 2;
    			}
    			// for odd cases 
    			else {
        			x = (3 * x + 1) / 2;
    			}
    			System.out.print(x);
    
    			// print comma if x is not 1
    			if (x != 1) {
        			System.out.print(",");
    			}
    			count++;
		}

		System.out.println("\nLength of the list: "+ count);
	}
}