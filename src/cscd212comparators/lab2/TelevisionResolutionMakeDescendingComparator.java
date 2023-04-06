package cscd212comparators.lab2;

import java.util.*;
import cscd212classes.lab2.Television;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {
    public int compare(final Television t1, final Television t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }
        int x = t2.getResolution() - t1.getResolution();
        if (x == 0) {
            x = t2.getMake().compareTo(t1.getMake());
        }
        return x;
    }
}
