package adm;

import controle.Lote;
import controle.Paciente;
import controle.PlanoSaude;
import controle.Receita;
import usuario.Usuario;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Contexto implements Serializable {

    private static Contexto instance = null;

    private Usuario usuario;

    private List<Usuario> usuarios;
    private List<Lote> lotes;
    private List<Receita> receitas;
    private List<Paciente> pacientes;
    private List<PlanoSaude> planoSaudes;

    private Contexto() {
        File file = new File("contexto.dat");

        if (file.exists() && file.isFile()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                instance = (Contexto) ois.readObject();
                JOptionPane.showMessageDialog(null, "Dados carregado com sucesso!");
            } catch (IOException | ClassNotFoundException e) {
                lotes = new ArrayList<>();
                receitas = new ArrayList<>();
                pacientes = new ArrayList<>();
                usuarios = new ArrayList<>();
                planoSaudes = new ArrayList<>();
                usuario = null;
                instance = this;
                JOptionPane.showMessageDialog(null, "Houve perda de dados.\nEntre como administrador!");
            }
            return;
        }

        lotes = new ArrayList<>();
        receitas = new ArrayList<>();
        pacientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        planoSaudes = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Primeira inicialização do sistema. \nEntre como administrador!");
        instance = this;
    }

    public static Contexto getInstance() {
        if (instance == null) {
            instance = new Contexto();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public void salvarContexto() {
        this.usuario = null;

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("contexto.dat"))) {
            os.writeObject(this);
            JOptionPane.showMessageDialog(null, "Dados salvos em contexto.dat");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar contexto:  " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
