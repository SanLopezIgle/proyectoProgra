package com.huerto.controller;

import com.huerto.view.View;

public class HuertoController {

    public static void main(String[] args){
        View.mostrarHuertoIU();
    }

    /**
     * Método para poder abrir la ventana del catalogo desde el controller
     */
    public static void abrirCatalogo(){
        View.mostrarHuertoCatalogoIU();
    }

    /**
     * Método para poder abrir la ventana del catalogo desde el controller
     */
    public static void abrirPersonalizado(){
        View.mostrarHuertoPersonalizadoIU();
    }
}
