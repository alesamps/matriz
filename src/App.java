import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] b = {
                {5, 6},
                {7, 8}
        };

        int[] valores = {1, 2, 3, 4, 5};

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção (0 para sair): ");

            switch (opcao) {
                case 1 -> System.out.println(exercicioPG(2,3,5));
                case 2 -> System.out.println(Arrays.toString(exercicioDecrescente(1,10)));
                case 3 -> System.out.println(exercicioDinamico(5));
                case 4 -> System.out.println(exercicioSoma(valores));
                case 5 -> System.out.println(Arrays.deepToString(exercicioMatrizIncremental(3,5)));
                case 6 -> System.out.println(Arrays.deepToString(exercicioSomaMatrizes(a,b)));
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    public static double[] exercicioPG(double a1, double razao, int n) {
        double[] pg = new double[n];

        pg[0] = a1; // primeiro termo

        for (int i = 1; i < n; i++) {
            pg[i] = pg[i - 1] * razao; // multiplica pelo anterior
        }

        return pg;
    }

    public static int[] exercicioDecrescente(int inicio, int tamanho) {
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = inicio - i;
        }

        return vetor;
    }

    public static int[][] exercicioSomaMatrizes(int[][] m1, int[][] m2) {
        int linhas = m1.length;
        int colunas = m1[0].length;

        int[][] resultado = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return resultado;
    }

    public static int[][] exercicioMatrizIncremental(int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        int valor = 1;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valor++;
            }
        }

        return matriz;
    }

    public static int exercicioSoma(int[] vetor) {
        int soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }

        return soma;
    }

    public static ArrayList<Integer> exercicioDinamico(int tamanho) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            lista.add(i); // adiciona valores de forma dinâmica
        }

        return lista;
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU DE EXERCÍCIOS ---");
        System.out.println("1. Progressão Geométrica");
        System.out.println("2. Sequência Decrescente");
        System.out.println("3. Vetor Dinâmico");
        System.out.println("4. Soma de Elementos");
        System.out.println("5. Matriz Incremental");
        System.out.println("6. Soma de Matrizes");
        System.out.println("0. Sair");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.");
            }
        }
    }
}
