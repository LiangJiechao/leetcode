package offer.qunaer.q3;

import java.util.*;

/**
 * @author liangjiechao
 * @date 2022/10/12 16:27
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().showDown("SA SK SQ SJ S10 H10 C9"));


    }


    public String showDown(String inHand) {
        int[][] arr = new int[4][13];
        String[] str = inHand.split(" ");

        for (String s : str) {
            char huase = s.charAt(0);
            if (s.substring(1, s.length()).equals("A")) {
                if (huase == 'S') {
                    arr[0][0]++;
                } else if (huase == 'H') {
                    arr[1][0]++;
                } else if (huase == 'C') {
                    arr[2][0]++;
                } else if (huase == 'D') {
                    arr[3][0]++;
                }
            } else if (s.substring(1, s.length()).equals("J")) {
                if (huase == 'S') {
                    arr[0][10]++;
                } else if (huase == 'H') {
                    arr[1][10]++;
                } else if (huase == 'C') {
                    arr[2][10]++;
                } else if (huase == 'D') {
                    arr[3][10]++;
                }
            } else if (s.substring(1, s.length()).equals("Q")) {
                if (huase == 'S') {
                    arr[0][11]++;
                } else if (huase == 'H') {
                    arr[1][11]++;
                } else if (huase == 'C') {
                    arr[2][11]++;
                } else if (huase == 'D') {
                    arr[3][11]++;
                }
            } else if (s.substring(1, s.length()).equals("K")) {
                if (huase == 'S') {
                    arr[0][12]++;
                } else if (huase == 'H') {
                    arr[1][12]++;
                } else if (huase == 'C') {
                    arr[2][12]++;
                } else if (huase == 'D') {
                    arr[3][12]++;
                }
            } else {
                int num = Integer.parseInt(s.substring(1, s.length()));

                if (huase == 'S') {
                    arr[0][num-1]++;
                } else if (huase == 'H') {
                    arr[1][num-1]++;
                } else if (huase == 'C') {
                    arr[2][num-1]++;
                } else if (huase == 'D') {
                    arr[3][num-1]++;
                }
            }


        }

        Set<String> set = new HashSet<>(Arrays.asList(str));
        if (validHuangjia(set)) {
            return "HuangJiaTongHuaShun";
        }
        if (validTongHuaShun(arr)) {
            return "TongHuaShun";
        }
        if (validSiTiao(arr)) {
            return "SiTiao";
        }
        if (validHuLu(arr)) {
            return "HuLu";
        }
        if (validTonghua(arr)) {
            return "TongHua";
        }
        if (validShunZi(arr)) {
            return "ShunZi";
        }
        if (validSanTiao(arr)) {
            return "SanTiao";
        }
        if (validLiangDui(arr)) {
            return "LiangDui";
        }
        if (validYiDui(arr)) {
            return "YiDui";
        }
        return "GaoPai";


    }

    private boolean validYiDui(int[][] arr) {
        int[] nums = new int[13];
        int duishu = 0;
        for (int i = 0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }
        for (int num : nums) {
            if (num == 2) {
                duishu++;
            }
        }
        return duishu == 1;

    }

    private boolean validLiangDui(int[][] arr) {
        int[] nums = new int[13];
        int duishu = 0;
        for (int i =0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }
        for (int num : nums) {
            if (num == 2) {
                duishu++;
            }
        }
        return duishu >= 2;
    }

    private boolean validSanTiao(int[][] arr) {
        int[] nums = new int[13];
        for (int i = 0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }
        for (int num : nums) {
            if (num == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean validShunZi(int[][] arr) {
        int[] nums = new int[13];
        for (int i = 0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0
                    && nums[i + 1] > 0
                    && nums[i + 2] > 0
                    && nums[i + 3] > 0
                    && nums[(i + 4)%13] > 0) {
                return true;
            }
        }
        return false;

    }

    private boolean validTonghua(int[][] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) {
                    count++;
                }
            }
            if (count >= 5) {
                flag = true;
            }
        }
        return flag;
    }

    private boolean validHuLu(int[][] arr) {

        int[] nums = new int[13];
        for (int i = 0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }

        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                flag1 = true;
            }
            if (nums[i] == 2) {
                flag2 = true;
            }
        }
        return flag1 && flag2;
    }

    private boolean validSiTiao(int[][] arr) {
        boolean flag = false;
        int[] nums = new int[13];
        for (int i = 0; i < 13; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += arr[j][i];
            }
            nums[i] = count;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                flag = true;
            }
        }
        return flag;

    }

    private boolean validTongHuaShun(int[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr[0].length - 3; j++) {
                if (arr[i][j] > 0
                        && arr[i][j + 1] > 0
                        && arr[i][j + 2] > 0
                        && arr[i][j + 3] > 0
                        && arr[i][(j + 4)&13] > 0) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean validHuangjia(Set<String> set) {

        if ((set.contains("SA") && set.contains("SK") && set.contains("SQ") && set.contains("SJ") && set.contains("S10"))

                ||
                (set.contains("HA") && set.contains("HK") && set.contains("HQ") && set.contains("HJ") && set.contains("H10"))

                ||
                (set.contains("CA") && set.contains("CK") && set.contains("CQ") && set.contains("CJ") && set.contains("C10"))
                ||
                (set.contains("DA") && set.contains("DK") && set.contains("DQ") && set.contains("DJ") && set.contains("D10"))
        ) {
            return true;
        }
        return false;
    }
}
