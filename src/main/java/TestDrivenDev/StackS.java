package TestDrivenDev;

import java.util.ArrayList;
import java.util.List;

public class StackS<T> {
    private int size;
    private List<T> list;
    private T lastElem;

    public StackS() {
        this.list = new ArrayList<>();
        //TODO with LinkedList will be more eficient
    }

    public int size() {
        return size;
    }

    public void push(T elem) {
        this.list.add(elem);
        this.size++;
        this.lastElem = elem;
    }

    public T peek() throws EmptyStackSException {
        if (this.size == 0) {
            throw new EmptyStackSException("The stack is empty");
        }
        return lastElem;
    }

    public T pop() throws EmptyStackSException {
        if (this.size == 0) {
            throw new EmptyStackSException("The stack is empty");
        }
        T result = this.lastElem;
        this.list.remove(this.lastElem);
        this.size--;
        if (this.size == 0) {
            this.lastElem = null;
        } else {
            this.lastElem = this.list.get(this.size - 1);
        }
        return result;
    }

    public boolean empty() {
        return this.size == 0;
    }
}
