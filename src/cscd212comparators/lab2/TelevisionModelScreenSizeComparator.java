package cscd212comparators.lab2;

import java.util.*;
import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {

    public int compare(final Television t1, final Television t2) {
        int x = t1.getModel().compareTo(t2.getModel());
        if (x == 0) {
            x = t1.getScreenSize() - t2.getScreenSize();
        }
        return x;
    }
}
