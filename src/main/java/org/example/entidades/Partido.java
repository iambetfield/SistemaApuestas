package org.example.entidades;

import org.example.enums.Resultado;

public class Partido {

    private Integer id;
    private Equipo equipo1;
    private Equipo equipo2;
    private Integer scoreEq1;
    private Integer scoreEq2;
    private Resultado resultado;

    public Partido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Integer getScoreEq1() {
        return scoreEq1;
    }

    public void setScoreEq1(Integer scoreEq1) {
        this.scoreEq1 = scoreEq1;
    }

    public Integer getScoreEq2() {
        return scoreEq2;
    }

    public void setScoreEq2(Integer scoreEq2) {
        this.scoreEq2 = scoreEq2;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public Resultado setResultado(Resultado resultado) {
        this.resultado = resultado;
        return resultado;
    }

    @Override
    public String toString() {
        return "Partido: " +
                equipo1.toString() + " " + scoreEq1.toString() + " - " + equipo2.toString() + " " + scoreEq2.toString() ;
    }
}
