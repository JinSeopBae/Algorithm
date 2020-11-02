package stack;

import exception.EmptyIntStackException;
import exception.OverflowIntStackException;

public class MakeStack {

    private int max;

    private int point;

    private int[] stackArray;

    public MakeStack(int capacity) {
        point = 0;
        max = capacity;
        try {
            stackArray = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if(point >= max)
            throw  new OverflowIntStackException();
        return stackArray[point++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if(point <= 0)
            throw new EmptyIntStackException();
        return stackArray[--point];
    }

    public int peek() throws EmptyIntStackException {
        if(point <= 0)
            throw new EmptyIntStackException();
        return stackArray[point-1];
    }

    public static void main(String[] args) {
        MakeStack makeStack = new MakeStack(10);
        for(int i=0; i<10; i++) {
            makeStack.push(i);
        }
        System.out.println(makeStack.pop());
        makeStack.push(12);
        System.out.println(makeStack.peek());
        System.out.println(makeStack.peek());
    }
}
