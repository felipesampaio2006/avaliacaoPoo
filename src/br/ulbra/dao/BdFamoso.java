package br.ulbra.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class BdFamoso {

    public ArrayList<String> listaFamoso;
    public ArrayList<String> listaFamosoAlfabetica;

    public BdFamoso() {
        listaFamoso = new ArrayList();
        listaFamosoAlfabetica = new ArrayList();
    }

    public void save(String nome) {
        listaFamoso.add(nome);
        listaFamosoAlfabetica.add(nome);
        JOptionPane.showMessageDialog(null, "O " + nome + " foi salvo com sucesso!");

    }

    public String toString() {
        String result = "lista de Famoso(a)\n";
        if (!listaFamoso.isEmpty()) {
            for (int i = 0; i < listaFamoso.size(); i++) {
                result += listaFamoso.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }

        return result;
    }

    public String toStringAlfabeto() {
        String result = "lista de Famoso(a)\n";
        if (!listaFamosoAlfabetica.isEmpty()) {
            Collections.sort(listaFamosoAlfabetica);
            for (int i = 0; i < listaFamosoAlfabetica.size(); i++) {
                result += listaFamosoAlfabetica.get(i) + "\n";
            }
        } else {
            result = "A base de dados encontra-se vazia!";
        }

        return result;
    }

    public int getSize() {
        return listaFamoso.size();
    }

    public String getNome(int i) {
        String r = "";
        if (i >= 0) {
            r = listaFamoso.get(i);
        } else {
            r = "O famoso(a) não existe";
        }
        return r;
    }

    public void delete(int i, int iAlfabetica) {
        if (i != -1) {
            listaFamoso.remove(i);
            JOptionPane.showMessageDialog(null, "Famoso excluido");
        } else {
            JOptionPane.showMessageDialog(null, "O famoso(a) não existe!");
        }
        if (iAlfabetica != -1) {
            listaFamosoAlfabetica.remove(iAlfabetica);

        }
    }

    public void del() {
        listaFamoso.clear();
        listaFamosoAlfabetica.clear();
    }

    public int search(String nome) {
        boolean achou = false;
        int i = 0, r = -1;
        while (i < listaFamoso.size() && !achou) {
            if (listaFamoso.get(i).equals(nome)) {
                r = i;
                achou = true;
            }//fim do if
            i++;//proximo famoso
        }//fim do loop
        return r;
    }

    public void update(int i, String update) {
        if (i != -1 || update.length() > 0) {
            listaFamoso.set(i, update);
            JOptionPane.showMessageDialog(null, "Famoso(a) modificado com sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "O famoso(a) não foi modificado com sucesso!!");

        }
    }

}
