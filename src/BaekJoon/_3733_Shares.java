package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3733_Shares {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			String line; //이걸 먼저!
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				StringTokenizer st = new StringTokenizer(line);
				int N = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				int result = S / (N + 1);
				bw.write(result + "\n");
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
