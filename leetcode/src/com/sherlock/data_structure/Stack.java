package com.sherlock.data_structure;

/**
 * 类描述：栈
 * 创建人：Sherlock
 * 创建时间：2019-11-26
 * 修改备注：
 */
public abstract class Stack<T> {
    public Stack(int size){

    }

    private T[] data;

    public abstract boolean push(T element);

    public abstract T pop();

    public abstract T peek();

    public abstract int elementCount();

    public abstract boolean isEmpty();

    public abstract void showElements();

}
