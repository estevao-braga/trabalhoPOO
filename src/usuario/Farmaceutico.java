package usuario;

import java.io.Serializable;

public class Farmaceutico extends Usuario implements Serializable {

    private String matriculaCRF;

    public Farmaceutico(String nome, String senha, String cpf, String matriculaCRF) {
        super(nome, senha, cpf);
        this.matriculaCRF = matriculaCRF;
    }

    public String getMatriculaCRF() {
        return matriculaCRF;
    }

    protected void setMatriculaCRF(String matriculaCRF) {
        this.matriculaCRF = matriculaCRF;
    }

    @Override
    public String toString() {
        return "Farmaceutico{" +
                "matriculaCRF='" + matriculaCRF + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
