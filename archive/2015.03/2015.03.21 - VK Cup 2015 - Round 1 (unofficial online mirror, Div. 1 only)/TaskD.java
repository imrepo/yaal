package net.egork;

import net.egork.datetime.Time;
import net.egork.io.IOUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		int count = in.readInt();
		int max = in.readInt();
		int segment = in.readInt();
		String[] times = IOUtils.readStringArray(in, count);
		int[] queue = new int[count];
		int start = 0;
		int end = 0;
		int[] at = new int[count];
		boolean achieved = false;
		int[] answer = new int[count];
		for (int i = 0; i < count; i++) {
			at[i] = Time.parse(times[i], "hh:mm:ss").totalSeconds();
			while (start < end && at[i] >= at[queue[start]] + segment) {
				start++;
			}
			if (end - start == max) {
				answer[i] = end;
				queue[end - 1] = i;
				continue;
			}
			answer[i] = end + 1;
			queue[end++] = i;
			if (end - start == max) {
				achieved = true;
			}
		}
		if (achieved) {
			out.printLine(end);
			for (int i : answer) {
				out.printLine(i);
			}
		} else {
			out.printLine("No solution");
		}
    }
}
