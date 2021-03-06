package net.egork;

import net.egork.collections.ArrayUtils;
import net.egork.io.IOUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskB {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int[] numbers = IOUtils.readIntArray(in, count);
		long sum = ArrayUtils.sumArray(numbers);
		int head = 0;
		for (int i = 0; i < count; i++) {
			head += numbers[i];
			if ((head << 1) == sum) {
				out.printLine(i + 1);
				return;
			}
		}
		out.printLine(-1);
	}
}
