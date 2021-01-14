package com.sherlock.data_structure;

/**
 * 类描述：
 * 创建人：Sherlock
 * 创建时间：2019-11-26
 * 修改备注：
 */
public class IntStack {
    private int[] data;
    private int maxSize;
    private int top = -1;

    public IntStack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    /**
     * 栈内元素和
     */
    public int elementCount() {
        return top + 1;
    }

    public boolean push(int object) {
        if (top + 1 < maxSize) {
            data[++top] = object;
            return true;
        }
        return false;
    }

    public int pop() {
        top--;
        return data[top + 1];
    }

    public int peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }
    public void clear() {
        top=-1;
    }
}
