package pessoas;

public final class Paciente extends Pessoa{

	private Long telefone; //(atributo necessario para enviar notificacoes via whatsapp)

	public Paciente(String nome, Long cpf, Long rg, Character sexo, String dataNasc, Long telefone) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.telefone = telefone;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	
}
