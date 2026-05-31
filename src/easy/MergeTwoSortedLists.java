package easy;

public class MergeTwoSortedLists {
    /*
        Se proporcionan las cabeceras de dos listas enlazadas ordenadas.
        Combinar ambas listas en una sola lista ordenada, uniendo los nodos existentes.

        Ejemplo 1:
        Entrada: list1 = [1,2,4], list2 = [1,3,4]
        Salida: [1,1,2,3,4,4]

        Ejemplo 2:
        Entrada: list1 = [], list2 = []
        Salida: []

        Ejemplo 3:
        Entrada: list1 = [], list2 = [0]
        Salida: [0]
    */

    public static void main(String[] args) {
        MergeTwoSortedLists solucion = new MergeTwoSortedLists();

        ListNode lista1 = crearLista(new int[]{1, 2, 4});
        ListNode lista2 = crearLista(new int[]{1, 3, 4});

        ListNode resultado = solucion.mergeTwoLists(lista1, lista2);

        System.out.print("Ejemplo 1: ");
        imprimirLista(resultado);

        ListNode lista3 = crearLista(new int[]{});
        ListNode lista4 = crearLista(new int[]{});

        ListNode resultado2 = solucion.mergeTwoLists(lista3, lista4);

        System.out.print("Ejemplo 2: ");
        imprimirLista(resultado2);

        ListNode lista5 = crearLista(new int[]{});
        ListNode lista6 = crearLista(new int[]{0});

        ListNode resultado3 = solucion.mergeTwoLists(lista5, lista6);

        System.out.print("Ejemplo 3: ");
        imprimirLista(resultado3);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Creo un nodo auxiliar para facilitar el armado de la lista resultado.
        ListNode aux = new ListNode(-1);

        // actual se va moviendo y siempre apunta al último nodo agregado.
        ListNode actual = aux;

        // Mientras ambas listas tengan nodos, comparo sus valores.
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Comparo valores, pero enlazo el nodo completo.
                actual.next = list1;

                // Avanzo en la lista de donde tomé el nodo.
                list1 = list1.next;
            } else {
                actual.next = list2;
                list2 = list2.next;
            }

            // Avanzo actual al último nodo agregado.
            actual = actual.next;
        }

        // Si una lista todavía tiene nodos, los engancho directamente.
        // Como ya están ordenados, no hace falta seguir comparando.
        if (list1 != null) {
            actual.next = list1;
        } else {
            actual.next = list2;
        }

        // aux es un nodo auxiliar; la lista real empieza en aux.next.
        return aux.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode crearLista(int[] valores) {
        ListNode aux = new ListNode(-1);
        ListNode actual = aux;

        for (int valor : valores) {
            actual.next = new ListNode(valor);
            actual = actual.next;
        }

        return aux.next;
    }

    private static void imprimirLista(ListNode nodo) {
        System.out.print("[");

        while (nodo != null) {
            System.out.print(nodo.val);

            if (nodo.next != null) {
                System.out.print(", ");
            }

            nodo = nodo.next;
        }

        System.out.println("]");
    }
}