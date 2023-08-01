package huihui.bitmap;

/**
 * 灰灰算法中的 BitMap, 可以看看jdk中的 BitSet源码
 * @author xiaoliang
 * @date 2021/08/27 14:44
 **/
public class BitMap{

    static class  MyBitmap{
        // 每个word是一个long类型元素，对应一个64位二进制数据
        private long [] words;
        // BitMap的位数大小
        private int size;

        public MyBitmap(int size){
            this.size = size;
            this.words = new long[(getWordIndex(size-1)+1)];
        }

        
        public  int getWordIndex(int bitIndex){
            // 右移6位，相当于除以64
            return bitIndex >> 6;
        }

        public boolean getBit(int bitIndex){
            if(bitIndex < 0 || bitIndex > size-1){
                throw new IndexOutOfBoundsException("超过Bitmap有效范围");

            }

            int wordIndex = getWordIndex(bitIndex);
            return (words[wordIndex] & (1L << bitIndex)) != 0;
        }

        public void setBit(int bitIndex){
            if(bitIndex <0 || bitIndex > size-1){
                throw new IndexOutOfBoundsException("超过Bitmap有效范围");
            }
            int wordIndex = getWordIndex(bitIndex);
            words[wordIndex] |= (1L << bitIndex);

        }
    }


    public static void main(String[] args) {
        MyBitmap bitMap = new MyBitmap(128);
        bitMap.setBit(127);
        bitMap.setBit(75);

        System.out.println("bitMap.getWordIndex(12) = " + bitMap.getWordIndex(12));//0
        System.out.println("bitMap.getWordIndex(127) = " + bitMap.getWordIndex(127));//1

        System.out.println(bitMap.getBit(127));
        System.out.println(bitMap.getBit(78));
    }
}