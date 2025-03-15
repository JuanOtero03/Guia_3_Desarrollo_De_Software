/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.central_pacientes;

/**
 *
 * @author Nadia Irina M Morales L
 */
public class Nodo {
    private Paciente paciente;
    private Nodo siguiente;

    public Nodo(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }

    // Getters y Setters
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}
