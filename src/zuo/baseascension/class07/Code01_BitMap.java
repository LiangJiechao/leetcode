package zuo.baseascension.class07;

/**
 * BitArray 或叫 BitMap
 *
 * @author xiaoliang
 * @date 2021/09/18 15:01
 **/
public class Code01_BitMap {

    static class MyBitMap{ 
//         int 占有4字节 ==> 32bit
        int[] map;
//         byte 占有1字节 ==> 8bit
//        byte[] map;
        int size;

        public MyBitMap(int size){
            this.size=size;
            map = new int[getMapIndex(size-1)+1];
        }

        public int getMapIndex(int n){
            //相当于 除32，因为int一个占用4字节
            return n>>5;
        }

        // 在n位上设置 1
        public void set(int n){
            if(n < 0 || n > size-1){
                throw new IndexOutOfBoundsException("超过Bitmap有效范围");
            }
            int index = getMapIndex(n);
            int bit = n%8;
            map[index] |= (1 << bit);
        }

        // 在n位上设置 0
        public void clear(int n){
            if(n < 0 || n > size-1){
                throw new IndexOutOfBoundsException("超过Bitmap有效范围");
            }
            int index = getMapIndex(n);
            int bit = n%8;
            map[index] &= (~(1 << bit));
        }

        // 查看在n位上是否为 1
        public boolean get(int n){
            if(n < 0 || n > size-1){
                throw new IndexOutOfBoundsException("超过Bitmap有效范围");
            }
            int index = getMapIndex(n);
            int bit = n%8;
            return (map[index] & (1 << bit)) != 0 ;
        }

    }

    public static void main(String[] args) {
        MyBitMap bitMap = new MyBitMap(50);

        bitMap.set(49);
        System.out.println("bitMap.get(49) = " + bitMap.get(49));
        bitMap.set(0);
        System.out.println("bitMap.get(0) = " + bitMap.get(0));
        System.out.println("bitMap.get(10) = " + bitMap.get(10));
    }


}
