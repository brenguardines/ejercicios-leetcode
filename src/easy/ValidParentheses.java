package easy;

public class ValidParentheses {
    /*
        Dada una cadena que contiene solo los caracteres:
        '(', ')', '{', '}', '[' y ']',
        determinar si la cadena de entrada es válida.

        Una cadena es válida si:
        - Cada apertura tiene un cierre del mismo tipo.
        - Los cierres respetan el orden correcto.
        - Cada cierre tiene una apertura correspondiente.

        Ejemplo 1:
        Entrada: s = "()"
        Salida: true

        Ejemplo 2:
        Entrada: s = "()[]{}"
        Salida: true

        Ejemplo 3:
        Entrada: s = "(]"
        Salida: false

        Ejemplo 4:
        Entrada: s = "([])"
        Salida: true

        Ejemplo 5:
        Entrada: s = "([)]"
        Salida: false
    */

    public static void main(String[] args) {
        ValidParentheses solucion = new ValidParentheses();

        String ejemplo1 = "()";
        String ejemplo2 = "()[]{}";
        String ejemplo3 = "(]";
        String ejemplo4 = "([])";
        String ejemplo5 = "([)]";

        System.out.println("Ejemplo 1: " + solucion.isValid(ejemplo1));
        System.out.println("Ejemplo 2: " + solucion.isValid(ejemplo2));
        System.out.println("Ejemplo 3: " + solucion.isValid(ejemplo3));
        System.out.println("Ejemplo 4: " + solucion.isValid(ejemplo4));
        System.out.println("Ejemplo 5: " + solucion.isValid(ejemplo5));
    }

    public boolean isValid(String s) {
        // Uso un array de char para simular una pila manualmente.
        // En esta pila voy a guardar los cierres que espero encontrar.
        char[] pila = new char[s.length()];

        // El tope indica la posición del último elemento guardado.
        // Empieza en -1 porque la pila está vacía.
        int tope = -1;

        // Recorro cada carácter de la cadena.
        for (int i = 0; i < s.length(); i++) {
            char caracterActual = s.charAt(i);

            // Si encuentro una apertura, guardo el cierre que debería aparecer después.
            if (caracterActual == '(') {
                tope++;
                pila[tope] = ')';
            } else if (caracterActual == '{') {
                tope++;
                pila[tope] = '}';
            } else if (caracterActual == '[') {
                tope++;
                pila[tope] = ']';
            } else {
                // Si encuentro un cierre y la pila está vacía,
                // significa que no hay una apertura correspondiente.
                if (tope == -1 || caracterActual != pila[tope]) {
                    return false;
                }

                // Si el cierre coincide con el esperado,
                // saco ese elemento de la pila.
                tope--;
            }
        }

        // Si la pila quedó vacía, todos los símbolos fueron cerrados correctamente.
        return tope == -1;
    }
}