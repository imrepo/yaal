package net.egork;

import net.egork.collections.intcollection.IntPair;
import net.egork.collections.map.Counter;
import net.egork.io.IOUtils;
import net.egork.misc.ArrayUtils;
import net.egork.misc.MiscUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Map;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int required = in.readInt();
		int[] first = new int[count];
		int[] second = new int[count];
		IOUtils.readIntArrays(in, first, second);
		MiscUtils.decreaseByOne(first, second);
		Counter<IntPair> counter = new Counter<>();
		int[] qty = new int[count];
		for (int i = 0; i < count; i++) {
			if (first[i] > second[i]) {
				int temp = first[i];
				first[i] = second[i];
				second[i] = temp;
			}
			counter.add(new IntPair(first[i], second[i]));
			qty[first[i]]++;
			qty[second[i]]++;
		}
		int[] order = ArrayUtils.order(qty);
		int at = count;
		long answer = 0;
		for (int i = 0; i < count; i++) {
			at = Math.max(at, i + 1);
			while (at - 1 > i && qty[order[i]] + qty[order[at - 1]] >= required)
				at--;
			answer += count - at;
		}
		for (Map.Entry<IntPair, Long> entry : counter.entrySet()) {
			int sum = qty[entry.getKey().first] + qty[entry.getKey().second];
			if (sum >= required && sum - entry.getValue() < required)
				answer--;
		}
		out.printLine(answer);
	}
}
