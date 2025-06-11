package controle;

import exceptions.EstoqueException;

import java.io.Serializable;
import java.util.List;

public class Medicamento implements Serializable {

    private String nome;
    private Tarja tarja;
    private float qtdMg;
    private float preco;
    private List<Lote> lotes;

    public Medicamento(String nome, Tarja tarja, Float qtdMg, Float preco) {
        this.nome = nome;
        this.tarja = tarja;
        this.qtdMg = qtdMg;
        this.preco = preco;
    }

    protected void addLote(Lote lote) {
        lotes.add(lote);
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected Tarja getTarja() {
        return tarja;
    }

    protected void setTarja(Tarja tarja) {
        this.tarja = tarja;
    }

    protected float getQtdMg() {
        return qtdMg;
    }

    protected void setQtdMg(float qtdMg) {
        this.qtdMg = qtdMg;
    }

    protected Float getPreco() {
        return preco;
    }

    protected void setPreco(Float preco) {
        this.preco = preco;
    }

    protected Integer getQuantidadeEstoque() {
        int qtd = 0;
        for (Lote lote : lotes) {
            if (!lote.isDescartado())
                qtd += lote.getQuantidadeUnidades();
        }
        return qtd;
    }

    protected void dispensaUnidade() {
        for (Lote lote : lotes) {
            if (!lote.isDescartado() && lote.getQuantidadeUnidades() > 0) {
                lote.setQuantidadeUnidades(lote.getQuantidadeUnidades() - 1);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nome='" + nome + '\'' +
                ", tarja=" + tarja +
                ", qtdMg=" + qtdMg +
                ", preco= R$" + preco +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                '}';
    }
}
