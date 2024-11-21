import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Banco {
    public static void main(String[] args) {
    
        LocalDate today = LocalDate.now();
        
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        
        Data hoje = new Data(day,month,year);
        
      
        Gerente g1 = new Gerente();
      
        Gerente g2 = new Gerente();
        
    
        

     


        ContaCorrente c1 = new ContaCorrente(g1);
        ContaCorrente c2 = new ContaCorrente(g2);
        c1.depositar(50.78);
        c2.depositar(10005.00);
        c2.transferir(5002.50,c1);
        c2.sacar(5200);
        if(c1.sacar(2500)){
        //...
        }
        c1.extrato();
        c2.extrato();
        
        Poupanca poup1 = new Poupanca(g1);
        Poupanca poup2 = new Poupanca(g2);
        poup2.depositar(100.5);
        poup1.depositar(174.79);
        
        
        for(int i = 1 ;  i<= 30; i++){
        
        poup1.rendimento(0.02);
     
  
        }
         JOptionPane.showMessageDialog(null,"Saldo da conta: " + poup1.numero + " após 30 dias de rendimento: " + poup1.saldo,"AVISO",JOptionPane.INFORMATION_MESSAGE);
    
        
        c1.extrato();
        c2.extrato();
        poup1.transferir(50,c1);
        poup1.extrato();
        poup2.extrato();
        
        g1.years_old(hoje);
        
        
        
        
        for(int i = 1 ; i<=30 ; i++){
          c1.chequeEspecial(0.05);
         
        }
        JOptionPane.showMessageDialog(null,"Saldo da conta: " + c1.numero + " após 30 dias de juros: " + c1.saldo,"AVISO",JOptionPane.INFORMATION_MESSAGE);
        }
        }
        
