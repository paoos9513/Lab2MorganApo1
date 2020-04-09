package model;

import java.util.ArrayList;

public class Ship {

    private final static double MAXVALUE = 28000;

    //atributos

    private String captain;

    private Client[] clients;

    private ArrayList<Load> myLoads;

    private double totalWeight;

    /**
    *this is the constructor method that allows me to give value to the attributes
    *@author: Paola Osorio
    */  

    public Ship() {

        captain = "Barba Negra";

        totalWeight = 0;

        myLoads = new ArrayList<Load>();

    }

    /**
    *this method allows me to enter a new load as long as the restrictions are met
    *@param newLoad this parameter is of type Load. newLoad != null
    *@return String msg
    *@author: Paola Osorio
    */

    public String addLoad(Load newLoad) {

        String msg = "";

        boolean perecedera = false;
        boolean peligrosa = false;

        for (int i = 0; i < myLoads.size(); i++) {

            if (myLoads.get(i).getTypeLoad().equals("PERISHABLE")) {
                perecedera = true;
            }

            if (myLoads.get(i).getTypeLoad().equals("DANGEROUS")) {
                peligrosa = true;
            }

        }

        if (totalWeight < MAXVALUE) {

            if (perecedera && newLoad.getTypeLoad().equals("DANGEROUS")) {

                for (int i = 0; i < myLoads.size(); i++) {
                    if (myLoads.get(i).getOwner().getName().equals(newLoad.getOwner().getName())) {
                        myLoads.remove(i);
                    }
                }

                msg = "Could not load because it does not meet the conditions.";

            } else {

                msg = "It can be loaded and its value including a possible discount is: $" + costOfLoad(newLoad);

                myLoads.add(newLoad);

                totalWeight += newLoad.getWeightByLoad() * newLoad.getNumBoxes();

                for (int i = 0; i < clients.length; i++) {
                    if (newLoad.getOwner().getName().equals(clients[i].getName())) {
                        clients[i].setWeightAccum(
                                clients[i].getWeightAccum() + (newLoad.getNumBoxes() * newLoad.getWeightByLoad()));
                        clients[i].setMoneyAccum(clients[i].getMoneyAccum() + (costOfLoad(newLoad)));
                    }
                }

            }

            if (peligrosa && newLoad.getTypeLoad().equals("PERISHABLE")) {

                for (int i = 0; i < myLoads.size(); i++) {
                    if (myLoads.get(i).getOwner().getName().equals(newLoad.getOwner().getName())) {
                        myLoads.remove(i);
                    }
                }

                msg = "Could not load because it does not meet the conditions.";

            } else {

                msg = "It can be loaded and its value including a possible discount is: $" + costOfLoad(newLoad);

                myLoads.add(newLoad);

                totalWeight += newLoad.getWeightByLoad() * newLoad.getNumBoxes();

                for (int i = 0; i < clients.length; i++) {
                    if (newLoad.getOwner().getName().equals(clients[i].getName())) {
                        clients[i].setWeightAccum(
                                clients[i].getWeightAccum() + (newLoad.getNumBoxes() * newLoad.getWeightByLoad()));
                        clients[i].setMoneyAccum(clients[i].getMoneyAccum() + (costOfLoad(newLoad)));
                    }
                }

            }

        } else {

            for (int i = 0; i < myLoads.size(); i++) {
                if (myLoads.get(i).getOwner().getName().equals(newLoad.getOwner().getName())) {
                    myLoads.remove(i);
                }
            }

            msg = "Could not be loaded because it exceeds the allowed weight.";
        }

        return msg;

    }

    /**
    *this method allows me to empty the boat
    *@return Unloaded ship
    *@author: Paola Osorio
    */

    public String emptyShip() {

        myLoads.clear();
        totalWeight = 0;

        return "Unloaded ship";
    }

    /**
    *this method allows me to check if you can already set sail or not
    *@return It cannot set sail yet or If you can set sail.
    *@author: Paola Osorio
    */

    public String canSail() {

        String result = "It cannot set sail yet.";

        System.out.println(myLoads.size());
        if (myLoads.size() > 2) {
            result = "If you can set sail";
        }

        System.out.println(totalWeight);
        if (totalWeight > 12000) {
            result = "If you can set sail";
        }

        return result;
    }

    /**
    *This method allows me to evaluate the cost of the cargo and if it meets the conditions, the discount will be applied.
    *@param newLoad this parameter is of type Load. newLoad != null 
    *@return double cost
    *@author: Paola Osorio
    */

    public double costOfLoad(Load newLoad) {
        double cost = 0;
        double totalWeightOfBoxes = newLoad.getWeightByLoad() * newLoad.getNumBoxes();

        if (newLoad.getTypeLoad().equals(Load.TYPELOAD[0])) {
            cost = totalWeightOfBoxes * 390000;
        } else if (newLoad.getTypeLoad().equals(Load.TYPELOAD[1])) {
            cost = totalWeightOfBoxes * 250000;
        } else {
            cost = totalWeightOfBoxes * 80000;
        }

        if (newLoad.getOwner().getTypeClient().equals(Client.TYPESCLIENT[1])
                && newLoad.getTypeLoad().equals(Load.TYPELOAD[1])) {
            cost = cost - (cost * 0.015);
        }

        if (newLoad.getOwner().getTypeClient().equals(Client.TYPESCLIENT[2])
                && (newLoad.getTypeLoad().equals(Load.TYPELOAD[1]) || newLoad.getTypeLoad().equals(Load.TYPELOAD[2]))) {
            cost = cost - (cost * 0.03);
        }

        if (newLoad.getOwner().getTypeClient().equals(Client.TYPESCLIENT[3])) {
            cost = cost - (cost * 0.05);
        }

        return cost;
    }

    /**
    *This method evaluates the amount of cargo that the client has sent or the money that has been paid and increases it from category
    *@param numClient this parameter is of type int. numClient != null 
    *@return String result
    *@author: Paola Osorio
    */

    public String upgradeClient(int numClient) {
        String result = "";

        if (clients[numClient - 1].getTypeClient().equals("Normal")) {
            if (clients[numClient - 1].getWeightAccum() >= 35000) {
                result = "Congratulations!!! This customer went up to Silver";
            }
        }

        if (clients[numClient - 1].getTypeClient().equals("Silver")) {
            if (clients[numClient - 1].getWeightAccum() >= 55000 || clients[numClient - 1].getMoneyAccum() >= 2000000) {
                result = "Congratulations!!! This customer upgraded to Gold";
            }
        }

        if (clients[numClient - 1].getTypeClient().equals("Gold")) {
            if (clients[numClient - 1].getMoneyAccum() >= 5000000) {
                result = "Congratulations!!! This customer upgraded to Platinum";
            }
        }

        return result;
    }

    /**
    *this method gives me the name of the captain
    *@return captain
    *@author: Paola Osorio
    */

    public String getCaptain() {
        return captain;
    }

    /**
    *this method allows me to change the captain's name
    *@param captain this parameter is of type String. captain != null
    *@author: Paola Osorio
    */

    public void setCaptain(String captain) {
        this.captain = captain;
    }

   
 /**​
​    * This method returns the five relations with clients. 
    *@return an array != null of type Client
    *@author: Paola Osorio
    */

    public Client[] getClients() {
        return clients;
    }

    /**
    *this method allows me to change the five clients that the boat has
    *@param client this parameter is an array of type Client[]. clients != null
    *@author: Paola Osorio
    */

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    /**
    *this method allows me to store the amount of cargo the ship receives
    *@return ArrayList<Load> myLoads
    *@author: Paola Osorio
    */

    public ArrayList<Load> getMyLoads() {
        return myLoads;
    }

    /**
    *This method allows me to modify the amount of cargo the ship receives
    *@param myLoads this is an array of type Load arrayList. myLoads != null
    *@author: Paola Osorio
    */

    public void setMyLoads(ArrayList<Load> myLoads) {
        this.myLoads = myLoads;
    }

    /**
    *this method gives me the total weight that the boat carries
    *@return double totalWeight
    *@author: Paola Osorio
    */

    public double getTotalWeight() {
        return totalWeight;
    }

    /**
    *this method allows me to modify the total weight of the boat
    *@param totalWeight this is a type parameter double. totalWeight != null
    *@author: Paola Osorio
    */

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

}