package leetcode.labuladong.la16bst;

public class Demo4 {
	public static void main(String[] args) {
		int i = Demo4.test();

		System.out.println(i); // 10
	}

	public static int test() {
		int i = 10;
		try {
			// 因为在返回之前已经准备好数据了
			int a = 111/0;
			return i;

		}finally {
			i = 20;
			System.out.println("fff"+i);
		}
	}
}