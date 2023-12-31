package com.practica01.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbol; // El Hibernate lo transforma en id_categoria por 
    private String tipoArbol;
    private String nombreComun;
    private String tipoFlor;
    private String dureza;
    private String rutaImagen;
    private Long altura;
    private boolean activo;
    
    public Arbol() {}

    public Arbol(String tipoArbol, String nombreComun, String tipoFlor, String dureza, String rutaImagen, Long altura) {
        this.tipoArbol = tipoArbol;
        this.nombreComun = nombreComun;
        this.tipoFlor = tipoFlor;
        this.dureza = dureza;
        this.rutaImagen = rutaImagen;
        this.altura = altura;
    } 
}