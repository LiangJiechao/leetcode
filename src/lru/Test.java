package lru;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 测试LinkedHashMap
 * @author xiaoliang
 * @date 2021/08/27 15:59
 **/
public class Test {

    public static void main(String[] args) {
        LinkedHashMap<String, String> mapLRU = new LinkedHashMap<>(4,0.75F,true);
        mapLRU.put("a","A");
        mapLRU.put("b","B");
        mapLRU.put("c","C");
        mapLRU.put("d","D");
        mapLRU.put("e","E");
        mapLRU.put("f","F");

        Set<String> strings = mapLRU.keySet();
        strings.forEach(System.out::println);
    }
}
