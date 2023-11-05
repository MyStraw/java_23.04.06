package _스터디_자료구조;

import Chap4_스택과큐.EmptyIntStackException;
import Chap4_스택과큐.OverflowIntStackException;

public class _3_스택 {
}
class IntStackTest {
    private int[] stk; // 스택용 배열
    private int capacity; // 스택의 크기
    private int ptr; // 스택 포인터

    // --- 실행시 예외: 스택이 비어있음 ---//

    // --- 생성자(constructor) ---//
    public IntStackTest(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없음
            capacity = 0;
        }
    }

    // --- 스택에 x를 푸시 ---//
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) // 스택이 가득 참
            throw new OverflowIntStackException(); // 생성자 통해 객체 만들어서 던져. 가득차면 overflow 예외로 간다.
        return stk[ptr++] = x; // 넣고 플러스
    }

    // --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public int pop() throws EmptyIntStackException {//
        if (ptr <= 0) // 스택이 빔
            throw new EmptyIntStackException();
        return stk[--ptr]; // ptr 앞에 하나 빼고 가져오고
    }

    // --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 빔
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // --- 스택을 비움 ---//
    public void clear() {
        ptr = 0;
    }

    // --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
            if (stk[i] == x)
                return i; // 검색 성공
        return -1; // 검색 실패
    }

    // --- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    // --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size() {
        return ptr;
    }

    // --- 스택이 비어있는가? ---//
    public boolean isEmpty() {
        return ptr <= 0; // 0보다 작거나 같으면 트루.
    }

    // --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
    public void dump() {
        if (isEmpty()) // isEmpty 만들었으니 밑에꺼 안쓰고 이걸로. 이런 큰 범주를 쓰는 연습.
            // if (ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
