public class JITDemo {

    public static void main(String[] args) {

        // First run
        long start1 = System.currentTimeMillis();
        runLoop();
        long end1 = System.currentTimeMillis();

        // Second run (should be faster due to JIT)
        long start2 = System.currentTimeMillis();
        runLoop();
        long end2 = System.currentTimeMillis();

        System.out.println("First Run Time: " + (end1 - start1) + " ms");
        System.out.println("Second Run Time: " + (end2 - start2) + " ms");
    }

    public static void runLoop() {
        for (int i = 0; i < 100000000; i++) {
            int x = i * i;
        }
    }
}
