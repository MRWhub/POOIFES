import javax.swing.JOptionPane;
import java.util.Scanner;

public class Gerente extends Pessoa{
	String matricula;
	String senha;
  
  
 public Gerente(){
 super();
 Scanner scanner_mat = new Scanner(System.in);
 System.out.print("Insira a matricula do gerente: ");
 this.matricula = scanner_mat.nextLine();

 this.senha = "123456";
 
 
 }
 
  
  public Gerente(String nome, Data nascimento, char sexo, String cpf,String senha, String matricula){
	super(nome,nascimento,sexo,cpf);
	this.senha = senha;
	this.matricula = matricula; 
  }
  
  
  boolean validar_acesso(String senha){
	
	if(this.senha.equals(senha)){


		return true;

	}
	JOptionPane.showMessageDialog(null, "OPERAÇÃO NEGADA(SENHA INCORRETA) !!"
                      , "AVISO!!", 0);
	return false;
	



}
boolean validar_acesso(){
Scanner scanner_senha = new Scanner(System.in);
System.out.print("Insira a senha gerencial: ");
String pwd = scanner_senha.nextLine();
if(this.senha.equals(pwd)){
scanner_senha.close();
return true;
}
JOptionPane.showMessageDialog(null, "OPERAÇÃO NEGADA(SENHA INCORRETA) !!"
                      , "AVISO!!", 0);
	
	scanner_senha.close();
	return false;


}

}
