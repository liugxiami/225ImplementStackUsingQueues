package com.ccsi;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.empty()){
            System.out.println(stack.top());
            stack.pop();
        }
    }
}
//Implement the following operations of a stack using queues.
//push(x)--push element x onto stack.
//pop()--removes the element on top of the stack
//empty()--Return whether the stack is empty.
//wrong method.
class MyStack{
    Queue<Integer> myQueue=new LinkedList<>();
    Queue<Integer> helper=new LinkedList<>();
    public void push(int x){
       myQueue.offer(x);
    }
    public void pop(){
        while(!myQueue.isEmpty()){
            helper.offer(myQueue.poll());
        }
        helper.poll();
        while (!helper.isEmpty()){
            myQueue.offer(helper.poll());
        }
    }
    public int top(){
        while(!myQueue.isEmpty()){
            helper.offer(myQueue.poll());
        }
        int res=helper.peek();
        while(!helper.isEmpty()){
            myQueue.offer(helper.poll());
        }
        return res;
    }
    public  boolean empty(){
        return myQueue.isEmpty();
    }
}
//modified
class MyStack{
    Queue<Integer> myQueue=new LinkedList<>();
    Queue<Integer> helper=new LinkedList<>();
    public void push(int x){
        myQueue.offer(x);
    }
    public void pop(){
        int size=myQueue.size();
        for (int i = 0; i < size-1; i++) {
            helper.offer(myQueue.poll());
        }
        myQueue.poll();
        while (!helper.isEmpty()){
            myQueue.offer(helper.poll());
        }
    }
    public int top(){
        int size=myQueue.size();
        for (int i = 0; i < size-1; i++) {
            helper.offer(myQueue.poll());
        }
        int res=myQueue.peek();
        helper.offer(myQueue.poll());
        while(!helper.isEmpty()){
            myQueue.offer(helper.poll());
        }
        return res;
    }
    public  boolean empty(){
        return myQueue.isEmpty();
    }
}
