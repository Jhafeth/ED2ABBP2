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
        System.out.println("------PREGUNTAS 1-4 -------");
        System.out.println(arbolb);
        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        System.out.println("Cantidad de hojas en Nivel N=1:" + arbolb.cantidadHojasN(1));
        System.out.println("Cantidad de hojas en Nivel N=1 Iterativo:" + arbolb.cantidadHojasNI(1));
        arbolb.insertar(20, "Carlos");
        arbolb.insertar(30, "Juan");
        System.out.println("------PREGUNTAS 1-4 -------");
        System.out.println(arbolb);
        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        System.out.println("Cantidad de hojas en Nivel N=1:" + arbolb.cantidadHojasN(1));
        System.out.println("Cantidad de hojas en Nivel N=1 Iterativo:" + arbolb.cantidadHojasNI(1));
        arbolb.insertar(1, "Pedro");
        arbolb.insertar(100, "Marcos");
        arbolb.insertar(70, "Maria");
        arbolb.insertar(21, "Luis");
        System.out.println("------PREGUNTAS 1-5 -------");
        System.out.println(arbolb);
        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
        System.out.println("Cantidad de hojas Iterativo: " + arbolb.cantidadHojasI());
        System.out.println("Cantidad de hojas en Nivel N=1:" + arbolb.cantidadHojasN(1));
        System.out.println("Cantidad de hojas en Nivel N=1 Iterativo:" + arbolb.cantidadHojasNI(1));
        System.out.println("Cantidad de hojas antes del Nivel N=3 Iterativo:" + arbolb.cantidadHojasAntesNI(3));
        System.out.println("----------------------------");

        System.out.println("PREGUNTA 8");
        List<NodoBinario<Integer, String>> listaInOrden = new LinkedList<>();
        NodoBinario<Integer, String> nodo1 = new NodoBinario<>(25, "Izq");
        NodoBinario<Integer, String> nodo2 = new NodoBinario<>(50, "Raiz");
        NodoBinario<Integer, String> nodo3 = new NodoBinario<>(75, "Der");

        listaInOrden.add(nodo1);
        listaInOrden.add(nodo2);
        listaInOrden.add(nodo3);
        System.out.println("Lista InOrden: " + listaInOrden);

        List<NodoBinario<Integer, String>> listaPreOrden = new LinkedList<>();

        listaPreOrden.add(nodo2);
        listaPreOrden.add(nodo1);
        listaPreOrden.add(nodo3);
        System.out.println("Lista PreOrden: " + listaPreOrden);

        ArbolBinarioBusqueda<Integer, String> arbolb2 = new ArbolBinarioBusqueda<>();
        arbolb2.reconstruir(listaPreOrden, listaInOrden);
        System.out.println(arbolb2);
        System.out.println("----------------------------");
        System.out.println("PREGUNTA 12");
        System.out.println(arbolb);
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 0: " + arbolb.cantidadNodosCompletos(0));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 1: " + arbolb.cantidadNodosCompletos(1));
        System.out.println("Cantidad de Nodos Completos luego del nivel N = 2: " + arbolb.cantidadNodosCompletos(2));
    }

}
