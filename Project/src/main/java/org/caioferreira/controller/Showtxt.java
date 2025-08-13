package org.caioferreira.controller;

import org.caioferreira.entities.Doctor;
import org.caioferreira.entities.Nurse;
import org.caioferreira.entities.Patient;
import org.caioferreira.entities.Person;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Showtxt {
    // Declaração do Set para armazenar as pessoas e o Scanner
    private final Set<Person> newpeople = new LinkedHashSet<>();
    private final Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int option;

        do {
            System.out.println("=========SisHop=========");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Consultar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.println("========================");
            System.out.println("Escolha uma opção: ");

            option = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha

            switch (option) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    consultarPessoa();
                    break;
                case 3:
                    editarPessoa();
                    break;
                case 4:
                    excluirPessoa();
                    break;
                case 5:
                    System.out.println("SAINDO DO PROGRAMA...");
                    break;
                default:
                    System.out.println("Insira uma opção válida");
            }
        } while (option != 5);

        sc.close(); // Fechamos o Scanner quando o programa termina
    }

    public void cadastrarPessoa() {
        System.out.println("\n=======CADASTRO=======");
        System.out.println("Qual tipo de pessoa você deseja cadastrar?");
        System.out.println("1 - Paciente");
        System.out.println("2 - Médico");
        System.out.println("3 - Enfermeiro");
        System.out.println("Opção: ");
        int tipoPessoa = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha

        Person p;

        switch (tipoPessoa) {
            case 1:
                p = new Patient();
                System.out.println("Nome do Paciente:");
                p.setName(sc.nextLine());
                System.out.println("CPF do Paciente:");
                p.setCPF(sc.nextLine());
                System.out.println("Telefone do Paciente:");
                p.setPhone(sc.nextLine());
                System.out.println("Endereço do Paciente:");
                p.setEndereco(sc.nextLine());
                System.out.println("ID do Paciente:");
                ((Patient) p).setIdPaciente(sc.nextLine());
                System.out.println("Plano de Saúde:");
                ((Patient) p).setPlanoSaude(sc.nextLine());
                System.out.println("Problema de Saúde:");
                ((Patient) p).setProblemaSaude(sc.nextLine());

                System.out.println("CPF do médico responsável (ou ENTER para pular):");
                String cpfMedico = sc.nextLine();
                if (!cpfMedico.isEmpty()) {
                    Doctor medico = encontrarMedicoPorCpf(cpfMedico);
                    if (medico != null) {
                        ((Patient) p).setMedicoResponsavel(medico);
                        System.out.println("Médico associado com sucesso!");
                    } else {
                        System.out.println("Médico não encontrado. Associação ignorada.");
                    }
                }
                break;
            case 2:
                p = new Doctor();
                System.out.println("Nome do Médico:");
                p.setName(sc.nextLine());
                System.out.println("CPF do Médico:");
                p.setCPF(sc.nextLine());
                System.out.println("Telefone do Médico:");
                p.setPhone(sc.nextLine());
                System.out.println("Endereço do Médico:");
                p.setEndereco(sc.nextLine());
                System.out.println("CRM do Médico:");
                ((Doctor) p).setCrm(sc.nextLine());
                System.out.println("Especialidade do Médico:");
                ((Doctor) p).setSpecialty(sc.nextLine());
                break;
            case 3:
                p = new Nurse();
                System.out.println("Nome do Enfermeiro(a):");
                p.setName(sc.nextLine());
                System.out.println("CPF do Enfermeiro(a):");
                p.setCPF(sc.nextLine());
                System.out.println("Telefone do Enfermeiro(a):");
                p.setPhone(sc.nextLine());
                System.out.println("Endereço do Enfermeiro(a):");
                p.setEndereco(sc.nextLine());
                System.out.println("COREN do Enfermeiro(a):");
                ((Nurse) p).setCoren(sc.nextLine());
                System.out.println("Turno de trabalho:");
                ((Nurse) p).setShift(sc.nextLine());
                break;
            default:
                System.out.println("Opção inválida. Retornando ao menu principal.");
                return;
        }

        newpeople.add(p);
        System.out.println("Cadastro realizado com sucesso!");
    }

    private Doctor encontrarMedicoPorCpf(String cpf) {
        for (Person person : newpeople) {
            if (person instanceof Doctor && person.getCPF() != null && person.getCPF().equals(cpf)) {
                return (Doctor) person;
            }
        }
        return null;
    }

    public void consultarPessoa() {
        System.out.println("\n=======CONSULTAR=======");

        if (newpeople.isEmpty()) {
            System.out.println("A lista de pessoas está vazia.");
            return;
        }

        System.out.println("Nomes de pessoas cadastradas:");
        for (Person p : newpeople) {
            System.out.println("- " + p.getName() + " (" + p.getCPF() + ")");
        }

        System.out.println("\n-----------------------");

        System.out.println("Para consultar os dados completos, digite o CPF da pessoa (ou 'sair' para voltar ao menu):");
        String cpfParaConsultar = sc.nextLine();

        if (cpfParaConsultar.equalsIgnoreCase("sair")) {
            return;
        }

        boolean encontrada = false;
        for (Person p : newpeople) {
            if (p.getCPF() != null && p.getCPF().equals(cpfParaConsultar)) {
                encontrada = true;
                System.out.println("\nDados completos da pessoa:");
                System.out.println("Nome: " + p.getName());
                System.out.println("CPF: " + p.getCPF());
                System.out.println("Telefone: " + p.getPhone());
                System.out.println("Endereço: " + p.getEndereco());

                if (p instanceof Patient) {
                    Patient paciente = (Patient) p;
                    System.out.println("ID Paciente: " + paciente.getIdPaciente());
                    System.out.println("Plano de Saúde: " + paciente.getPlanoSaude());
                    System.out.println("Problema de Saúde: " + paciente.getProblemaSaude());
                    if (paciente.getMedicoResponsavel() != null) {
                        System.out.println("Médico Responsável: " + paciente.getMedicoResponsavel().getName());
                    } else {
                        System.out.println("Médico Responsável: Não associado");
                    }
                } else if (p instanceof Doctor) {
                    Doctor medico = (Doctor) p;
                    System.out.println("CRM: " + medico.getCrm());
                    System.out.println("Especialidade: " + medico.getSpecialty());
                } else if (p instanceof Nurse) {
                    Nurse enfermeira = (Nurse) p;
                    System.out.println("COREN: " + enfermeira.getCoren());
                    System.out.println("Turno: " + enfermeira.getShift());
                }

                break;
            }
        }

        if (!encontrada) {
            System.out.println("Pessoa com o CPF " + cpfParaConsultar + " não encontrada.");
        }
    }

    public void editarPessoa() {
        System.out.println("\n=======EDITAR=======");
        System.out.println("Digite o CPF da pessoa que deseja editar: ");
        String cpfParaEditar = sc.nextLine();

        boolean encontrada = false;
        for (Person p : newpeople) {
            if (p.getCPF() != null && p.getCPF().equals(cpfParaEditar)) {
                encontrada = true;
                System.out.println("Pessoa encontrada! Insira os novos dados:");

                System.out.println("Novo Nome: ");
                p.setName(sc.nextLine());
                System.out.println("Novo Telefone: ");
                p.setPhone(sc.nextLine());
                System.out.println("Novo Endereço: ");
                p.setEndereco(sc.nextLine());

                if (p instanceof Doctor) {
                    Doctor medico = (Doctor) p;
                    System.out.println("Novo CRM: ");
                    medico.setCrm(sc.nextLine());
                    System.out.println("Nova Especialidade: ");
                    medico.setSpecialty(sc.nextLine());
                } else if (p instanceof Nurse) {
                    Nurse enfermeira = (Nurse) p;
                    System.out.println("Novo COREN: ");
                    enfermeira.setCoren(sc.nextLine());
                    System.out.println("Novo Turno: ");
                    enfermeira.setShift(sc.nextLine());
                } else if (p instanceof Patient) {
                    Patient paciente = (Patient) p;
                    System.out.println("Novo ID do Paciente: ");
                    paciente.setIdPaciente(sc.nextLine());
                    System.out.println("Novo Plano de Saúde: ");
                    paciente.setPlanoSaude(sc.nextLine());
                    System.out.println("Novo Problema de Saúde: ");
                    paciente.setProblemaSaude(sc.nextLine());

                    System.out.println("Novo CPF do médico responsável (ou ENTER para manter o atual):");
                    String novoCpfMedico = sc.nextLine();
                    if (!novoCpfMedico.isEmpty()) {
                        Doctor novoMedico = encontrarMedicoPorCpf(novoCpfMedico);
                        if (novoMedico != null) {
                            paciente.setMedicoResponsavel(novoMedico);
                            System.out.println("Novo médico associado com sucesso!");
                        } else {
                            System.out.println("Médico não encontrado. Associação não alterada.");
                        }
                    }
                }

                System.out.println("Dados atualizados com sucesso!");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Pessoa com o CPF " + cpfParaEditar + " não encontrada.");
        }
    }

    public void excluirPessoa() {
        System.out.println("\n=======EXCLUIR=======");
        System.out.println("Digite o CPF da pessoa que deseja excluir: ");
        String cpfParaExcluir = sc.nextLine();

        Person pessoaParaRemover = null;
        for (Person p : newpeople) {
            if (p.getCPF() != null && p.getCPF().equals(cpfParaExcluir)) {
                pessoaParaRemover = p;
                break;
            }
        }

        if (pessoaParaRemover != null) {
            newpeople.remove(pessoaParaRemover);
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.out.println("Pessoa com o CPF " + cpfParaExcluir + " não encontrada.");
        }
    }
}