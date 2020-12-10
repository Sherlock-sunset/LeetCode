package com.sherlock.normal;
//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。  1，5，10，50，100，500，1000
//I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
//X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
//C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
//给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

public class T12 {
    public String intToRoman(int num) {
        int t = num / 1000;
        num %= 1000;
        int h = num / 100;
        num %= 100;
        int ten = num / 10;
        num %= 10;
        StringBuilder sb = new StringBuilder();
        //0 <= t <=3
        sb.append(toRoman(t, "M", "M", "M"));
        sb.append(toRoman(h, "C", "D", "M"));
        sb.append(toRoman(ten, "X", "L", "C"));
        sb.append(toRoman(num, "I", "V", "X"));

        return sb.toString();
    }

    public String toRoman(int num, String... romans) {

        switch (num){
            case 1:
                return romans[0];
            case 2:
                return romans[0]+romans[0];
            case 3:
                return romans[0]+romans[0]+romans[0];
            case 4:
                return  romans[0]+romans[1];
            case 5:
                return  romans[1];
            case 6:
                return  romans[1]+romans[0];
            case 7:
                return  romans[1]+romans[0]+romans[0];
            case 8:
                return  romans[1]+romans[0]+romans[0]+romans[0];
            case 9:
                return  romans[0]+romans[2];

            default:
                return "";
        }

    }
}
