package 00000000000000;

class DadosEpis{
    private int icone;
    private String nome;
    private String descricao;
    private String dicas;


    public DadosEpis(int icone, String nome, String descricao, String dicas) {
        this.icone = icone;
        this.nome = nome;
        this.descricao = descricao;
        this.dicas = dicas;

    }

    public int getIcone() {
        return icone;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDicas() {return dicas;}
}
