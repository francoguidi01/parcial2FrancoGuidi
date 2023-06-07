import Clases.Persona;
import Clases.Registro;
import Clases.TestSSM;
import Clases.listaDeSSM;
import Exepciones.ReactivosLimitados;
import Exepciones.TemperaturaAlta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        listaDeSSM listaSSM = new listaDeSSM();
        try {
            TestSSM testSSM = new TestSSM(new Persona());
            testSSM.getPaciente().setDNI("123");
            TestSSM testSSM2 = new TestSSM(new Persona());
            testSSM2.getPaciente().setDNI("456");
            TestSSM testSSM3 = new TestSSM(new Persona());
            testSSM3.getPaciente().setDNI("789");
            TestSSM testSSM4 = new TestSSM(new Persona());
            testSSM4.getPaciente().setDNI("396");
            listaSSM.agregarPaciente(testSSM);
            listaSSM.agregarPaciente(testSSM2);
            listaSSM.agregarPaciente(testSSM3);
            listaSSM.agregarPaciente(testSSM4);
            System.out.printf(listaSSM.toString());


            Hashtable<Integer, Registro> tablaDeDatos = listaSSM.testear();
            try {
                List<String> listaPersonasAisladas = listaSSM.aislar(tablaDeDatos);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoAEscribir.json"))) {
                    gson.toJson(tablaDeDatos, Hashtable.class, bufferedWriter);
                    gson.toJson(listaPersonasAisladas, List.class, bufferedWriter);
                } catch (IOException e) {
                    System.out.println("Error en el archivo JSON");
                }

            } catch (TemperaturaAlta temperaturaAlta) {
                System.out.printf("Hay una persona con alta temperatura");
            }

        } catch (ReactivosLimitados reactivosLimitados) {
            System.out.printf("ERROR");
            System.out.println("Agregar mas reactivos? SI / NO ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.next().equals("SI")) {
                listaSSM.setReactivos(4);
                System.out.printf("Listoo");
            }
        }
    }
}