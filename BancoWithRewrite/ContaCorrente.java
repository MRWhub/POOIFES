import javax.swing.JOptionPane;
import java.util.Scanner;
public class ContaCorrente extends Conta{
	double limite;
	public ContaCorrente(Gerente g){
     super(g);
    this.limite = 200;
}

void alterarLimite(String senha, double new_limit){
      if(this.gerente.validar_acesso(senha)){
      this.limite = new_limit;
      JOptionPane.showMessageDialog(null,"Limite da conta " + this.numero + " alterado com sucesso!","AVISO",JOptionPane.INFORMATION_MESSAGE);
      }
         

}

void alterarLimite(){
  if (this.gerente.validar_acesso()){
     
Scanner value_scan  = new Scanner(System.in);
System.out.print("Insira o novo limite: ");
this.limite = value_scan.nextFloat();

 JOptionPane.showMessageDialog(null,"Limite da conta " + this.numero + " alterado com sucesso!","AVISO",JOptionPane.INFORMATION_MESSAGE);
}

}
	
	double disponivel(){
    		return this.saldo + this.limite;
    	}

	void extrato(){
    	JOptionPane.showMessageDialog(null, "Conta:  " + this.numero + "\n"+
	"CPF do titular: "+ this.titular.cpf + "\nNome do Titular: " + this.titular.nome +"\nSaldo da Conta Corrente: "+this.saldo  +"\nSaldo disponível para saque(Saldo + Limite): "+this.disponivel()  
                      , "EXTRATO CONTA-CORRENTE", JOptionPane.INFORMATION_MESSAGE);
}


	void chequeEspecial(double taxa){
    	if(this.saldo<0){
    	this.saldo += saldo*taxa;
    	}
    	}

	
		
}
