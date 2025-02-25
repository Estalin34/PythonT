class Casa:
    def __init__(self):
        self.partes = []
    
    def agregar(self, parte):
        self.partes.append(parte)
    
    def __str__(self):
        return "Casa:\n" + "\n".join(self.partes)
    def get_total_cost(self):
        return sum(item.get_cost() for item in self.items)


class ConstructorCasa:
    def __init__(self):
        self.casa = Casa()
    
    def construir_paredes(self):
        pass
    
    def construir_techo(self):
        pass
    
    def construir_puertas(self):
        pass
    
    def construir_ventanas(self):
        pass
    
    def reiniciar(self):
        self.casa = Casa()
    
    def obtener_casa(self):
        return self.casa


class ConstructorCasaMadera(ConstructorCasa):
    def construir_paredes(self):
        self.casa.agregar("Paredes de madera",0.85)
    
    def construir_techo(self):
        self.casa.agregar("Techo de madera",15)
    
    def construir_puertas(self):
        self.casa.agregar("Puertas de madera",31)
    
    def construir_ventanas(self):
        self.casa.agregar("Ventanas de vidrio",30)


class ConstructorCasaLadrillo(ConstructorCasa):
    def construir_paredes(self):
        self.casa.agregar("Paredes de ladrillo",0.85)
    
    def construir_techo(self):
        self.casa.agregar("Techo de tejas",15)
    
    def construir_puertas(self):
        self.casa.agregar("Puertas de metal",34)
    
    def construir_ventanas(self):
        self.casa.agregar("Ventanas de vidrio reforzado",30)


class DirectorCasa:
    def __init__(self, constructor):
        self.constructor = constructor
    
    def construir_casa_completa(self):
        self.constructor.reiniciar()
        self.constructor.construir_paredes()
        self.constructor.construir_techo()
        self.constructor.construir_puertas()
        self.constructor.construir_ventanas()
    
    def construir_casa_basica(self):
        self.constructor.reiniciar()
        self.constructor.construir_paredes()
        self.constructor.construir_techo()


# Construcción y prueba de una casa de madera
constructor_madera = ConstructorCasaMadera()
director_madera = DirectorCasa(constructor_madera)
director_madera.construir_casa_completa()
print(constructor_madera.obtener_casa())

# Construcción y prueba de una casa de ladrillo
constructor_ladrillo = ConstructorCasaLadrillo()
director_ladrillo = DirectorCasa(constructor_ladrillo)
director_ladrillo.construir_casa_completa()
print(constructor_ladrillo.obtener_casa())
