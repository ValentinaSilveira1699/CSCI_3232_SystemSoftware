import java.util.*;
public class A2p1 {
	public static void main(String[] args) {
		//Scanner
		Scanner s = new Scanner(System.in);
		int x = Integer.parseInt(args[0]);
		System.out.println("Iterated list for "+x+" is:");
		System.out.print(x+",");
		int count=1;
		//loop till x not equals to 1 
		while(x!=1) {
			//even condition 
			if(x%2==0) {
				x=x/2;
			}
			//for odd cases 
			else {
				x = (3*x+1)/2;
			}
			System.out.print(x+",");
			count++;
		}
		System.out.println("\nLength of the list: "+count);
	}
}
