package trabalho.individual.api.ClinicaPopular.enumerated;

import trabalho.individual.api.ClinicaPopular.exception.EnumValidationException;

public enum TipoEspecialidade {

    CLINICO_GERAL("Clinico geral"),
    PEDIATRA("Pediatra"),
    ORTOPEDISTA("Ortopedia"),
    CARDIOLOGISTA("Cardiologista"),
    DERMATOLOGISTA("Dermatologista"),
    OFTALMOLOGISTA("Oftalmologista");

    private String valor;

    TipoEspecialidade(String valor) {
        this.valor = valor;
    }

    public static TipoEspecialidade verifica(Integer value) throws EnumValidationException {
        for (TipoEspecialidade tipo:values()){
            if(value.equals(tipo.valor)){
                return tipo;
            }
        }
        throw new EnumValidationException(
                "Especialidade inválida. especialidades válidas:" +
                        "Clinico Geral," +
                        "Pediatra," +
                        "Ortopedia," +
                        "Cardiologista," +
                        "Dermatologista," +
                        "Oftalmologista");
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
