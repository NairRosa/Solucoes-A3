package pessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Medico extends Pessoa {

	private String crm;
	private String subspec;
	
    private ArrayList<Medico> listMedicos = new ArrayList<>();
    
    private Scanner sc = new Scanner(System.in);

    // Construtor vazio
    public Medico() {
        super();
    }

    // Construtor completo
    public Medico(String nome, String cpf, String rg, char sexo, String dataNasc, String crm, String subspec) {
        super(nome, cpf, rg, sexo, dataNasc);
        this.crm = crm;
        this.subspec = subspec;
    }
    
    //Objetos pre-cadastrados. 	
    public void medicosPreCadastrados(){  
	listMedicos.add(new Medico("Medico Joao", "11111111111", "1111111111", 'M', "03/01/2000", "999999999", "catarata"));
	listMedicos.add(new Medico("Medica Maria", "22222222222", "2222222222", 'F', "28/12/1992", "999999999", "glaucoma"));
    }
    
	// Método de cadastrar médico
    public void cadastrarMedico(Scanner sc) {
        try {
            System.out.println("Informe os dados do novo médico:");
            sc.nextLine();
            System.out.print("NOME: ");
            String nome = sc.nextLine();
			if(nome.isEmpty()) {
				throw new IllegalArgumentException("O nome não pode estar vazio.");
			}
			this.nome = nome;

			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			if(!validarCPF(cpf)) {
				throw new IllegalArgumentException("CPF inválido.");
			}
            this.cpf = cpf;

            /*System.out.print("RG: ");
            String rg = sc.nextLine();

			System.out.println("RG inserido antes da validação: " + rg); // Imprime o RG antes da validação
			if(!validarRG(rg)) {
				throw new IllegalArgumentException("RG inválido.");
			}
            this.rg = rg;
			System.out.println("RG inserido depois da validação: " + rg); // Imprime o RG depois da validação*/

            System.out.print("SEXO: ");
            Character sexo = sc.nextLine().charAt(0);
			if(sexo != 'M' && sexo != 'F') {
				throw new IllegalArgumentException("Sexo inválido. Insira M para masculino ou F para feminino.");
			}
            this.sexo = sexo;

            System.out.print("DATA DE NASCIMENTO: ");
            String dataNasc = sc.nextLine();
			if(!validarDataNascimento(dataNasc)) {
				throw new IllegalArgumentException("Data de nascimento inválida. Insira no formato dd/mm/aaaa.");
			}
            this.dataNasc = dataNasc;

            System.out.print("CRM: ");
            String crm = sc.nextLine();
			if(crm.isEmpty()) {
				throw new IllegalArgumentException("O CRM não pode estar vazio.");
			}

            System.out.print("SUBESPECIALIDADE: ");
            String subspec = sc.nextLine();

            listMedicos.add(new Medico(nome, cpf, rg, sexo, dataNasc, crm, subspec)); 

            System.out.println("Médico cadastrado!");
            System.out.println();
            
			}  catch (InputMismatchException e) {
			System.out.println("Entrada inválida. Certifique-se de inserir o tipo correto de dados.");
			sc.nextLine();
		} catch (NumberFormatException e) {
			System.out.println("Erro de formato numérico ao tentar converter dados.");
			sc.nextLine();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
    }

	public boolean validarCPF(String cpf) {
		// Remove caracteres especiais do CPF
		cpf = cpf.replaceAll("[^0-9]", "");
	
		// Verifica se o CPF possui 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}
	
		// Verifica se todos os dígitos são iguais (caso contrário, o CPF é inválido)
		boolean digitosIguais = true;
		for (int i = 1; i < 11; i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				digitosIguais = false;
				break;
			}
		}
		if (digitosIguais) {
			return false;
		}
	
		// Calcula e verifica o primeiro dígito verificador
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += (cpf.charAt(i) - '0') * (10 - i);
		}
		int resto = 11 - (soma % 11);
		int digitoVerificador1 = (resto == 10 || resto == 11) ? 0 : resto;
		if (digitoVerificador1 != cpf.charAt(9) - '0') {
			return false;
		}
	
		// Calcula e verifica o segundo dígito verificador
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += (cpf.charAt(i) - '0') * (11 - i);
		}
		resto = 11 - (soma % 11);
		int digitoVerificador2 = (resto == 10 || resto == 11) ? 0 : resto;
		if (digitoVerificador2 != cpf.charAt(10) - '0') {
			return false;
		}
	
		return true;
	}


	public boolean validarRG(String rg) {
		// Remover caracteres especiais do RG
		rg = rg.replaceAll("[^0-9]", "");
		
		// Verificar se o RG possui entre 9 e 10 dígitos
		if (rg.length() != 9 && rg.length() != 10) {
			return false;
		}
		
		// Extrair os dígitos e o dígito verificador
		String digitos = rg.substring(0, rg.length() - 1);
		char digitoVerificador = rg.charAt(rg.length() - 1);
		
		// Calcular o dígito verificador esperado
		int soma = 0;
		int peso = 2; // O peso começa em 2 para RGs com 9 dígitos
		if (rg.length() == 10) {
			peso = 3; // Se o RG tiver 10 dígitos, o peso começa em 3
		}
		for (int i = digitos.length() - 1; i >= 0; i--) {
			soma += (digitos.charAt(i) - '0') * peso;
			peso++;
		}
		int resto = soma % 11;
		char esperado;
		if (resto == 10) {
			esperado = 'X';
		} else {
			esperado = (char) (resto + '0');
		}
		
		// Verificar se o dígito verificador é válido
		return esperado == digitoVerificador;
	}


	public boolean validarDataNascimento(String dataNasc) {
		// Definir o formato esperado da data
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		formatoData.setLenient(false); // Desativar modo tolerante

		try {
			// Tentar fazer o parsing da data
			@SuppressWarnings("unused")
			Date data = formatoData.parse(dataNasc);
			
			// Verificar se a data é válida (evita datas como 30 de fevereiro, etc.)
			return true;
		} catch (ParseException e) {
			// A data não está no formato esperado
			return false;
		}
	}


	//Método de editar cadastro de médicos
    public void editarMedico() {
			System.out.print("Informe o nome do médico:");
			sc.nextLine();
			String procurarMedico = sc.nextLine();
			
			boolean encontrado = false;
	
			for (int i = 0; i < listMedicos.size(); i++) {
				if (listMedicos.get(i).getNome().equalsIgnoreCase(procurarMedico)) {
					encontrado = true;
					while (true) {
						try {
							System.out.println();
							System.out.println("*** ATUALIZAR MEDICO EXISTENTE ***");
					 		System.out.println();
							System.out.println("[1] Atualizar NOME.");
							System.out.println("[2] Atualizar CPF.");
							System.out.println("[3] Atualizar RG.");
							System.out.println("[4] Atualizar SEXO.");
							System.out.println("[5] Atualizar DATA NASCIMENTO.");
							System.out.println("[6] Atualizar CRM.");
							System.out.println("[7] Atualizar ESPECIALIZACAO.");
							System.out.println();	
							System.out.println("[0] Voltar para o MENU PRINCIPAL.");
							System.out.println();							
							System.out.print("Informe a opcao desejada:");

							
							int selecao = sc.nextInt();
							System.out.println();	
							
							switch (selecao) {
								case 1:
								System.out.print("Informe o novo NOME:");
								sc.nextLine();
								String nome = sc.nextLine();
								listMedicos.get(i).setNome(nome);
								break;
							case 2:
								System.out.print("Informe o novo CPF:");
								String cpf = sc.nextLine();
								listMedicos.get(i).setCpf(cpf);
								break;
							case 3:
								System.out.print("Informe o novo RG:");
								String rg = sc.nextLine();
								listMedicos.get(i).setRg(rg);
								break;
							case 4:
								System.out.print("Informe o novo SEXO:");
								Character sexo = sc.next().charAt(0);
								listMedicos.get(i).setSexo(sexo);
								break;
							case 5:
								System.out.print("Informe a nova DATA DE NASCIMENTO:");
								String dataNasc = sc.nextLine();
								listMedicos.get(i).setDataNasc(dataNasc);
								break;
							case 6:
								System.out.print("Informe o novo CRM:");
								String crm = sc.nextLine();
								listMedicos.get(i).setCrm(crm);
								break;
							case 7:
								System.out.print("Informe a nova SUBESPECIALIDADE:");
								String subspec = sc.next();
								listMedicos.get(i).setCrm(subspec);
								break;
							case 0:
								System.out.println("Operacao encerrada.");
								return;
	  
							default:
                                System.out.println("Opcao invalida, tente novamente.");
								break;
							}
						} catch (InputMismatchException e) {
							System.out.println("Entrada invalida. Por favor, insira um número.");
							sc.nextLine();
						}
					}
				}
				
				if (!encontrado) {
					continue;
				}

				System.out.println("Medico nao encontrado.");
				System.out.println();
			}
    }

    public void excluirMedico() {
        System.out.print("Informe o NOME do Medico a ser excluido:");
		sc.nextLine();
        String medicoExcluir = sc.nextLine();

        Iterator<Medico> it = listMedicos.iterator();
        while (it.hasNext()) {
            Medico medico = it.next();
            if (medico.getNome().equals(medicoExcluir)) {
                it.remove();
                System.out.println("Medico excluido com sucesso.");
                System.out.println();
                return;
            }
        }
        System.out.println("Medico nao encontrado.");
    }

 // Método para buscar especificamente ou listar relação de pacientes
 	public void relacaoMedicos() {
 		int opcao;
 	
 		System.out.println("*** LISTAR MEDICO ***");
 		System.out.println();
 		System.out.println("[1] Buscar Médico por NOME.");
 		System.out.println("[2] Imprimir relação de Medicos cadastrados.");
 		System.out.println();
 		System.out.print("Informe a opcao desejada: ");
 		opcao =sc.nextInt();
 		System.out.println();
 		
 		if (listMedicos.isEmpty()) {
 			System.out.println("Nao ha Medicos cadastrados!");
 			System.out.println();
 			return;
 		} else {
 			switch(opcao) {
 				
 			case 1:
 				System.out.print("Insira o NOME do Medico: ");
				sc.nextLine();
 				String buscar = sc.nextLine();
 				boolean encontrado = false;
 				
 				for (Medico medico: listMedicos){
 					if (medico.getNome().equalsIgnoreCase(buscar)) {
 						encontrado = true;
 						System.out.println("Medico encontrado:");
 						System.out.println(medico);
 					}
 				}

 				if (!encontrado) {
 					System.out.println("Medico nao encontrado.");				
 				}
 				break; 
 			
 			case 2: 
				System.out.println("---------- RELACAO DE MEDICOS ----------");
 			
			    for(Medico m: listMedicos) {
			    	System.out.println(m);
			    }
			    
				System.out.println("------------------------------------------------------");
				System.out.println();
 				break;

 			default: //caso escolham uma opcao inexistente
 				System.out.println("Opcao invalida, tente novamente.");
 				break;
 			}
 		}    
 	}
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspec() {
        return subspec;
    }

    public void setEspec(String subspec) {
        this.subspec = subspec;
    }

    @Override
    public String toString() {
        return "[" + nome + ", " + cpf + ", " + crm + "]";
    }
}