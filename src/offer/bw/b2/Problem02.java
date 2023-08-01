import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem02 {

    public static void main(String[] args) {
        Problem02 problem02 = new Problem02();
        String input = "key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8";
        HashMap<String, Object> parse = problem02.parse(input);
        for(Map.Entry entry : parse.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getClass());
        }
    }

    public HashMap<String, Object> parse(String input) {
        int len = input.length();
        if(len == 0) return null;
        StringBuilder key = new StringBuilder();
        StringBuilder val = new StringBuilder();
        HashMap<String, Object> map = new HashMap<>();
        int i = 0;
        while(i < len) {
            char cur = input.charAt(i);
            if(cur == ',') i++;
            else if(cur == '=') {
                if(input.charAt(i + 1) != '[') {
                    while(i + 1 < len && input.charAt(i + 1) != ',') {
                        val.append(input.charAt(i + 1));
                        i++;
                    }
                    i++;
                    map.put(key.toString(), val.toString());
                    key.delete(0, key.length());
                    val.delete(0, val.length());
                }else {
                    String str = input.substring(i + 1, len);
                    String sub = getMapValue(str);
                    HashMap<String, Object> res = parse(getMapValue(sub));
                    map.put(key.toString(), res);
                    key.delete(0, key.length());
                    i += 1 + sub.length() + 2;
                }
            }else {
                key.append(cur);
                i++;
            }
        }
        return map;
    }

    public String getMapValue(String input) {
        int len = input.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < len) {
            char cur = input.charAt(i);
            if(cur == '[') stack.push('[');
            else if(cur == ']') {
                stack.pop();
                if(stack.isEmpty()) break;
            }
            i++;
        }
        return input.substring(1, i);
    }
}
