
package org.si301.jugueteria.core;

import java.util.ArrayList;
import org.si301.jugueteria.model.PedidoProducto;

/**
 *
 * @author hugo_
 */
public class Carrito {
    
    private ArrayList<PedidoProducto> carrito = new ArrayList<PedidoProducto>();
    
    public void add(PedidoProducto pedido) {
        this.carrito.add(pedido);
    }
    
    public void eliminar(int index) {
        this.carrito.remove(index);
    }
    
    public Carrito() {
        
    }

    public ArrayList<PedidoProducto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<PedidoProducto> carrito) {
        this.carrito = carrito;
    }
    
}