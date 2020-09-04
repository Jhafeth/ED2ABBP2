/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.abbp2;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Jhafeth
 * @param <K> CLAVE
 * @param <V> VALOR
 */
public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

    protected NodoBinario<K, V> raiz;

    @Override
    public void insertar(K clave, V valor) throws DatoYaExiste {
        //El arbol esta vacio, se inserta en la raiz
        if (this.esArbolVacio()) {
            this.raiz = new NodoBinario<>(clave, valor);
            return;
        }

        //El arbol no es vacio
        NodoBinario<K, V> nodoActual = this.raiz;
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();

        while (!NodoBinario.esNodoVacio(nodoActual)) {
            nodoAnterior = nodoActual;
            //Dato a insertar es mayor que el dato actual, ir a la derecha
            if (clave.compareTo(nodoActual.getClave()) > 0) {
                nodoActual = nodoAnterior.getHijoDerecho();
                //Dato a insertar es menor que el dato actual, ir a la izquierda
            } else if (clave.compareTo(nodoActual.getClave()) < 0) {
                nodoActual = nodoAnterior.getHijoIzquierdo();
                //Dato ya existe en el arbol
            } else {
                throw new DatoYaExiste("Ya existe el dato");
            }
        }

        NodoBinario<K, V> nuevoNodo = new NodoBinario(clave, valor);

        if (clave.compareTo(nodoAnterior.getClave()) > 0) {
            nodoAnterior.setHijoDerecho(nuevoNodo);
        } else if (clave.compareTo(nodoAnterior.getClave()) < 0) {
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }

    }

    @Override
    public K eliminar(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V buscar(K clave) {
        NodoBinario<K, V> nodoActual = this.raiz;

        while (!NodoBinario.esNodoVacio(nodoActual)) {

            //Dato a buscar es mayor que el dato actual, ir a la derecha
            if (clave.compareTo(nodoActual.getClave()) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
                //Dato a buscar es menor que el dato actual, ir a la izquierda
            } else if (clave.compareTo(nodoActual.getClave()) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
                //Dato ya encontrado en el arbol
            } else {
                return nodoActual.getValor();
            }
        }
        return null;
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave) != null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> recorrido = new LinkedList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoDerecho()) {
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new LinkedList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return recorrido;
    }

    @Override
    public int size() {
        if (this.esArbolVacio()) {
            return 0;
        }
        int contadorDeNodos = 0;
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            contadorDeNodos++;
            if (!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return contadorDeNodos;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        } else {
            int alturaIzquierda = altura(nodoActual.getHijoIzquierdo());
            int alturaDerecha = altura(nodoActual.getHijoDerecho());
            return (alturaIzquierda > alturaDerecha) ? alturaIzquierda + 1 : alturaDerecha + 1;
        }

    }

    @Override
    public void vaciar() {
        this.raiz = new NodoBinario<>();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int nivel(K clave) {
        return nivel(clave, this.raiz);
    }

    private int nivel(K clave, NodoBinario<K, V> nodo) {
        if (clave.compareTo(nodo.getClave()) == 0) {
            return 0;
        } else if (clave.compareTo(nodo.getClave()) > 0) {
            return nivel(clave, nodo.getHijoDerecho()) + 1;
        } else {
            return nivel(clave, nodo.getHijoIzquierdo()) + 1;
        }
    }

    @Override
    public String toString() {
        return "R-" + toStrRec(this.raiz);
    }

    private String toStrRec(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return "*";
        } else if (nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()) {
            return "" + nodoActual.getClave();
        } else {
            return "" + nodoActual.getClave()
                    + "{" + toStrRec(nodoActual.getHijoIzquierdo())
                    + "," + toStrRec(nodoActual.getHijoDerecho()) + "}";
        }
    }

    //pregunta 1
    public int cantidadHojas() {
        return cantidadHojas(raiz);
    }

    private int cantidadHojas(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.esHoja()) {
            return 1;
        }

        int chi = cantidadHojas(nodo.getHijoIzquierdo());
        int chd = cantidadHojas(nodo.getHijoDerecho());
        return chi + chd;
    }

    //pregunta 2
    public int cantidadHojasI() {
        int cantidad = 0;
        if (this.esArbolVacio()) {
            return 0;
        }

        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            if (nodoActual.esHoja()) {
                cantidad++;
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return cantidad;
    }

    //pregunta 3
    public int cantidadHojasN(int n) {
        return cantidadHojasN(raiz, n, 0);
    }

    private int cantidadHojasN(NodoBinario nodo, int n, int a) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.esHoja()) {
            if (a == n) {
                return 1;
            }
        }

        return cantidadHojasN(nodo.getHijoIzquierdo(), n, a + 1)
                + cantidadHojasN(nodo.getHijoDerecho(), n, a + 1);
    }

    //pregunta 4 
    public int cantidadHojasNI(int n) {
        int cantidad = 0;
        if (this.esArbolVacio()) {
            return 0;
        }
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            if (nivel(nodoActual.getClave()) == n) {
                if (nodoActual.esHoja()) {
                    cantidad++;
                }
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return cantidad;
    }

    //pregunta 5
    public int cantidadHojasAntesNI(int n) {
        int cantidad = 0;
        if (this.esArbolVacio()) {
            return 0;
        }
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            if (nivel(nodoActual.getClave()) < n) {
                if (nodoActual.esHoja()) {
                    cantidad++;
                }
            }
            if (!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return cantidad;
    }

    //pregunta 6 verificar si el arbol esta balenceado recursivo
    //pregunta 7 logica de postOrden verificar si esta balanceado iterativo
    //pregunta 8 reconstruir arbol con listas en preorden e inorden
    public void reconstruir(List<NodoBinario<K, V>> listaPreOrden, List<NodoBinario<K, V>> listaInOrden) {
        vaciar();
        this.raiz = reconstruirR(listaPreOrden, listaInOrden);
    }

    private NodoBinario<K, V> reconstruirR(List<NodoBinario<K, V>> listaPreOrden,
            List<NodoBinario<K, V>> listaInOrden) {
        NodoBinario<K, V> nuevoNodo = null;
        if (!listaInOrden.isEmpty() && !listaPreOrden.isEmpty()) {
            //en la lista preorden el primer elemento es la raiz
            nuevoNodo = new NodoBinario<>();
            nuevoNodo.setClave(listaPreOrden.get(0).getClave());
            nuevoNodo.setValor(listaPreOrden.get(0).getValor());

            //agregar hijos
            int m = 0;
            while (!(nuevoNodo.getClave().compareTo(listaInOrden.get(m).getClave()) == 0)) {
                m++;
            }
            List<NodoBinario<K, V>> listaPreOrdenIzq = new LinkedList<>();
            List<NodoBinario<K, V>> listaInOrdenIzq = new LinkedList<>();
            listaPreOrden.remove(0);

            for (int i = 0; i < m; i++) {
                listaInOrdenIzq.add(listaInOrden.get(0));
                listaInOrden.remove(0);
                listaPreOrdenIzq.add(listaPreOrden.get(0));
                listaPreOrden.remove(0);
            }

            nuevoNodo.setHijoIzquierdo(reconstruirR(listaPreOrdenIzq, listaInOrdenIzq));
            listaInOrden.remove(0);
            nuevoNodo.setHijoDerecho(reconstruirR(listaPreOrden, listaInOrden));
        }
        return nuevoNodo;
    }

    //    public boolean isAVL() {
    //        return isAVL(raiz);
    //    }
    //
    //    private boolean isAVL(NodoBinario nodo) {
    //        if (nodo == null) {
    //            return true;
    //        }
    //        if (nodo.esHoja()) {
    //            return true;
    //        }
    //
    //        boolean bandera = false;
    //        if (nivel(nodo.getHijoIzquierdo()) == nivel(nodo.getHijoDerecho())) {
    //            bandera = true;
    //        }
    //
    //        return bandera && isAVL(nodo.getHijoIzquierdo()) && isAVL(nodo.getHijoDerecho());
    //    }
    //pregunta 9 sucesor InOrden
    //pregunta 10 predecesor InOrden
    //pregunta 11 eliminar de un arbol AVL
//pregunta 12 cantidad de nodos completos luego del nivel N
    public int cantidadNodosCompletos(int n) {
        return cantidadNodosCompletos(raiz, n, 0);
    }

    private int cantidadNodosCompletos(NodoBinario<K, V> nodo, int n, int a) {
        if (nodo == null) {
            return 0;
        }
        if (a > n) {
            if (!nodo.esVacioHijoIzquierdo() && !nodo.esVacioHijoDerecho()) {
                return 1;
            }
        }
        return cantidadNodosCompletos(nodo.getHijoIzquierdo(), n, a + 1)
                + cantidadNodosCompletos(nodo.getHijoDerecho(), n, a + 1);
    }

}
