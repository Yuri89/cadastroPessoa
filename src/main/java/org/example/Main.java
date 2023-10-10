package org.example;

import org.example.Endereco.Endereco;
import org.example.Pessoas.PessoaFisica;
import org.example.Pessoas.PessoaJuridica;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listPj = new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();
        PessoaJuridica metodoPj = new PessoaJuridica();


        Scanner leitor = new Scanner(System.in);
        String opcao;


        do {

            System.out.println("Escolha um opção: 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = leitor.next();

            switch (opcao){
                case "1":

                    String opcaoPf;

                    do {


                        System.out.println("Pessoa Fisica\n\nEscolha um opção: 1 - Cadastrar PF/ 2 - Listar PF / 0 - Voltar");
                        opcaoPf = leitor.next();

                        switch (opcaoPf){
                            case "1":

                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("\nDigite o nome:");
                                novaPf.nome = leitor.next();

                                System.out.println("\nDigite o cpf:");
                                novaPf.cpf = leitor.next();

                                System.out.println("\nDigite o rendimento:");
                                novaPf.rendimento = leitor.nextFloat();
                                System.out.println(novaPf.rendimento);


                                System.out.println("\nDigite Data de nascimento: (dd/mm/aaaa)");

                                novaPf.dateNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dateNasc, LocalDate.now());

                                if (idade.getYears() >= 18){
                                    System.out.println("maior de idade");
                                }else {
                                    System.out.println("menor de idade, idade Invalida!");
                                    break;
                                }




                                System.out.println("\nDigite o logradouro:");
                                novoEndPf.logradouro = leitor.next();

                                System.out.println("\nDigite o numero:");
                                novaPf.rendimento = leitor.nextInt();

                                System.out.println("\nEste endereço é comercial: S/N");
                                String endCom = leitor.next();



                                    if (endCom.equals("S") || endCom.equals("s")) {
                                        novoEndPf.endComercial = true;

                                    } else if (endCom.equals("N") || endCom.equals("n")) {
                                        novoEndPf.endComercial = false;
                                    }
                                    else {
                                        System.out.println("\nIncorreto");
                                        break;
                                    }


                                novaPf.endereco = novoEndPf;

                                listPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!!");


                                break;

                            case "2":

                                if (listPf.size() > 0){

                                    for (PessoaFisica cadaPf : listPf){
                                        System.out.println(
                                                "\nNome " + cadaPf.nome +
                                                "\nCPF " + cadaPf.nome +
                                                "\nData de Nascimento: " +
                                                cadaPf.dateNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
                                                "\nImposto a ser pago: " + metodoPf.CalcularImposto(cadaPf.rendimento) +
                                                "\nEndereço: " + cadaPf.endereco.logradouro + "-" + cadaPf.endereco.numero +
                                                "\n"+
                                                "Aperte Enter para continuar"

                                        );
                                        leitor.next();
                                        break;
                                    }


                                } else {
                                    System.out.println("\n lista está vazia parceiro, pode dando meia volta!");
                                }

                                break;

                            case "0":

                                break;

                            default:

                                break;
                        }


                    } while ( !opcaoPf.equals("0") );

                    break;
                case "2":

                    String opcaoPj;

                    do {


                        System.out.println("Pessoa Juridica\n\nEscolha um opção: 1 - Cadastrar Pessoa Juridica/ 2 - Listar Pessoa Juridica/ 0 - Voltar");
                        opcaoPj = leitor.next();

                        switch (opcaoPj){
                            case "1":

                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("\nDigite o nome:");
                                novaPj.nome = leitor.next();

                                System.out.println("\nDigite o cnpj:");
                                novaPj.cnpj = leitor.next();

                                System.out.println("\nDigite o rendimento:");
                                novaPj.rendimento = leitor.nextFloat();


                                System.out.println("\nDigite Data de Registro: (dd/mm/aaaa)");
                                novaPj.dataRegis = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


                                System.out.println("\nDigite o logradouro:");
                                novoEndPj.logradouro = leitor.next();

                                System.out.println("\nDigite o numero:");
                                novaPj.rendimento = leitor.nextInt();

                                System.out.println("\nEste endereço é comercial: S/N");
                                String endCom = leitor.next();



                                if (endCom.equals("S") || endCom.equals("s")) {
                                    novoEndPj.endComercial = true;

                                }
                                else if(endCom.equals("N") || endCom.equals("n")) {
                                    novoEndPj.endComercial = false;
                                }else {
                                    System.out.println("\nIncorreto");
                                    break;
                                }



                                novaPj.endereco = novoEndPj;

                                listPj.add(novaPj);

                                System.out.println("Cadastro realizado com sucesso!!");


                                break;

                            case "2":

                                if (listPj.size() > 0){

                                    for (PessoaJuridica cadaPj : listPj){
                                        System.out.println(
                                                "\nNome " + cadaPj.nome +
                                                        "\nCPF " + cadaPj.nome +
                                                        "\nData de Registro: " +
                                                        cadaPj.dataRegis.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
                                                        "\nImposto a ser pago: " + metodoPj.CalcularImposto(cadaPj.rendimento) +
                                                        "\nEndereço: " + cadaPj.endereco.logradouro + "-" + cadaPj.endereco.numero +
                                                        "\n"+
                                                        "Aperte qualquer coisa para continuar"


                                        );
                                        leitor.next();
                                        break;
                                    }


                                } else {
                                    System.out.println("\n lista está vazia parceiro, pode dando meia volta!");
                                }

                                break;

                            case "0":

                                break;

                            default:

                                break;
                        }


                    } while ( !opcaoPj.equals("0") );

                    break;
                case "0":
                    System.out.println("0 selecionado");
                    break;

                default:
                    System.out.println("default selecionado");
                    break;
            }

        }while( !opcao.equals("0"));
    }
}

