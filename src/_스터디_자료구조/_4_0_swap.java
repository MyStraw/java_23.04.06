package _스터디_자료구조;

public class _4_0_swap {
	public static void swap(int[] bubble, int index1, int index2) {
		int temp = bubble[index1];
		bubble[index1] = bubble[index2];
		bubble[index2] = temp;
	}
}
