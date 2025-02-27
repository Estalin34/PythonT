from abc import ABC, abstractmethod

class Archivo(ABC):
    @abstractmethod
    def ejecutar(self):
        pass

class Virus(Archivo):
    def __init__(self, nombre):
        self.nombre = nombre
    
    def ejecutar(self):
        print(f" Ejecutando el virus: {self.nombre}... ")

class ProxyVirus(Archivo):
    def __init__(self, nombre, usuario):
        self.nombre = nombre
        self.usuario = usuario
        self.virus_real = None
    
    def ejecutar(self):
        if self.usuario == "admin":
            if not self.virus_real:
                self.virus_real = Virus(self.nombre)
            self.virus_real.ejecutar()
        else: 
            print(f" Acceso denegado: El usuario '{self.usuario}' no tiene permisos para ejecutar {self.nombre}")

# Simulación de acceso al virus
archivo1 = ProxyVirus("troyano.exe", "admin")
archivo1.ejecutar()

archivo2 = ProxyVirus("troyano.exe", "invitado")
archivo2.ejecutar()

