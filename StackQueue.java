public class StackQueue<T> implements Queue<T>{
    private int init;
    private int size;
    private T[] elems;
    private int top;
    private int head;

    @SuppressWarnings("unchecked")
    public StackQueue(int init){
        elems = (T[]) new Object[init]; //Initial capacity
        top = 0;
        head = 0;
    }

    public boolean isEmpty(){
        return top == 0 && head == 0; // top == 0 means it is empty

    }

    /*public boolean isFull(){
        if ((top) == init){ // Checking to see if top is equal to intital capacity. Meaning full.
            return true;
        }

        else{
            return false;
        }

    }*/

    public T peek(){
        if (top == 0){
            return elems[elems.length - 1];
        }
        return elems[top-1]; //Looking at last element
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        T[] temp = (T[]) new Object[1];
        temp[0] = elems[head];
        elems[head] = null;
        head = (head+1) % elems.length;
        size--;
        return temp[0];
    }

    public void enqueue(T elem){
        elems[top] = elem; //Adding element
        size++;
        top = (top+1) % elems.length;
    }
    @SuppressWarnings("unchecked")
    public void clear(){
        top = 0;

        for (int i = 0; i<elems.length; i++){
            elems[i] = null; // Scrubbing every element
        }
    }

    public int getSize(){
        return size;
    }
}
