package trabalho.individual.api.ClinicaPopular.enumerated;

import trabalho.individual.api.ClinicaPopular.exception.EnumValidationException;

public enum TipoExames {

    COLETA(1,"Exame de Sangue"),
    RAIO_X(2,"Raio X"),
    TOMOGRAFIA(3,"Tomografia"),
    ELETROCARDIOGRAMA(4,"Eletrocardiograma"),
    RESSONANCIA(5,"Ressonancia"),
    ULTRASSONOGRAFIA(6,"Ultrassonografia");

    private Integer opcao;
    private String valor;


    private TipoExames(Integer opcao, String valor) {
        this.opcao = opcao;
        this.valor = valor;
    }

    public static TipoExames verificaTipoExame(Integer value) throws EnumValidationException {
        for (TipoExames tipoExame : values()) {
            if(value.equals(tipoExame.getOpcao())) {
                return tipoExame;
            }
        }
        throw new EnumValidationException(
                "Tipo de examo inválido. exames válidos:" +
                        "1-Exame de Sangue" +
                        "2-Raio X" +
                        "3-Tomografia" +
                        "4-Eletrocardiograma" +
                        "5-Ultrassonografia");
    }

    public Integer getOpcao() {
        return opcao;
    }

    public void setOpcao(Integer opcao) {
        this.opcao = opcao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
