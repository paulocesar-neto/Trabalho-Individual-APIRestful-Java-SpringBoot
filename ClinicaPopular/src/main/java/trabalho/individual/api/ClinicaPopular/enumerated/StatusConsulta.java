package trabalho.individual.api.ClinicaPopular.enumerated;

import com.fasterxml.jackson.annotation.JsonCreator;
import trabalho.individual.api.ClinicaPopular.exception.EnumValidationException;

public enum StatusConsulta {
    AGENDADA,
    PENDENTE,
    CONFIRMADA,

    CONCLUIDA,
    REAGENDADA,
    CANCELADA;

    @JsonCreator
    public static StatusConsulta verifica(String value) throws EnumValidationException {
        for(StatusConsulta status : values()){

            if(value.equals(status.name())){
                return status;
            }
        }
       throw new EnumValidationException(
               "Status da consulta inválido.Status correto:" +
                       " AGENDADA," +
                       "PENDENTE," +
                       "CONFIRMADA," +
                       "CONCLUIDA," +
                       "REAGENDADA," +
                       "CANCELADA");
    }
}
