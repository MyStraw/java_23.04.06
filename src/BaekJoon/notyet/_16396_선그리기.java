package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _16396_선그리기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Segment> segments = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			segments.add(new Segment(start, end));
		}
	
		Collections.sort(segments, new Comparator<Segment>() {
			public int compare(Segment s1, Segment s2) {
				return s1.start - s2.start;
			}
		});

		int totalLength = 0;
		int currentStart = segments.get(0).start;
		int currentEnd = segments.get(0).end;

		for (int i = 1; i < segments.size(); i++) {
			Segment segment = segments.get(i);
			if (segment.start <= currentEnd) {			
				currentEnd = Math.max(currentEnd, segment.end);
			} else {			
				totalLength += currentEnd - currentStart;
				currentStart = segment.start;
				currentEnd = segment.end;
			}
		}
	
		totalLength += currentEnd - currentStart;

		System.out.println(totalLength);
	}

	static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
