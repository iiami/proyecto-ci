/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios08_7;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AluDAM
 */
public class Concesionario {

    private ArrayList<Coche> listaCoches;

    public Concesionario() {
        this.listaCoches = new ArrayList<>();
    }

    public ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }

    public boolean existeMatricula(String m) {
        if (listaCoches != null) {
            for (Coche c : listaCoches) {
                if (m.equals(c.getMatricula())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean nuevoCoche(String mat, String mod, double precio) {
        if (existeMatricula(mat)) {
            return false;
        } else {
            listaCoches.add(new Coche(mat, mod, precio));
            return true;
        }
    }
}
