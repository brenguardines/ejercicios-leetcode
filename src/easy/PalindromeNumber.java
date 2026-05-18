package easy;

public class PalindromeNumber {
    /*
        Dado un número entero x, devolver true si x es un palíndromo y false en caso contrario.

        Ejemplo 1:
        Entrada: x = 121
        Salida: true

        Ejemplo 2:
        Entrada: x = -121
        Salida: false

        Ejemplo 3:
        Entrada: x = 10
        Salida: false
    */

    public static void main(String[] args) {
        PalindromeNumber solucion = new PalindromeNumber();

        int numero1 = 121;
        int numero2 = -121;
        int numero3 = 10;

        System.out.println("Ejemplo 1 con while: " + solucion.palindromoConWhile(numero1));
        System.out.println("Ejemplo 2 con while: " + solucion.palindromoConWhile(numero2));
        System.out.println("Ejemplo 3 con while: " + solucion.palindromoConWhile(numero3));

        System.out.println("Ejemplo 1 con for: " + solucion.palindromoConFor(numero1));
        System.out.println("Ejemplo 2 con for: " + solucion.palindromoConFor(numero2));
        System.out.println("Ejemplo 3 con for: " + solucion.palindromoConFor(numero3));
    }

    public boolean palindromoConWhile(int x) {
        // Convierto el número a String para poder comparar sus caracteres.
        String numeroComoString = Integer.toString(x);

        // i empieza al inicio del String.
        int i = 0;

        // j empieza al final del String.
        int j = numeroComoString.length() - 1;

        // Mientras los índices no se crucen, comparo extremos opuestos.
        while (i < j) {
            // Si los caracteres son distintos, no es palíndromo.
            if (numeroComoString.charAt(i) != numeroComoString.charAt(j)) {
                return false;
            }

            // Avanzo desde el inicio y retrocedo desde el final.
            i++;
            j--;
        }

        // Si no se encontraron diferencias, el número es palíndromo.
        return true;
    }

    public boolean palindromoConFor(int x) {
        // Convierto el número a String para poder comparar sus caracteres.
        String numeroComoString = Integer.toString(x);

        // Uso dos índices: i desde el inicio y j desde el final.
        // En cada vuelta, i avanza y j retrocede.
        for (int i = 0, j = numeroComoString.length() - 1; i < j; i++, j--) {
            // Si encuentro una diferencia entre extremos opuestos,
            // el número no es palíndromo.
            if (numeroComoString.charAt(i) != numeroComoString.charAt(j)) {
                return false;
            }
        }

        // Si terminó el recorrido sin diferencias, es palíndromo.
        return true;
    }
}