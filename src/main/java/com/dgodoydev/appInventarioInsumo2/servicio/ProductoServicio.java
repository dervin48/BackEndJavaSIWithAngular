/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgodoydev.appInventarioInsumo2.servicio;

import com.dgodoydev.appInventarioInsumo2.modelo.Producto;
import com.dgodoydev.appInventarioInsumo2.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author durvingodoy
 */
@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;
    
    @Override
    public List<Producto> listarProducto() {
        return this.productoRepositorio.findAll();
        
    }

    @Override
    public Producto buscarProductoId(Integer idProducto) {
        Producto producto =this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }
    
}
