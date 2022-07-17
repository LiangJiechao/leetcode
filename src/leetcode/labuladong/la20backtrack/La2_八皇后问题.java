package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoliang
 * @date 2022/03/04 21:43
 **/
public class La2_八皇后问题 {

    public int nQueue(int n ){

        int[] record = new int[n];

        return dfs(record,0,n);
    }

    private int dfs(int[] record, int i, int n) {

        if (i==n){
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)){
                record[i]=j;
                res += dfs(record,i+1,n);
            }
        }

        return res;
    }

    private boolean isValid(int[] record, int i, int j) {

        // 与前面放进去的 i行比较
        for (int k = 0; k < i; k++) {
            // record[k] == j 表示在(i,j)放入的的皇后与前面已放的皇后处于同一列
            // Math.abs(k - i) == Math.abs(record[k] - j) 表示在(i,j)放入的的皇后与前面已放的皇后处于 统一对角线上
            if (record[k] == j || Math.abs(k-i) == Math.abs(record[k]-j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
//        Iterator<String> iterator = list.iterator();
//        int i = 0 ;
//        while(iterator.hasNext()) {
//            if (i == 3) {
//                iterator.remove(); //迭代器的remove()方法
//            }
//            System.out.println(iterator.next());
//            i++;
//        }

        System.out.println(list.getClass());
        System.out.println(list2.getClass());

        List<Integer> list3 = new ArrayList<>(100);
        System.out.println(list3.size());
    }
}
