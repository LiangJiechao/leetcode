package leetcode;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 * [[0,0,0],[0,1,1]]
 * 1
 * 1
 * 1
 *
 * @author xiaoliang
 * @date 2021/10/26 17:45
 **/
public class LC733_E_图像渲染 {

    /**
     * 递归实现，相当于infect
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        if (oldColor != newColor){
            infect(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    private static void infect(int[][] image, int sr, int sc, int oldColor, int newColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
        } else {
            return;
        }
        infect(image, sr - 1, sc, oldColor, newColor);
        infect(image, sr + 1, sc, oldColor, newColor);
        infect(image, sr, sc - 1, oldColor, newColor);
        infect(image, sr, sc + 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(img, 1, 1, 2);
        System.out.println(img);
    }
}
