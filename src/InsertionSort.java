/**
 * Created by olsenp on 9/13/18.
 */
public class InsertionSort implements SortingAlgorithm
{
    public int[] sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while(j >= 0 && key < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }
}
