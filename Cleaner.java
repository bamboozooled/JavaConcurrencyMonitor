
/**
 * Created by owotu on 2018-04-07.
 */
public class Cleaner extends Thread {
    private boolean busy;
    Office office;
    int ID;
    public Cleaner(int ID, Office office2){
        this.ID = ID;
        busy = false;
        office = office2;
    }

    public void  setBusy(boolean val){
        busy = val;
    }

    public void run(){
        while (true){
            Desk desk = office.service();
            System.out.println("Cleaner " + String.valueOf(ID) + " is Cleaning the desk");
            try {
                sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            office.Cleaned(desk);
            System.out.println("Cleaner " + String.valueOf(ID) + " Cleaned the desk");
        }
    }


}
