package designpattern.optional;

import java.util.Optional;

/**
 * 
 * @author xiaoliang
 * @date 2021/12/12 11:29
 **/
public class OptionalTest {

    public static void main(String[] args) {
        User u = new User();
        Optional.ofNullable(u).orElse(createUser());
        Optional.ofNullable(u).orElseGet(()->createUser());
    }
    public static User createUser(){
        System.out.println("createUser...");
        User user = new User();
        user.setName("zhangsan");
        return user;
    }
}
class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
