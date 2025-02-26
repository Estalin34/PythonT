from abc import ABC, abstractmethod

# Interfaz base para notificaciones
class Notificador(ABC):
    @abstractmethod
    def enviar(self, mensaje):
        pass

# Notificación por email (componente base)
class NotificadorEmail(Notificador):
    def enviar(self, mensaje):
        print(f"📧 Enviado Email: {mensaje}")

# Decorador base
class NotificadorDecorator(Notificador):
    def __init__(self, notificador):
        self.notificador = notificador

    def enviar(self, mensaje):
        self.notificador.enviar(mensaje)

# Decorador para SMS
class NotificadorSMS(NotificadorDecorator):
    def enviar(self, mensaje):
        super().enviar(mensaje)
        print(f"📩 Enviado SMS: {mensaje}")

# Decorador para WhatsApp
class NotificadorWhatsApp(NotificadorDecorator):
    def enviar(self, mensaje):
        super().enviar(mensaje)
        print(f"📱 Enviado WhatsApp: {mensaje}")

# Uso de los decoradores
notificador_basico = NotificadorEmail()
notificador_sms = NotificadorSMS(notificador_basico)
notificador_whatsapp = NotificadorWhatsApp(notificador_sms)

print("📢 Enviando mensaje con Email, SMS y WhatsApp:")
notificador_whatsapp.enviar("Hola, tiene un mensaje importante para usted.")
