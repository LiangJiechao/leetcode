package offer.qunaer.q1;

/**
 * @author liangjiechao
 * @date 2022/10/12 16:27
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().compareVersion("1.0", "1.0.E"));
    }

    public int compareVersion(String version1, String version2) {
        // write code here


        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int len1 = arr1.length;
        int len2 = arr2.length;

        try {
            Integer.valueOf(arr1[len1 - 1]);
        } catch (Exception e) {
            len1--;
        }

        try {
            Integer.valueOf(arr2[len2 - 1]);
        } catch (Exception e) {
            len2--;
        }


        int i1 = 0;
        int i2 = 0;
        if (len1 == len2) {
            StringBuilder item1 = new StringBuilder();
            for (int i = 0; i < len1; i++) {
                item1.append(arr1[i]).append(".");
            }

            StringBuilder item2 = new StringBuilder();
            for (int i = 0; i < len2; i++) {
                item2.append(arr2[i]).append(".");
            }
            if (item1.toString().equals(item2.toString())) {
                return 0;
            }

            if (arr1[i1].equals(arr2[i2])) {
                i1++;
                i2++;
            } else {
                return Integer.parseInt(arr1[i1]) - Integer.parseInt(arr2[i2]);

            }
        }

        while (i1 < len1 && i2 < len2) {
            if (arr1[i1].equals(arr2[i2])) {
                i1++;
                i2++;
            } else {
                return Integer.parseInt(arr1[i1]) - Integer.parseInt(arr2[i2]);
            }
        }
        if (i1 == len1) {
            return -1;
        } else {
            return 1;
        }

    }
}
