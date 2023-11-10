public class A2p1 {

    // Counts for even and odd lengths
    private static int countA = 0; //Even 
    private static int countB = 0; //Odd

    public static void main(String[] args) {
        // Argument validation to ensure that there are three expected arguments.
        if (args.length != 3) {
            System.out.println("Expected three arguments: a, b, and n.");
            return;
        }

        // Reads three values from the command line.
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        // Input validation
        if (a >= b || a < 1 || b < 1 || n < 2 || n > 6) {
            System.out.println("Ensure a < b (both positive) and 2 <= n <= 6.");
            return;
        }

        System.out.println("Using " + n + " threads.");

        // Thread creation and start
        Thread[] threads = new Thread[n];
        int chunkSize = (b - a + 1) / n;
        int start = a, end;

        for (int i = 0; i < n; i++) {
            end = (i == n - 1) ? b : start + chunkSize - 1;
            threads[i] = new Thread(new CollatzWorker(start, end));
            threads[i].start();
            start = end + 1;
        }

        // Joining threads
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }

        // Final output
        System.out.println("Count for (A) is " + countA + ".");
        System.out.println("Count for (B) is " + countB + ".");
    }

    // Method to update the counts in a thread-safe manner
    private static synchronized void updateCounts(boolean isEven) {
        if (isEven) {
            countA++;
        } else {
            countB++;
        }
    }

    // Worker class to perform Collatz sequence calculations
    static class CollatzWorker implements Runnable {
        private final int start, end;

        CollatzWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            // Iterate through the specified range and update counts
            for (int i = start; i <= end; i++) {
                int length = collatzLength(i);
                updateCounts(length % 2 == 0);
            }
        }

        // Calculate the length of the Collatz sequence for a given number
        private int collatzLength(int number) {
            int length = 1;
            while (number != 1) {
                number = (number % 2 == 0) ? number / 2 : (3 * number + 1) / 2;
                length++;
            }
            return length;
        }
    }
}
