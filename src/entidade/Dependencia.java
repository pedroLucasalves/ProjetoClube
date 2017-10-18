/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author aluno
 */
public class Dependencia {
    private int codigo;
    private String grauParentesco;
    private Associado dependente;
    private Associado patrocinador;

    public Dependencia(Associado dependente, Associado patrocinador) {
        this.dependente = dependente;
        this.patrocinador = patrocinador;
    }
    
    public Dependencia() {
        this.dependente = new Associado();
        this.patrocinador =  new Associado();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Associado getDependente() {
        return dependente;
    }

    public void setDependente(Associado dependente) {
        this.dependente = dependente;
    }

    public Associado getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Associado patrocinador) {
        this.patrocinador = patrocinador;
    }
}
