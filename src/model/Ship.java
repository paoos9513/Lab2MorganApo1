package model;

import java.util.ArrayList;

public class Ship {

    private final static double MAXVALUE = 28000;

    private String captain;

    private Client[] clients;

    private ArrayList<Load> myLoads;

    private double totalWeight;

    public Ship() {

        captain = "Barba Negra";

        totalWeight = 0;

        myLoads = new ArrayList<Load>();

    }

    public String addLoad(Load newLoad) {

        String msg = "";

        boolean perecedera = false;
        boolean peligrosa = false;

        for (int i = 0; i < myLoads.size(); i++) {

            if (myLoads.get(i).getTypeLoad().equals("PERECEDERA")) {
                perecedera = true;
            }

            if (myLoads.get(i).getTypeLoad().equals("PELIGROSA")) {
                peligrosa = true;
            }

        }

        if (totalWeight < MAXVALUE) {

            if (perecedera && newLoad.getTypeLoad().equals("PELIGROSA")) {

                for (int i = 0; i < myLoads.size(); i++) {
                    if (myLoads.get(i).getOwner().getName().equals(newLoad.getOwner().getName())) {
                        myLoads.remove(i);
                    }
                }

                msg = "No se pudo cargar por que no cumple las condiciones.";

            } else {

                msg = "Se puede cargar y su valor incluyendo un posible descuento es: $" + costOfLoad(newLoad);

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

            if (peligrosa && newLoad.getTypeLoad().equals("PERECEDERA")) {

                for (int i = 0; i < myLoads.size(); i++) {
                    if (myLoads.get(i).getOwner().getName().equals(newLoad.getOwner().getName())) {
                        myLoads.remove(i);
                    }
                }

                msg = "No se pudo cargar por que no cumple las condiciones.";

            } else {

                msg = "Se puede cargar y su valor incluyendo un posible descuento es: $" + costOfLoad(newLoad);

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

            msg = "No se pudo cargar porque excede el peso permitido.";
        }

        return msg;

    }

    public String emptyShip() {

        myLoads.clear();
        totalWeight = 0;

        return "Barco descargado";
    }

    public String canSail() {
        String result = "No puede zarpar aun.";

        System.out.println(myLoads.size());
        if (myLoads.size() > 2) {
            result = "Si se puede zarpar";
        }

        System.out.println(totalWeight);
        if (totalWeight > 12000) {
            result = "Si se puede zarpar";
        }

        return result;
    }

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

    public String upgradeClient(int numClient) {
        String result = "";

        if (clients[numClient - 1].getTypeClient().equals("Normal")) {
            if (clients[numClient - 1].getWeightAccum() >= 35000) {
                result = "Felicidades!!! Este cliente subio de categoria a Plata";
            }
        }

        if (clients[numClient - 1].getTypeClient().equals("Plata")) {
            if (clients[numClient - 1].getWeightAccum() >= 55000 || clients[numClient - 1].getMoneyAccum() >= 2000000) {
                result = "Felicidades!!! Este cliente subio de categoria a Oro";
            }
        }

        if (clients[numClient - 1].getTypeClient().equals("Oro")) {
            if (clients[numClient - 1].getMoneyAccum() >= 5000000) {
                result = "Felicidades!!! Este cliente subio de categoria a Platinum";
            }
        }

        return result;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public ArrayList<Load> getMyLoads() {
        return myLoads;
    }

    public void setMyLoads(ArrayList<Load> myLoads) {
        this.myLoads = myLoads;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

}