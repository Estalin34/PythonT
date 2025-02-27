class TipoZombie:
    def __init__(self, nombre, textura, sonido):
        self.nombre = nombre
        self.textura = textura
        self.sonido = sonido
    
    def mostrar(self, x, y):
        print(f" Mostrando {self.nombre} en ({x}, {y}) con textura {self.textura} y sonido {self.sonido}")

class FabricaZombies:
    _tipos = {}

    @staticmethod
    def obtener_tipo_zombie(nombre, textura, sonido):
        if nombre not in FabricaZombies._tipos:
            print(f" Creando nuevo tipo de zombie: {nombre}")
            FabricaZombies._tipos[nombre] = TipoZombie(nombre, textura, sonido)
        return FabricaZombies._tipos[nombre]

class Zombie:
    def __init__(self, tipo, x, y):
        self.tipo = tipo
        self.x = x
        self.y = y
    
    def dibujar(self):
        self.tipo.mostrar(self.x, self.y)


tipo_zombie_normal = FabricaZombies.obtener_tipo_zombie("Zombie Normal", "zombie_normal.png", "gruñido.mp3")
tipo_zombie_corredor = FabricaZombies.obtener_tipo_zombie("Zombie Corredor", "zombie_corredor.png", "grito.mp3")


horda = [
    Zombie(tipo_zombie_normal, 5, 10),
    Zombie(tipo_zombie_normal, 15, 25),
    Zombie(tipo_zombie_corredor, 30, 5),
    Zombie(tipo_zombie_corredor, 50, 20),
]


for zombie in horda:
    zombie.dibujar()
