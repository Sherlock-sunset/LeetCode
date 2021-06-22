package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T93 {
    public List<String> restoreIpAddresses(String s) {
        char[] ipstr = s.toCharArray();
        List<String> ans = new ArrayList<>();
        trackBack(ans, ipstr, 1, new StringBuilder(), 0, "");
        return ans;
    }

    private void trackBack(List<String> ans, char[] ipstr, int ipPos, StringBuilder ip, int index, String ippart) {

        if (ipPos > 4 || index >= ipstr.length || (ipstr.length - index - 1 < 4 - ipPos))
            return; //ip地址最长是4段，单段数字长度0～255
        char c = ipstr[index];

        if (isValid(ippart.concat(c + ""))) { //扩充当前ip段长
            ip.append(c);
            if (!isCompleteIp(ip.toString(), ans, index, ipstr, ipPos)) {
                trackBack(ans, ipstr, ipPos, ip, index + 1, ippart.concat(c + ""));
            }
            ip.deleteCharAt(ip.length() - 1);
        }
        //扩充当前ip段
        if (!ippart.isEmpty() && isValid(c + "") && ipPos < 4) {
            ip.append("." + c);
            if (!isCompleteIp(ip.toString(), ans, index, ipstr, ipPos + 1)) {
                trackBack(ans, ipstr, ipPos + 1, ip, index + 1, c + "");
            }

            ip.deleteCharAt(ip.length() - 1);
            ip.deleteCharAt(ip.length() - 1);
        }
    }

    private boolean isCompleteIp(String ip, List<String> ans, int index, char[] ipstr, int parts) {
        if (index != ipstr.length - 1) {
            return false;
        }
        if (parts != 4) {
            return false;
        }
        ans.add(ip);
        return true;
    }

    private boolean isValid(String ip) {
        if (ip.isEmpty()) return false;
        if (ip.startsWith("0") && ip.length() > 1) return false;
        int ipNum = Integer.parseInt(ip);
        return ipNum >= 0 && ipNum <= 255;
    }
}
