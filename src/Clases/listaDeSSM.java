package Clases;

import Exepciones.ReactivosLimitados;
import Exepciones.TemperaturaAlta;

import java.util.*;

public class listaDeSSM {
    private List<TestSSM> listaDeSSM;
    private Integer reactivos;

    public listaDeSSM() {
        listaDeSSM = new ArrayList<>();
        reactivos = 4;
    }

    public List<TestSSM> getListaDeSSM() {
        return listaDeSSM;
    }

    public void setListaDeSSM(List<TestSSM> listaDeSSM) {
        this.listaDeSSM = listaDeSSM;
    }

    public Integer getReactivos() {
        return reactivos;
    }

    public void setReactivos(Integer reactivos) {
        this.reactivos = reactivos;
    }

    @Override
    public String toString() {
        return "listaDeSSM{" +
                "listaDeSSM=" + listaDeSSM +
                '}';
    }

    public Boolean agregarPaciente(TestSSM testSSM) throws ReactivosLimitados {
        for (TestSSM testSSM1 : listaDeSSM) {
            if (testSSM1.getPaciente().equals(testSSM)) {
                //System.out.printf("Ya existe un paciente con este DNI");
                return false;
            }
        }
        this.reactivos = reactivos - 1;
        if (reactivos <= 0) {
            throw new ReactivosLimitados("No hay reactivos.");
        }

        listaDeSSM.add(testSSM);
        return true;
    }

    public Hashtable<Integer, Registro> testear() {
        Random random = new Random();
        Hashtable<Integer, Registro> tablaDeDatos = new Hashtable<>();
        for (TestSSM testSSM : listaDeSSM) {
            Double temperatura = random.nextDouble(36, 39);
            //Aca trate de hacerlo sin la necesidad de una clase llamada registro pero fui incapaz
            //String registro = "Temperatura: " + temperatura.toString() + " DNI: " + testSSM.getPaciente().getDNI();
            tablaDeDatos.put(testSSM.getNmoDeKit(), new Registro(testSSM.getPaciente().getDNI(), temperatura));
        }
        return tablaDeDatos;
    }

    public List<String> aislar(Hashtable<Integer, Registro> tablaDeDatos) throws TemperaturaAlta {
        //Hashtable<Integer, Registro> tablaDeDatos = testear();
        Enumeration<Integer> keys = tablaDeDatos.keys();
        List<String> pacientesAislados = new ArrayList<>();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            Registro value = tablaDeDatos.get(key);
            if (value.getTemperatura() >= 38) {
                for (TestSSM testSSM : listaDeSSM) {
                    if (value.getDNI() == testSSM.getPaciente().getDNI()) {
                        pacientesAislados.add("Nro de test: " + testSSM.getNmoDeKit() + " Barrio: " + testSSM.getPaciente().getBarrio());
                        throw new TemperaturaAlta("Temperatura Alta");
                    }
                }
            }
        }
        return pacientesAislados;
    }

}
