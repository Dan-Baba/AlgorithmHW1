

/**
 * Created by olsenp on 9/13/18.
 */
public class MergeSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] array) { //base case.
        if(array.length < 2) return array;
        int[] left = new int[array.length / 2];
        int[] right = new int[(array.length - array.length / 2)];
        for(int i = 0; i < array.length; i++) {
            if(i < left.length) {
                left[i] = array[i];
            } else {
                right[i - left.length] = array[i];
            }
        }
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int sentinel = Math.max(Util.max(left), Util.max(right)) + 1;
        int[] answer = new int[left.length + right.length];
        left = append(left, sentinel);
        right = append(right, sentinel);
        int i = 0, j = 0;
        for(int k = 0; k < answer.length; k++) {
            if(left[i] < right[j]) {
                answer[k] = left[i++];
            } else {
                answer[k] = right[j++];
            }
        }
        return answer;
    }

    private int[] append(int[] left, int sentinel) {
        int[] answer = new int[left.length + 1];
        for(int i = 0; i < left.length; i++) answer[i] = left[i];
        answer[left.length] = sentinel;
        return answer;
    }
}
