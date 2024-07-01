/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgodoydev.appInventarioInsumo2.servicio;

import com.dgodoydev.appInventarioInsumo2.modelo.Producto;
import java.util.List;

/**
 *
 * @author durvingodoy
 */
public interface IProductoServicio {
    public List<Producto> listarProducto();
    
    public Producto buscarProductoId(Integer idProducto);
    
    public Producto guardarProducto(Producto producto);
    
    public void eliminarProducto(Integer idProducto);
    
}
