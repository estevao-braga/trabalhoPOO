package usuario;

import java.io.Serializable;

public class Medico extends Usuario implements Serializable {

    private String matriculaCRM;

    public Medico(String nome, String senha, String cpf, String matriculaCRM) {
        super(nome, senha, cpf);
        this.matriculaCRM = matriculaCRM;
    }

    public String getMatriculaCRM() {
        return matriculaCRM;
    }

    protected void setMatriculaCRM(String matriculaCRM) {
        this.matriculaCRM = matriculaCRM;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "matriculaCRM='" + matriculaCRM + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
