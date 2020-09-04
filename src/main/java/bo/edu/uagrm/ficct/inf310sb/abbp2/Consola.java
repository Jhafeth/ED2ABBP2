/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.abbp2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jhafeth
 */
public class Consola {

    public static void main(String argumentos[]) throws Exception {
        ArbolBinarioBusqueda<Integer, String> arbolb = new ArbolBinarioBusqueda<>();
        arbolb.insertar(50, "Alan");
        arbolb.insertar(25, "Brandon");
        arbolb.insertar(75, "Pablo");
        System.out.println("------PREGUNTAS-------");
        System.out.println(arbolb);
        System.out.println("1.Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("2.Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        int n = 1;
        System.out.println("3.Cantidad de hojas en Nivel N=" + n + ": " + arbolb.cantidadHojasN(n));
        System.out.println("4.Cantidad de hojas en Nivel N=" + n + " Iterativo:" + arbolb.cantidadHojasNI(n));
        System.out.println("6.Arbol balanceado? " + arbolb.esBalanceado());

        int k = 50;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        arbolb.insertar(20, "Carlos");
        arbolb.insertar(30, "Juan");

        System.out.println("------PREGUNTAS-------");
        System.out.println(arbolb);
        System.out.println("1.Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("2.Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        n = 2;
        System.out.println("3.Cantidad de hojas en Nivel N=" + n + ": " + arbolb.cantidadHojasN(n));
        System.out.println("4.Cantidad de hojas en Nivel N=" + n + " Iterativo:" + arbolb.cantidadHojasNI(n));
        System.out.println("6.Arbol balanceado? " + arbolb.esBalanceado());
        k = 25;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        arbolb.insertar(1, "Pedro");
        arbolb.insertar(21, "Luis");
        arbolb.insertar(45, "Lilian");

        System.out.println("------PREGUNTAS-------");
        System.out.println(arbolb);
        System.out.println("6.Arbol balanceado? " + arbolb.esBalanceado());
        k = 21;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        k = 45;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        k = 75;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        arbolb.insertar(100, "Marcos");
        arbolb.insertar(70, "Maria");

        System.out.println("------PREGUNTAS-------");
        System.out.println(arbolb);
        System.out.println("1.Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("2.Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        System.out.println("3.Cantidad de hojas en Nivel N=1:" + arbolb.cantidadHojasN(1));
        System.out.println("4.Cantidad de hojas en Nivel N=1 Iterativo:" + arbolb.cantidadHojasNI(1));
        System.out.println("5.Cantidad de hojas antes del Nivel N=3 Iterativo:" + arbolb.cantidadHojasAntesNI(3));
        System.out.println("6.Arbol balanceado? " + arbolb.esBalanceado());
        k = 50;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));
        k = 100;
        System.out.println("9.Sucesor InOrden k=" + k + ": " + arbolb.sucesorInorden(k));
        System.out.println("10.Predecesor InOrden k=" + k + ": " + arbolb.predecesorInorden(k));

        System.out.println("----------------------------");

        System.out.println("PREGUNTA 8");
        NodoBinario<Integer, String> nodo1 = new NodoBinario<>(25, "Izq");
        NodoBinario<Integer, String> nodo2 = new NodoBinario<>(50, "Raiz");
        NodoBinario<Integer, String> nodo3 = new NodoBinario<>(75, "Der");
        NodoBinario<Integer, String> nodo4 = new NodoBinario<>(20, "A");
        NodoBinario<Integer, String> nodo5 = new NodoBinario<>(30, "B");
        List<NodoBinario<Integer, String>> listaInOrden = new LinkedList<>();
        List<NodoBinario<Integer, String>> listaPreOrden = new LinkedList<>();

        listaInOrden.add(nodo1);
        listaInOrden.add(nodo2);
        listaInOrden.add(nodo3);

        listaPreOrden.add(nodo2);
        listaPreOrden.add(nodo1);
        listaPreOrden.add(nodo3);

        System.out.println("Lista InOrden: " + listaInOrden);
        System.out.println("Lista PreOrden: " + listaPreOrden);

        ArbolBinarioBusqueda<Integer, String> arbolb2 = new ArbolBinarioBusqueda<>();

        arbolb2.reconstruir(listaPreOrden, listaInOrden);
        System.out.println(arbolb2);

        listaInOrden.clear();
        listaPreOrden.clear();

        listaInOrden.add(nodo4);
        listaInOrden.add(nodo1);
        listaInOrden.add(nodo5);
        listaInOrden.add(nodo2);
        listaInOrden.add(nodo3);

        listaPreOrden.add(nodo2);
        listaPreOrden.add(nodo1);
        listaPreOrden.add(nodo4);
        listaPreOrden.add(nodo5);
        listaPreOrden.add(nodo3);

        System.out.println("Lista InOrden: " + listaInOrden);
        System.out.println("Lista PreOrden: " + listaPreOrden);

        arbolb2.reconstruir(listaPreOrden, listaInOrden);
        System.out.println(arbolb2);

        System.out.println("----------------------------");

        System.out.println("PREGUNTA 12");
        System.out.println(arbolb);
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 0: " + arbolb.cantidadNodosCompletos(0));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 1: " + arbolb.cantidadNodosCompletos(1));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 2: " + arbolb.cantidadNodosCompletos(2));
        arbolb.insertar(28, "Rodrigo");
        System.out.println(arbolb);
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 0: " + arbolb.cantidadNodosCompletos(0));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 1: " + arbolb.cantidadNodosCompletos(1));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 2: " + arbolb.cantidadNodosCompletos(2));
        System.out.println("----------------------------");
    }

}
