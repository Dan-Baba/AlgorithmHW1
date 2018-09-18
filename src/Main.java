public class Main {

    private static final int START_SIZE = 1024;
    private static final int STOP_SIZE = 1024*1024;
    private static final int INSERTION_STOP = 1024 * 128;
    private static final int STEP_SIZE = 2;
    private static final int TRIAL_COUNT = 10;

    public static void main(String[] args) {

        SortingAlgorithm[] algorithms = new SortingAlgorithm[3];
        algorithms[2] = new InsertionSort();
        algorithms[1] = new MergeSort();
        algorithms[0] = new CountingSort();

        int[][] arrays = new int[TRIAL_COUNT][];
        System.out.println("size\tcount\tmerge\tinsertion");
        for(int size = START_SIZE; size <= STOP_SIZE; size *= STEP_SIZE) {
            long avg_time = 0;
            System.out.print(size + "\t");
            for(int i = 0; i < TRIAL_COUNT; i++) {
                arrays[i] = Util.random(size);
            }
            for(int i = 0; i < algorithms.length; i++) {
                Util.timerStart();
                for(int trial = 0; trial < TRIAL_COUNT; trial++) {
                    if(i != 2 || size <= INSERTION_STOP) algorithms[i].sort(arrays[trial]);
                }
                avg_time = Util.timerStop() / TRIAL_COUNT;
                if(i != 2 || size <= INSERTION_STOP) System.out.print(avg_time + (i == algorithms.length - 1 ? "\n" : "\t"));
                else System.out.print((i == algorithms.length - 1 ? "\n" : "\t"));
            }
        }
        int[] random = Util.random(100000);

    }
}
