package trabalho.individual.api.ClinicaPopular.enumerated;

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
}
