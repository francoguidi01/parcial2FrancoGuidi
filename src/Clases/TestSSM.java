package Clases;

import Exepciones.ReactivosLimitados;

import java.util.Random;

public class TestSSM {
   // private  Integer reactivos = 4;
    private Persona paciente;
    private  Integer nmoDeKit;

    public TestSSM() {
    }

    public TestSSM(Persona paciente) {
        Random random = new Random();
        this.paciente = paciente;
        this.nmoDeKit = random.nextInt(15)+1;

    }



    public Persona getPaciente() {
        return paciente;
    }

    public void setPaciente(Persona paciente) {
        this.paciente = paciente;
    }

    public Integer getNmoDeKit() {
        return nmoDeKit;
    }

    public void setNmoDeKit(Integer nmoDeKit) {
        this.nmoDeKit = nmoDeKit;
    }

    @Override
    public String toString() {
        return "TestSSM{" +
                "paciente=" + paciente +
                ", nmoDeKit=" + nmoDeKit +
                '}';
    }
}
