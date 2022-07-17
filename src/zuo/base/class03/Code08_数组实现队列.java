package zuo.base.class03;

/**
 * @author xiaoliang
 * @date 2021/10/06 17:32
 **/
public class Code08_数组实现队列 {
    static class ArrayQueue {
        int[] arrayQueue;
        //要出列的位置
        int start;
        //要入列的位置
        int end;
        //队列中元素个数
        int size;

        public ArrayQueue(int length) {
            if (length < 0) {
                throw new IllegalArgumentException("参数错误");
            }
            arrayQueue = new int[length];
            start = 0;
            end = 0;
            size = 0;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }

            size--;
            int result = arrayQueue[start];
            start = start == arrayQueue.length - 1 ? 0 : start + 1;
            return result;

        }

        public int peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }
            return arrayQueue[start];
        }

        public void push(int num) {
            if (size == arrayQueue.length) {
                throw new ArrayIndexOutOfBoundsException("队列满了");
            }
            size++;
            arrayQueue[end] = num;
            end = end == arrayQueue.length - 1 ? 0 : end + 1;
        }

    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        queue.push(10);
        int peek = queue.peek();
        System.out.println("peek = " + peek);
        int poll = queue.poll();
        System.out.println("poll = " + poll);
        queue.push(10);
        queue.push(1);
        queue.push(13434);
        while (queue.size != 0) {
            System.out.println(queue.poll());
        }
    }
}
