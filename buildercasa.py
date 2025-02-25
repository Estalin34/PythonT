class Casa:
    def __init__(self):
        self.partes = []
        self.costo_total = 0.0
    
    def agregar(self, parte, costo):
        self.partes.append(f"{parte} - ${costo:.2f}")
        self.costo_total += costo
    
    def __str__(self):
        return "Casa:\n" + "\n".join(self.partes) + f"\nCosto Total: ${self.costo_total:.2f}"


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
        self.casa.agregar("Paredes de madera", 5000)
    
    def construir_techo(self):
        self.casa.agregar("Techo de madera", 3000)
    
    def construir_puertas(self):
        self.casa.agregar("Puertas de madera", 1200)
    
    def construir_ventanas(self):
        self.casa.agregar("Ventanas de vidrio", 2000)


class ConstructorCasaLadrillo(ConstructorCasa):
    def construir_paredes(self):
        self.casa.agregar("Paredes de ladrillo", 8000)
    
    def construir_techo(self):
        self.casa.agregar("Techo de tejas", 5000)
    
    def construir_puertas(self):
        self.casa.agregar("Puertas de metal", 2000)
    
    def construir_ventanas(self):
        self.casa.agregar("Ventanas de vidrio reforzado", 2500)


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
