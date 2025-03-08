public class Buscar {
    public static void main(String[] args) {
    }

boolean Ex1(int[] a, int elem) {
    int pos = buscar(a, elem);
    int n = a.length;
    int x = pos;
    
    for (int i = 0; i < n; ++i) {
        x += 2;
        for (int j = 0; j< n; ++j) {
            if (a[j] > a[pos]) {
                x++;
            }
        }
    }
    return x > elem;
}
}

/*
Análisis de complejidad:

1. Se sabe que toda variable de tipo primitivo en Java tiene una complejidad de O(1).

2. En `Ex1`, la función `buscar(a, elem)` se ejecuta una sola vez y tiene una complejidad de O(n log n).

     = O(n log n)

2.1. El primer ciclo for se ejecuta n veces.

     = O(n)

2.2. El segundo ciclo for (anidado dentro del primero) también se ejecuta n veces.

     = O(n)

3. La complejidad del bucle anidado es:

     = O(n) * O(n) = O(n²)

4. La complejidad total del algoritmo `Ex1` es:

     = O(n log n) + O(n²)

5. Como O(n²) domina sobre O(n log n), la complejidad final de `Ex1` en notación Big-O es:

     = O(n²)
*/




boolean Ex2(int[] a, int elem) {
    int n = a.length;
    int x = 0;

    for (int i = 0; i < n; ++i) {
        int pos = buscar(a, elem);
        x += pos + 2;
        for (int j = 0; j < n; ++j) {
            if (a[j] > a[pos]) {
                x++;
            }
        }
    }
    return x > elem;
}

/*
Análisis de complejidad:

1. Se sabe que toda variable de tipo primitivo en Java tiene una complejidad de O(1).

2. En `Ex2`, la función `buscar(a, elem)` se ejecuta **dentro del primer ciclo for**, por lo que se ejecuta n veces y tiene una complejidad de O(n log n) en cada iteración.

     = O(n) * O(n log n) = O(n² log n)

2.1. El primer ciclo for se ejecuta n veces.

     = O(n)

2.2. El segundo ciclo for (anidado dentro del primero) también se ejecuta n veces.

     = O(n)

3. La complejidad del bucle anidado es:

     = O(n) * O(n) = O(n²)

4. La complejidad total del algoritmo `Ex2` es:

     = O(n² log n) + O(n²)

5. Como O(n² log n) domina sobre O(n²), la complejidad final de `Ex2` en notación Big-O es:

     = O(n² log n)
*/

/* 
Conclusion = 
    Ex1 tiene una complejidad de O(n²) y Ex2 tiene una complejidad de O(n² log n). Por lo tanto, Ex1 es más eficiente que Ex2.
*/