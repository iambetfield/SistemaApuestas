package org.example.entidades;

import java.util.ArrayList;
import java.util.List;

public class Participante {

    private Integer id;
    private String nombre;
    private List<Apuesta> apuestas = new ArrayList<>();
    private Integer puntos=0;

    public Participante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Participante: " + nombre;
    }
}
