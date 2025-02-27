interface State {
    void addStock(Bodega bodega);
    void selectProduct(Bodega bodega);
    void dispense(Bodega bodega);
}

class NoStockState implements State {
    @Override
    public void addStock(Bodega bodega) {
        System.out.println("Stock agregado a la bodega.");
        bodega.setState(new HasStockState());
    }

    @Override
    public void selectProduct(Bodega bodega) {
        System.out.println("No hay stock disponible.");
    }

    @Override
    public void dispense(Bodega bodega) {
        System.out.println("No se puede dispensar sin stock.");
    }
}

class HasStockState implements State {
    @Override
    public void addStock(Bodega bodega) {
        System.out.println("Más stock agregado a la bodega.");
    }

    @Override
    public void selectProduct(Bodega bodega) {
        System.out.println("Producto seleccionado.");
        bodega.setState(new ProductSelectedState());
    }

    @Override
    public void dispense(Bodega bodega) {
        System.out.println("Debes seleccionar un producto antes de dispensarlo.");
    }
}

class ProductSelectedState implements State {
    @Override
    public void addStock(Bodega bodega) {
        System.out.println("No puedes agregar stock mientras un producto está seleccionado.");
    }

    @Override
    public void selectProduct(Bodega bodega) {
        System.out.println("Ya has seleccionado un producto.");
    }

    @Override
    public void dispense(Bodega bodega) {
        System.out.println("Producto dispensado.");
        bodega.setState(new HasStockState());
    }
}

class Bodega {
    private State state;

    public Bodega() {
        this.state = new NoStockState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addStock() {
        state.addStock(this);
    }

    public void selectProduct() {
        state.selectProduct(this);
    }

    public void dispense() {
        state.dispense(this);
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        Bodega bodega = new Bodega();

        bodega.selectProduct();
        bodega.dispense();
        bodega.addStock();
        bodega.selectProduct();
        bodega.dispense();
        bodega.selectProduct();
        bodega.dispense();
    }
}
