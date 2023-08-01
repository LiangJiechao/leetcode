package offer.bw.b2;

import java.util.*;

/**
 * 2. 属性字符串解析
 * 连续的K=V的字符串，每个K=V之间用”,”分隔，V中可嵌套K=V的连续字符串结构，例如“
 * key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8
 * 请编写如下函数，给定字符串，输出嵌套结构的HashMap
 * HashMap<String, Object> parse(String input) {
 * …
 * }
 * 要求：分别写一个递归的解法和一个非递归的解法
 *
 * @author liangjiechao
 * @date 2022/10/10 20:19
 **/
public class Main2 {




    HashMap<String, Object> parse(String input) {

        HashMap<String, Object> res = new HashMap<>();

        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        boolean flag = false;
        for (char c : input.toCharArray()) {
            if (c == ','){
                if(flag){
                    while (true){
                        Character poll = stack.poll();
                        if (poll=='['){
                            list.add(sb.reverse().toString());
                            sb = new StringBuilder();
                            break;
                        }else{
                            sb.append(c);
                        }

                    }
                }else {
                    while(!stack.isEmpty()){
                        sb.append(stack.poll());
                    }
                    list.add(sb.reverse().toString());
                    sb = new StringBuilder();
                }

            }else if(c=='['){
                flag=true;
                stack.push(c);
            }
            else if( c ==']'){
                while (true){
                    Character poll = stack.poll();
                    if (poll=='['){
                        list.add(sb.reverse().toString());
                        sb = new StringBuilder();
                        break;
                    }else{
                        sb.append(c);
                    }

                }
            }else {
                stack.push(c);
            }

        }

        // 这里先将 input 按正则划分
        String[] split = input.split(",");
        for (String s : split) {
            String[] entry = s.split("=");
            if (entry[1].contains("[")){
                res.put(entry[0],parse(entry[1]));
            }else {
                res.put(entry[0],entry[1]);
            }
        }
        return res;
    }
}
