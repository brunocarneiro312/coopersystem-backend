package br.com.coopersystem.backendcoopersystem.enums;

public enum TipoTelefoneEnum {

    RESIDENCIAL(0),
    COMERCIAL(1),
    CELULAR(2);

    private int tipoTelefone;

    TipoTelefoneEnum(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
