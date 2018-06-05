/**
 * Created by owotu on 2018-04-07.
 */
public class Office2 implements Office {
    Queue<Desk> cleanDesks;
    Queue<Desk> dirtyDesks;
    public Office2(){
        cleanDesks = new StackQueue<Desk>(100);
        dirtyDesks = new StackQueue<Desk>(100);
        for (int i = 0; i< 100; i++){
            Desk newDesk = new Desk(i);
            cleanDesks.enqueue(newDesk);
        }
    }
    @Override
    public synchronized Desk arrive() {
        while (cleanDesks.getSize() == 0){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Desk d = cleanDesks.dequeue();
        return d;
    }
    @Override
    public synchronized void leave(Desk desk) {
        desk.setDirty();
        dirtyDesks.enqueue(desk);
        notify();
    }
    @Override
    public synchronized Desk service() {
        while (dirtyDesks.getSize() == 0){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Desk d = dirtyDesks.dequeue();
        return d;
    }
    @Override
    public synchronized void Cleaned(Desk desk) {
        desk.setClean();
        cleanDesks.enqueue(desk);
        notify();
    }
}