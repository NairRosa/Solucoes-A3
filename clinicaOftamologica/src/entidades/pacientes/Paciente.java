package entidades.pacientes;

public class Paciente {
    
    public class Funcionario {
        private String nome;
        private Integer cpf;
        private Boolean rg;
        private String ocupacao;
        private String dataDeNasciemnto;

        
        public Funcionario(String nome, Integer cpf, Boolean rg, String ocupacao, String dataDeNasciemnto) {
            this.nome = nome;
            this.cpf = cpf;
            this.rg = rg;
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


        public Boolean getRg() {
            return rg;
        }


        public void setRg(Boolean rg) {
            this.rg = rg;
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
    
        @Override
        public String toString() {
            return "Paciente{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", ocupacao=" + ocupacao + ", dataDeNasciemnto=" + dataDeNasciemnto + '}';
        }

    }    
    
}
