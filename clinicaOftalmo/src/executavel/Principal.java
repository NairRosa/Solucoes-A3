package executavel;

import pessoas.Paciente;
import pessoas.Medico;
import operacoes.Consulta;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        List<Paciente> listPacientes = new ArrayList<>();
        List<Medico> listMedicos = new ArrayList<>();
        List<Consulta> listConsultas = new ArrayList<>();

        while (true) {
            System.out.println("*** MENU ***");
            System.out.println("[1] Cadastrar novo paciente.");
            System.out.println("[2] Cadastrar novo médico.");
            System.out.println("[3] Agendar nova consulta.");
            System.out.println("[4] Ver relação de pacientes.");
            System.out.println("[5] Ver relação de médicos.");
            System.out.println("[6] Ver relação de consultas.");
            System.out.println("[7] Ver relação de pacientes.");
            System.out.println("[0] Encerrar programa.");
            System.out.print("Digite a opção desejada:");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    Paciente paciente = cadastrarNovoPaciente(sc);
                    listPacientes.add(paciente);
                    break;

                case 2:
                    Medico medico = cadastrarNovoMedico(sc);
                    listMedicos.add(medico);
                    break;

                case 3:
                    Consulta consulta = agendarNovaConsulta(sc, listPacientes, listMedicos);
                    listConsultas.add(consulta);
                    break;

                case 4:
                    if (!listPacientes.isEmpty()) {
                        System.out.println("Lista de Pacientes:");
                        for (Paciente p : listPacientes) {
                            System.out.println(p);
                        }
                    } else {
                        System.out.println("Não há pacientes cadastrados.");
                    }
                    break;

                case 5:
                    if (!listMedicos.isEmpty()) {
                        System.out.println("Lista de Médicos:");
                        for (Medico m : listMedicos) {
                            System.out.println(m);
                        }
                    } else {
                        System.out.println("Não há médicos cadastrados.");
                    }
                    break;

                case 6:
                    if (!listConsultas.isEmpty()) {
                        System.out.println("Lista de Consultas:");
                        for (Consulta c : listConsultas) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Não há consultas agendadas.");
                    }
                    break;
                case 7: 
                    System.out.println("Lista de Pacientes:");
                    for (Paciente p : listPacientes) {
                        System.out.println(p);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    private static Paciente cadastrarNovoPaciente(Scanner sc) {
        System.out.println("Digite as seguintes informações do novo paciente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.print("RG: ");
        Long rg = sc.nextLong();
        sc.nextLine();
        System.out.print("Sexo: ");
        char sexo = sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNasc = sc.nextLine();
        System.out.print("Telefone celular: ");
        String celular = sc.nextLine();
        return new Paciente(nome, cpf, rg, sexo, dataNasc, celular);
    }

    private static Medico cadastrarNovoMedico(Scanner sc) {
        System.out.println("Digite as seguintes informações do novo médico:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        Long cpf = sc.nextLong();
        sc.nextLine();
        System.out.print("RG: ");
        Long rg = sc.nextLong();
        sc.nextLine();
        System.out.print("Sexo: ");
        char sexo = sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNasc = sc.nextLine();
        System.out.print("CRM: ");
        String crm = sc.nextLine();
        return new Medico(nome, cpf, rg, sexo, dataNasc, crm);
    }

    private static Consulta agendarNovaConsulta(Scanner sc, List<Paciente> listPacientes, List<Medico> listMedicos) {
        System.out.println("Digite as seguintes informações da nova consulta:");
        System.out.print("Nome do Paciente: ");
        String pacienteNome = sc.nextLine();
        System.out.print("Nome do Médico: ");
        String medicoNome = sc.nextLine();
        System.out.print("Data: ");
        String data = sc.nextLine();
        System.out.print("Horário: ");
        String horario = sc.nextLine();
        Paciente paciente = findPacienteByName(listPacientes, pacienteNome);
        Medico medico = findMedicoByName(listMedicos, medicoNome);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        }
        if (medico == null) {
            System.out.println("Médico não encontrado.");
        }
        return new Consulta(paciente, medico, data, horario);
    }

    private static Paciente findPacienteByName(List<Paciente> listPacientes, String name) {
        for (Paciente p : listPacientes) {
            if (p.getNome().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    private static Medico findMedicoByName(List<Medico> listMedicos, String name) {
        for (Medico m : listMedicos) {
            if (m.getNome().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
}