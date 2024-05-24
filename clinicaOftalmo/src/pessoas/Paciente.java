package pessoas;
import java.util.ArrayList;
//import java.util.List;

public final class Paciente extends Pessoa{

	private Long telefone; // Atributo necessário para enviar notificações via WhatsApp
    
	private ArrayList<Paciente> listPacientes;

    public Paciente(String nome, Long cpf, Long rg, char sexo, String dataNasc, String celular) {
        super(nome, cpf, rg, sexo, dataNasc);
        //this.telefone = telefone;
        this.listPacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente novoPaciente) {
        listPacientes.add(novoPaciente);
    }

    public void listarPacientes() {
        for (Paciente paciente : listPacientes) {
            System.out.println(paciente.toString());
        }
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
}