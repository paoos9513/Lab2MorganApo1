package model;

public class Load {

    public final static String[] TYPELOAD = { "DANGEROUS", "PERISHABLE", "NOT PERISHABLE" };

    // Atributos
    private String typeLoad;

    private double weightByLoad;

    private int numBoxes;

    private Client owner;

    /**
    *this is the constructor method that allows me to give value to the attributes
    *@param typeLoad this parameter is of type String. typeLoad != null
    *@param weightByLoad this parameter is of type double. weightByLoad  != null
    *@param numBoxes this parameter is of type int. numBoxes != null
    *@param owner this parameter is of type Client owner != null
    *@author: Paola Osorio
    * <b>pre: </b> attributes must be created.
    * <b>post: </b> attributes with an assigned value 
    */    

    public Load(String typeLoad, double weightByLoad, int numBoxes, Client owner) {
        this.typeLoad = typeLoad;
        this.weightByLoad = weightByLoad;
        this.numBoxes = numBoxes;

        this.owner = owner;
    }

    /**
    *this method allows me to give the type of cargo that the client sends
    *@return String typeLoad
    *@author: Paola Osorio
    */

    public String getTypeLoad() {
        return typeLoad;
    }

    /**
    *this method allows me to change the type of cargo that the client sends
    *@param typeLoad this parameter is of type String. typeLoad != null
    *@author: Paola Osorio
    */   

    public void setTypeLoad(String typeLoad) {
        this.typeLoad = typeLoad;
    }

    /**
    *this method allows me to give the value that the client pays by weight
    *@return double weightByLoad
    *@author: Paola Osorio
    */

    public double getWeightByLoad() {
        return weightByLoad;
    }

   /**
    *this method allows me to modify the value that the client pays by weight
    *@param weightByLoadthis parameter is of type double. weightByLoad  != null
    *@author: Paola Osorio
    */   

    public void setWeightByLoad(double weightByLoad) {
        this.weightByLoad = weightByLoad;
    }

    /**
    *this method gives me the number of boxes that the client sends
    *@return int numBoxes
    *@author: Paola Osorio
    */

    public int getNumBoxes() {
        return numBoxes;
    }

   /**
    *This method allows me to modify the number of boxes that the client sends
    *@param numBoxes parameter is of type int. numBoxes  != null
    *@author: Paola Osorio
    */ 

    public void setNumBoxes(int numBoxes) {
        this.numBoxes = numBoxes;
    }

    /**
    *this method tells me who owns the cargo
    *@return Client owner
    *@author: Paola Osorio
    */

    public Client getOwner() {
        return owner;
    }
    /**
    *this method allows me to modify the name of the owner of the load
    *@param owner parameter is of type Client. owner != null
    *@author: Paola Osorio
    */ 

    public void setOwner(Client owner) {
        this.owner = owner;
    }

}