/**
 * Created by owotu on 2018-04-07.
 */
public interface Queue<T> {
    public boolean isEmpty();
    /*public boolean isFull();*/
    public T peek();
    public T dequeue();
    public void enqueue(T obj);
    public void clear();
    public int getSize();
}
