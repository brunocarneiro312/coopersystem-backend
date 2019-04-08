package br.com.coopersystem.backendcoopersystem.enums;

/**
 * Enum que define o tipo de telefone
 */
public enum TipoTelefoneEnum {

    CELULAR(0),
    RESIDENCIAL(1),
    COMERCIAL(2);

    private int tipoTelefone;

    TipoTelefoneEnum(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
