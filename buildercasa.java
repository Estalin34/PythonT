import java.util.ArrayList;
import java.util.List;

class Casa {
    private List<String> partes;
    private double costoTotal;

    public Casa() {
        this.partes = new ArrayList<>();
        this.costoTotal = 0.0;
    }

    public void agregar(String parte, double costo) {
        this.partes.add(parte + " - $" + String.format("%.2f", costo));
        this.costoTotal += costo;
    }

    @Override
    public String toString() {
        return "Casa:\n" + String.join("\n", partes) + "\nCosto Total: $" + String.format("%.2f", costoTotal);
    }
}

abstract class ConstructorCasa {
    protected Casa casa;

    public ConstructorCasa() {
        this.casa = new Casa();
    }

    public abstract void construirParedes();
    public abstract void construirTecho();
    public abstract void construirPuertas();
    public abstract void construirVentanas();

    public void reiniciar() {
        this.casa = new Casa();
    }

    public Casa obtenerCasa() {
        return this.casa;
    }
}

class ConstructorCasaMadera extends ConstructorCasa {
    public void construirParedes() {
        casa.agregar("Paredes de madera", 5000);
    }

    public void construirTecho() {
        casa.agregar("Techo de madera", 3000);
    }

    public void construirPuertas() {
        casa.agregar("Puertas de madera", 1200);
    }

    public void construirVentanas() {
        casa.agregar("Ventanas de vidrio", 2000);
    }
}

class ConstructorCasaLadrillo extends ConstructorCasa {
    public void construirParedes() {
        casa.agregar("Paredes de ladrillo", 8000);
    }

    public void construirTecho() {
        casa.agregar("Techo de tejas", 5000);
    }

    public void construirPuertas() {
        casa.agregar("Puertas de metal", 2000);
    }

    public void construirVentanas() {
        casa.agregar("Ventanas de vidrio reforzado", 2500);
    }
}

class DirectorCasa {
    private ConstructorCasa constructor;

    public DirectorCasa(ConstructorCasa constructor) {
        this.constructor = constructor;
    }

    public void construirCasaCompleta() {
        constructor.reiniciar();
        constructor.construirParedes();
        constructor.construirTecho();
        constructor.construirPuertas();
        constructor.construirVentanas();
    }

    public void construirCasaBasica() {
        constructor.reiniciar();
        constructor.construirParedes();
        constructor.construirTecho();
    }
}

public class buildercasa {
    public static void main(String[] args) {
        
        ConstructorCasa constructorMadera = new ConstructorCasaMadera();
        DirectorCasa directorMadera = new DirectorCasa(constructorMadera);
        directorMadera.construirCasaCompleta();
        System.out.println(constructorMadera.obtenerCasa());

        
        ConstructorCasa constructorLadrillo = new ConstructorCasaLadrillo();
        DirectorCasa directorLadrillo = new DirectorCasa(constructorLadrillo);
        directorLadrillo.construirCasaCompleta();
        System.out.println(constructorLadrillo.obtenerCasa());
    }
}
