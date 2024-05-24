package pessoas;

public class Pessoa {

    private String nome;
	private Long cpf;
	private Long rg;
	private char sexo;
	private String dataNasc;

	
	public Pessoa(String nome, Long cpf, Long rg, char sexo, String dataNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public Long getRg() {
		return rg;
	}


	public void setRg(Long rg) {
		this.rg = rg;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public String getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	
}
