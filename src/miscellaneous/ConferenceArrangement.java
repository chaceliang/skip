package miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/28/14.
 */
public class ConferenceArrangement {

    // Supposed the array is sorted by start time
    public static ArrayList<Conference> arrange(Conference[] A) {
        ArrayList<Conference> results = new ArrayList<Conference>();
        if (A == null || A.length <= 0) {
            return results;
        }

        results.add(A[0]);
        int i = 1;
        while (i < A.length) {
            Conference prev = results.get(results.size() - 1);
            Conference curr = A[i];
            if (curr.s >= prev.e) {
                results.add(curr);
            }
            i++;
        }

        return results;
    }
}

class Conference {
    int s;
    int e;

    public Conference(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
