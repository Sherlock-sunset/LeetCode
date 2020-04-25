package com.sherlock.data_structure;

/**
 * 类描述：
 * 创建人：Sherlock
 * 创建时间：2019-12-11
 * 修改备注：
 */
public class CharStack {
    private char[] data;
    private int maxSize;
    private int top = -1;

    public CharStack(int maxSize) {
        this.maxSize = maxSize;
        data = new char[maxSize];
    }

    /**
     * 栈内元素和
     */
    public int elementCount() {
        return top + 1;
    }

    public boolean push(char object) {
        if (top + 1 < maxSize) {
            data[++top] = object;
            return true;
        }
        return false;
    }

    public char pop() {
        top--;
        return data[top + 1];
    }

    public char peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }
}
