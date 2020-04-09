package model;

public class Client {

    public static final String[] TYPESCLIENT = { "Normal", "Plata", "Oro", "Platinum" };

    // Atributos
    private String name;

    private String commercialRNumber;

    private String dateCR;

    private double weightAccum;

    private double moneyAccum;

    private String typeClient;

    /**
    *this is the constructor method that allows me to give value to the attributes
    *@param name this parameter is of type String. name != null
    *@param commercialRNumber this parameter is of type String. commercialRNumber  != null
    *@param dateCR this parameter is of type String. dateCR != null
    *@author: Paola Osorio
    * <b>pre: </b> attributes must be created.
    * <b>post: </b> attributes with an assigned value 
    */

    public Client(String name, String commercialRNumber, String dateCR) {

        typeClient = TYPESCLIENT[0];

        this.name = name;
        this.commercialRNumber = commercialRNumber;
        this.dateCR = dateCR;

        weightAccum = 0;
        moneyAccum = 0;

    }
    /**
    *this method allows me to return the client's name
    *@return String name
    *@author: Paola Osorio
    */

    public String getName() {
        return name;
    }

    /**
    *this method allows me to change the client's name
    *@param name this parameter is of type String. name != null
    *@author: Paola Osorio
    */

    public void setName(String name) {
        this.name = name;
    }

    /**
    *this method allows me to give the registration number of the client's business registration
    *@return String commercialRNumber
    *@author: Paola Osorio
    */

    public String getCommercialRNumber() {
        return commercialRNumber;
    }

    /**
    *this method allows me to modify the registration number of the client's business registration
    *@param commercialRNumber this parameter is of type String. commercialRNumber  != null
    *@author: Paola Osorio
    */    

    public void setCommercialRNumber(String commercialRNumber) {
        this.commercialRNumber = commercialRNumber;
    }

    /**
    *this method allows me to give the client's registration date
    *@return String dateCR.
    *@author: Paola Osorio
    */

    public String getDateCR() {
        return dateCR;
    }

    /**
    *
    *
    *@param dateCR this parameter is of type String. dateCR != null
    *@author: Paola Osorio
    */

    public void setDateCR(String dateCR) {
        this.dateCR = dateCR;
    }

    /**
    *this method allows me to give the weight of the loads that the client has sent over time
    *@return double weightAccum
    *@author: Paola Osorio
    */

    public double getWeightAccum() {
        return weightAccum;
    }

    /**
    *this method allows me to change the weight of the loads that the client has sent over time
    *@param weightAccum this parameter is of type double. weightAccum != null
    *@author: Paola Osorio
    */

    public void setWeightAccum(double weightAccum) {
        this.weightAccum = weightAccum;
    }

    /**
    *this method allows me to give the price of each load sent by customer
    *@return double nomeyAccum
    *@author: Paola Osorio
    */

    public double getMoneyAccum() {
        return moneyAccum;
    }

    /**
    *this method allows me to change the price of each load sent by customer
    *@param moneyAccum this parameter is of type double. moneyAccum!= null
    *@author: Paola Osorio
    */

    public void setMoneyAccum(double moneyAccum) {
        this.moneyAccum = moneyAccum;
    }

    /**
    *this method allows me to return the type of client
    *@return String typeClient
    *@author: Paola Osorio
    */

    public String getTypeClient() {
        return typeClient;
    }

    /**
    *this method allows me to change the type of client
    *@param typeClient this parameter is of type String. typeClient != null
    *@author: Paola Osorio
    */

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

}