public class Complejidad_Algoritmica {
    public static void main(String[] args) {
    }

    void calcularComplejidadAlgoritmica(int n){ 
        int x = 0;                                                 // O(1)
        for (int i = 1; i <= n; i *= 5) {                          // Se ejecuta log5(n) veces
            for (int j = 1; j <= n; j += 2) {                      // Se ejecuta n/2 veces = O(n)
                x = x + j;                                         // O(1)
            }
            for (int k = n; k >= 1; k /= 2) {                      // Se ejecuta log2(n) veces
                x = x + 1;                                         // O(1)
            }
        }
    }    
}

/*
Análisis de complejidad:

1.  Se sabe que toda variable de tipo primitivo en Java tiene una complejidad de O(1).

2.  El primer ciclo for se ejecuta O(log5(n)) veces, ya que i se multiplica por 5 en cada iteración.

     = O(log5(n))

2.1.  El segundo ciclo for se ejecuta n/2 veces, ya que j se incrementa en 2 en cada iteración osea que es igual a O(n).
2.2  Se sabe que toda variable de tipo primitivo en Java tiene una complejidad de O(1).

    = O(log5(n) * n)

4.  El tercer ciclo for se ejecuta log2(n) veces, ya que k se divide por 2 en cada iteración.

     = O(log5(n)) * O(log2(n))

5.  La complejidad total del algoritmo es:
     
        = O(log5(n) * n) + O(log5(n) * log2(n))

 6.  Por lo tanto, la complejidad del algoritmo donde el termino dominante es O(log5(n) * n), La complejidad final en notación Big-O es =  O(n log n)

*/
