import java.util.HashMap;
import java.util.Map;


class TipoZombie {
    private String nombre;
    private String textura;
    private String sonido;

    public TipoZombie(String nombre, String textura, String sonido) {
        this.nombre = nombre;
        this.textura = textura;
        this.sonido = sonido;
    }

    public void mostrar(int x, int y) {
        System.out.println(" " + nombre + " aparece en (" + x + "," + y + ") con textura " + textura + " y sonido " + sonido);
    }
}


class FabricaZombies {
    private static final Map<String, TipoZombie> tipos = new HashMap<>();

    public static TipoZombie obtenerTipoZombie(String nombre, String textura, String sonido) {
        if (!tipos.containsKey(nombre)) {
            System.out.println(" Creando nuevo tipo de zombie: " + nombre);
            tipos.put(nombre, new TipoZombie(nombre, textura, sonido));
        }
        return tipos.get(nombre);
    }
}


class Zombie {
    private TipoZombie tipo;
    private int x, y;

    public Zombie(TipoZombie tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public void dibujar() {
        tipo.mostrar(x, y);
    }
}
public class flyweightzonbies {
    public static void main(String[] args) {
        TipoZombie zombieNormal = FabricaZombies.obtenerTipoZombie("Zombie Normal", "zombie_normal.png", "gruñido.mp3");
        TipoZombie zombieCorredor = FabricaZombies.obtenerTipoZombie("Zombie Corredor", "zombie_corredor.png", "grito.mp3");

        Zombie[] horda = {
            new Zombie(zombieNormal, 5, 10),
            new Zombie(zombieNormal, 15, 25),
            new Zombie(zombieCorredor, 30, 5),
            new Zombie(zombieCorredor, 50, 20)
        };

        for (Zombie z : horda) {
            z.dibujar();
        }
    }
    
}
