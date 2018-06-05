public class Desk {
    boolean clean;
    boolean occupied;
    int ID;
    public Desk(int ID2){
        clean = true;
        occupied = false;
        this.ID = ID2;
    }

    public boolean getClean(){
        return clean;
    }

    public void setClean(){
        this.clean = clean;
    }

    public void setDirty(){
        this.clean = false;
    }

    public void setOccupied(boolean val){
        this.occupied = val;
    }
}
