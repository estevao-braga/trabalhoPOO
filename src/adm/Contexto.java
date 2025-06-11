package adm;

import usuario.Usuario;
import java.io.Serializable;

public class Contexto implements Serializable {

    private static Contexto instance = null;

    private Usuario usuario;

    private Contexto() {

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
}
