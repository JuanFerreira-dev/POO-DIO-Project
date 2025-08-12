package org.caioferreira.controller;
import org.caioferreira.entities.Person;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class Showtxt {
    Person p = new Person();
    Scanner sc = new Scanner(System.in);

    public void showMenu(){
        int option;

        do {
            System.out.println("=========SisHop=========");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Consultar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.println("========================");
            System.out.println("Escolha um opção: ");

            option = sc.nextInt();
            sc.nextLine();

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
        }while(option != 5);


    }

    private final Set<Person> newpeople =  new LinkedHashSet<>();
    public void cadastrarPessoa(){
        Person p = new Person();
        System.out.println("\n=======CADASTRO=======");
        System.out.println("Nome do Pessoa:");
        p.setName(sc.nextLine());
        newpeople.add(p);
        System.out.println("CPF: ");
        p.setCPF(sc.nextLine());
        System.out.println("Telefone: ");
        p.setPhone(sc.nextLine());
        System.out.println("Endereço: ");
        p.setEndereco(sc.nextLine());

    }
    public void consultarPessoa(){
        System.out.println("\n=======CONSULTAR=======");

        if(newpeople.isEmpty()){
            System.out.println("Lista está vazia");
        }
        for(Person p : newpeople){
            System.out.println(p.getName());
        }
    }

    public void editarPessoa(){

    }

    public void excluirPessoa(){

    }

}
