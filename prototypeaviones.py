import copy

class AvionPrototype:
    def __init__(self, modelo, capacidad, alcance):
        self.modelo = modelo
        self.capacidad = capacidad
        self.alcance = alcance  

    def clone(self):
        return copy.deepcopy(self)

    def mostrar_info(self):
        return f"Modelo: {self.modelo}, Capacidad: {self.capacidad} pasajeros, Alcance: {self.alcance} km"


prototipo_avion = AvionPrototype("Boeing 747", 400, 13000)


avion1 = prototipo_avion.clone()
avion1.modelo = "Airbus A380"


avion2 = prototipo_avion.clone()
avion2.capacidad = 500

print(avion1.mostrar_info())  
print(avion2.mostrar_info())  
