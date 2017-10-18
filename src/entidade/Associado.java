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
public class Associado {

    private int codigo;
    private String nome;
    private String cpf;
    private String rg;
    private int fone;
    private String endereco;
  
    private TipoAssociado ETipoAssociado;

    public Associado(TipoAssociado tipoAssociado) {
        this.ETipoAssociado = tipoAssociado;
    }

    public Associado() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getFone() {
        return fone;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoAssociado getTipoAssociado() {
        return ETipoAssociado;
    }

    public void setTipoAssociado(TipoAssociado tipoAssociado) {
        this.ETipoAssociado = tipoAssociado;
    }
    
}