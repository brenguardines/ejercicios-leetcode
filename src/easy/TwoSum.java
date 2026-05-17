package easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Example 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] resultado1 = solution.twoSumWithTwoLoops(nums1, target1);
        // int[] resultado1 = solution.twoSumWithHashMap(nums1, target1);
        System.out.println("Example 1: " + Arrays.toString(resultado1));

        // Example 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] resultado2 = solution.twoSumWithTwoLoops(nums2, target2);
        // int[] resultado2 = solution.twoSumWithHashMap(nums2, target2);
        System.out.println("Example 2: " + Arrays.toString(resultado2));

        // Example 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] resultado3 = solution.twoSumWithTwoLoops(nums3, target3);
        // int[] resultado3 = solution.twoSumWithHashMap(nums3, target3);
        System.out.println("Example 3: " + Arrays.toString(resultado3));
    }

    public int[] twoSumWithTwoLoops(int[] nums, int target) {
        int[] posiciones = new int[2];

        // Primer índice: selecciona un número del array.
        for(int i = 0; i < nums.length; i++){

            // Segundo índice: compara el número seleccionado con los siguientes.
            for(int j = i + 1; j < nums.length; j++){

                // Si ambos valores suman el target, guardo y devuelvo sus índices.
                if(nums[i] + nums[j] == target){
                    posiciones[0] = i;
                    posiciones[1] = j;
                    return posiciones;
                }
            }
        }

        return posiciones;
    }

    public int[] twoSumWithHashMap(int[] nums, int target) {
        // Creo un HashMap para guardar cada número que voy recorriendo
        // junto con su posición en el array.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Recorro el array una sola vez.
        for (int i = 0; i < nums.length; i++) {
            // Calculo qué número necesito para llegar al target.
            int complemento = target - nums[i];

            // Si el complemento ya está en el HashMap,
            // significa que encontré los dos números que suman target.
            if (map.containsKey(complemento)) {
                // Devuelvo la posición del complemento y la posición actual.
                return new int[] { map.get(complemento), i };
            }

            // Si todavía no encontré el complemento,
            // guardo el número actual con su índice.
            map.put(nums[i], i);
        }

        // Este return queda por seguridad.
        // El enunciado garantiza que siempre hay una solución.
        return new int[0];
    }

/*
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/
}
