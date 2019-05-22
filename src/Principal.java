
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
     * Troca um número pelo rótulo do vértice no grafo.
     *
     * Retorna o rótulo da posição i do vértice no grafo.
     *
     * @param i Posição do vértice no grafo
     * @return Um rótulo para a posição i
     */
    public static String rotuloVertice(int i) {
        String[] rotulos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        if ((i >= 0) && (i <= rotulos.length)) {
            return (rotulos[i] + "");
        } else {
            return "-";
        }
    }

    /**
     * Troca o rótulo pela posição do vértice no grafo.
     *
     * @param chave Rótulo a ser trocado pela posição do vértice no grafo.
     * @return Um inteiro que representa a posição do vértice no grafo
     */
    public static int indiceRotuloVertice(String chave) {
        String[] rotulos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int pos = -1;
        for (int i = 0; i < rotulos.length; i++) {
            if (rotulos[i].equals(chave)) {
                return i;
            }
        }
        return -1;
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
                saida = saida + "\t" + rotuloVertice(j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; i++) {
                String dados = "";
                for (int j = 0; j < colunas; j++) {
                    dados = dados + "\t" + String.format("%2d", M[i][j]);
                }
                saida = saida + rotuloVertice(i) + dados + "\n";
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

//        int[][] g = {
//            //1  2  3 
//            {0, 1, 1},//1
//            {1, 0, 1},//2
//            {1, 1, 0},//3
//        };
        //Número de vértices do grafo
        n = 7;

        //Atribui para G
        G = g;
        JOptionPane.showMessageDialog(null, "Grafo carregado!");
    }

    /**
     * Verifica se existe a aresta no Grafo.
     *
     * @param G Grafo a ser verifica a aresta.
     * @param i Vértice adjacente i da aresta.
     * @param j Vértice adjacente j da aresta.
     * @return Se existe a aresta;
     */
    public static boolean existeAresta(int[][] G, int i, int j) {
        if (G[i][j] == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Incluir um areta para o Grafo.
     *
     * @param G Gravo a ser inserido a aresta.
     * @param i Vértice adjacente.
     * @param j Vértice adjacente.
     */
    public static void incluirAresta(int[][] G, int i, int j) {
        //1 valor para a aresta que possui o vértice i e j como adjacentes.        
        G[i][j] = 1;
        G[j][i] = 1;
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
            int j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + rotuloVertice(i) + ")"
                    + "\nDigite o indice(0-" + n + ") do vértice de incidência de " + i
                    + "\n ou -1 para ir ao próximo vértice:"));
            while (j != -1) {
                incluirAresta(G, i, j);
                j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + rotuloVertice(i) + ")"
                        + "\nDigite o índice(0-" + n + ") do vértice de incidência de " + i
                        + "\n ou -1 para ir ao próximo vértice:"));
            }
        }
    }

    /**
     * Retorna a quantidade de vértices do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return A quantidade vértices do grafo.
     */
    public static int quantidadeVertices(int[][] G, int n) {
        //A quantidade de vértices é o tamanho da matriz.
        return n;
    }

    /**
     * Retorna a quantidade de arestas do Grafo.
     *
     * Realiza a soma de todas as posições A[i][j] do grafo no triângulo
     * superior(i<=j).
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return A quantidade de arestas do grafo.
     */
    public static int quantidadeArestas(int[][] G, int n) {
        //Acumula a quantidade de arestas
        int conta = 0;
        //Percorre a matriz de adjacência
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Verifica se´é diferente de 0 ou seja existe aresta em G[i][j]. 
                // e o i <= j ou seja o triângulo superior.
                if ((G[i][j] != 0) && (i <= j)) {
                    conta = conta + G[i][j];
                }
            }
        }
        return conta;
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
            saida = saida + rotuloVertice(i) + ",";
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
                //Verifica se´é diferente de 0 ou seja existe aresta em G[i][j]. 
                // e o i <= j ou seja o triângulo superior.
                if ((G[i][j] != 0) && (i <= j)) {
                    for (int x = 0; x < G[i][j]; x++) {
                        saida = saida + "e" + conta + ",";
                        conta = conta + 1;
                    }
                }
            }
        }
        return saida;
    }

    /**
     * Retorna a lista de arestas do Grafo.
     *
     * Retorna uma lista das arestas em pares E=(vi,vj).
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
                //Verifica se´é diferente de 0 ou seja existe aresta em G[i][j]. 
                // e o i <= j ou seja o triângulo superior.
                if ((G[i][j] != 0) && (i <= j)) {
                    //Adiciona uma aresta para ocorrência
                    for (int x = 0; x < G[i][j]; x++) {
                        saida = saida + "e" + conta + "=(" + rotuloVertice(i) + "," + rotuloVertice(j) + "),";
                        conta = conta + 1;
                    }
                }
            }
            saida = saida + "\n";
        }
        return saida;
    }

    /**
     * Verifica se dois vértices são adjacentes.
     *
     * Para ser adjacente deve existir uma aresta ligando os dois vértices. Ou
     * seja G[x][y] deve ser diferente 0.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @param i Primeiro vértice
     * @param j Segundo vértice
     * @return Se x e y são adjacentes
     */
    public static boolean verificaAdjacencia(int[][] G, int n, int i, int j) {
        //Os vértices x e y devem ser menor que n
        if ((i < n) && (j < n)) {
            //Verifica se é diferente de 0 ou seja existe aresta em G[i][j]
            if (G[i][j] != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
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
            //Verifica se é diferente de 0 ou seja existe aresta em G[i][j]
            if (G[i][j] != 0) {
                conta = conta + G[i][j];
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
            saida = saida + "d(" + rotuloVertice(i) + ")=" + dv + "\n";
            conta = conta + dv;
        }
        saida = saida + "Total = " + conta;
        return saida;
    }

    /**
     * Retorna os vértices adjacentes de um vértice.
     *
     * Retorna os vizinhos de um vértice.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @param i Vértice do grafo.
     * @return String com as adjacentes de i.
     */
    public static String adjacentes(int[][] G, int n, int i) {
        String saida = rotuloVertice(i) + "->";
        for (int j = 0; j < n; j++) {
            //Verifica se existe um vértice adjacente para i em j
            if (G[i][j] != 0) {
                saida = saida + rotuloVertice(j) + ",";
            }
        }
        return saida;
    }

    /**
     * Retorna a lista dos vértices adjacentes do Grafo.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return String com a lista dos vértices adjacentes.
     */
    public static String listarAdjacentes(int[][] G, int n) {
        String saida = "";
        for (int i = 0; i < n; i++) {
            saida = saida + adjacentes(G, n, i) + "\n";
        }
        return saida;
    }

    /**
     * Verifica se o grafo é simples.
     *
     * O Grafo não pode ter laço(G[i][i]>0) ou arestas paralelas((G[i][j]>1).
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo é simples.
     */
    public static boolean eSimples(int[][] G, int n) {
        // Nao pode ter laco ou paralela
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Verifica se o vértice i possui aresta paralela(>1) ou laço(i,i) > 0
                if ((G[i][j] > 1) || (G[i][i] > 0)) {
                    return false;
                }
            }
        }
        return true;
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
        for (int i = 0; i < n; i++) {
            //Verifica se o vértice i é de grau 0, ou seja
            //nenhum vértice chega ou parte dele
            if (grauVertice(G, n, i) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se o grafo é completo.
     *
     * Se para todo A[i][j] existe uma aresta e não seja na diagonal principal.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo é completo.
     */
    public static boolean eCompleto(int[][] G, int n) {
        boolean diagonal0 = true;
        //Verifica se a diagonal principal não possui laços
        for (int i = 0; i < n; i++) {
            if (G[i][i] != 0) {
                diagonal0 = false;
            }
        }
        boolean acima1 = true;
        //Verifica se acima da diagonal principal existes arestas simples(1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((G[i][j] != 1) && (i < j)) {
                    acima1 = false;
                }
            }
        }
        //Verifica as duas condições
        if ((diagonal0 == true) && (acima1 == true)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se o grafo é regular.
     *
     * O Grafo tem o mesmo grau para todos os vértices.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo é regular.
     */
    public static boolean eRegular(int[][] G, int n) {
        //Armazenar o grau de cada vértice    
        int[] graus = new int[n];
        //Soma o grau de entrada e saída de cada vértice        
        for (int i = 0; i < n; i++) {
            graus[i] = 0;
            for (int j = 0; j < n; j++) {
                graus[i] = graus[i] + G[i][j];
            }
        }
        //Verifica a soma dos graus
        //Desconta 1 no tamanho
        for (int i = 0; i < n - 1; i++) {
            //Verifica se o grau do vértice graus[i] é diferente a graus[i+1]            
            if (graus[i] != graus[i + 1]) {
                return false;
            }
        }
        //Todos os graus são iguais
        return true;
    }

    /**
     * Verifica se o grafo possu ciclo euleriano.
     *
     * Um grafo euleriano deve possuir um ciclo que inclua todas as arestas do
     * grafo. Para um grafo ser Euleriano todos os vértices precisam ser de grau
     * par. O caminho começa e termina no mesmo vértice.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo é euleriano.
     */
    public static boolean possuiCicloEuleriano(int[][] G, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Verifica se o vértice i possui aresta paralela(>1) ou laço(i,i) > 0
                //Se existir é um grafo euleriano
                if ((G[i][j] > 1) || (G[i][i] > 0)) {
                    return false;
                }
            }
        }
        //Conta o grau do vértice i
        for (int i = 0; i < n; i++) {
            int grau = 0;
            for (int j = 0; j < n; j++) {
                grau = grau + G[i][j];
            }
            //Se o grau for impar não é euleriano
            if ((grau % 2) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se o grafo possui caminho euleriano.
     *
     * Um caminho Euleriano não repete arestas, mas não precisam terminar no
     * mesmo vértice. Pode existir no máximo 2 vértices com grau impar.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Se o grafo possui caminho euleriano.
     */
    public static boolean possuiCaminhoEuleriano(int[][] G, int n) {
        //Registra a quantidade de vértices com grau impar
        int verticeGrauImpar = 0;
        for (int i = 0; i < n; i++) {
            int grau = 0;
            for (int j = 0; j < n; j++) {
                //Conta o grau do vértice i
                if (G[i][j] == 1) {
                    grau = grau + 1;
                }
            }
            //Se o grau do vértice i for impar conta
            if ((grau % 2) == 1) {
                //Conta as quantidade de vértices com grau impar
                verticeGrauImpar = verticeGrauImpar + 1;
            }
        }
        if (verticeGrauImpar > 2) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Converte a representação de matriz de Adjacência para matriz de
     * Incidência.
     *
     * @param G Matriz do grafo.
     * @param n Quantidade de vértices do grafo.
     * @return Uma matriz de incidência.
     */
    public static int[][] converte(int[][] G, int n) {
        //Conta o número de arestas
        int contaArestas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Somente diferente de 0 e que fazem parte do 
                //Triângulo superior 
                if ((i <= j) && (G[i][j] != 0)) {
                    //Conta o número de arestas 
                    contaArestas = contaArestas + G[i][j];
                }
            }
        }

        //Cria a matriz de incidência
        int[][] I = new int[n][contaArestas];

        //Conta o número de arestas
        int e = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Somente diferente de 0 e que fazem parte do 
                //Triângulo superior
                if ((i <= j) && (G[i][j] != 0)) {
                    //Adiciona uma incidência para cada aresta
                    for (int x = 0; x < G[i][j]; x++) {
                        I[i][e] = 1;
                        I[j][e] = 1;
                        //Avança para a próxima aresta
                        e = e + 1;
                    }
                }
            }
        }
        return I;
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
                    + " 2- Leitura do Grafo(i)\n"
                    + " 3- Mostra a quantidade de vértices do Grafo\n"
                    + " 4- Mostra a quantidade de vértices do Grafo\n"
                    + " 5- Mostra a lista dos vértices\n"
                    + " 6- Mostra a lista das arestas\n"
                    + " 7- Mostra a lista das arestas em pares\n"
                    + " 8- Mostra o grau de um vértice\n"
                    + " 9- Mostra a lista dos graus dos vértices\n"
                    + "10- Verifica se dois vértices são adjacentes\n"
                    + "11- Mostra as adjacências de um vértice\n"
                    + "12- Mostra a lista das adjacências dos vértices\n"
                    + "13- Verifica se o grafo é simples\n"
                    + "14- Verifica se o grafo é conexo\n"
                    + "15- Verifica se o grafo é completo\n"
                    + "16- Verifica se o grafo é regular\n"
                    + "17- Verifica se o grafo é Euleriano\n"
                    + "18- Verifica se o possui caminho Euleriano\n"
                    + "19- Converte para Matriz de Incidência\n"
                    
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
                    String dados = "Quantidade de Vértices:" + "\n" + quantidadeVertices(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 4: {
                    //Recupera os dados da matriz
                    String dados = "Quantidade de Arestas:" + "\n" + quantidadeArestas(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 5: {
                    //Recupera os dados da matriz
                    String dados = "Lista dos Vértices:" + "\n" + listarVertices(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 6: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Arestas:" + "\n" + listarArestas(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 7: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Arestas:" + "\n" + listarArestasPares(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 8: {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + (n - 1) + ") de um vértice para saber o grau(d):"));
                    //Recupera os dados da matriz
                    String dados = "Grau do Vértice : \n" + "d(" + rotuloVertice(i) + ")=" + grauVertice(G, n, i);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 9: {
                    //Recupera os dados da matriz
                    String dados = "Grau dos Vértices:" + "\n" + listarGrau(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 10: {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + (n - 1) + ") do primeiro vértice:"));
                    int j = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + (n - 1) + ") do segundo vértice:"));
                    String dados = "Os vértices " + rotuloVertice(i) + " e " + rotuloVertice(j);
                    //Recupera os dados da matriz
                    if (verificaAdjacencia(G, n, i, j) == true) {
                        dados = dados + " são adjacentes";
                    } else {
                        dados = dados + " não são adjacentes";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }

                case 11: {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice(0-" + (n - 1) + ") de um vértice para saber as adjacências:"));
                    //Recupera os dados da matriz
                    String dados = "Adjacências: \n" + adjacentes(G, n, i);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 12: {
                    //Recupera os dados da matriz
                    String dados = "Lista das Adjacências:" + "\n" + listarAdjacentes(G, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 13: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (eSimples(G, n) == true) {
                        dados = dados + "é simples";
                    } else {
                        dados = dados + "não é simples";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 14: {
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
                case 15: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (eCompleto(G, n) == true) {
                        dados = dados + "é completo";
                    } else {
                        dados = dados + "não é completo";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 16: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (eRegular(G, n) == true) {
                        dados = dados + "é regular";
                    } else {
                        dados = dados + "não é regular";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 17: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (possuiCicloEuleriano(G, n) == true) {
                        dados = dados + "possui ciclo euleriano";
                    } else {
                        dados = dados + "não possui ciclo euleriano";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 18: {
                    String dados = "O grafo ";
                    //Recupera s dado da matriz
                    if (possuiCaminhoEuleriano(G, n) == true) {
                        dados = dados + " poussi caminho euleriano";
                    } else {
                        dados = dados + " não possui caminho euleriano";
                    }
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 19: {
                    int[][] I = converte(G, n);
                    int e = quantidadeArestas(G, n);

                    //Recupera os dados da matriz
                    String dados = "Matriz Incidência:" + "\n" + imprimirMatriz(I, n, e);
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
            }//Fim switch
        }//Fim while
    }//Fim main
}
