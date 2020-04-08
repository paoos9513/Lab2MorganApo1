package ui;

import model.*;

import java.util.Scanner;

public class Pirate {

    private static Ship elPirata;

    public static void main(String[] args) {

        elPirata = new Ship();
        Scanner r = new Scanner(System.in);

        int opt = -1;

        System.out.println("Por favor agrege los 5 clientes: \n");
        Client clients[] = new Client[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese nombre del cliente " + (i + 1));
            String name = r.nextLine();
            System.out.println("Ingrese el numero de registro mercantil " + (i + 1));
            String commercialRNumber = r.nextLine();
            System.out.println("Ingrese la fecha de registro (dd-mm-aaaa)");
            String dateCR = r.nextLine();

            clients[i] = new Client(name, commercialRNumber, dateCR);
        }

        elPirata.setClients(clients);

        do {
            System.out.println(
                    "Escoja la opcion que desee:\n\n(1) Cargar el barco\n(2) Descargar el barco para iniciar un nuevo viaje\n(3) Mostrar peso total de la carga que transporta el barco\n(4) Verificar si se puede zarpar\n(5) Salir");

            opt = r.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Escoja el cliente:");

                    for (int i = 0; i < elPirata.getClients().length; i++) {
                        System.out.println((i + 1) + " " + elPirata.getClients()[i].getName());
                    }

                    int numClient = r.nextInt();
                    Client owner = elPirata.getClients()[numClient - 1];

                    System.out.println("Escoja el tipo de carga");
                    for (int i = 0; i < Load.TYPELOAD.length; i++) {
                        System.out.println((i + 1) + " " + Load.TYPELOAD[i]);
                    }
                    String typeLoad = Load.TYPELOAD[r.nextInt() - 1];

                    System.out.println("Ingrese el peso de cada caja en gramos");
                    double weightByLoad = (r.nextDouble() * 0.001);

                    System.out.println("Ingrese el numero de cajas");
                    int numBoxes = r.nextInt();

                    Load newLoad = new Load(typeLoad, weightByLoad, numBoxes, owner);

                    System.out.println(elPirata.addLoad(newLoad));

                    System.out.println(elPirata.upgradeClient(numClient));

                    break;

                case 2:
                    System.out.println(elPirata.emptyShip());
                    break;

                case 3:
                    System.out.println(
                            "El peso total de la carga hasta el momento es: " + elPirata.getTotalWeight() + "kilos");
                    break;

                case 4:
                    System.out.println(elPirata.canSail());
                    break;

                case 5:
                    System.out.println("Cerrando el programa");

                    break;

                default:
                    System.out.println("Opcion invalida, vuelva a intentar");
                    break;
            }

        } while (opt != 5);

        r.close();

    }
}