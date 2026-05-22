/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicios08_7;

/**
 *
 * @author AluDAM
 */
public class Coche {

    public static void setIva(double aIva) {
        iva = aIva;
    }

    public static void setContadorCod(int aContadorCod) {
        contadorCod = aContadorCod;
    }

    private String codigo;
    private String matricula;
    private String modelo;
    private double precio;
    private boolean disponibildad;
    private static double iva = 0.21;
    private static int contadorCod = 1;
    
    
    public Coche(String mat, String mod, double precio) {
        codigo = "2021-" + String.format("%05d", contadorCod);
        contadorCod++;
        matricula = mat;
        modelo = mod;
        this.precio = precio;
        disponibildad = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponibildad() {
        return disponibildad;
    }
    
    public double getPrecioTotal() {
        return (precio + (iva * precio));
    }

    public void setDisponibildad(boolean disponibildad) {
        this.disponibildad = disponibildad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public static String getSiguienteCodigo() {
        return "2021-" + String.format("%05d", contadorCod);
    }
}
