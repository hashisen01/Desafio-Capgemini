
/**
 *
 * @author Matheus C.F (Hashi Sen)
 * Twitter @hashi_sen01
 * Intagram @hashi_sen01
 * 
 */

import java.util.Scanner;

public class Questao03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //VARIÁVEL PARA CAPTURAR DADOS DIGITADOS
        Scanner scanner = new Scanner(System.in);
        String entrada = "";

        System.out.println("==========================================================");
        System.out.println("ENTRADA PROPOSTA PELA QUESTÃO DO DESAFIO: tenha um bom dia");
        System.out.println();
        //EXECUÇÃO DA ENTRADA PROPOSTA NO DESAFIO
        EncriptarTexto(entrada);
        System.out.println("\n");
        System.out.println("==========================================================");

        System.out.println("Seja bem vindo ao sistema de criptografia de textos.");
        System.out.println("==========================================================");
        System.out.println("Informe o(a) texto/frase a ser encriptado(a):");
        entrada = scanner.nextLine();
        //EXECUÇÃO DA ENTRADA INFORMADA PELO USUÁRIO OU TESTR
        EncriptarTexto(entrada);
    }
    private static void EncriptarTexto(String entrada) {

        if (entrada.isEmpty()) {
            entrada = "tenha um bom dia";
        }

		//REMOÇÃO DE ESPAÇOS
		String entradaSemEspaco = entrada.replaceAll("\\s+", "");
		//VETOR PARA GUARDAR CADA CARACTER EM UMA POSIÇÃO.
		String[] vetor = entradaSemEspaco.split("");

		int tamanho = (int) Math.round(Math.sqrt(entradaSemEspaco.length()));

        //SE tamanho FOR MENOR OU IGUAL A 3 O ALGORITMO IRA EXCLUIR ALGUNS CARACTERES
        if (tamanho < 4) {
            tamanho += 1;
        }

        //MATRIZ PARA GUARDAR DADOS EMBARALHADOS/ENCRIPTADO
		String[][] matriz = new String[tamanho][tamanho];

		int cont = 0;
        System.out.println("ENCRIPTADO:");

        //ADICIONANDO PALAVRAS EMCRIPTADA
		for (int i = 0; i < tamanho; i++) {

			int j = 0;

			while (j < tamanho && cont < vetor.length) {
				matriz[i][j] = vetor[cont];
				j++;
				cont++;
			}
		}

        //INSERINDO VALORES DA MATRIZ DENTRO DE UMA VARIÁVEL PARE SEREM IMPRESSOS
		for (int i = 0; i < tamanho; i++) {
			String resultado = "";
			for (int j = 0; j < tamanho; j++) {
				if (matriz[j][i] == null) {
					break;
				}
				resultado = resultado + matriz[j][i];
			}

			//EMPRIMINDO RESULTADO ENCRIPTAÇÃO
			System.out.print(resultado);
			System.out.print(" ");
		}
	}
}