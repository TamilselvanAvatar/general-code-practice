package generalAmbiguous;

import helperUtil.Printer;

/**
 * <p>Description: Need To Place A Plant And There Should Not Be Any Adjacent Plant</p>
 * <pre>
 *  Input:
 *      Garden: [0,1,0,1,0,0,0]
 *      Plants: 1
 *  Output: YES (Able to fill One Plant in Garden)
 *  0 - Empty Place
 *  1 - Already Plant Placed
 * </pre>
 */

public class PlacePlantInGarden {
    private static final Printer<Integer> print = new Printer<>();

    public static void main(String[] args) {
        Integer[] arr = {0, 0, 0, 0, 0};
        int plants = 1;
        placePlantInGarden(arr, plants);
    }

    public static void placePlantInGarden(Integer[] arr, int plants) {
        int availableSpace = 0;
        for (int i = 0; i < arr.length; i++) {
            if (checkAdjacentPlaceEmpty(arr, i)) {
                arr[i] = 1;
                availableSpace++;
            }
        }
        print.printAsArray(arr);
        System.out.println("Able to place the plants?: " + (availableSpace >= plants ? "YES" : "NO"));
    }

    public static boolean checkAdjacentPlaceEmpty(Integer[] arr, int index) {
        boolean isAdjacentEmpty = arr[index] == 0;
        try {
            isAdjacentEmpty = isAdjacentEmpty && arr[index - 1] == 0;
        } catch (Exception e) {
            isAdjacentEmpty = isAdjacentEmpty && index == 0;
        }
        try {
            isAdjacentEmpty = isAdjacentEmpty && arr[index + 1] == 0;
        } catch (Exception e) {
            isAdjacentEmpty = isAdjacentEmpty && index == arr.length - 1;
        }
        return isAdjacentEmpty;
    }

}
