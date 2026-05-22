/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios08_7;

import java.awt.Color;
import java.awt.Font;
import java.nio.file.Files;
import javax.swing.JOptionPane;

/**
 *
 * @author AluDAM
 */
public class AltaCoche extends javax.swing.JFrame {

    private javax.swing.JLabel titulo;

    private javax.swing.JLabel etqCodigo;
    private javax.swing.JLabel etqMatricula;
    private javax.swing.JLabel etqModelo;
    private javax.swing.JLabel etqPrecio;

    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JCheckBox chkEnVenta;

    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnLimpiarFormulario;
    private javax.swing.JButton btnVolver;

    private Concesionario concesionario;

    public AltaCoche() {
        setTitle("Los Enlaces. Alta Coche");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //DECLARACION DE ETIQUETAS
        titulo = new javax.swing.JLabel("ALTA COCHE");
        titulo.setForeground(Color.blue);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        etqCodigo = new javax.swing.JLabel("CÓDIGO");
        etqMatricula = new javax.swing.JLabel("MATRÍCULA");
        etqModelo = new javax.swing.JLabel("MODELO");
        etqPrecio = new javax.swing.JLabel("PRECIO");

        txtCodigo = new javax.swing.JTextField(Coche.getSiguienteCodigo());
        txtCodigo.setEnabled(false); //desactivado por defecto
        txtMatricula = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        chkEnVenta = new javax.swing.JCheckBox("EN VENTA");
        chkEnVenta.setSelected(true);

        btnAlta = new javax.swing.JButton("ALTA");
        btnLimpiarFormulario = new javax.swing.JButton("LIMPIAR FORMULARIO");
        btnVolver = new javax.swing.JButton("VOLVER");

        concesionario = new Concesionario();

        // panel principal
        setLayout(new java.awt.BorderLayout(20, 20));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(titulo, java.awt.BorderLayout.NORTH);

        //panel formulario
        javax.swing.JPanel panelFormulario = new javax.swing.JPanel();
        panelFormulario.setLayout(new java.awt.GridLayout(5, 2, 20, 20));
        panelFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelFormulario.add(etqCodigo);
        panelFormulario.add(txtCodigo);

        panelFormulario.add(etqMatricula);
        panelFormulario.add(txtMatricula);

        panelFormulario.add(etqModelo);
        panelFormulario.add(txtModelo);

        panelFormulario.add(etqPrecio);
        panelFormulario.add(txtPrecio);

        panelFormulario.add(chkEnVenta);

        add(panelFormulario, java.awt.BorderLayout.CENTER);

        //panel botones
        javax.swing.JPanel panelBotones = new javax.swing.JPanel();
        panelBotones.add(btnAlta);
        panelBotones.add(btnLimpiarFormulario);
        panelBotones.add(btnVolver);

        add(panelBotones, java.awt.BorderLayout.SOUTH);

        //eventos jtextfield
        txtMatricula.addActionListener((evt -> {
            if (txtMatricula.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Error: La matricula no puede estar vacía.");
            } else if (concesionario.existeMatricula(txtMatricula.getText())) {
                JOptionPane.showMessageDialog(null, "Error: La matricula pertenece a otro coche.");
            } else {
                txtModelo.requestFocus();
            }
        }));

        txtModelo.addActionListener((evt -> {
            if (txtModelo.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Error: El modelo no puede estar vacía.");
            } else {
                txtPrecio.requestFocus();
            }
        }));

        txtPrecio.addActionListener((evt -> {
            try {
                double precio = Double.parseDouble(txtPrecio.getText());

                if (precio < 0) {
                    JOptionPane.showMessageDialog(null, "Error: El precio tiene que ser mayor a cero.");

                } else {
                    btnAlta.requestFocus();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Introduce un número válido.");
            }
        }));

        /*botones*/
        btnAlta.addActionListener((ev -> {
            try {
                String mat = txtMatricula.getText();
                String mod = txtModelo.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                boolean posibilidadCoche = false;

                if (mat.isBlank() || mod.isBlank() || precio <= 0) {
                    JOptionPane.showMessageDialog(null, "Revise que los datos introducidos sean correctos.");
                    return;
                } else {
                    posibilidadCoche = concesionario.nuevoCoche(mat, mod, precio);
                }

                if (posibilidadCoche) {
                    JOptionPane.showMessageDialog(null, "Se ha dado de alta el coche");
                    txtCodigo.setText(Coche.getSiguienteCodigo());
                    txtMatricula.setText("");
                    txtModelo.setText("");
                    txtPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha dado de alta el coche");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: El precio tiene un formato incorrecto.");
            }
        }));

        btnLimpiarFormulario.addActionListener((evt -> {
            txtCodigo.setText(Coche.getSiguienteCodigo());
            txtMatricula.setText("");
            txtModelo.setText("");
            txtPrecio.setText("");
        }));
        
        btnVolver.addActionListener((evt -> {
            new VentanaPrincipal().setVisible(true);
            dispose();
        }));
    }

    public static void main(String[] args) {
        new AltaCoche().setVisible(true);
    }

}
