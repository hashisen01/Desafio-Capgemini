/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author mathe
 */

import java.util.Scanner;

public class Questao02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        String[] q2 = {"1","5","3","4","2"};
        String dif = "2";
        String[] textos = {
                "Dado um vetor de inteiros n e um inteiro qualquer x. "
                + "Construa um algoritmo que determine o número de elementos pares do vetor que tem uma diferença igual ao valor de x.", 
                "Qual o tamanho do vetor?",
                "O valor informado não é válido. Encerrando o algoritmo para evitar erros na operação. \n Você pode reiniciar o algoritmo quando quiser."
        };
        
        //IMPRIMINDO O RESULTADO MOSTRADO NO DESAFIO.
        verificandoParesDeDiferencaIguais(q2, dif);

        try (Scanner qtd = new Scanner(System.in)) {
            String verif;
            System.out.println("======================================================================");
            System.out.println(textos[0]);
            System.out.println("----------------------------------------------------------------------");
            System.out.println(textos[1]);
            verif = qtd.nextLine();

            if (campoNumerico(verif) == true) {
                //DEFINIÇÃO DE VARIÁVEIS
                int x = Integer.valueOf(verif), i = 0;
                Scanner scanner = new Scanner(System.in);
                String[] valor = new String[x];
                String diferenca = null;

                while (i < x) {
                    //DEFININDO UM VALOR PARA CADA POSIÇÃO DO VETOR
                    System.out.printf("Informe o " + (i + 1) + "º valor da sequência: ");
                    valor[i] = qtd.nextLine();
                    //VERIFICANDO SE O QUE FOI INFORMADO É UM NÚMERO
                    if (valor[i].matches("[0-9]*")) {
                        i++;
                    } else {
                        System.out.println(textos[2]);
                        System.exit(0);
                    }
                }

                System.out.printf("Determine a diferença entre os pares que voçê deseja buscar: ");
                diferenca = scanner.nextLine();

                //CHAMANDO MÉTODO PARA VIRIFICAR OS PARES COM DIFERENÇA IGUAL AO QUE O USUÁRIO INFORMOU
                verificandoParesDeDiferencaIguais(valor, diferenca);

            } else {
                //ENCERRANDO ALGORITMO
                System.out.println("Ops! Houve um problema com o valor que você informou.");
                System.exit(0);

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void verificandoParesDeDiferencaIguais(String[] valor, String diferenca) {
        
        //DEFINIÇÃO DE VARIÁVEIS
        int y = 0, z = 0, aux = 0;
        int[] varrer = new int[valor.length];
        String[] pares = new String[varrer.length];
        int difer = 0;
        int cont = 0;

        //VERIFICANDO SE FOI INFORMADO APENAS NÚMEROS INTEIRO EM CADA POSIÇÃO DO VETOR
        while (aux < valor.length) {
            if (valor[y].matches("[0-9]*")) {
                varrer[aux] = Integer.valueOf(valor[aux]);
                aux++;
            } else {
                System.out.println("Ops! Houve um problema com o valor que você informou.");
                System.exit(0);
            }
        }
        
        //VERIFICANDO SE FOI INFORMADO UM NÚMERO NA diferenca
        if (campoNumerico(diferenca) == true){
            difer = Integer.valueOf(diferenca);
            //FAZENDO VARREDURA NO VETORE PARA BUSCAR PARES COM DIFERENÇA IGUAL A QUE FOI INFORMADA PELO USUÁRIO
            while (varrer.length > y) {
                for (int x = 0; x < varrer.length; x++) {
                    if (varrer[y] - varrer[x] == difer){
                        pares[y] = "["+varrer[y]+", "+varrer[x]+"] ";
                        cont += 1;
                    }
                }
                y++;
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Existem "+cont+" pares de inteiros no vetor com uma diferença de "+difer+":");
        y = 0;
        //IMPRIMINDO OS PARES ENCONTRADOS (SE HOUVER)
        while (varrer.length > y) {
            if(pares[y] != null){
                System.out.println(pares[y]);
            }
            y++;
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

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