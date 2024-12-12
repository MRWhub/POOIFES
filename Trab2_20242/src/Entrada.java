import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Entrada {
    /**
     * Classe com as rotinas de entrada e saída do projeto
     * @author Hilario Seibel Junior e Miguel Rabelo Wagner
     */

    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt na pasta corrente, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);
            // NAO ALTERE A LOCALICAÇÃO DO ARQUIVO!!
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in).useLocale(Locale.US);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um ponto flutuante
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um ponto flutuante e retorna este número
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**********************/
    /** MENUS DO SISTEMA **/
    /**********************/

    /**
     * Exibe o menu principal até que o usuário opte por sair do programa.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Sistema s) {
        if (s.sistemaVazio()) {
            System.out.println("** Inicializando o sistema **");
            this.cadAdmin(s);
        }

        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Login.\n" +
                "0) Sair.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) login(s);
            else System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }

    }

    /**
     * Exibe o menu do administrador até que o usuário deslogue.
     * @param a: Objeto a classe Admin.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Admin a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar novo administrador.\n" +
                "2) Cadastrar aluno.\n" +
                "3) Cadastrar produto.\n" +
                "4) Cadastrar sala.\n" +
                "0) Logout.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) cadAdmin(s);
            if (op == 2) cadAluno(s);
            if (op == 3) cadProduto(s);
            if (op == 4) cadSala(s);
            if (op < 0 || op > 4) System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }
    }

    /**
     * Exibe o menu do aluno até que o usuário deslogue.
     * @param a: Objeto a classe Aluno.
     * @param s: Objeto a classe Sistema.
     */
    public void menu(Aluno a, Sistema s) {
        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Fazer pedido.\n" +
                "2) Fazer entrega.\n" +
                "3) Meus pedidos.\n" +
                "4) Inserir crédito.\n" +
                "0) Logout.\n";

        int op = this.lerInteiro(msg);

        while (op != 0) {
            if (op == 1) fazerPedido(a, s);
            if (op == 2) entregarPedido(a, s);
            if (op == 3) listarPedidos(a, s);
            if (op == 4) inserirCredito(a, s);
            if (op < 0 || op > 4) System.out.println("Opção inválida. Tente novamente: ");

            op = this.lerInteiro(msg);
        }
    }

    public void login(Sistema s) {
        System.out.println("\nBem vindo! Digite seus dados de login:");
        String cpf = this.lerLinha("CPF:");
        String senha = this.lerLinha("Senha:");

        Admin adm = s.getAdmin(cpf);

        if (adm != null) {
            if (adm.validarAcesso(senha)) {
                this.menu(adm, s);
            }
            else System.out.println("Senha inválida.");
        }
        else {
            Aluno a = s.getAluno(cpf);
            if (a != null) {
                if (a.validarAcesso(senha)) {
                    this.menu(a, s);
                }
                else System.out.println("Senha inválida");
            }
            else {
                System.out.println("Usuário inexistente");
            }
        }
    }

    /***************/
    /** CADASTROS **/
    /***************/

    /**
     * Lê os dados de um novo administrador e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAdmin(Sistema s) {
        System.out.println("\n** Cadastrando um novo administrador **\n");
        String cpf = this.lerLinha("Digite o cpf: ");

        while (s.getAdmin(cpf) != null) {
            cpf = this.lerLinha("Usuário já existente. Escolha outro cpf: ");
        }

        String nome = this.lerLinha("Digite o nome: ");
        String senha = this.lerLinha("Digite a senha: ");
        String email = this.lerLinha("Digite o email: ");

        Admin a = new Admin(cpf, nome, senha, email);
        s.addAdmin(a);

        System.out.println("Usuário " + a + " criado com sucesso.");
    }
    /**
     * Lê os dados de um novo aluno e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAluno(Sistema s){

        System.out.println("\n** Cadastrando um novo Aluno **\n");
        String cpf = this.lerLinha("Digite o cpf: ");

        while (s.getAluno(cpf) != null || s.getAdmin(cpf) != null) {
            cpf = this.lerLinha("Usuário já existente. Escolha outro cpf: ");
        }

        String nome = this.lerLinha("Digite o nome: ");
        String senha = this.lerLinha("Digite a senha: ");


        Aluno a = new Aluno(cpf, nome, senha);
        s.addAluno(a);

        System.out.println("Usuário " + a + " criado com sucesso.");
    }

    /**
     * Lê os dados de um novo produto e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadProduto(Sistema s){

        System.out.println("\n** Cadastrando um novo Produto **\n");

        String new_code = s.generateProductCode();

        while (s.getProduto(new_code) != null) {
            new_code = s.generateProductCode();
        }

        String nome = this.lerLinha("Digite o nome do produto: ");
        int quantidade = this.lerInteiro("Digite a quantidade inicial: ");
        double valor = this.lerDouble("Digite o valor: ");

        Produto p = new Produto(nome,quantidade,valor,new_code);
        s.addProduto(p);

        System.out.println("Produto " + p + " criado com sucesso.");
    }

    public void cadSala(Sistema s){

        System.out.println("\n** Cadastrando uma nova Sala **\n");



        String bloco = this.lerLinha("Digite o bloco: ");
        String sala = this.lerLinha("Digite a sala: ");
        String andar = this.lerLinha("Digite o andar: ");

        Sala s1 = new Sala(bloco,sala,andar);
        s.addSalas(s1);

        System.out.println("Sala " + s1 + " criada com sucesso.");
    }

    public void fazerPedido(Aluno a, Sistema s) {

        ArrayList<Item> itens = new ArrayList<>();
        System.out.println("Salas disponíveis:");
        s.listarSalas();

        Sala sala = this.lerSala(s);
        while ( sala == null) {
            sala = this.lerSala(s);
        }

        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Inserir produto no carrinho.\n" +
                "2) Fechar Pedido.\n";

        int op = this.lerInteiro(msg);

        while (op != 1 && op != 2) {
            op = this.lerInteiro("Escolha uma opção Válida:\n" +
                    "1) Inserir produto no carrinho.\n" +
                    "2) Fechar Pedido.\n");
        }
            while (op == 1) {
                s.listarProdutos();
                String escolha = this.lerLinha("Digite o código do produto que deseja: ");
                while (s.getProduto(escolha) == null) {
                    escolha = this.lerLinha("Código Inválido, digite novamente: ");
                }

                Produto p = s.getProduto(escolha);

                int quantidade = this.lerInteiro("Digite a quantidade do produto: ");

                while (!p.verificaEstoque(quantidade)) {

                    quantidade = this.lerInteiro("\nQuantidade maior do que a disponível digite novamente:  ");

                }
                System.out.println("\nItem inserido no carrinho com sucesso.");
                Item new_item = new Item(p, quantidade);
                itens.add(new_item);
                op = this.lerInteiro(msg);
            }
            if(op == 2){
                Pedido new_order = new Pedido(s.generateOrderCode(),a,sala,itens);
                if(a.retirarSaldo(new_order.valorTotal())){
                    System.out.println("Pedido realizado com sucesso!!");
                    s.addPedido(new_order);
                    new_order.confirmar();
                }
                else{
                    System.out.println("Saldo Insuficiente.");

                }
            }


    }

    public void entregarPedido(Aluno a , Sistema s){
        ArrayList<Pedido> pedidos = s.filtrarPedidos(true);
        ArrayList<String> codigos = new ArrayList<>();
        for(Pedido p : pedidos) {
            System.out.println(p);
            codigos.add(p.getCodigo());

        }

        String cod = this.lerLinha("Digite o código do pedido: ");

        while(!codigos.contains(cod)){

            cod = this.lerLinha("Código Inválido. Digite o código do pedido novamente: ");

        }

        Pedido p1 = s.getPedido(cod);

        p1.atribuirEntregador(a);
        p1.setEntregue();
        System.out.println("Entrega realizada com sucesso! ");
        //a.inserirSaldo(0.20);

        }

    public Sala lerSala(Sistema s){

        String sala = this.lerLinha("Digite a Sala: ");
        return s.getSala(sala);


    }

    public void listarPedidos(Aluno a, Sistema s){
        ArrayList<Pedido> p = s.filtrarPedidos(a);
        for(Pedido pedido : p){
            System.out.println(pedido);
        }
    }

    public void inserirCredito(Aluno a, Sistema s){
        double value = this.lerDouble("Digite o valor: ");
        a.inserirSaldo(value);

    }

    }



