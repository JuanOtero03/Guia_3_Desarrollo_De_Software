/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluador_aritmetico;

/**
 *
 * @author Nadia Irina M Morales López
 */
import java.util.HashMap;
import java.util.Map;

public class EvaluadorExpresiones {

    public static boolean verificarParentesis(String expresion) {
        Pila<Character> pila = new Pila<>();

        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    private static final Map<Character, Integer> PRECEDENCIA = new HashMap<>();

    static {
        PRECEDENCIA.put('+', 1);
        PRECEDENCIA.put('-', 1);
        PRECEDENCIA.put('*', 2);
        PRECEDENCIA.put('/', 2);
        PRECEDENCIA.put('^', 3);
    }

    public static String infijoAPostfijo(String expresion) {
        if (!verificarParentesis(expresion)) {
            throw new IllegalArgumentException("Los paréntesis no están balanceados");
        }

        StringBuilder salida = new StringBuilder();
        Pila<Character> pila = new Pila<>();

        for (char caracter : expresion.toCharArray()) {
            if (Character.isDigit(caracter)) {
                salida.append(caracter);
            } else if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop());
                }
                pila.pop(); // Sacar '(' de la pila
            } else {
                while (!pila.isEmpty() && PRECEDENCIA.getOrDefault(pila.peek(), 0) >= PRECEDENCIA.getOrDefault(caracter, 0)) {
                    salida.append(pila.pop());
                }
                pila.push(caracter);
            }
        }

        while (!pila.isEmpty()) {
            salida.append(pila.pop());
        }

        return salida.toString();
    }
    
    public static int evaluarPostfijo(String expresion) {
        Pila<Integer> pila = new Pila<>();

        for (char caracter : expresion.toCharArray()) {
            if (Character.isDigit(caracter)) {
                pila.push(Character.getNumericValue(caracter));
            } else {
                int operando2 = pila.pop();
                int operando1 = pila.pop();
                int resultado = aplicarOperacion(caracter, operando1, operando2);
                pila.push(resultado);
            }
        }

        return pila.pop();
    }

    private static int aplicarOperacion(char operador, int operando1, int operando2) {
        switch (operador) {
            case '+': return operando1 + operando2;
            case '-': return operando1 - operando2;
            case '*': return operando1 * operando2;
            case '/': return operando1 / operando2;
            case '^': return (int) Math.pow(operando1, operando2);
            default: throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}
