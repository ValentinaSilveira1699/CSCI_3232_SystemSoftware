import java.util.Random;

public class A2p2 {
	// reverse_offset function
	// gets the character and returns the reverse offset lowercase letter
	public static char reverse_offset(char c){
		// shift the character by 1 place
		char convert = (char)((((int)c + 25 - 65) % 26) + 65);
		// return the lower case version of the character
		return Character.toLowerCase(convert);
	}
	
	// convert_index1 function
	// converts the letters with the gap of total_methods starting from 0
	public static void convert_index1(char[] letters,int total_methods){
		for(int i=0;i<letters.length;i+=total_methods){
			letters[i] = reverse_offset(letters[i]);
		}
	}

	// convert_index2 function
	// converts the letters with the gap of total_methods starting from 1
	public static void convert_index2(char[] letters,int total_methods){
		for(int i=1;i<letters.length;i+=total_methods){
			letters[i] = reverse_offset(letters[i]);
		}
	}

	// convert_index3 function
	// converts the letters with the gap of total_methods starting from 2
	public static void convert_index3(char[] letters,int total_methods){
		for(int i=2;i<letters.length;i+=total_methods){
			letters[i] = reverse_offset(letters[i]);
		}
	}

	// print_letters function
	// used to print the character array
	public static void print_letters(char[] letters){
		System.out.println();
		for(int i=0;i<letters.length;i++){
			System.out.print(letters[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		try{
			// get the command line argument
			int m = Integer.parseInt(args[0]);
			// if the value of m is not multiple of 60
			if(m%60 != 0){
				System.out.println("The value of the argument must be multiple of 60");
				return;
			}
			// declare total_methods variable
			// this variable will contain the number of methods used to convert the array
			int total_methods = 3;
			Random r = new Random();
			// declare the character array
			char[] random_letters = new char[m];
			// append random uppercase letters in the array
			// ASCII code of uppercase letters starts from 65
			for(int i=0;i<m;i++){
				random_letters[i] = (char) (65+r.nextInt(26));
			}
			print_letters(random_letters);
			// convert 1st part of letters
			convert_index1(random_letters,total_methods);
			print_letters(random_letters);
			// convert 2nd part of letters
			convert_index2(random_letters,total_methods);
			print_letters(random_letters);
			// convert 3rd part of letters
			convert_index3(random_letters,total_methods);
			print_letters(random_letters);
		}
		catch(Exception e){
			System.out.println("Please provide atleast one argument");
		}
	}
}
