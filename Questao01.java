
/**
 *
 * @author Matheus C.F (Hashi Sen)
 * Twitter @hashi_sen01
 * Intagram @hashi_sen01
 */

import java.util.Scanner;

public class Questao01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        String[] q1 = {"9","2","1","4","6"};
        String[] textos = { "A mediana de uma lista de números é basicamente o "
                + "elemento que se encontra no meio da lista após a ordenação. "
                + "Dada uma lista de números com um número ímpar de elementos, "
                + "desenvolva um algoritmo que encontre a mediana.",
                "Quantos números deseja informar para saber a mediana entre eles? Informe um números ímpar: ",
                "O valor informado não é válido. Encerrando o algoritmo para evitar erros na operação. \n Você pode reiniciar o algoritmo quando quiser."
        };

        //IMPRIMINDO O RESULTADO MOSTRADO NO DESAFIO.
        verificandoMediana(q1);

        try (Scanner qtd = new Scanner(System.in)) {
            String verif;
            System.out.println("======================================================================");
            System.out.println(textos[0]);
            System.out.println("----------------------------------------------------------------------");
            System.out.println(textos[1]);
            verif = qtd.nextLine();

            if (campoNumerico(verif) == true) {
                //DEFININDO VARIÁVEL PARA SABER SE O VALOR INFORMADO É ÍMPAR
                int x = Integer.valueOf(verif), i = 0;
                if (x % 2 == 0) {
                    while (x % 2 == 0) {
                        //ENQUANTO O VALOR NÃO FOR ÍMPAR OU O ALGORITMO NÃO FOR CANCELADO, AS SEGUINTES LINHAS SERÃO IMPRESSA.
                        System.out.println("!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
                        System.out.println("VEJO QUE VOCÊ INFORMOU UM NÚMERO PAR, LETRA OU CARACTERE :(");
                        System.out.println("!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!*");
                        System.out.println(
                                "INFORME UM NÚMERO ÍMPAR PARA A VERIFICAÇÃO DA MEDIANA \n        OU DIGITE C PAGA CANCELAR O ALGORITMO.");
                        System.out.println("======================================================================");
                        System.out.println(textos[0]);
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println(textos[1]);
                        verif = qtd.nextLine();
                        x = Integer.valueOf(verif);
                        
                        //VERIFICANDO SE O USUÁRIO QUE ENCERRAR A EXECUÇÃO DO ALGORITMO
                        if (verif.equals("c") || verif.equals("C")) {
                            System.exit(0);
                        }
                    }

                    try (Scanner scanner = new Scanner(System.in)) {
                        //VETOR PARA CAPTURA OS VALORES INFORMADO PELO USUÁRIO
                        String[] valor = new String[x];

                        while (i < x) {
                            //DEFININDO UM VALOR PARA CADA POSIÇÃO DO VETOR
                            System.out.printf("Informe o " + (i + 1) + "º valor da sequência: ");
                            valor[i] = scanner.nextLine();
                            //VERIFICANDO SE O QUE FOI INFORMADO É UM NÚMERO
                            if (valor[i].matches("[0-9]*")) {
                                i++;
                            } else {
                                System.out.println(textos[2]);
                                System.exit(0);
                            }
                        }
                        verificandoMediana(valor);
                    }
                } else {
                    try (Scanner scanner = new Scanner(System.in)) {
                        //VETOR PARA CAPTURA OS VALORES INFORMADO PELO USUÁRIO
                        String[] valor = new String[x];

                        while (i < x) {
                            //DEFININDO UM VALOR PARA CADA POSIÇÃO DO VETOR
                            System.out.printf("Informe o " + (i + 1) + "º valor da sequência: ");
                            valor[i] = scanner.nextLine();
                            //VERIFICANDO SE O QUE FOI INFORMADO É UM NÚMERO
                            if (valor[i].matches("[0-9]*")) {
                                i++;
                            } else {
                                //ENCERRANDO ALGORITMO
                                System.out.println(textos[2]);
                                System.exit(0);
                            }
                        }

                        verificandoMediana(valor);
                    }
                }
            } else {
                //ENCERRANDO O ALGORITMO SE O TAMANHO DO VETOR NÃO FOR UM NÚMERO.
                System.out.println("Ops! Houve um problema com o valor que você informou.");
                System.exit(0);

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // ESSE MÉTODO FAZ A ORDENAÇÃO DO VETOR E DETERMINA A MEDIANA DO MESMO.
    private static void verificandoMediana(String[] valor) {
        //DEFININDO VARIÁVEIS CONTADORAS
        int y = 0, z = 0, aux = 0;
        //DEFININDO VETOR DE INTEIRO PARA A ORDENAÇÃO DOS VALORES INFORMADOS
        int[] varrer = new int[valor.length];
        //TRANSFORMANDO OS VALORES DO ARRAY DE STRING (valor) EM INTEIRO E ADICIONANDO NO VETOR DE INTEIRO varrer
        while (aux < valor.length) {
            varrer[aux] = Integer.valueOf(valor[aux]);
            aux++;
        }
        //ORDENANDO VALORES
        for (int n = 0; n < varrer.length; n++) {
            for (int k = 0; k < varrer.length; k++) {
                if (varrer[n] < varrer[k]) {
                    y = varrer[n];
                    varrer[n] = varrer[k];
                    varrer[k] = y;
                }
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //IMPRIMINDO VALORES
        while (z < varrer.length) {
            if (z == valor.length - 1) {
                System.out.println(varrer[z]);
            } else {
                System.out.printf(varrer[z] + ", ");
            }
            z++;
        }
        //CAPTURANDO A MEDIANA DO VETOR
        aux = Integer.valueOf(varrer.length / 2);
        System.out.println("A meriana é da sequência de números informados é: " + varrer[aux]);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /*
     * ESSE MÉTODO FAZ UMA VARREDURA PARA DETERMINAR SE A QUANTIDADE DE NÚMEROS
     * (TAMANHO DO VETOR) FOI INFORMADA CORRETAMENTE.
     * SE O USUÁRIO INFORMAR ALGO DIFERENTE DE NÚMERO, ESSE MÉTODO É RESPONSÁVEL POR
     * PEDIR AO USUÁRIO QUE CORRIJA O VALOR
     * INFORMADO (TAMANHO DO VETOR).
     */
    private static boolean campoNumerico(String campo) {
        //DEFININDO VARIÁVEL CONTADORA
        int i = 0;
        //DEFININDO UMA CADEIA DE CARACTERE PARA VERIFICAR SE FOI INFORMADO APENAS NÚMEROS PARA DETERMINAR O TAMANHO DO VETOR.
        char[] ch = campo.toCharArray();

        while (i < campo.length()) {
            //VERIFICANDO SE FOI INFORMADO APENAS NÚMEROS PARA O TAMANHO DO VETOR.
            if (Character.isDigit(ch[i])) {
                // IMPORTANTE!
            } else {
                // !FOR DIFERENTE DE UM DIGITO RETONAR FALSO!
                return false;
            }
            i += 1;
        }

        return true;
    }
}
