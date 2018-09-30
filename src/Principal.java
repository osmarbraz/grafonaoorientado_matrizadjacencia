
/**
 * Implementação de exemplo que utiliza JOptionPane para construir um menu de
 * opções para um grafo utilizando uma matriz de adjacência.
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

    //Número de vértices do grafo
    static int n = 0;
    //Matriz M de n por n
    static int[][] G = new int[n][n];

    /**
     * Troca um número que representa a posição pela vértice do grafo.
     *
     * @param i Posição da letra
     * @return Uma String com a letra da posição
     */
    public static String trocar(int i) {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        if ((i >= 0) && (i <= letras.length())) {
            return letras.charAt(i) + "";
        } else {
            return "-";
        }
    }

    /**
     * Troca a letra pela posição na matriz de adjacência.
     *
     * @param v Letra a ser troca pela posição
     * @return Um inteiro com a posição da letra no grafo
     */
    public static int destrocar(char v) {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        int pos = -1;
        for (int i = 0; i < letras.length(); i++) {
            if (letras.charAt(i) == v) {
                pos = i;
            }
        }
        return pos;
    }

    /**
     * Gera uma string formatada com os dados Matriz G.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String formatada com os dados da matriz.
     */
    public static String imprimirMatriz(int[][] M, int linhas, int colunas) {
        if (linhas != 0 || colunas != 0) {
            String saida = "";
            for (int j = 0; j < colunas; j++) {
                saida = saida + "\t" + trocar(j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; i++) {
                String dados = "";
                for (int j = 0; j < colunas; j++) {
                    dados = dados + "\t" + String.format("%2d", M[i][j]);
                }
                saida = saida + trocar(i) + dados + "\n";
            }
            return saida;
        } else {
            return "Matriz vazia!";
        }
    }

    /**
     * Carrega um Grado Padrão com valores.
     *
     */
    public static void carregarGrafoPadrao() {
        //Número de vértices do grafo
        n = 7;

        //Declara a matriz de adjacência do grafo g
        int[][] g = {
            //1  2  3  4  5  6  7
            {0, 1, 0, 1, 0, 0, 0},//1
            {1, 0, 1, 1, 0, 1, 0},//2
            {0, 1, 0, 0, 0, 1, 0},//3
            {1, 1, 0, 0, 0, 0, 1},//4
            {0, 0, 0, 0, 0, 1, 1},//5
            {0, 1, 1, 0, 1, 0, 0},//6
            {0, 0, 0, 1, 1, 0, 0} //7
        };
        //Atribui para G
        G = g;
        JOptionPane.showMessageDialog(null, "Grafo carregado!");
    }

    /**
     * Realiza a leitura dos dados do Grafo G.
     */
    public static void leituraGrafo() {
        //Preenche a quantidade de vértice do grafo.
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vértices do grafo(G):"));
        //Instância a matriz de adjacência com o novo tamanho.
        G = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + trocar(i) + ")"
                    + "\nDigite o indice(0-" + n + ") do vértice de incidência de " + i
                    + "\n ou -1 para ir ao próximo vértice:"));
            while (j != -1) {
                G[i][j] = 1;
                j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + trocar(i) + ")"
                        + "\nDigite o índice(0-" + n + ") do vértice de incidência de " + i
                        + "\n ou -1 para ir ao próximo vértice:"));
            }
        }
    }

    /**
     * Retorna a lista de arestas do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com a lista dos vértices.
     */
    public static String listarVertices(int[][] G, int n) {
        String saida = "";
        for (int i = 0; i < n; i++) {
            saida = saida + trocar(i) + ",";
        }
        return saida;
    }

    /**
     * Retorna a lista de arestas do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com as arestas.
     */
    public static String listarArestas(int[][] G, int n) {
        String saida = "";
        int conta = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((G[i][j] == 1) && (i < j)) {
                    saida = saida + "e" + conta + ",";
                    conta = conta + 1;
                }
            }
        }
        return saida;
    }

    /**
     * Retorna a lista de arestas do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com as arestas em pares.
     */
    public static String listarArestasPares(int[][] G, int n) {
        String saida = "";
        int conta = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (G[i][j] == 1) {
                    saida = saida + "e" + conta + "=(" + trocar(i) + "," + trocar(j) + "),";
                    conta = conta + 1;
                }
            }
            saida = saida + "\n";
        }
        return saida;
    }

    /**
     * Retorna o grau de um vértice.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @param i Vértice do grafo.
     * @return Grau do vértice.
     */
    public static int grauVertice(int[][] G, int n, int i) {
        int conta = 0;
        for (int j = 0; j < n; j++) {
            if (G[i][j] == 1) {
                conta = conta + 1;
            }
        }
        return conta;
    }

    /**
     * Retorna a lista do grau dos vértices do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com os graus dos vértices.
     */
    public static String listarGrau(int[][] G, int n) {
        String saida = "";
        int conta = 0;
        for (int i = 0; i < n; i++) {
            int dv = grauVertice(G, n, i);
            saida = saida + "d(" + trocar(i) + ")=" + dv + "\n";
            conta = conta + dv;
        }
        saida = saida + "Total = " + conta;
        return saida;
    }

    /**
     * Retorna as adjacências de um vértice.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @param i Vértice do grafo.
     * @return String com as adjacências de i.
     */
    public static String adjacencias(int[][] G, int n, int i) {
        String saida = trocar(i) + "->";
        for (int j = 0; j < n; j++) {
            if (G[i][j] == 1) {
                saida = saida + trocar(j) + ",";
            }
        }
        return saida;
    }

    /**
     * Retorna a lista das adjacências dos vértices do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com os graus dos vértices.
     */
    public static String listarAdjacencias(int[][] G, int n) {
        String saida = "";
        for (int i = 0; i < n; i++) {
            saida = saida + adjacencias(G, n, i) + "\n";
        }
        return saida;
    }

    /**
     * Verifica se o grafo é conexo.
     *
     * Se o grau de um vértice for igual a 0 nenhum vértice chega ou parte dele.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo é conexo.
     */
    public static boolean eConexo(int[][] G, int n) {
        //Assume que o grafo é conexo
        boolean conexo = true;
        int i = 0;
        //Percorre todos os vértice e não encontrou nenhum vértice desconexo
        while ((i < n) && (conexo == true)) {
            //Verifica se o vértice i é de grau 0
            if (grauVertice(G, n, i) == 0) {
                conexo = false;
            }
            //Avança para o próximo vértice
            i = i + 1;
        }
        return conexo;
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Armazena opção lida
        int opcao = -1;
        while (opcao != 99) {
            //Realiza a leitura da opção
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Menu de Opções - Grafo Não Orientado com Matriz de Adjacência ###\n"
                    + " 0- Carregamento da Grafo\n"
                    + " 1- Imprime Matriz Adjacência\n"
                    + " 2- Leitura do Grafo\n"
                    + " 3- Mostra a lista dos vértices\n"
                    + " 4- Mostra a lista das arestas\n"
                    + " 5- Mostra a lista das arestas em pares\n"
                    + " 6- Mostra o grau de um vértice\n"
                    + " 7- Mostra a lista dos graus dos vértices\n"
                    + " 8- Mostra as adjacências de um vértice\n"
                    + " 9- Mostra a lista das adjacências dos vértices\n"
                    + "10- Verifica se o grafo é conexo\n"
                    //Outras opções vão aqui                    
                    + "99- Sair\n"
                    + "Digite a opção desejada:"));
            //Verifica a opção
            switch (opcao) {
                case 0: {
                    carregarGrafoPadrao();
                    break;
                }
                case 1: {
                    //Recupera os dados da matriz
                    String dados = "Matriz Adjacência:" + "\n" + imprimirMatriz(G, n, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 2: {
                    leituraGrafo();
                    break;
                }
                case 3: {
                    //Recupera os dados da matriz
                    String dados = "Lista dos Vértices:" + "\n" + listarVertices(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 4: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Arestas:" + "\n" + listarArestas(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 5: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Arestas:" + "\n" + listarArestasPares(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 6: {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + n + ") de um vértice para saber o grau(d):"));
                    //Recupera os dados da matriz
                    String dados = "Grau do Vértice : \n" + "d(" + trocar(i) + ")=" + grauVertice(G, n, i);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 7: {
                    //Recupera os dados da matriz
                    String dados = "Grau dos Vértices:" + "\n" + listarGrau(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 8: {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + n + ") de um vértice para saber as adjacências:"));
                    //Recupera os dados da matriz
                    String dados = "Adjacências: \n" + adjacencias(G, n, i);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 9: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Adjacências:" + "\n" + listarAdjacencias(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 10: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (eConexo(G, n) == true) {
                        dados = dados + "é conexo";
                    } else {
                        dados = dados + "não é conexo";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim Switch
        }//Fim While
    }//Fim Main
}
