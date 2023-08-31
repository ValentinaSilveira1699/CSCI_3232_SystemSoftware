public class A2p3 {

public static void main(String[] args) {
	// The program expects two arguments: m and n.
	if (args.length != 2) {
		System.err.println("Usage: java A2p3 <m> <n>");
		System.exit(1);
	}

	// Parse the arguments as integers.
	int m = Integer.parseInt(args[0]);
	int n = Integer.parseInt(args[1]);

	// Validate the input.
	if (m % 60 != 0 || n < 2 || n > 6) {
		System.err.println("m must be a multiple of 60 and n must be between 2 and 6 inclusive.");
		System.exit(1);
	}

	// Generate a random string of uppercase letters.
	char[] chars = generateRandomString(m);

	// Print some information about the input and the original string.
	System.out.println("Using " + n + " threads to handle " + m + " chars.");
	System.out.println("Original random upper case string:");
	System.out.println(chars);

	// Divide the string into chunks and create a separate thread to process each chunk.
	int chunkSize = m / n;
	Thread[] threads = new Thread[n];
	for (int i = 0; i < n; i++) {
		int startIndex = i * chunkSize;
		int endIndex = (i == n - 1) ? m : (i + 1) * chunkSize;
		
		// Create a new Task object and start a new thread for each chunk.
		threads[i] = new Thread(new Task(chars, startIndex, endIndex));
		threads[i].start();
	}

	// Wait for all the threads to finish.
	for (int i = 0; i < n; i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Print the modified string.
	System.out.println("Reverse-offset lower case string:");
	System.out.println(chars);
	}

	// A helper method to generate a random string of uppercase letters.
	private static char[] generateRandomString(int length) {
	char[] chars = new char[length];
	for (int i = 0; i < length; i++) {
		chars[i] = (char) ('A' + Math.random() * 26);
	}
	return chars;
}

// A nested class that implements the task performed by each thread.
private static class Task implements Runnable {
	private char[] chars;
	private int startIndex;
	private int endIndex;

	// The constructor takes the chunk of the string that this thread is responsible for.
	public Task(char[] chars, int startIndex, int endIndex) {
		this.chars = chars;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	// The run method is called when the thread starts.
	public void run() {
		// This loop iterates over the chunk of the string that this thread is responsible for.
		for (int i = startIndex; i < endIndex; i++) {
			// Convert each character to lowercase and shift it by 25 positions.
			chars[i] = (char) ('a' + ('Z' - chars[i]));
		}
	}
}

}

