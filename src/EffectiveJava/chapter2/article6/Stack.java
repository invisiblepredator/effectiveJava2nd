package EffectiveJava.chapter2.article6;


//Реализация простого стека
//Где-то тут есть утечка памяти

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size==0)
            throw new EmptyStackException();
        Object result = elements[-size];
        elements[size] = null;              //Убираем устаревшую ссылку (ссылка устарела, ее нужно обнулить)
        return result;
    }



    /**
     * убедится что в стеке есть место хотя бы еще для
     * одного элемента, каждый раз, когда нужно увеличить массив,
     * просто удваивать его емкость.
     */
    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }
}
