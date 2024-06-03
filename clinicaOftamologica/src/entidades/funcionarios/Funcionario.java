package entidades.funcionarios;

public class Funcionario {
    private String nome;
    private Integer cpf;
    private Boolean genero;
    private String ocupacao;
    private String dataDeNasciemnto;



    public Funcionario(String nome, Integer cpf, Boolean genero, String ocupacao, String dataDeNasciemnto) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.ocupacao = ocupacao;
        this.dataDeNasciemnto = dataDeNasciemnto;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public Integer getCpf() {
        return cpf;
    }



    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }



    public Boolean getGenero() {
        return genero;
    }



    public void setGenero(Boolean genero) {
        this.genero = genero;
    }



    public String getOcupacao() {
        return ocupacao;
    }



    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }



    public String getDataDeNasciemnto() {
        return dataDeNasciemnto;
    }



    public void setDataDeNasciemnto(String dataDeNasciemnto) {
        this.dataDeNasciemnto = dataDeNasciemnto;
    }

    public void addFuncionario() {
        
    }

    public void editarFuncionário () {

    }


}
