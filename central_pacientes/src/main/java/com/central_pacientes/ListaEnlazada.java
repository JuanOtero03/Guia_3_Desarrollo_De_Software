/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.central_pacientes;

/**
 *
 * @author Nadia Irina M Morales L
 */
public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregarPaciente(Paciente paciente) {
        Nodo nuevoNodo = new Nodo(paciente);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
    }

    public Paciente buscarPaciente(int id) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getPaciente().getId() == id) {
                return temp.getPaciente();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    public void eliminarPaciente(int id) {
        if (cabeza == null) return;

        if (cabeza.getPaciente().getId() == id) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        Nodo temp = cabeza;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getPaciente().getId() == id) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                return;
            }
            temp = temp.getSiguiente();
        }
    }

    public void mostrarPacientes() {
        Nodo temp = cabeza;
        while (temp != null) {
            Paciente paciente = temp.getPaciente();
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + ", Edad: " + paciente.getEdad() + ", Clínica: " + paciente.getClinica());
            temp = temp.getSiguiente();
        }
    }
}
