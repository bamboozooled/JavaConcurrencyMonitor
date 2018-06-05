public class Clerk extends Thread {
    Office office;
    int ID;
    public Clerk(int ID, Office office2){
        office = office2;
        this.ID = ID;
    }

    public void run(){

        while (true){
            Desk desk = office.arrive();
            System.out.println("Clerk " + String.valueOf(ID) + " is Working at Desk");
            try {
                sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            office.leave(desk);
            System.out.println("Clerk " + String.valueOf(ID) + " Left the desk");
        }
    }
}
