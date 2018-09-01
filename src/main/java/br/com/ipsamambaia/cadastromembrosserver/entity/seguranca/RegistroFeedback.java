package br.com.ipsamambaia.cadastromembrosserver.entity.seguranca;

import java.io.Serializable;

public class RegistroFeedback implements Serializable {

    private boolean usuarioJaExistente;
    private boolean emailInvalido;
    private boolean senhaIncorreta;
    private boolean senhasDiferentes;

    public boolean isRegistroInvalido() {
        return usuarioJaExistente || emailInvalido || senhaIncorreta || senhasDiferentes;
    }

    public boolean isUsuarioJaExistente() {
        return usuarioJaExistente;
    }

    public void setUsuarioJaExistente(boolean usuarioJaExistente) {
        this.usuarioJaExistente = usuarioJaExistente;
    }

    public boolean isEmailInvalido() {
        return emailInvalido;
    }

    public void setEmailInvalido(boolean emailInvalido) {
        this.emailInvalido = emailInvalido;
    }

    public boolean isSenhaIncorreta() {
        return senhaIncorreta;
    }

    public void setSenhaIncorreta(boolean senhaIncorreta) {
        this.senhaIncorreta = senhaIncorreta;
    }

    public boolean isSenhasDiferentes() {
        return senhasDiferentes;
    }

    public void setSenhasDiferentes(boolean senhasDiferentes) {
        this.senhasDiferentes = senhasDiferentes;
    }
}
