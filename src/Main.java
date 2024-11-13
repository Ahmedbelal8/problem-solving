import leet_code.CountingFairPairs;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testCountFairPairs();
    }

    public static void testCountFairPairs() {
        CountingFairPairs countingFairPairs = new CountingFairPairs();
        int[] nums = {0, 1, 7, 4, 4, 5};
        long res = countingFairPairs.countFairPairs(nums, 3, 6);
        System.out.println("Result is: " + res);
    }
}