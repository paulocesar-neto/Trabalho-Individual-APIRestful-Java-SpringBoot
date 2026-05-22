package trabalho.individual.api.ClinicaPopular.enumerated;

import trabalho.individual.api.ClinicaPopular.exception.EnumValidationException;

public enum TipoConsulta {
    PRIMEIRA_CONSULTA,
    ROTINA,
    RETORNO,
    ACOMPANHAMENTO,
    PRESENCIAL,
    TELECONSULTA;


    public static TipoConsulta verificaTipoConsulta(String value)throws EnumValidationException{
        for(TipoConsulta tc : values()){
            if (values().equals(tc.name())){
                return tc;
            }
        }
        throw new EnumValidationException(
                "Tipo da consulta inválido. tipo correto:" +
                        "PRIMEIRA_CONSULTA," +
                        "ROTINA," +
                        "RETORNO," +
                        "ACOMPANHAMENTO," +
                        "PRESENCIAL," +
                        "TELECONSULTA");
    }
}
