/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2;

import java.io.*;
import java.util.*;

/**
 * Esta es la clase que he creado para realizar el laboratorio 
 * @author dng
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    private static HashSet<String> namesSet = new HashSet<>();
    private static ArrayDeque<String> namesDeque = new ArrayDeque<>();
 
    
    /**
     * El metodo main del codigo donde se lee el TXT y se llaman a los 
     * metodos para ser ejecutados, teniendo un try-catch para en caso de que
     * exista un problema con el TXT
     * @param args 
     */
    public static void main(String[] args) {
        try ( FileReader nameReader = new FileReader("C:\\Users\\dng\\Downloads"
                + "\\Programación II (1).txt")) { // profe, no pude importarlo 
            //desde los paquetes, se me olvido como era
            BufferedReader documentReader = new BufferedReader(nameReader);
            String read;
            while ((read = documentReader.readLine()) != null) {
                if (namesSet.add(read)) {
                    namesDeque.addFirst(read);
                }
            }

            repitName();
            ordeningNames();
            agregName();
            searchName();
        } catch (Exception e) {
            System.err.println("El proceso de lectura del documento fallo"
                    + " profe :( (Yo importo el TXT desde mis archivos, entonces "
                    + "ese es el fallo, cargelo con la direccion de la ubicacion"
                    + " en sus archivos y funcionara");
        }
    }
    
    /**
     * metodo para determinar si hay nombres repetidos en el txt, donde recibe 
     * el namesDeque y verifica si hay otro nombre igual
     */
    public static void repitName() {
        ArrayList<String> namesList = new ArrayList<>(namesDeque);
        System.out.println("Nombres repetidos:");
        for (String name : namesList) {
            int frequency = Collections.frequency(namesList, name);
            if (frequency > 1) {
                System.out.println(name);
            }
        }
    }

    /**
     * metodo que ordena los nombres en la lista usando el collections.sort
     */
    public static void ordeningNames() {
        ArrayList<String> namesList = new ArrayList<>(namesDeque);
        Collections.sort(namesList);
        System.out.println("\nNombres ordenados:");
        for (String name : namesList) {
            System.out.println(name);
        }
    }

    /**
     * metodo para agregar nombres a la lista usando el namesDeque.addFirts
     */
    public static void agregName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nuevo nombre del "
                + "estudiante:");
        String newName = sc.nextLine();
        namesDeque.addFirst(newName);
        ordeningNames();
    }
    
    /**
     * metodo final para buscar nombres, editarlos o eliminarlos y que se 
     * muestre la lista actualizada despues de eso.
     */
    public static void searchName() {
        Scanner sn = new Scanner(System.in);
        Scanner az = new Scanner(System.in);

        System.out.println("Profe, digite lo que desea hacer: \n"
                + "1- Buscar estudiante, 2 - Editar, 3- Removerlo");
        int option = sn.nextInt();

        switch (option) {
            case 1:
                System.out.println("Ingrese el nombre a buscar profe");
                String searchName = az.nextLine();
                if (namesDeque.contains(searchName)) {
                    System.out.println(searchName + " se encuentra"
                            + " en la lista.");
                } else {
                    System.out.println("Aqui no esta, al igual que no estan"
                            + " los titulos de la liga.");
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre del estudiante "
                        + "que desea modificar profe :");
                String naEd = az.nextLine();
                if (namesDeque.contains(naEd)) {
                    System.out.println("Ingrese el nuevo nombre del sujeto :");
                    String neName = az.nextLine();
                    namesDeque.remove(naEd);
                    namesDeque.addFirst(neName);
                    System.out.println("Nombre editado exitosamente.");
                    System.out.println("Lista con los cambiosss:");
                    ordeningNames();
                } else {
                    System.out.println("El estudiante no se encuentra"
                            + " en la lista.");
                }
                break;
            case 3:
                System.out.println("Ingrese el nombre del estudiante "
                        + "que desea remover:");
                String nameRe = az.nextLine();
                if (namesDeque.contains(nameRe)) {
                    namesDeque.remove(nameRe);
                    System.out.println(nameRe + " fue removido exitosamente.");
                    System.out.println("Lista actualizada:");
                    ordeningNames();
                } else {
                    System.out.println("El estudiante no se"
                            + " encuentra en la lista.");
                }
                break;
            default:
                System.out.println("Numero no validation");
        }
    }

}
