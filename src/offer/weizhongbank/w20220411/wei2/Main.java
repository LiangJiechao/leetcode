package offer.weizhongbank.w20220411.wei2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 一个数的左视野,和右视野的数都比它自己大,那么这个数就要努力,称之为努力的人
 *
 *  第一行输入n,x,y
 *  x表示左视野,y表示右视野, n表示有多少个数
 *  第二行输入一组数
 *
 *  求最左边那个努力的人
 *  也就是求数组中, 左右一定范围内都比他大的这样的数
 *  取最左边的那个
 */
public class Main {

    /**
     * 10 2 3
     * 10 8 7 1 9 2 6 4 3 5
     * <p>
     * 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // 思路：记录lmin与rmin
        int[] lmin = new int[n];
        int[] rmin = new int[n];

        lmin[0] = Integer.MAX_VALUE;
        rmin[n-1] = Integer.MAX_VALUE;

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n - 1; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peekLast()]) {
                stack.pollLast();
                //i- maxHeap.peek()<=x &&
            }
            stack.offerLast(i);

            lmin[i + 1] = arr[stack.peekFirst()];

            if (i - stack.peekFirst() >= x - 1) {
                stack.pollFirst();
            }
        }

        stack.clear();

        for (int i = n - 1; i > 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peekLast()]) {
                stack.pollLast();
                //i- maxHeap.peek()<=x &&
            }
            stack.offerLast(i);

            rmin[i - 1] = arr[stack.peekFirst()];

            if (stack.peekFirst() - i >= y - 1) {
                stack.pollFirst();
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < Math.min(lmin[i], rmin[i])) {
                System.out.println(i + 1);
                return;
            }
        }

    }
}
