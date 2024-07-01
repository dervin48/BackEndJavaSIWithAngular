/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgodoydev.appInventarioInsumo2.controlador;

import com.dgodoydev.appInventarioInsumo2.excepcion.RecursoNoEncontradoExcepcion;
import com.dgodoydev.appInventarioInsumo2.modelo.Producto;
import com.dgodoydev.appInventarioInsumo2.servicio.ProductoServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author durvingodoy
 */
@RestController
@RequestMapping("inventario")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private ProductoServicio productoServicio; 
    
    @GetMapping("/productos")
    public List<Producto> obtenerProducto(){
        List<Producto> productos = productoServicio.listarProducto();
        logger.info("Productos Obtenidos");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
        
    }
    @PostMapping("/productos")
    public Producto agregarPRoducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        return this.productoServicio.guardarProducto(producto);
        
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id){
            Producto producto= this.productoServicio.buscarProductoId(id);
        if(producto!=null)
            return ResponseEntity.ok(producto);
        else
            throw new RecursoNoEncontradoExcepcion("No se Encontro el ID");
        
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
        Producto producto = this.productoServicio.buscarProductoId(id);
        if(producto==null)
            throw new RecursoNoEncontradoExcepcion("No se econtro el id:" +id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }
    
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto =productoServicio.buscarProductoId(id);
        if(producto==null)
            throw new RecursoNoEncontradoExcepcion("No se econtro el id:" +id);
        this.productoServicio.eliminarProducto(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
