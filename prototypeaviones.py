import copy
from abc import ABC, abstractmethod

class Avion(ABC):
    def __init__(self, modelo, velocidad_maxima, armamento):
        self.modelo = modelo
        self.velocidad_maxima = velocidad_maxima
        self.armamento = armamento
    
    @abstractmethod
    def clone(self):
        pass

    def __str__(self):
        return f"Modelo: {self.modelo}, Velocidad Máxima: {self.velocidad_maxima} km/h, Armamento: {', '.join(self.armamento)}"
    
class AvionCombate(Avion):
    def __init__(self, modelo, velocidad_maxima, armamento, maniobrabilidad):
        super().__init__(modelo, velocidad_maxima, armamento)
        self.maniobrabilidad = maniobrabilidad
    
    def clone(self):
        return copy.deepcopy(self)
    
    def __str__(self):
        return super().__str__() + f", Maniobrabilidad: {self.maniobrabilidad}"
    
class AvionBombardero(Avion):
    def __init__(self, modelo, velocidad_maxima, armamento, capacidad_bombas):
        super().__init__(modelo, velocidad_maxima, armamento)
        self.capacidad_bombas = capacidad_bombas
    
    def clone(self):
        return copy.deepcopy(self)
    
    def __str__(self):
        return super().__str__() + f", Capacidad de Bombas: {self.capacidad_bombas} kg"


avion_combate_prototipo = AvionCombate("F-22 Raptor", 2410, ["Misiles AIM-9", "Misiles AIM-120"], "Alta")
avion_bombardero_prototipo = AvionBombardero("B-2 Spirit", 1010, ["Bombas JDAM", "Misiles de crucero"], 20000)


avion1 = avion_combate_prototipo.clone()
avion1.modelo = "F-35 Lightning II"
avion1.velocidad_maxima = 1930

avion2 = avion_bombardero_prototipo.clone()
avion2.modelo = "B-52 Stratofortress"
avion2.capacidad_bombas = 32000

print(avion1)
print(avion2)
