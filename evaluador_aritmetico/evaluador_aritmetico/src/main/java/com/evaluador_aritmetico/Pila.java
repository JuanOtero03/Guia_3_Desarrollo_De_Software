/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evaluador_aritmetico;

/**
 *
 * @author Nadia Irina M Morales López
 */
import java.util.EmptyStackException;

public class Pila<T> {
    private Nodo<T> tope;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public void push(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }
}
