public class Driver {
    public static void main(String[] args) {
        CountingSort algo = new CountingSort();

        // int[] random = Util.random(1000);
        // int[] random = {48, 176, 319, 12, 8, 502};
        int[] random = {2, 1};
        int[] sorted = algo.sort(random);

        System.out.println("WINNER!");
    }
}
