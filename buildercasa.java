class Casa {
    private int habitaciones;
    private int baños;
    private int pisos;
    private boolean piscina;
    private boolean garaje;

    public Casa(int habitaciones, int baños, int pisos, boolean piscina, boolean garaje) {
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.pisos = pisos;
        this.piscina = piscina;
        this.garaje = garaje;
    }

    public void mostrarInfo() {
        System.out.println("Casa con " + habitaciones + " habitaciones, " + baños + " baños, " + pisos + " pisos, " +
                (piscina ? "con piscina" : "sin piscina") + ", " + (garaje ? "con garaje" : "sin garaje") + ".");
    }
}

class CasaBuilder {
    private int habitaciones = 0;
    private int baños = 0;
    private int pisos = 1;
    private boolean piscina = false;
    private boolean garaje = false;

    public CasaBuilder setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
        return this;
    }

    public CasaBuilder setBaños(int baños) {
        this.baños = baños;
        return this;
    }

    public CasaBuilder setPisos(int pisos) {
        this.pisos = pisos;
        return this;
    }

    public CasaBuilder agregarPiscina() {
        this.piscina = true;
        return this;
    }

    public CasaBuilder agregarGaraje() {
        this.garaje = true;
        return this;
    }

    public Casa build() {
        return new Casa(habitaciones, baños, pisos, piscina, garaje);
    }
}

public class buildercasa {
    public static void main(String[] args) {
        Casa casa1 = new CasaBuilder().setHabitaciones(3).setBaños(2).setPisos(2).agregarGaraje().build();
        Casa casa2 = new CasaBuilder().setHabitaciones(5).setBaños(3).setPisos(3).agregarPiscina().agregarGaraje().build();

        casa1.mostrarInfo();  
        casa2.mostrarInfo();  
    }
}
