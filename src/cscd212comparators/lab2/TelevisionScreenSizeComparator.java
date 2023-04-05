package cscd212comparators.lab2;

import java.util.*;
import cscd212classes.lab2.Television;

public class TelevisionScreenSizeComparator implements Comparator<Television> {
    public int compare(final Television t1, final Television t2) {
        return t1.getScreenSize() - t2.getScreenSize();
    }
}
