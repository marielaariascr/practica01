/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practica01.service;
import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    // Retorna una lista de categorias (activas o todas)
    public List<Arbol> getArboles();
    //retorna una categoria por ID
    public Arbol getArbol(Arbol arbol);
    
    //se inserta un nuevo registro si el ID de la categoria esta vacio
    //se actualiza el registro si el ID de la categoria no esta vacio.
    public void save(Arbol arbol);
    
    public void delete(Arbol arbol);
    
}
