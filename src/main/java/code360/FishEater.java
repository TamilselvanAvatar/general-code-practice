package code360;

import java.util.Stack;

/**
 * <p>Link: <a href="https://www.naukri.com/code360/problem-of-the-day/easy?leftPanelTabValue=PROBLEM">RiverFish</a></p>
 * Problem statement
 * There is a river which flows in one direction. One day, the river has 'N' number of fishes.
 * You are given an array 'FISHES' of integers representing the size of 'N' fishes.
 * The fishes are present in the river from left to right(0th index represents the size of the leftmost fish).
 * As the river flows from left to right so the fishes also swim from left to right.
 * The fishes are of different sizes and have different speeds.
 * The larger fishes are faster than the smaller fishes. Also,
 * larger fishes can eat smaller fishes but can’t eat fishes of the same size.
 *
 * <p>Can you find the number of fishes that survive at the end of the day?</p>
 * <p>
 * Example:
 * Let the size of fishes present in the river from left to right be{ 4, 2, 3, 1, 5 }.
 *
 * <p>1. As fish 4 is faster and bigger than fish 2, so fish 4 will eat fish 2.<p></p>
 * Remaining fishes: { 4, 3, 1, 5 }
 *
 * <p>2. As fish 3 is faster and bigger than fish 1, so fish 3 will eat fish 1. </p>
 * Remaining fishes: { 4, 3, 5 }
 *
 * <p>3. As fish 4 is faster and bigger than fish 3, so fish 4 will eat fish 3.</p>
 * Remaining fishes: { 4, 5 }
 * <p>Now fish 5 cannot eat fish 4, as fish 5 is faster than fish 4 and they swim from left to right.</P>
 * Thus, fish 4 will never reach fish 5.
 * <p>
 * Finally, we are left with only 2 fishes.
 */

public class FishEater {

    public static void main(String[] args) {
        int[] fishes = {4, 3, 1, 5};
/*
        int[] fishes = {8, 1, 3};
        int[] fishes = {4, 4, 3, 4};
        int[] fishes = {1, 1, 1};
        int[] fishes = {5, 3, 5, 3};
*/
        fishEaterUsingNormalApproach(fishes);
        fishEaterUsingStack(fishes); //better solution
    }

    public static void fishEaterUsingNormalApproach(int[] fishes) {
        int totalFish = 0;
        boolean proceed = true;
        int index = fishes.length;

        while (proceed && index != 0) {
            int[] fasterFish = getFasterFishAndPosition(fishes, index);
            index = fasterFish[0];
            totalFish += 1;
            proceed = !(index == 0);
            /*
                System.out.println("Position: " + index + " FasterFish: " + fasterFish[1]);
                common part can be extracted removing branch
                if (0 == index) {
                    totalFish += 1;
                    proceed = false;

                } else {
                    totalFish += 1;
                }
            */
        }
        System.out.println("Normal Approach:");
        System.out.println("Last Day Number of fish alive: " + totalFish);

    }

    public static void fishEaterUsingStack(int[] fishes) {
        Stack<Integer> finalFishLive = new Stack<>();
        int totalFish = fishes.length;
        if (totalFish == 0) return;
        finalFishLive.push(fishes[0]);
        for (int i = 1; i < totalFish; i++) {
            int currentFish = fishes[i];
            Integer lastFish = finalFishLive.peek();
            if (lastFish <= currentFish) {
                finalFishLive.push(currentFish);
            }
        }
        System.out.println("Alternative Approach:");
        // finalFishLive.forEach(System.out::println);
        System.out.println("Last Day Number of fish alive: " + finalFishLive.size());
    }

    public static int[] getFasterFishAndPosition(int[] fishes, int len) {
        int position = len - 1;
        int fasterFish = fishes[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (fasterFish < fishes[i]) {
                position = i;
                fasterFish = fishes[i];
            }
        }
        return new int[]{position, fasterFish};
    }

}
