package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class J번_트리를안쓰는트리문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Piece> pieces = new ArrayList<>();
		if (N == 1) {
			pieces.add(new Piece(1, 1, 1, 1));
		} else if (N == 2) {
			pieces.add(new Piece(1, 2, 1, 1));
			pieces.add(new Piece(3, 3, 2, 2));
			pieces.add(new Piece(4, 4, 2, 1));
		} else if (N == 3) {
			pieces.add(new Piece(1, 3, 1, 1));
			pieces.add(new Piece(9, 9, 1, 3));
			pieces.add(new Piece(4, 5, 2, 1));
			pieces.add(new Piece(6, 8, 2, 2));
			pieces.add(new Piece(9, 9, 2, 3));
		} else if (N == 4) {
			pieces.add(new Piece(1, 3, 1, 1));
			pieces.add(new Piece(16, 16, 1, 4));
			pieces.add(new Piece(6, 9, 2, 1));
			pieces.add(new Piece(11, 11, 3, 1));
			pieces.add(new Piece(4, 5, 3, 2));
			pieces.add(new Piece(10, 10, 3, 4));
			pieces.add(new Piece(12, 15, 4, 1));
		} else {			
			boolean[] used = new boolean[N * N + 1];

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					int color = (i + j - 2) % N + 1;
					int pos = (i - 1) * N + j; 					
					while (pos <= N * N && ((pos - 1) % N + 1) != color) {
						pos++;
					}

					if (pos <= N * N && !used[pos]) {
						boolean canMerge = false;
						for (int p = 0; p < pieces.size(); ++p) {
							Piece piece = pieces.get(p);
							if (piece.e + 1 == pos && piece.row == i && piece.col + (piece.e - piece.s + 1) == j) {
								piece.e = pos;
								canMerge = true;
								break;
							}
						}

						if (!canMerge) {
							pieces.add(new Piece(pos, pos, i, j));
						}

						used[pos] = true;
					}
				}
			}
		}
		System.out.println(pieces.size());
		for (Piece piece : pieces) {
			System.out.println(piece.s + " " + piece.e + " " + piece.row + " " + piece.col);
		}
	}

	static class Piece {
		int s, e, row, col;

		Piece(int s, int e, int row, int col) {
			this.s = s;
			this.e = e;
			this.row = row;
			this.col = col;
		}
	}

}
