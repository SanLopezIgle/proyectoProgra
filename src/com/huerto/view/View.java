package com.huerto.view;

public class View {
    /**
     * Método para hacer visible la ventana principal
     */
    public static void mostrarHuertoIU(){
        HuertoIU vistaHuerto = new HuertoIU();
        vistaHuerto.setVisible(true);
    }

    /**
     * Metodo para hacer visible la ventana del catalogo
     */
    public static void mostrarHuertoCatalogoIU(){
        HuertoCatalogoIU vistaHuertoCatalogo = new HuertoCatalogoIU();
        vistaHuertoCatalogo.setVisible(true);
    }

    /**
     * Metodo para hacer visible la ventana para el huerto personalizado
     */
    public static void mostrarHuertoPersonalizadoIU(){
        HuertoPersonalizadoIU vistaHuertoPersonalizado = new HuertoPersonalizadoIU();
        vistaHuertoPersonalizado.setVisible(true);
    }
}
