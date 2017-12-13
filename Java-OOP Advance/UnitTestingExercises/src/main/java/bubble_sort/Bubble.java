package bubble_sort;

public class Bubble {
    public static int[] sort(int[] arrayToSort) {
        boolean isFinished = false;

        while (!isFinished) {
            isFinished = true;
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i] < arrayToSort[i + 1]) {
                    swapElements(arrayToSort, i, i + 1);
                    isFinished = false;
                }
            }
        }
        return arrayToSort;
    }

    private static void swapElements(int[] arrayToSort, int i, int j) {
        int temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[j];
        arrayToSort[j] = temp;
    }
}
