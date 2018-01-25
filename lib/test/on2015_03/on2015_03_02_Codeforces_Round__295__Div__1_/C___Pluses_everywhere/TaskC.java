package on2015_03.on2015_03_02_Codeforces_Round__295__Div__1_.C___Pluses_everywhere;



import net.egork.numbers.IntegerUtils;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskC {
	private static final long MOD = (long) (1e9 + 7);
	long[] factorial;
	long[] reverseFactorial;

	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int length = in.readInt();
		int count = in.readInt();
		char[] number = in.readCharArray(length);
		for (int i = 0; i < length; i++) {
			number[i] -= '0';
		}
		if (count == 0) {
			long answer = 0;
			for (char c : number) {
				answer *= 10;
				answer += c;
				answer %= MOD;
			}
			out.printLine(answer);
			return;
		}
		factorial = IntegerUtils.generateFactorial(length + 1, MOD);
		reverseFactorial = IntegerUtils.generateReverseFactorials(length + 1, MOD);
		long answer = 0;
		long sum = 0;
		for (int i = 1; i < length - 1; i++) {
			sum += number[i];
			if (i >= count - 1) {
				int exponent = length - 2 - i;
				long exp = IntegerUtils.power(10, exponent, MOD);
				answer += sum * c(i, count - 1) % MOD * exp % MOD;
				if (i >= count) {
					answer += number[i] * 10 * c(i, count) % MOD * exp % MOD;
				}
			}
		}
		answer += number[length - 1] * c(length - 1, count) % MOD;
		for (int i = 0; i < length - 1; i++) {
			if (length - 2 - i >= count - 1) {
				answer += number[0] * c(length - 2 - i, count - 1) % MOD * IntegerUtils.power(10, i, MOD) % MOD;
			}
		}
		out.printLine(answer % MOD);
	}

	long c(int n, int m) {
		return factorial[n] * reverseFactorial[m] % MOD * reverseFactorial[n - m] % MOD;
	}
}
