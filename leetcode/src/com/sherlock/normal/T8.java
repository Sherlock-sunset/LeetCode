package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class T8 {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int result = 0;
        char[] chars = s.toCharArray();
        boolean poistive = true;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, count = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                list.add(0, Integer.parseInt(chars[i] + ""));
                count++;
            } else {
                if (count == 0 && chars[i] != ' ' && chars[i] != '-' && chars[i] != '+')
                    return 0;
                if (count == 0 && i > 0 && (chars[i] != '-' || chars[i] != '+') && (chars[i - 1] == '-' || chars[i - 1] == '+'))
                    return 0;
                if (list.size() > 0)
                    break;
                else
                    poistive = chars[i] != '-';

            }
        }
        double count = 1.0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result += list.get(i);
            } else {
                double buff = list.get(i) * count + result;
                if (poistive && buff >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (!poistive && -buff <= Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                result = (int) buff;
            }
            count *= 10;
        }
        return poistive ? result : -result;
    }
}
