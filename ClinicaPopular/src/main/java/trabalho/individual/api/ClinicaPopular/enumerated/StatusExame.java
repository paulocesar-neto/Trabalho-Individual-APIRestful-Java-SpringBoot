package trabalho.individual.api.ClinicaPopular.enumerated;

import trabalho.individual.api.ClinicaPopular.exception.EnumValidationException;

public enum StatusExame {
    SOLICITADO,
    EM_ANALISE,
    REALIZADO,
    PENDENTE,
    REAGENDADO,
    CANCELADO;

    public static StatusExame verifica(String value) throws EnumValidationException {
        for(StatusExame statusExame : values()){
            if(value.equals(statusExame.name())){
                return statusExame;
            }
        }
        throw new EnumValidationException(
                "Status Exame inválido.Status Correto:" +
                        "SOLICITADO," +
                        "EM_ANALISE," +
                        "REALIZADO," +
                        "PENDENTE," +
                        "REAGENDADO," +
                        "CANCELADO");
    }
}
