package pessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//import operacoes.Consulta;

public class Medico extends Pessoa {

	private String crm;
    private ArrayList<Medico> listMedicos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Construtor vazio
    public Medico() {
        super();
    }

    // Construtor com parâmetros
    public Medico(String nome, String cpf, String rg, char sexo, String dataNasc, String crm) {
        super(nome, cpf, rg, sexo, dataNasc);
        this.crm = crm;
    }

    // Método para cadastrar um novo médico
    
	
	     //MÉTODOS PERSONALIZADOS:
	public void cadastrarMedico(Scanner sc2) {
        try {
            // Tentativa de coletar os dados do novo médico
            System.out.println("Informe os dados do novo médico:");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("CPF: ");
            String cpf = sc.next();
            System.out.print("RG: ");
            String rg = sc.next();
            System.out.print("Sexo: ");
            char sexo = sc.next().charAt(0);
            System.out.print("Data de Nascimento: ");
            String dataNasc = sc.next();
            System.out.print("CRM: ");
            String crm = sc.next();

            // Adiciona o médico à lista de médicos
            listMedicos.add(new Medico(nome, cpf, rg, sexo, dataNasc, crm)); 

            System.out.println("Médico cadastrado!");
        } catch (InputMismatchException e) {
            // Se a entrada do usuário for inválida, exibe uma mensagem de erro
            System.out.println("Entrada inválida. Certifique-se de inserir o tipo correto de dados.");
            sc.nextLine(); // Limpa o buffer do scanner
        }
    }

    // Método para editar os dados de um médico cadastrado
    public void editarCadastroDeMedico() {
        System.out.println("Informe o nome do médico:");
        String procurarMedico = sc.next();
        boolean encontrado = false;

        for (Medico medico : listMedicos) {
            if (medico.getNome().equalsIgnoreCase(procurarMedico)) {
                encontrado = true;
                while (true) {
                    try {
                        // Tentativa de atualizar os dados do médico
                        System.out.println("Selecione a atualização:");
                        System.out.println("1. Atualizar nome");
                        System.out.println("2. Atualizar CPF");
                        System.out.println("3. Atualizar RG");
                        System.out.println("4. Atualizar sexo");
                        System.out.println("5. Atualizar Data de Nascimento");
                        System.out.println("6. Atualizar CRM");
                        System.out.println("0. Encerrar operação");

                        int selecao = sc.nextInt();

                        switch (selecao) {
                            // Casos de atualização dos dados
                            // ...
                        }
                    } catch (InputMismatchException e) {
                        // Se o usuário inserir uma opção inválida, exibe uma mensagem de erro
                        System.out.println("Opção inválida. Insira um número.");
                        sc.nextLine(); // Limpa o buffer do scanner
                    }
                }
            }
        }
        if (!encontrado) {
            // Se o médico não for encontrado, exibe uma mensagem
            System.out.println("Médico não encontrado.");
        }
    }

    // Métodos getter e setter para crm

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void excluirMedico() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Informe o nome do Médico a ser excluído:");
			String medicoExcluir = sc.next();
	
			Iterator<Medico> it = listMedicos.iterator();
			while (it.hasNext()) {
				Medico medico = it.next();
				if (medico.getNome().equals(medicoExcluir)) {
					it.remove();
					System.out.println("Médico excluído com sucesso.");
					sc.close(); // Fechar o Scanner
					return;
				}
			}
			System.out.println("Médico não encontrada.");
			sc.close(); // Fechar o Scanner
		
    }

    public void listarMedico() {
        System.out.println("Lista de Médicos:");
        for (Medico medico : listMedicos) {
            System.out.println(medico);
        }
    }
}