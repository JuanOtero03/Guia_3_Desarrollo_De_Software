/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluador_aritmetico;

/**
 *
 * @author nadir
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la expresión al usuario
        System.out.println("Ingrese una expresión aritmética en notación infija: ");
        String expresionInfija = scanner.nextLine();

        // Eliminar espacios en blanco para facilitar el procesamiento
        expresionInfija = expresionInfija.replaceAll("\\s", "");

        // Verificar paréntesis balanceados
        boolean parentesisBalanceados = EvaluadorExpresiones.verificarParentesis(expresionInfija);
        System.out.println("Paréntesis balanceados: " + (parentesisBalanceados ? "Sí" : "No"));

        if (parentesisBalanceados) {
            // Convertir a notación postfija
            String expresionPostfija = EvaluadorExpresiones.infijoAPostfijo(expresionInfija);
            System.out.println("Expresión Postfija: " + expresionPostfija);

            // Evaluar la expresión postfija
            int resultado = EvaluadorExpresiones.evaluarPostfijo(expresionPostfija);
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("La expresión no puede ser procesada debido a paréntesis desbalanceados.");
        }

        scanner.close();
    }
}
