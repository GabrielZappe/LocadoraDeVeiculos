import java.time.LocalDateTime;

public class Devolucao {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private double valorAluguel;

    public Devolucao(Aluguel aluguel, LocalDateTime dataHoraFim, double valorAluguel) {
        this.cliente = aluguel.getCliente();
        this.veiculo = aluguel.getVeiculo();
        this.dataHoraInicio = aluguel.getDataHoraInicio();
        this.dataHoraFim = dataHoraFim;
        this.valorAluguel = valorAluguel;

    }
}
