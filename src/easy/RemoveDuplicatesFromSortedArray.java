package easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    /*
        Dado un array de enteros ordenado en orden no decreciente,
        eliminar los duplicados in-place para que cada elemento único aparezca solo una vez.

        La función debe devolver k, que representa la cantidad de elementos únicos.
        Los primeros k elementos del array deben contener los valores únicos.

        Ejemplo 1:
        Entrada: nums = [1,1,2]
        Salida: k = 2, nums = [1,2,_]

        Ejemplo 2:
        Entrada: nums = [0,0,1,1,1,2,2,3,3,4]
        Salida: k = 5, nums = [0,1,2,3,4,_,_,_,_,_]
    */

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solucion = new RemoveDuplicatesFromSortedArray();

        int[] nums1 = {1, 1, 2};
        int k1 = solucion.removeDuplicates(nums1);

        System.out.println("Ejemplo 1:");
        System.out.println("k = " + k1);
        System.out.println("nums = " + Arrays.toString(Arrays.copyOf(nums1, k1)));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solucion.removeDuplicates(nums2);

        System.out.println("Ejemplo 2:");
        System.out.println("k = " + k2);
        System.out.println("nums = " + Arrays.toString(Arrays.copyOf(nums2, k2)));
    }

    public int removeDuplicates(int[] nums) {
        // k representa dos cosas:
        // 1. La cantidad de elementos únicos encontrados.
        // 2. La próxima posición donde se debe escribir un número único.
        int k = 1;

        // Recorro el array desde la segunda posición,
        // porque el primer elemento ya se considera único.
        for (int i = 1; i < nums.length; i++) {

            // Como el array está ordenado, si el número actual es distinto
            // al anterior, entonces encontré un nuevo valor único.
            if (nums[i] != nums[i - 1]) {

                // Guardo el nuevo valor único en la próxima posición válida.
                nums[k] = nums[i];

                // Avanzo k para la próxima posición libre.
                k++;
            }
        }

        // Devuelvo la cantidad de elementos únicos.
        return k;
    }
}