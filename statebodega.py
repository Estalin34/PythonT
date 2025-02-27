from abc import ABC, abstractmethod

class State(ABC):
    @abstractmethod
    def add_stock(self, bodega):
        pass
    
    @abstractmethod
    def select_product(self, bodega):
        pass
    
    @abstractmethod
    def dispense(self, bodega):
        pass

class NoStockState(State):
    def add_stock(self, bodega):
        print("Stock agregado a la bodega.")
        bodega.state = HasStockState()
    
    def select_product(self, bodega):
        print("No hay stock disponible.")
    
    def dispense(self, bodega):
        print("No se puede dispensar sin stock.")

class HasStockState(State):
    def add_stock(self, bodega):
        print("Más stock agregado a la bodega.")
    
    def select_product(self, bodega):
        print("Producto seleccionado.")
        bodega.state = ProductSelectedState()
    
    def dispense(self, bodega):
        print("Debes seleccionar un producto antes de dispensarlo.")

class ProductSelectedState(State):
    def add_stock(self, bodega):
        print("No puedes agregar stock mientras un producto está seleccionado.")
    
    def select_product(self, bodega):
        print("Ya has seleccionado un producto.")
    
    def dispense(self, bodega):
        print("Producto dispensado.")
        bodega.state = HasStockState()

class Bodega:
    def __init__(self):
        self.state = NoStockState()
    
    def add_stock(self):
        self.state.add_stock(self)
    
    def select_product(self):
        self.state.select_product(self)
    
    def dispense(self):
        self.state.dispense(self)


bodega = Bodega()
bodega.select_product()
bodega.dispense()
bodega.add_stock()
bodega.select_product()
bodega.dispense()
bodega.select_product()
bodega.dispense()
