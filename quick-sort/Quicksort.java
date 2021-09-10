import java.util.Arrays;

public class Quicksort {

    private static void quicksort(final int[] array) {
        quicksortImpl(array, 0, (array.length - 1));
    }

    private static void quicksortImpl(final int[] array, final int left, final int right) {
        if (left >= 0 && right >= 0 && left < right) {
            int p = partition(array, left, right);
            quicksortImpl(array, 0, p);
            quicksortImpl(array, p + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivotIdx = (left + right) / 2;
        int pivot = array[pivotIdx];
        int i = left;
        int j = right;

        while (true) {
            while (array[i] < pivot)
                i++;

            while (array[j] > pivot)
                j--;

            if (i >= j)
                return j;

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    /*static volatile int partitionTimes = 0;
    static volatile int quickSortImplTimes = 0;*/

    public static void main(final String []args) {
        int[] array = new int[]{2, 2, 59, 34, 89, 18, 18};
        quicksort(array);
        System.out.println(Arrays.toString(array));

        //System.out.println("partitionTimes=" + partitionTimes + "  quickSortImplTimes="+quickSortImplTimes);
    }
}