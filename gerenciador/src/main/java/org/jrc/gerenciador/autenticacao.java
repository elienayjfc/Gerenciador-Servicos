package org.jrc.gerenciador;

public class autenticacao {
    private static final String user = "elienay";
    private static final String  pass = "3543629";

    public boolean validar (String usuario, String senha) {
        if (usuario == null || senha == null) return false;

        return usuario.equals(user) && senha.equals(pass);
    }
    
}
