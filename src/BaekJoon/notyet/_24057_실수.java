package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _24057_실수 {
	static class Number {
		long a, b, c, d;

		Number(long a, long b, long c, long d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Number A = new Number(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()),
				Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Number B = new Number(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()),
				Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

		writeResult(bw, add(A, B));
		writeResult(bw, subtract(A, B));
		writeResult(bw, multiply(A, B));
		writeResult(bw, divide(A, B));

		br.close();
		bw.close();
	}

	static Number add(Number A, Number B) {
		long a = A.a * B.a;
		long b = A.b * B.a + B.b * A.a;
		long c = A.c * B.a + B.c * A.a;
		return simplify(new Number(a, b, c, A.d));
	}

	static Number subtract(Number A, Number B) {
		long a = A.a * B.a;
		long b = A.b * B.a - B.b * A.a;
		long c = A.c * B.a - B.c * A.a;
		return simplify(new Number(a, b, c, A.d));
	}

	static Number multiply(Number A, Number B) {
		long a = A.a * B.a;
		long b = A.b * B.b + A.c * B.c * A.d;
		long c = A.b * B.c + A.c * B.b;		
		return simplify(new Number(a, b, c, A.d));
	}

	static Number divide(Number A, Number B) {
		long a = Math.abs(B.b * B.b - B.c * B.c * B.d);
		long b = A.b * B.b - A.c * B.c * A.d;
		long c = A.c * B.b - A.b * B.c;
		if (B.b * B.b - B.c * B.c * B.d < 0) {
			b = -b;
			c = -c;
		}		
		return simplify(new Number(a, b, c, A.d));
	}

	static Number simplify(Number n) {
        long gcd = gcd(Math.abs(n.a), Math.abs(n.b), Math.abs(n.c));
        long a = n.a / gcd;
        long b = n.b / gcd;
        long c = n.c / gcd;
        if (a < 0) {
            a = -a;
            b = -b;
            c = -c;
        }
        return new Number(a, b, c, n.d);
    }

	static long gcd(long a, long b, long c) {
		return gcd(gcd(a, b), c);
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	static void writeResult(BufferedWriter bw, Number n) throws IOException {
		bw.write(n.a + " " + n.b + " " + n.c + " " + n.d);
		bw.newLine();
	}
}