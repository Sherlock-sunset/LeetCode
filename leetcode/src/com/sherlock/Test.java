package com.sherlock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //while (sc.hasNext())
        //ThreadPoolExecutor executor = new ThreadPoolExecutor()
        System.out.println(findMaxButtons(new int[]{1, 1, 4,5,1,4}));
        System.out.println(findMaxButtons(new int[]{2,2,2}));

//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.next());
//        String nums = sc.next();
//        System.out.println(solution2(nums.toCharArray(), n));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param buttons int整型一维数组
     * @return long长整型
     */
    public static long findMaxButtons(int[] buttons) {
        // write code here
        int ans = 0;
        for (int i = 0; i < buttons.length; i++) {
            int len = buttons[i];
            if (len == 1) {
                ans++;
            } else {
                ans += (i + 1) * (len - 1) + 1;
            }
        }
        return ans;
    }

    public static int solution(char[] nums, int n) {
        // write code here
        int ans = 0;
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i] - '0';
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, Integer.MAX_VALUE);
        ans = Math.min(trackback(num, map, 0, 0, false, true), trackback(num, map, 0, 0, true, true));
        return ans;
    }

    public static int solution2(char[] nums, int n) {
        // write code here
        int ans = 0, blue = 0, red = 0;
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i] - '0';
            if (num[i] == 1) blue++;
        }
        //Arrays.sort(num);
        red = num.length - blue;
        boolean flag = blue <= red;
        boolean isContinue = true;
        for (int i = 0; i < num.length; i++) {
            if (i < (flag ? blue : red)){
                if (flag && num[i] ==0) ans++;//红改蓝
                else if(!flag && num[i] ==1) ans++;//蓝改红
            }else {
                if (isContinue && ((flag &&num[i]==1)||(!flag &&num[i] == 0))){
                    continue;
                }else {
                    isContinue = false;
                    if (flag && num[i] ==1) ans++;//蓝改红
                    else if(!flag && num[i] ==0) ans++;
                }
            }
        }

        return ans;
    }

    private static int trackback(int[] num, HashMap<Integer, Integer> map, int p, int cur, boolean isBlue, boolean flag) {
        if (p >= num.length) {
            if (cur < map.get(0)) map.put(0, cur);
            return cur;
        }
        int ans = cur;
        if (isBlue) {
            ans += num[p] == 1 ? 0 : 1;
        } else {
            ans += num[p] == 0 ? 0 : 1;
        }

        if (ans >= map.get(0)) return ans;

        ans = trackback(num, map, p + 1, ans, isBlue, flag);
        if (flag) ans = Math.min(ans, trackback(num, map, p + 1, ans, !isBlue, false));
        return ans;


    }
}
