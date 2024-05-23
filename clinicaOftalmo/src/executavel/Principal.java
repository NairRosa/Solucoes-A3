package executavel;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//import pessoas.Pessoa;
import pessoas.Paciente;
import pessoas.Medico;
import operacoes.Consulta;

public class Principal {
    public static void main(String[] args) throws Exception {
        List<Paciente> listPacientes = new ArrayList<>();
        List<Medico> listMedicos = new ArrayList<>();
        List<Consulta> listConsultas = new ArrayList<>();
                
        Scanner sc = new Scanner(System.in);
                
        System.out.println("Digite informacoes sobre o paciente:");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        long cpf = sc.nextLong();
        sc.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("RG: ");
        long rg = sc.nextLong();
        sc.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Sexo: ");
        String sexo = sc.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNasc = sc.nextLine();




        System.out.println("Digite informacoes sobre o médico:");

        System.out.print("Nome: ");
        String nomeMedico = sc.nextLine();

        System.out.print("CPF: ");
        long cpfMedico = sc.nextLong();
        sc.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("RG: ");
        long rgMedico = sc.nextLong();
        sc.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Sexo: ");
        String sexoMedico = sc.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascMedico = sc.nextLine();

        System.out.print("CRM: ");
        String crm = sc.nextLine();
                
        listPacientes.add(new Paciente(nome, cpf, rg, sexo, dataNasc));
        listMedicos.add(new Medico(nomeMedico, cpfMedico, rgMedico, sexoMedico, dataNascMedico, crm));


    }
}