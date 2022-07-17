package b;

public class OddEvenExchange {

    public static int[] exchange(int[] nums) {
        if(nums==null || nums.length<=0){return nums;}
        int left=0;
        int right = nums.length-1;
        int temp = nums[left];
        while (left<right){
            while(left<right&&nums[right]%2==0){right--;}
            nums[left]=nums[right];
            while (left<right&&nums[left]%2==1){left++;}
            nums[right]=nums[left];
        }
        nums[left]=temp;

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(OddEvenExchange.exchange(nums));
    }
}
