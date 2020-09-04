/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.abbp2;

import java.util.List;

/**
 *
 * @author Jhafeth
 * @param <K> CLAVE
 * @param <V> VALOR
 */
public interface IArbolBusqueda<K extends Comparable<K>,V> {

    public void insertar(K clave, V valor) throws DatoYaExiste;

    public K eliminar(K clave) throws DatoNoExiste;

    public V buscar(K clave);

    public boolean contiene(K clave);

    public List<K> recorridoEnInOrden();

    public List<K> recorridoEnPreOrden();

    public List<K> recorridoEnPostOrden();

    public List<K> recorridoPorNiveles();

    public int size();

    public int altura();

    public void vaciar();

    public boolean esArbolVacio();

    public int nivel(K clave);
    
}
