package easy;

public class RomanToInteger {
    /*
        Dado un número romano, convertirlo a número entero.

        Símbolos:
        I = 1
        V = 5
        X = 10
        L = 50
        C = 100
        D = 500
        M = 1000

        Ejemplo 1:
        Entrada: s = "III"
        Salida: 3

        Ejemplo 2:
        Entrada: s = "LVIII"
        Salida: 58

        Ejemplo 3:
        Entrada: s = "MCMXCIV"
        Salida: 1994
    */

    public static void main(String[] args) {
        RomanToInteger solucion = new RomanToInteger();

        String numeroRomano1 = "III";
        String numeroRomano2 = "LVIII";
        String numeroRomano3 = "MCMXCIV";

        System.out.println("Ejemplo 1: " + solucion.romanToInt(numeroRomano1));
        System.out.println("Ejemplo 2: " + solucion.romanToInt(numeroRomano2));
        System.out.println("Ejemplo 3: " + solucion.romanToInt(numeroRomano3));
    }

    public int romanToInt(String s) {
        int numeroFinal = 0;

        // Recorro cada símbolo del número romano.
        for (int i = 0; i < s.length(); i++) {
            // Obtengo el valor del símbolo actual.
            int valorActual = obtenerValor(s.charAt(i));

            // Verifico si existe un símbolo siguiente para poder compararlo.
            if (i + 1 < s.length()) {
                int valorSiguiente = obtenerValor(s.charAt(i + 1));

                // Si el valor actual es menor que el siguiente,
                // significa que representa un caso de resta.
                // Ejemplo: IV, IX, XL, XC, CD, CM.
                if (valorActual < valorSiguiente) {
                    numeroFinal -= valorActual;
                } else {
                    // Si no es un caso de resta, sumo el valor actual.
                    numeroFinal += valorActual;
                }
            } else {
                // Si estoy en el último símbolo, no hay siguiente para comparar,
                // entonces siempre lo sumo.
                numeroFinal += valorActual;
            }
        }

        return numeroFinal;
    }

    private int obtenerValor(char simbolo) {
        // Convierto cada símbolo romano a su valor entero.
        switch (simbolo) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}