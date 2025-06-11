package controle;

import usuario.Farmaceutico;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Lote implements Serializable {

    private ZonedDateTime dataAquisicao;
    private ZonedDateTime dataVencimento;
    private ZonedDateTime dataFabricaccao;
    private float valor;
    private int quantidadeUnidades;
    private Medicamento medicamento;
    private Farmaceutico compradoPor;
    private boolean descartado;

    public Lote(ZonedDateTime dataVencimento, ZonedDateTime dataFabricaccao, Float valor, Integer quantidadeUnidades, Medicamento medicamento, Farmaceutico compradoPor) {
        this.dataAquisicao = ZonedDateTime.now();
        this.dataVencimento = dataVencimento;
        this.dataFabricaccao = dataFabricaccao;
        this.valor = valor;
        this.quantidadeUnidades = quantidadeUnidades;
        this.medicamento = medicamento;
        this.compradoPor = compradoPor;
        this.descartado = false;

        this.getMedicamento().addLote(this);
    }

    protected ZonedDateTime getDataAquisicao() {
        return dataAquisicao;
    }

    protected void setDataAquisicao(ZonedDateTime dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    protected ZonedDateTime getDataVencimento() {
        return dataVencimento;
    }

    protected void setDataVencimento(ZonedDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    protected ZonedDateTime getDataFabricaccao() {
        return dataFabricaccao;
    }

    protected void setDataFabricaccao(ZonedDateTime dataFabricaccao) {
        this.dataFabricaccao = dataFabricaccao;
    }

    protected float getValor() {
        return valor;
    }

    protected void setValor(float valor) {
        this.valor = valor;
    }

    protected int getQuantidadeUnidades() {
        return quantidadeUnidades;
    }

    protected void setQuantidadeUnidades(int quantidadeUnidades) {
        this.quantidadeUnidades = quantidadeUnidades;
    }

    protected Medicamento getMedicamento() {
        return medicamento;
    }

    protected void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    protected Farmaceutico getCompradoPor() {
        return compradoPor;
    }

    protected void setCompradoPor(Farmaceutico compradoPor) {
        this.compradoPor = compradoPor;
    }

    protected boolean isDescartado() {
        return descartado;
    }

    public void setDescartado(boolean descartado) {
        this.descartado = descartado;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
        return "Lote{" +
                "dataAquisicao=" + dataAquisicao.format(formatter) +
                ", dataVencimento=" + dataVencimento.format(formatter) +
                ", dataFabricaccao=" + dataFabricaccao.format(formatter) +
                ", valor= R$" + valor +
                ", quantidadeUnidades=" + quantidadeUnidades +
                ", medicamento=" + medicamento +
                ", compradoPor=" + compradoPor.getNome() +
                '}';
    }
}
