package org.example.entidades;

import org.example.enums.Resultado;

public class Apuesta {

    private Integer id;
    private Partido partido;
    private Resultado resultado;

    public Apuesta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Apuesta: " + partido + " >> " + resultado;
    }
}
