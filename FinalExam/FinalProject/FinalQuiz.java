// Valentina Silveira - Final Quiz code

public class FinalQuiz {

    private static int countA = 0;
    private static int countB = 0;

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java FinalQuiz a b n");
            return;
        }

	// Parse command-line arguments
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        if (a >= b || a % 2 == 0 || b % 2 == 0 || n < 2 || n > 6) {
            System.out.println("Invalid input. Make sure that a and b must be positive odd integers with a < b, and n is an integer between 2 and 6 inclusive.");
            return;
        }

	//Range Calculations
        int range = (b - a) / 2 + 1;
        int oneThread = range / n;
	
	System.out.println("Using " + n + " threads.");

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            int start = a + i * oneThread * 2;
            int end = i == n - 1 ? b : start + (oneThread * 2) - 2;

		threads[i] = new Thread(() -> {
                // Iterate through the range assigned to the thread
                	for (int j = start; j <= end; j += 2) {
                    		int listLength = collatzLength(j);
                    		// Check the condition for A and B and synchronizing the incrementation
                    		if (listLength >= j / 2.0) {
                        		synchronized (FinalQuiz.class) {
                            			countA++;  
                        		}
                    		} else {
                        		synchronized (FinalQuiz.class) {
                            		countB++;  
                        	}
                    	}
                }
        });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

	// Display Results
        System.out.println("Count for (A) is " + countA + ".");
        System.out.println("Count for (B) is " + countB + ".");
    }

    private static int collatzLength(int x) {
        int length = 1;
        while (x != 1) {
            if (x % 2 == 1) {
                x = (3 * x + 1) / 2;
            } else {
                x /= 2;
            }
            length++;
        }
        return length;
    }

}