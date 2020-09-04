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
//        ArbolBinarioBusqueda<Integer, String> arbolb = new ArbolBinarioBusqueda<>();
//
//        arbolb.insertar(50, "Alan");
//        arbolb.insertar(25, "Brandon");
//        arbolb.insertar(75, "Pablo");
//        System.out.println("------PREGUNTAS-------");
//        System.out.println(arbolb);
//        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
//        System.out.println("Cantidad de hojasIte: " + arbolb.cantidadHojasI());
//        System.out.println("Altura del arbol: " + arbolb.altura());
//        arbolb.insertar(20, "Carlos");
//        arbolb.insertar(30, "Juan");
//        System.out.println("------PREGUNTAS-------");
//        System.out.println(arbolb);
//        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
//        System.out.println("Cantidad de hojasIte: " + arbolb.cantidadHojasI());
//        System.out.println("Altura del arbol: " + arbolb.altura());
//        arbolb.insertar(1, "Pedro");
//        arbolb.insertar(100, "Marcos");
//        arbolb.insertar(70, "Maria");
//        arbolb.insertar(21, "Luis");
//        System.out.println("------PREGUNTAS-------");
//        System.out.println(arbolb);
//        System.out.println("Cantidad de hojas: " + arbolb.cantidadHojas());
//        System.out.println("Cantidad de hojasN: " + arbolb.cantidadHojasI());
//        System.out.println("Altura del arbol: " + arbolb.altura());
//        System.out.println("----------------------------");

        List<NodoBinario<Integer, String>> listaInOrden = new LinkedList<>();
        NodoBinario<Integer, String> nodo1 = new NodoBinario<>(25, "Izq");
        NodoBinario<Integer, String> nodo2 = new NodoBinario<>(50, "Raiz");
        NodoBinario<Integer, String> nodo3 = new NodoBinario<>(75, "Der");

        listaInOrden.add(nodo1);
        listaInOrden.add(nodo2);
        listaInOrden.add(nodo3);
        System.out.println(listaInOrden);

        List<NodoBinario<Integer, String>> listaPreOrden = new LinkedList<>();

        listaPreOrden.add(nodo2);
        listaPreOrden.add(nodo1);
        listaPreOrden.add(nodo3);
        System.out.println(listaPreOrden);

        ArbolBinarioBusqueda<Integer, String> arbolb = new ArbolBinarioBusqueda<>();
        arbolb.reconstruir(listaPreOrden, listaInOrden);
        System.out.println(arbolb);
    }

}
