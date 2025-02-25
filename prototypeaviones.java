import java.util.ArrayList;
import java.util.List;

abstract class Avion implements Cloneable {
    protected String modelo;
    protected int velocidadMaxima;
    protected List<String> armamento;

    public Avion(String modelo, int velocidadMaxima, List<String> armamento) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.armamento = new ArrayList<>(armamento);
    }

    public abstract Avion clone();

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Velocidad Máxima: " + velocidadMaxima + " km/h, Armamento: " + armamento;
    }
}

class AvionCombate extends Avion {
    private String maniobrabilidad;

    public AvionCombate(String modelo, int velocidadMaxima, List<String> armamento, String maniobrabilidad) {
        super(modelo, velocidadMaxima, armamento);
        this.maniobrabilidad = maniobrabilidad;
    }

    @Override
    public Avion clone() {
        return new AvionCombate(modelo, velocidadMaxima, armamento, maniobrabilidad);
    }

    @Override
    public String toString() {
        return super.toString() + ", Maniobrabilidad: " + maniobrabilidad;
    }
}

class AvionBombardero extends Avion {
    private int capacidadBombas;

    public AvionBombardero(String modelo, int velocidadMaxima, List<String> armamento, int capacidadBombas) {
        super(modelo, velocidadMaxima, armamento);
        this.capacidadBombas = capacidadBombas;
    }

    @Override
    public Avion clone() {
        return new AvionBombardero(modelo, velocidadMaxima, armamento, capacidadBombas);
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de Bombas: " + capacidadBombas + " kg";
    }
}

public class prototypeaviones{
    public static void main(String[] args) {
        List<String> armamentoCombate = List.of("Misiles AIM-9", "Misiles AIM-120");
        List<String> armamentoBombardero = List.of("Bombas JDAM", "Misiles de crucero");

        AvionCombate avionCombatePrototipo = new AvionCombate("F-22 Raptor", 2410, armamentoCombate, "Alta");
        AvionBombardero avionBombarderoPrototipo = new AvionBombardero("B-2 Spirit", 1010, armamentoBombardero, 20000);

        Avion avion1 = avionCombatePrototipo.clone();
        avion1.modelo = "F-35 Lightning II";
        
        Avion avion2 = avionBombarderoPrototipo.clone();
        avion2.modelo = "B-52 Stratofortress";

        System.out.println(avion1);
        System.out.println(avion2);
    }
}
