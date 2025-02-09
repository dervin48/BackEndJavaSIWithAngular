/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgodoydev.appInventarioInsumo2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author durvingodoy
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer idProducto;
    String descripcion;
    Double precio;
    Integer existencia;
    
            
    
}
