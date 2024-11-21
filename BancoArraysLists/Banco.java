import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco{
  public static void menuCadastro(ArrayList<Pessoa> p,ArrayList<Gerente> g, ArrayList<Conta> c){

    Scanner s = new Scanner(System.in);

    System.out.println("O que deseja cadastrar?");
    System.out.println("1) Novo Cliente");
    System.out.println("2) Novo Gerente");
    System.out.println("3) Nova Conta Corrente");
    System.out.println("4) Nova Poupança");

    int op = s.nextInt();

    if (op == 1) p.add(new Pessoa());
    if(op == 2) g.add(new Gerente());
    if(op == 3) {
      Pessoa tit = escolherPessoa(p);
      Gerente ger = escolherGerente(g);
      c.add(new ContaCorrente(ger,tit));

    }
    if(op == 4){
      Pessoa tit = escolherPessoa(p);
      Gerente ger = escolherGerente(g);
      c.add(new Poupanca(ger,tit));
    }

  }

  public static void menuMovimentacoes(ArrayList<Pessoa> p,ArrayList<Gerente> g, ArrayList<Conta> c){

    Scanner s = new Scanner(System.in);

    Conta conta = escolherConta(c);


    System.out.println("O que deseja realizar?");
    System.out.println("1) Visualizar Extrato");
    System.out.println("2) Realizar Saque");
    System.out.println("3) Realizar Deposito");
    System.out.println("4) Realizar Transferência");

    int op = s.nextInt();

    if (op == 1) conta.extrato();
    if(op == 2) conta.sacar();
    if(op == 3) conta.depositar();
    if(op == 4){
      System.out.println("Informe uma conta destino.");
      Conta conta2 = escolherConta(c);
      conta.transferir(conta2);
    }

  }

  public static Conta escolherConta(ArrayList<Conta> c){

    Scanner s = new Scanner(System.in);
    int i = 1;

    System.out.println("Escolha uma conta:");

    for(Conta cc: c){
      System.out.println(i + ") " + cc.getNumero() + " - " + cc.getTitular().getNome());

    i++;

    }
    int index = s.nextInt();

    return c.get(index-1);

  }

  public static Gerente escolherGerente(ArrayList<Gerente> g){
    Scanner s = new Scanner(System.in);
    int i = 1;

    System.out.println("Escolha o gerente da conta: ");
    for(Gerente ger : g){

      System.out.println( i + ") " + ger.getCpf() + " - " + ger.getNome());

    i++;
    }
    int index = s.nextInt();

    return g.get(index-1);
  
  }

    public static Pessoa escolherPessoa(ArrayList <Pessoa> p){
    Scanner s = new Scanner(System.in);
    int i = 1;

    System.out.println("Escolha o cliente da conta: ");
    for (Pessoa tit : p){

      System.out.println( i + ") " + tit.getCpf() + " - " + tit.getNome());

    i++;
    }
    int index = s.nextInt();

    return p.get(index-1);
  
  }


  public static int menuInicial(){

    Scanner s = new Scanner(System.in);

    System.out.println("Bem vindo! Escolha uma opção. \n");
    System.out.println("1) Cadastro");
    System.out.println("2) Movimentação Financeira");
    System.out.println("0) Sair");

    return s.nextInt();
  }

public static void main(String[] args){

ArrayList < Pessoa > p = new ArrayList < >() ;

ArrayList < Gerente > g = new ArrayList < >() ;

ArrayList < Conta > c = new ArrayList < >() ;

int op = menuInicial();

while(op != 0){
  if(op == 1){
    menuCadastro(p,g,c);

  }if(op == 2){
    menuMovimentacoes(p,g,c);
  }

  op  = menuInicial();
}
System.out.println("\nBye! :-)");

  }

}