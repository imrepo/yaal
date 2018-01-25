package on2016_02.on2016_02_09_February_Challenge_2016.Chef_and_Strange_Operations;



import net.egork.numbers.IntegerUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ChefAndStrangeOperations {
    private static final long MOD = (long) (1e9 + 7);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int x = in.readInt() - 1;
        long m = in.readLong();
        long[] a = in.readLongArray(n);
        long answer = 0;
        long multiplier = 1;
        for (int i = x; i >= 0; i--) {
            answer += a[i] % MOD * multiplier % MOD;
            multiplier *= IntegerUtils.reverse(x - i + 1, MOD);
            multiplier %= MOD;
            multiplier *= (x - i + m) % MOD;
            multiplier %= MOD;
        }
        out.printLine(answer % MOD);
    }
}
