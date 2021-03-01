package com.sherlock.normal;

public class T137 {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            /**
             * 通过 seenOnce ^ x 得到出现奇数次的数字  对出现偶数次对seenTwice取反与 seenOnce进行&操作确定奇数次的数，
             * 在这道题中奇数是3
             * */
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;

    }
}
