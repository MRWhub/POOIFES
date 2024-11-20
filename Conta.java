import javax.swing.JOptionPane;
import java.util.Scanner;
public class Conta {
    String numero;
    Pessoa titular;
    Data criacao;
    double saldo;
    Gerente gerente;


    Conta(Gerente g){
      Scanner scan_num = new Scanner(System.in);

        System.out.print("Insira o número da conta: ");
        this.numero = scan_num.nextLine();

        System.out.println("Insira os dados do novo titular da conta: ");
        this.titular = new Pessoa();

        System.out.println("Insira a data de criação da conta:");
        this.criacao = new Data();

        this.saldo = 0;
        this.gerente = g;

        // Não feche o Scanner aqui, pois is
    
    }

    Conta(String numero, Pessoa titular, Data criacao, Gerente g) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.criacao = criacao;
        this.gerente = g;

    }


    void depositar(double value) {
        this.saldo += value;
        JOptionPane.showMessageDialog(null, "Depósito de " + value + " realizado na conta " + this.numero + " com sucesso!! ", "AVISO", JOptionPane.INFORMATION_MESSAGE);

    }

  	double disponivel(){
	  return this.saldo;
	
	}
	
	  boolean sacar(double value){
    	if(this.disponivel() >= value){
    	this.saldo -= value;
    	JOptionPane.showMessageDialog(null,"Saque de " + value + " efetuado com sucesso na conta: " + this.numero +"\n","AVISO",JOptionPane.INFORMATION_MESSAGE);
    	return true;
    	}else{
    	JOptionPane.showMessageDialog(null,"Saldo atual inferior ao valor do saque.\n","AVISO",0);
    	return false;
    	}
        }
        
        
    boolean transferir(double value, Conta destino) {
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

   
    
    
    


    
    

