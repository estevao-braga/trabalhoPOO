package controle;

import java.io.Serializable;

public class PlanoSaude implements Serializable {

    private String nome;
    private String cnpj;

    public PlanoSaude(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCnpj() {
        return cnpj;
    }

    protected void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PlanoSaude{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
