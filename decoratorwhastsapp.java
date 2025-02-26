// Interfaz base para notificaciones
interface Notificador {
    void enviar(String mensaje);
}

// Componente base: Notificación por Email
class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("📧 Enviado Email: " + mensaje);
    }
}

// Decorador base
abstract class NotificadorDecorator implements Notificador {
    protected Notificador notificador;

    public NotificadorDecorator(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje);
    }
}

// Decorador para SMS
class NotificadorSMS extends NotificadorDecorator {
    public NotificadorSMS(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("📩 Enviado SMS: " + mensaje);
    }
}

// Decorador para WhatsApp
class NotificadorWhatsApp extends NotificadorDecorator {
    public NotificadorWhatsApp(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("📱 Enviado WhatsApp: " + mensaje);
    }
}

// Uso del patrón Decorator
public class decoratorwhastsapp{
    public static void main(String[] args) {
        Notificador notificadorBasico = new NotificadorEmail();
        Notificador notificadorSMS = new NotificadorSMS(notificadorBasico);
        Notificador notificadorWhatsApp = new NotificadorWhatsApp(notificadorSMS);

        System.out.println("📢 Enviando mensaje con Email, SMS y WhatsApp:");
        notificadorWhatsApp.enviar("Hola, tiene un mensaje importante para usted.");
    }
}
