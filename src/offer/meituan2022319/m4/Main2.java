package offer.meituan2022319.m4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 10 3 4
 * 6 8 -2 -5 2 9  1 3 -6 -3
 * @author xiaoliang
 * @date 2022/03/19 14:58
 **/
public class Main2 {
    static int arr[];
    static int max=0;
    static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k1=sc.nextInt();
        int k2=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        trackBack(k1,k2,0,0);
        System.out.println(max+" "+map.get(max));
    }
    private static void trackBack(int k1,int k2,int sum,int index){
        sum=sum%998244353;
        if(sum%k1==0&&sum%k2!=0){
            if(sum>=max){
                max=sum;
                if(map.containsKey(max)){
                    map.put(max,(map.get(max)+1)%998244353);
                }else{
                    map.put(max,1);
                }
            }
        }
        for(int i=index;i<arr.length;i++){
            sum+=arr[i];
            trackBack(k1,k2,sum,i+1);
            sum-=arr[i];
        }
    }
}
