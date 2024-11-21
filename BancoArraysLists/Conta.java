import javax.swing.JOptionPane;
import java.util.Scanner;
public class Conta {
   protected String numero;
   protected Pessoa titular;
   protected Data criacao;
   protected double saldo;
   protected Gerente gerente;


    public Conta(Gerente g,Pessoa p){
      Scanner scan_num = new Scanner(System.in);

        System.out.print("Insira o número da conta: ");
        this.numero = scan_num.nextLine();

        this.titular = p;

        System.out.println("Insira a data de criação da conta:");
        this.criacao = new Data();

        this.saldo = 0;
        this.gerente = g;

        // Não feche o Scanner aqui, pois is
    
    }

    public Pessoa getTitular(){
      return this.titular;

    }

    public String getNumero(){
      return this.numero;

    }
    public Conta(String numero, Pessoa titular, Data criacao, Gerente g) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.criacao = criacao;
        this.gerente = g;

    }


    public void depositar(double value) {
        this.saldo += value;
        JOptionPane.showMessageDialog(null, "Depósito de " + value + " realizado na conta " + this.numero + " com sucesso!! ", "AVISO", JOptionPane.INFORMATION_MESSAGE);

    }

  	protected double disponivel(){
	  return this.saldo;
	
	}
	
    public void extrato(){

      JOptionPane.showMessageDialog(null, "Conta: " + this.getNumero() + "\nCPF do titular: " + this.getTitular().getCpf() +
      
      "\nNome do Titular: "+ this.getTitular().getNome() + "\nSaldo Disponível para saque: " + this.disponivel(), "EXTRATO", 0);

    }
	  public boolean sacar(double value){
    	if(this.disponivel() >= value){
    	this.saldo -= value;
    	JOptionPane.showMessageDialog(null,"Saque de " + value + " efetuado com sucesso na conta: " + this.numero +"\n","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	return true;
    	}else{
    	JOptionPane.showMessageDialog(null,"Saldo atual inferior ao valor do saque.\n","AVISO",0);
    	return false;
    	}
        }

    public void depositar() {
      Scanner s = new Scanner(System.in);
      System.out.println("Digite o valor do depósito: ");
      double value = s.nextInt();
      JOptionPane.showMessageDialog(null, "Depósito de " + value + " realizado na conta " + this.numero + " com sucesso!! ", "AVISO", JOptionPane.INFORMATION_MESSAGE);

  }
    
        
      
    public boolean sacar(){

      Scanner s = new Scanner(System.in);
      System.out.println("Digite um valor para saque: ");

      double value = s.nextInt();
      if(this.disponivel() >= value){
        this.saldo -= value;
        JOptionPane.showMessageDialog(null,"Saque de " + value + " efetuado com sucesso na conta: " + this.numero +"\n","AVISO",JOptionPane.INFORMATION_MESSAGE);
        return true;
        }else{
        JOptionPane.showMessageDialog(null,"Saldo atual inferior ao valor do saque.\n","AVISO",0);
        return false;
        }

    }

    public boolean transferir(double value, Conta destino) {
		if (this.sacar(value)) {
			destino.depositar(value);
			JOptionPane.showMessageDialog(null, "Transferência para a conta: " + destino.numero + " no valor de R$  " + value + " realizada com sucesso!! \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Infelizmente não foi possível realizar a transferência :( " +  "\nConheça nossos planos de crédito consignado!!" +
			 "\nEntre em contato com nossa equipe: (27)99999999999 \n", "AVISO", 0);
			return false;

		}


      
      

    }

    public boolean transferir(Conta destino){
      Scanner s = new Scanner(System.in);
      System.out.print("Digite um valor para saque: ");
      double value = s.nextInt();
      if (this.sacar(value)) {
        destino.depositar(value);
        JOptionPane.showMessageDialog(null, "Transferência para a conta: " + destino.numero + " no valor de R$  " + value + " realizada com sucesso!! \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        return true;
      } else {
        JOptionPane.showMessageDialog(null, "Infelizmente não foi possível realizar a transferência :( " +  "\nConheça nossos planos de crédito consignado!!" +
         "\nEntre em contato com nossa equipe: (27)99999999999 \n", "AVISO", 0);
        return false;
  
      }


	}  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

}

   
    
    
    


    
    

