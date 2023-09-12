import java.time.LocalDateTime;

public class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private double valorAluguel;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, double valorAluguel) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.valorAluguel = valorAluguel;
    }
}
