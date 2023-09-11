public class Cliente {
    private String id;
    private String nome;
    private boolean pessoaJuridica;

    public Cliente(String id, String nome, boolean pessoaJuridica) {
        this.id = id;
        this.nome = nome;
        this.pessoaJuridica = pessoaJuridica;
    }

    public boolean isPessoaJuridica() {
        return pessoaJuridica;
    }

    public String getId() {
        return id;
    }

}
