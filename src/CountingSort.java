/**
 * Created by olsenp on 9/13/18.
 */
public class CountingSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) {
        // Take care of case when already sorted. We can guarantee we have at least 2 elements.
        if (array.length < 2)
            return array;

        // Generate indexArray -- to hold counts
        int maxVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal)
                maxVal = array[i];
        }
        maxVal++;

        int[] indexArray = new int[maxVal];

        // Count values in indexArray
        for (int i = 0; i < array.length; i++) {
            indexArray[array[i]]++;
        }

        // Increment indexArray left --> right
        for (int i = 1; i < indexArray.length; i++) {
            indexArray[i] += indexArray[i - 1];
        }

        /**
         * Note that this generating a sorted array you can do either forwards (starting at 0) or backwards as I
         * have here. Only doing it backwards like this is considered STABLE. Otherwise it's UNSTABLE (which
         * isn't a big deal...).
         */
        // Generate new sorted array
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            // Sorted array get's the location in indexArray. First decrementing it to account for 0 index.
            sortedArray[--indexArray[array[i]]] = array[i];;
        }

        return sortedArray;
    }
}
