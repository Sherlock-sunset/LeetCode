package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        trackBack(result,n,0,0,true);
        return result;
    }
    //同一个分支上0，1，下1，0
    private void trackBack(List<Integer> result, int n, int pos,int num,boolean flag) {
        if (pos==n){
            result.add(num);
            return;
        }
        if (flag){//0,1
            trackBack(result,n,pos+1,num<<1,true);//0
            trackBack(result,n,pos+1,(num<<1)+1,false);//1
        }else {//1,0
            trackBack(result,n,pos+1,(num<<1)+1,false);//1
            trackBack(result,n,pos+1,num<<1,true);//0
        }
    }

}
