import javax.swing.JOptionPane;

public class Poupanca extends Conta{
	public Poupanca(Gerente g){
      super(g);
	}
	
	

	
	void extrato(){
  JOptionPane.showMessageDialog(null, "Conta:  " + this.numero + "\n"+
	"CPF do titular: "+ this.titular.cpf + "\nNome do Titular: " + this.titular.nome +"\nSaldo da Conta Poupança: "+this.saldo  +"\nSaldo disponível para saque(Saldo + Limite): "+this.disponivel()  
                      , "EXTRATO CONTA-POUPANÇA", JOptionPane.INFORMATION_MESSAGE);
}

  

	void rendimento(double juros){
	this.saldo += saldo*juros;
	
	}


}
