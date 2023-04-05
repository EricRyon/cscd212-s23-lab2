package cscd212comparators.lab2;

import java.util.*;
import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {
    public int compare(final Television t1, final Television t2) {
        int x = t1.getResolution() - t2.getResolution();
        if (x == 0) {
            x = t1.getMake().compareTo(t2.getMake());
        }
        return x;
    }
}
