/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;

import br.com.wscompany.modelos.Cerveja;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class CervejaDao {

    private List<Cerveja> cervejas;

    public CervejaDao() {

        if (cervejas == null) {
            iniciaEstoqueCervejas();
        }
    }

    public List<Cerveja> listarCervejas() {

        return this.cervejas;
    }

    public Cerveja buscaCervejaPorCodgio(int codigo) {

        for (Cerveja cerveja : cervejas) {

            if (cerveja.getCodigo() == codigo) {

                return cerveja;
            }
        }

        return null;
    }

    public LinkedList<Cerveja> retornaCervejasPorImportacao(boolean isImportada) {

        LinkedList<Cerveja> cervejas_especificas = new LinkedList<Cerveja>();

        for (Cerveja cerveja : cervejas) {

            if (cerveja.getImportada().equals(isImportada)) {

                cervejas_especificas.add(cerveja);
            }
        }

        return cervejas_especificas;
    }

    private void iniciaEstoqueCervejas() {

        cervejas = new ArrayList<Cerveja>();

        cervejas.add(new Cerveja(2004, "Heinkg", true));
        cervejas.add(new Cerveja(1968, "Stella", false));
        cervejas.add(new Cerveja(1997, "Humbrela", true));

    }
}
