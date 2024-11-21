import javax.swing.JOptionPane;
import java.util.Scanner;
public class ContaCorrente extends Conta{
	private double limite;



	public  ContaCorrente(Gerente g , Pessoa p){

		super(g,p);
		this.limite = 200;
	}

public void alterarLimite(String senha, double new_limit){
      if(this.gerente.validar_acesso(senha)){
      this.limite = new_limit;
      JOptionPane.showMessageDialog(null,"Limite da conta " + this.numero + " alterado com sucesso!","AVISO",JOptionPane.INFORMATION_MESSAGE);
      }
         

}

public void alterarLimite(){
  if (this.gerente.validar_acesso()){
     
Scanner value_scan  = new Scanner(System.in);
System.out.print("Insira o novo limite: ");
this.limite = value_scan.nextFloat();

 JOptionPane.showMessageDialog(null,"Limite da conta " + this.numero + " alterado com sucesso!","AVISO",JOptionPane.INFORMATION_MESSAGE);
}

}
	
	protected double disponivel(){
    		return this.saldo + this.limite;
    	}

	public void extrato(){
    	JOptionPane.showMessageDialog(null, "Conta:  " + this.numero + "\n"+
	"CPF do titular: "+ this.titular.cpf + "\nNome do Titular: " + this.titular.nome +"\nSaldo da Conta Corrente: "+this.saldo  +"\nSaldo disponível para saque(Saldo + Limite): "+this.disponivel()  
                      , "EXTRATO CONTA-CORRENTE", JOptionPane.INFORMATION_MESSAGE);
}


	public void chequeEspecial(double taxa){
    	if(this.saldo<0){
    	this.saldo += saldo*taxa;
    	}
    	}

	
		
}
