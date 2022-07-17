import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException,
            CloneNotSupportedException {
//        Address s = new Address("天津");
//        Person p = new Person("张三", 23, s);
//        System.out.println("克隆前的地址：" + p.getAddress().getName());
//        Person cloneP = (Person) p.clone();
//        cloneP.getAddress().setName("北京");
//        cloneP.setAge(1232);
//        System.out.println("克隆后的地址：" +
//                cloneP.getAddress().getName()+cloneP.getAge());
//        System.out.println(p.getAge());
//
//        System.out.println(p);
//        System.out.println(cloneP);

//        HashSet<String> set = new HashSet<>();
//        set.add("4");
//        set.add("5");
//        set.add("1");
//        set.add("3");
//        set.add("2");
//        set.add("v");
//        set.add("c");
//        set.add("b");
//        set.add("a");
//        set.add(null);
//        set.add(null);
//        System.out.println(set.remove(null));
//        System.out.println(set.remove(null));
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        HashMap<String, String> map = new HashMap<>();
//        System.out.println(map.put("1","a"));
//        System.out.println(map.put("2","a"));
//        System.out.println(map.put("2","b"));
//        System.out.println(map.put("2","c"));
//        System.out.println(map.get("2"));


//        Map<Integer, String> map1 = new HashMap<Integer, String>();
//        map1.put(11, "11");
//        map1.put(22, "22");
//        long key1 = 11;
//        int key2 = 11;
//
//        System.out.println(map1.get(key1));  // null
//        System.out.println(map1.get(key2));  // 11
//
//        Map<Long, String> map2 = new HashMap<Long, String>();
//        map2.put(11L, "11");
//        map2.put(22L, "22");
//        System.out.println(map2.get(key1));  // 11
//        System.out.println(map2.get(key2));  // null

//        List<Number> list = new ArrayList<Integer>();

//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("2");
//        list.add("4");
//        list.iterator().remove();
////        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
//        String[] s = list.stream().toArray(String[]::new);
//        System.out.println(Arrays.toString(s));
//        StringBuilder sb = new StringBuilder();
//        sb.toString()

//        String s = "cat, dog, bird, dog, dog, cat";
//
//        String[] split = s.split(", ");
//        HashMap<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
//        for (Map.Entry<String, Long> item : collect.entrySet()) {
//            System.out.println(item.getKey()+"-->"+item.getValue());
//        }

//        System.out.println(new Main().preimageSizeFZF(1000000000));

        // round()==>加0.5后取其floor()
//        System.out.println(Math.round(-11.5));
//        System.out.println(Math.round(-11.6));
//        System.out.println(Math.round(11.4));
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(11.6));

        // 可以使用String类型，不能用long 浮点型等
//        String type= "http";
//        switch (type){
//            case "dubbo":
//                System.out.println(1);
//                break;
//            case "http":
//                System.out.println(2);
//                break;
//            default:
//                System.out.println(3);
//        }
    }


    public int preimageSizeFZF(int k) {
        return rightestIndex(k) - leftestIndex(k) + 1;
    }

    private int rightestIndex(int k){
        int left = 0;
        int right = 1000 * 1000 * 1000;
        int last = right;
        while(left<=right){
            int mid = left + ((right-left)>>1);
            if(trailingZeroes(mid)<= k){
                left = mid + 1;
                last = mid;
            }else{
                right = mid - 1;
            }
        }

        return last;

    }

    private int leftestIndex(int k){
        int left = 0;
        int right = 1000 * 1000 * 1000;
        int first = 0;
        while(left<=right){
            int mid = left + ((right-left)>>1);
            if(trailingZeroes(mid) >= k){
                right = mid - 1;
                first = mid;
            }else{
                left = mid + 1;
            }
        }

        return first;
    }
    // 阶乘后的零
    private int trailingZeroes(int n){

        int res = 0;
        for(int k=n;k/5>0;k/=5){
            res += k/5;
        }
        return res;
    }
}

class Address implements Cloneable {
    private String city;

    public Address(String name) {
        this.city = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return city;
    }

    public void setName(String name) {
        this.city = name;
    }
}

class Person implements Cloneable {
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.address = (Address) address.clone();
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}