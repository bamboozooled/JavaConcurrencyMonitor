import java.util.ArrayList;


/**
 * Created by owotu on 2018-04-07.
 */
public class OpenOffice{
    public static void main(String[] args){
        Office office = new Office2();
        ArrayList<Cleaner> allCleaners = new ArrayList<>();
        ArrayList<Clerk> allClerks = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            Cleaner cleaner = new Cleaner(i,office);
            allCleaners.add(cleaner);
        }

        for (int i = 0; i<allCleaners.size(); i++){
            allCleaners.get(i).start();
        }

        for (int i = 0; i < 120; i++){
            Clerk clerk = new Clerk(i,office);
            allClerks.add(clerk);
        }

        for (int i = 0; i<allClerks.size(); i++){
            allClerks.get(i).start();
        }


        try {
            for (int j = 0; j<allCleaners.size(); j++ ){
                allCleaners.get(j).join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        try{
            for (int j = 0; j<allClerks.size(); j++){
                allClerks.get(j).join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
        }

    }
}
