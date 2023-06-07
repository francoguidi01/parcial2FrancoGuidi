package Clases;

public class Registro {
    private String DNI;
    private Double temperatura;

    public Registro() {
    }

    public Registro(String DNI, Double temperatura) {
        this.DNI = DNI;
        this.temperatura = temperatura;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "DNI='" + DNI + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }
}
