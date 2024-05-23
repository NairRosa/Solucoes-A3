package operacoes;

public class Consulta {
    private String pacienteNome; // importar nome do paciente (seria feito com um método?)

	private String medicoNome; // importar nome do medico (seria feito com um método?)

	private String data;
	private String horario;
	private Boolean tipo; // se Consulta ou Exame (atributo necessario para armazenar os dados na tabela correta)

	public Consulta(String pacienteNome, String medicoNome, String data, String horario, Boolean tipo) {
		this.pacienteNome = pacienteNome;
		this.medicoNome = medicoNome;
		this.data = data;
		this.horario = horario;
		this.tipo = tipo;
	}

	public String getPacienteNome() {
		return pacienteNome;
	}

	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}

	public String getMedicoNome() {
		return medicoNome;
	}

	public void setMedicoNome(String medicoNome) {
		this.medicoNome = medicoNome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	
	
}
