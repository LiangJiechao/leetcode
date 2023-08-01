package offer.yongyou.y20220925.y1;

/**
 * @author xiaoliang
 * @date 2022/09/25 15:54
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new Main().shrinkCircle(arr));
    }

    public int shrinkCircle(int[] circle) {
        if (circle.length == 1) {
            return circle[0];
        }
        int index = 0;
        for (int i = 0; i < circle.length; i++) {
            if (circle[i] == 1) {
                index = i;
                circle[i] = -1;
            }
        }
        int[] mod = {0, 1, 2, 3};
        int modIdx = 2;
        int originLen = circle.length;
        int len = circle.length;
        len -= 1;
        while (len != 1) {
            if (circle[index % originLen] == -1) {
                index++;
                continue;
            }
            if (circle[index % originLen] % 4 == mod[modIdx]) {
                circle[index % originLen] = -1;
                modIdx = (modIdx + 1) % 4;
                len--;
            }
            index++;
        }
        for (int item : circle) {
            if (item!=-1){
                return item;
            }
        }
        return -1;
    }
}
