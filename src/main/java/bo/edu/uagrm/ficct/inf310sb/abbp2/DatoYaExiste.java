/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.abbp2;

/**
 *
 * @author Jhafeth
 */
public class DatoYaExiste extends Exception {

    public DatoYaExiste() {
        super("La clave ya existe");
    }

    public DatoYaExiste(String mensaje) {
        super(mensaje);
    }
}
