package com.sherlock.normal;

public class J45 {
    public String minNumber(int[] nums) {

        qucikSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public void qucikSort(int[] nums, int low, int high) {
        if (high <= low) return;
        int p = nums[low];
        int start = low, end = high;
        while (low < high) {
            while (low < high && compare(nums[high], p) >= 1) high--;
            nums[low] = nums[high];
            while (low < high && compare(nums[low], p) <= 1) low++;
            nums[high] = nums[low];
        }
        nums[low] = p;
        qucikSort(nums, start, low - 1);
        qucikSort(nums, low + 1, end);
    }

    public int compare(int n1, int n2) {
        String s1 = n1 + "" + n2;
        String s2 = n2 + "" + n1;
        if (s2.equals(s1)) return 1;
        return Double.parseDouble(s1) > Double.parseDouble(s2) ? 2 :0;
    }
}
