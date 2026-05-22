/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios08_7;

/**
 *
 * @author AluDAM
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    //propiedades
    private javax.swing.JButton btnAltaCoche;
    private javax.swing.JButton btnFin;
    private javax.swing.JButton btnListado;
    
    
    public VentanaPrincipal() {
        setTitle("Los Enlaces. Inicio");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //delcaración de etiquetas
        btnAltaCoche = new javax.swing.JButton("Alta coche");
        btnFin = new javax.swing.JButton("Fin");
        btnListado = new javax.swing.JButton("Listar coches");
        
        //panel botones
        javax.swing.JPanel panelBotones = new javax.swing.JPanel();
        
        panelBotones.add(btnAltaCoche);
        panelBotones.add(btnFin);
        panelBotones.add(btnListado);

        add(panelBotones, java.awt.BorderLayout.CENTER);
        
        //botones
        btnAltaCoche.addActionListener((evt -> {
            new AltaCoche().setVisible(true);
            dispose();
        }));
        
        btnFin.addActionListener((evt -> {
            System.exit(0);
        }));
        
        
        btnListado.addActionListener((evt -> {
            
            //continuar aquí
        }));
        
    }
    
    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }
}

