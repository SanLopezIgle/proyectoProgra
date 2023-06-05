package com.huerto.model;

public class Planta {
    private enum Especie{
        TOMATE, LECHUGA, ZANAHORIA, MANGO;
    }

    private Integer idPlanta;
    private Especie especie;

    public Planta(){

    }

    public Planta(Integer idPlanta){
        this.idPlanta = idPlanta;
    }

    public Planta(Especie especie) {
        this.especie = especie;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }
}
