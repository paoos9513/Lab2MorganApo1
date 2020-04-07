package model;

public class Load {

    public final static String[] TYPELOAD = { "PELIGROSA", "PERECEDERA", "NO PERECEDERA" };

    private String typeLoad;

    private double weightByLoad;

    private int numBoxes;

    private Client owner;

    public Load(String typeLoad, double weightByLoad, int numBoxes, Client owner) {
        this.typeLoad = typeLoad;
        this.weightByLoad = weightByLoad;
        this.numBoxes = numBoxes;

        this.owner = owner;
    }

    public String getTypeLoad() {
        return typeLoad;
    }

    public void setTypeLoad(String typeLoad) {
        this.typeLoad = typeLoad;
    }

    public double getWeightByLoad() {
        return weightByLoad;
    }

    public void setWeightByLoad(double weightByLoad) {
        this.weightByLoad = weightByLoad;
    }

    public int getNumBoxes() {
        return numBoxes;
    }

    public void setNumBoxes(int numBoxes) {
        this.numBoxes = numBoxes;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

}