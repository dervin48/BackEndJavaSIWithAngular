/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgodoydev.appInventarioInsumo2.repositorio;

import com.dgodoydev.appInventarioInsumo2.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author durvingodoy
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
