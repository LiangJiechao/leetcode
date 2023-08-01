package offer.mayi.m2;

import java.util.*;

/**
 * @author liangjiechao
 * @date 2022/10/11 18:59
 **/
public class Main {

//            5
//            1 1
//            1 1
//            1 1
//            2 4
//            3 4

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        Map<String,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            String key = arr[i][0]+"-"+arr[i][1];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);

    }


}


//        List<int[]> collect = list.stream().sorted((o1, o2) -> o1[0] - o2[0]).collect(Collectors.toList());
//        List<Integer> todel = new ArrayList<>();
//
//        for (int i = 0; i < collect.size() - 1; i++) {
//            if (collect.get(i)[0] == collect.get(i + 1)[0]) {
//                todel.add(i);
//                todel.add(i + 1);
//            }
//        }
//        List<Integer> collect1 = todel.stream().distinct().collect(Collectors.toList());
//        int res = 0;
//        res += collect1.size();
//
//        for (int i = collect1.size()-1; i >=0 ; i--) {
//            collect.remove(collect1.get(i).intValue());
//        }
//
//        collect = collect.stream().sorted((o1, o2) -> o1[1] - o2[1]).collect(Collectors.toList());
//        for (int i = 0; i < collect.size() - 1; i++) {
//            if (collect.get(i)[1] == collect.get(i + 1)[1]) {
//                res++;
//            }
//        }
//
//        System.out.println(res);
//    }
//}
