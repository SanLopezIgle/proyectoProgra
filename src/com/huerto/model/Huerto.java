package com.huerto.model;

public class Huerto {
    private Integer idHuerto;
    private Integer planta_id;

    public Huerto(){

    }
    public Huerto(Integer idHuerto, Integer planta_id) {
        this.idHuerto = idHuerto;
        this.planta_id = planta_id;
    }

    public Integer getIdHuerto() {
        return idHuerto;
    }
    public void setIdHuerto(Integer idHuerto) {
        this.idHuerto = idHuerto;
    }

    public Integer getPlanta_id() {
        return planta_id;
    }
    public void setPlanta_id(Integer planta_id) {
        this.planta_id = planta_id;
    }
}
