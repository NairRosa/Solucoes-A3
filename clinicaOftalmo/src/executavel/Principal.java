package executavel;

import pessoas.Paciente;
import pessoas.Pessoa;
import pessoas.Medico;
import operacoes.Consulta;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//import pessoas.Pessoa;

public class Principal {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        List<Paciente> listPacientes = new ArrayList<>();
        List<Medico> listMedicos = new ArrayList<>();
        //List<Consulta> listConsultas = new ArrayList<>();
        Boolean continuar = true;


        while (continuar) {
            System.out.println("Qual entidade deseja adicionar? (Paciente / Médico / Sair)");
            String entidade = sc.nextLine();
            
            switch (entidade.toLowerCase()) {
                case "paciente":
                    adicionarPaciente(sc, listPacientes);
                    break;
                case "médico":
                    adicionarMedico(sc, listMedicos);
                    break;
                case "sair":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
        // inserir a manipulação das listas
        
        sc.close();
    }

    //Pessoa paciente1 = new Pessoa(null, null, null, 0, null);
    //paciente1.setNome("Joaquim França");
    //paciente1.setDocumento("12197942199");

    private static void adicionarPaciente(Scanner sc, List<Paciente> listPacientes) {
        try {
            System.out.println("Digite informações sobre o paciente:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("CPF: ");
            long cpf = Long.parseLong(sc.nextLine());
            System.out.print("RG: ");
            long rg = Long.parseLong(sc.nextLine());
            System.out.print("Sexo: ");
            String sexo = sc.nextLine();
            System.out.print("Data de nascimento: ");
            String dataNasc = sc.nextLine();

            listPacientes.add(new Paciente(nome, cpf, rg, sexo, dataNasc));

            System.out.println("Paciente adicionado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter entrada para número. Certifique-se de inserir apenas números para CPF, RG, etc.");
        }
    }

    private static void adicionarMedico(Scanner sc, List<Medico> listMedicos) {
        try {
            System.out.println("Digite informações sobre o médico:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("CPF: ");
            long cpf = Long.parseLong(sc.nextLine());
            System.out.print("RG: ");
            long rg = Long.parseLong(sc.nextLine());
            System.out.print("Sexo: ");
            String sexo = sc.nextLine();
            System.out.print("Data de nascimento: ");
            String dataNasc = sc.nextLine();
            System.out.print("CRM: ");
            String crm = sc.nextLine();

            listMedicos.add(new Medico(nome, cpf, rg, sexo, dataNasc, crm));

            System.out.println("Médico adicionado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter entrada para número. Certifique-se de inserir apenas números para CPF, RG, etc.");
        }
    }
}