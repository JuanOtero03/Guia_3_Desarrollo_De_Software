/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.central_pacientes;

/**
 *
 * @author Nadia Irina M Morales L
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralPacientesGUI extends JFrame {
    private ListaEnlazada listaEnlazada;
    private JTextField idField, nombreField, edadField, clinicaField;
    private JTextArea outputArea;

    public CentralPacientesGUI() {
        listaEnlazada = new ListaEnlazada();
        initComponents();
    }

    private void initComponents() {
        setTitle("Central de Pacientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        idField = new JTextField(10);
        nombreField = new JTextField(10);
        edadField = new JTextField(10);
        clinicaField = new JTextField(10);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Edad:"));
        panel.add(edadField);
        panel.add(new JLabel("Clínica:"));
        panel.add(clinicaField);

        JButton agregarButton = new JButton("Agregar Paciente");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        });

        JButton buscarButton = new JButton("Buscar Paciente");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPaciente();
            }
        });

        JButton eliminarButton = new JButton("Eliminar Paciente");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPaciente();
            }
        });

        JButton mostrarButton = new JButton("Mostrar Pacientes");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPacientes();
            }
        });

        panel.add(agregarButton);
        panel.add(buscarButton);
        panel.add(eliminarButton);
        panel.add(mostrarButton);
        panel.add(new JScrollPane(outputArea));

        add(panel);
    }

    private void agregarPaciente() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        String clinica = clinicaField.getText();

        Paciente paciente = new Paciente(id, nombre, edad, clinica);
        listaEnlazada.agregarPaciente(paciente);
        outputArea.setText("Paciente agregado con éxito.");
    }

    private void buscarPaciente() {
        int id = Integer.parseInt(idField.getText());
        Paciente paciente = listaEnlazada.buscarPaciente(id);
        if (paciente != null) {
            outputArea.setText("Paciente encontrado: " + paciente.getNombre());
        } else {
            outputArea.setText("Paciente no encontrado.");
        }
    }

    private void eliminarPaciente() {
        int id = Integer.parseInt(idField.getText());
        listaEnlazada.eliminarPaciente(id);
        outputArea.setText("Paciente eliminado con éxito.");
    }

    private void mostrarPacientes() {
        outputArea.setText("");
        listaEnlazada.mostrarPacientes();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CentralPacientesGUI().setVisible(true);
            }
        });
    }
}
