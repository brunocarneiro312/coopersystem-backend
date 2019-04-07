package br.com.coopersystem.backendcoopersystem.enums;

/**
 * Enum que define o tipo de telefone
 */
public enum TipoTelefoneEnum {

    RESIDENCIAL(0),
    COMERCIAL(1),
    CELULAR(2);

    private int tipoTelefone;

    TipoTelefoneEnum(int tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
