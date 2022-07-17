package offer.tengxunyinyue.y3;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author xiaoliang
 * @date 2022/04/27 18:58
 **/
public class Main {

    public static void main(String[] args) {
        new Main().howMany("aacbcbdefghijklmnopqrstuvwxyz",1);
    }

    // "aaabcd",2
    // 1
    public int howMany (String S, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()>=k){
                res++;
            }
        }
        return res;
    }
}
