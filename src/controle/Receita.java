package controle;

import adm.Contexto;
import exceptions.EstoqueException;
import exceptions.NotAuthorizedException;
import usuario.Farmaceutico;
import usuario.Medico;
import usuario.Usuario;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Receita implements Serializable {

    private Medico receitadoPor;
    private Farmaceutico dispensadoPor;
    private String descricao;
    private ZonedDateTime dataEmicao;
    private ZonedDateTime dataDispensacao;
    private Medicamento medicamento;

    public Receita(Medico receitadoPor, String descricao, ZonedDateTime dataEmicao,  Medicamento medicamento) {
        this.receitadoPor = receitadoPor;
        this.descricao = descricao;
        this.dataEmicao = dataEmicao;
        this.medicamento = medicamento;
        this.dataDispensacao = null;
        this.dispensadoPor = null;
    }

    protected Medico getReceitadoPor() {
        return receitadoPor;
    }

    protected void setReceitadoPor(Medico receitadoPor) {
        this.receitadoPor = receitadoPor;
    }

    protected Farmaceutico getDispensadoPor() {
        return dispensadoPor;
    }

    private void setDispensadoPor(Farmaceutico dispensadoPor) {
        this.dispensadoPor = dispensadoPor;
    }

    protected String getDescricao() {
        return descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected ZonedDateTime getDataEmicao() {
        return dataEmicao;
    }

    protected void setDataEmicao(ZonedDateTime dataEmicao) {
        this.dataEmicao = dataEmicao;
    }

    protected ZonedDateTime getDataDispensacao() {
        return dataDispensacao;
    }

    protected void setDataDispensacao(ZonedDateTime dataDispensacao) {
        this.dataDispensacao = dataDispensacao;
    }

    protected Medicamento getMedicamento() {
        return medicamento;
    }

    protected void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    protected void dispensacao() throws NotAuthorizedException, EstoqueException {
        Contexto ctx = Contexto.getInstance();
        Usuario usuario =  ctx.getUsuario();

        if (!(usuario instanceof Farmaceutico)) {
            throw new NotAuthorizedException("Apenas Farmaceutico pode realizar está ação");
        }

        if (this.getMedicamento().getQuantidadeEstoque() <= 0) {
            throw new EstoqueException("Não possuimos estoque deste medicamento");
        }

        this.setDispensadoPor((Farmaceutico) usuario);
        this.dataDispensacao = ZonedDateTime.now();
        this.getMedicamento().dispensaUnidade();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");

        return "Receita{" +
                "receitadoPor=" + receitadoPor.getNome() +
                ", dispensadoPor=" + dispensadoPor.getNome() +
                ", descricao='" + descricao + '\'' +
                ", dataEmicao=" + dataEmicao.format(formatter) +
                ", dataDispensacao=" + dataDispensacao.format(formatter) +
                ", medicamento=" + medicamento.getNome() +
                '}';
    }
}
