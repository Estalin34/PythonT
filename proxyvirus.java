
interface Archivo {
    void ejecutar();
}
class Virus implements Archivo {
    private String nombre;

    public Virus(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void ejecutar() {
        System.out.println(" Ejecutando virus: " + nombre + " ");
    }
}

// Proxy que controla el acceso
class ProxyVirus implements Archivo {
    private Virus virus;
    private String usuario;
    private String nombre;

    public ProxyVirus(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        if (usuario.equals("admin")) {
            if (virus == null) {
                virus = new Virus(nombre);
            }
            virus.ejecutar();
        } else {
            System.out.println(" Acceso denegado al virus " + nombre + " para el usuario " + usuario);
        }
    }
}
public class proxyvirus {
    public static void main(String[] args) {
        Archivo virus1 = new ProxyVirus("Troyano.exe", "admin");
        virus1.ejecutar();

        Archivo virus2 = new ProxyVirus("Troyano.exe", "invitado");
        virus2.ejecutar();
    }
    
}
