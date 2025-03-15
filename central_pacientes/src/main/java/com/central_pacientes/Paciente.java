/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.central_pacientes;

/**
 *
 * @author Nadia Irina M Morales L
 */
public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String clinica;

    public Paciente(int id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getClinica() { return clinica; }
    public void setClinica(String clinica) { this.clinica = clinica; }
}
