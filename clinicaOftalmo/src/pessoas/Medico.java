package pessoas;
import java.util.ArrayList;


public final class Medico extends Pessoa {
	private String crm;

	//Array
    ArrayList<Medico> listMedicos;
    
    //Construtor vazio
    //public Medico(){
    
    //}

    //Construtor com Paramêtros

	public Medico(String nome, Long cpf, Long rg, char sexo, String dataNasc, String crm) {
		super(nome, cpf, rg, sexo, dataNasc);
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}


}