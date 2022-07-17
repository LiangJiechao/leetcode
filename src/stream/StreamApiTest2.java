package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author xiaoliang
 * @date 2022/05/31 14:55
 **/
public class StreamApiTest2 {

    public static void main(String[] args) {
        List<String> list = Stream.of("aa", "bb", "cc", "aa").collect(Collectors.toList());
        System.out.println(list);
        String[] strings = list.toArray(new String[0]);


    }
}
