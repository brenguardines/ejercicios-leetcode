package easy;

public class LongestCommonPrefix {
    /*
        Escribir una función para encontrar el prefijo común más largo entre un conjunto de cadenas.
        Si no hay un prefijo común, devolver una cadena vacía "".

        Ejemplo 1:
        Entrada: palabras = ["flor", "florero", "florecer"]
        Salida: "flor"

        Ejemplo 2:
        Entrada: palabras = ["perro", "casa", "auto"]
        Salida: ""
    */

    public static void main(String[] args) {
        LongestCommonPrefix solucion = new LongestCommonPrefix();

        String[] palabras1 = {"flor", "florero", "florecer"};
        String[] palabras2 = {"perro", "casa", "auto"};

        System.out.println("Ejemplo 1 con prefijo acumulado: " + solucion.longestCommonPrefixConAcumulador(palabras1));
        System.out.println("Ejemplo 2 con prefijo acumulado: " + solucion.longestCommonPrefixConAcumulador(palabras2));

        System.out.println("Ejemplo 1 con substring: " + solucion.longestCommonPrefixConSubstring(palabras1));
        System.out.println("Ejemplo 2 con substring: " + solucion.longestCommonPrefixConSubstring(palabras2));
    }

    public String longestCommonPrefixConAcumulador(String[] strs) {
        String prefijo = "";

        // Recorro las letras de la primera palabra.
        for (int i = 0; i < strs[0].length(); i++) {
            char letraActual = strs[0].charAt(i);

            // Comparo esa letra con la misma posición en las demás palabras.
            for (int j = 1; j < strs.length; j++) {

                // Si alguna palabra no tiene esa posición o la letra es distinta,
                // devuelvo el prefijo acumulado hasta el momento.
                if (i >= strs[j].length() || letraActual != strs[j].charAt(i)) {
                    return prefijo;
                }
            }

            // Si todas las palabras tienen la misma letra en esa posición,
            // la agrego al prefijo.
            prefijo += letraActual;
        }

        return prefijo;
    }

    public String longestCommonPrefixConSubstring(String[] strs) {
        // Recorro las letras de la primera palabra.
        for (int i = 0; i < strs[0].length(); i++) {
            char letraActual = strs[0].charAt(i);

            // Comparo esa letra con la misma posición en las demás palabras.
            for (int j = 1; j < strs.length; j++) {

                // Si alguna palabra no tiene esa posición o la letra es distinta,
                // el prefijo común llega hasta la posición anterior.
                if (i >= strs[j].length() || letraActual != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // Si no hubo diferencias, la primera palabra completa es el prefijo común.
        return strs[0];
    }
}