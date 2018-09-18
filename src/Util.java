import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by olsenp on 9/13/18.
 */
public class Util {

    private static long startTime;

    public static int[] random(int limit) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < limit; i++) answer.add(i);
        Collections.shuffle(answer);
        int[] ans = new int[limit];
        for(int i = 0; i < limit; i++) ans[i] = answer.get(i);
        return ans;
    }

    public static int max(int[] array) {
        Integer max = null;
        for(int x : array) if(max == null || max < x) max = x;
        return max;
    }

    public static void timerStart() {
        startTime = System.currentTimeMillis();
    }

    public static long timerStop() {
        long ans = System.currentTimeMillis() - startTime;
        return ans;
    }

}
