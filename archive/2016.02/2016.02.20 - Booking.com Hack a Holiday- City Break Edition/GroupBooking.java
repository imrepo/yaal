package net.egork;

import net.egork.collections.intcollection.Heap;
import net.egork.generated.collections.comparator.IntComparator;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import static net.egork.io.IOUtils.*;
import static net.egork.misc.MiscUtils.*;
import static net.egork.misc.ArrayUtils.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class GroupBooking {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int g = in.readInt();
        int r = in.readInt();
        int[] b = readIntArray(in, g);
        int[] p = new int[r];
        int[] c = new int[r];
        readIntArrays(in, p, c);
        sort(b, IntComparator.DEFAULT);
        orderBy(p, c);
        Heap heap = new Heap((x, y) -> c[y] - c[x], r);
        int answer = 0;
        int at = 0;
        for (int i = 0; i < g; ) {
            while (at < r && p[at] <= b[i]) {
                heap.add(at++);
            }
            answer++;
            i += c[heap.poll()];
        }
        out.printLine(answer);
    }
}
