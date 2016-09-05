
package org.si301.jugueteria.model;

/**
 *
 * @author Hugo
 */
public class Producto {
    //Atributos
    private int idProducto;
    private String nombre;
    private String modelo;
    private Marca marca;
    private double precio;
    private String foto;
    private int existencia;
    private Categoria categoria;
    private boolean estatus;

    //Metodos

    //Constructor
    public Producto() {
    }

    public Producto(String nombre, String modelo, Marca marca, double precio, String foto, int existencia, Categoria categoria, boolean estatus) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.foto = foto;
        this.existencia = existencia;
        this.categoria = categoria;
        this.estatus = estatus;
    }

    //Seccion de metodos gettes and settes
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}//fin de la clase, despues de esta linea no va nada