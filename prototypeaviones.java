
class AvionPrototype implements Cloneable {
    private String modelo;
    private int capacidad;
    private int alcance;

    public AvionPrototype(String modelo, int capacidad, int alcance) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.alcance = alcance;
    }

    @Override
    public AvionPrototype clone() {
        try {
            return (AvionPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el avión", e);
        }
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void mostrarInfo() {
        System.out.println("Modelo: " + modelo + ", Capacidad: " + capacidad + " pasajeros, Alcance: " + alcance + " km");
    }
}

public class prototypeaviones {
    public static void main(String[] args) {
        AvionPrototype prototipo = new AvionPrototype("Boeing 747", 400, 13000);

       
        AvionPrototype avion1 = prototipo.clone();
        avion1.setModelo("Airbus A380");

        AvionPrototype avion2 = prototipo.clone();
        avion2.setCapacidad(500);

        avion1.mostrarInfo();  
        avion2.mostrarInfo();  
    }
}
