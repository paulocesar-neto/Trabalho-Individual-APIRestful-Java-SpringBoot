package trabalho.individual.api.ClinicaPopular.enumerated;

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

}
