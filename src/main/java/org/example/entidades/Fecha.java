package org.example.entidades;

import java.util.ArrayList;
import java.util.List;

public class Fecha {

    private Integer numero;
    private List<Partido> partidos = new ArrayList<>();

    public Fecha() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "numero=" + numero +
                ", partidos=" + partidos +
                '}';
    }
}
