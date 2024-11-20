import javax.swing.JOptionPane;
import java.util.Scanner;
public class Pessoa{
    public String nome;
    String cpf;
    Data dtNasc;
    char sexo;
    
    


    public Pessoa() {
        // Leitura do nome

        Scanner scan_person = new Scanner(System.in);
        System.out.print("Insira o nome da nova pessoa: ");
        this.nome = scan_person.nextLine();

        // Leitura do CPF
        System.out.print("Insira o CPF da nova pessoa: ");
        this.cpf = scan_person.nextLine();

        // Leitura do sexo
        System.out.print("Insira o Sexo da nova pessoa: ");
        this.sexo = scan_person.next().charAt(0);

        // Consumir a nova linha restante
         // Necessário após o next() para evitar problemas na próxima leitura


        // Leitura da data de nascimento
        System.out.println("Insira a data de nascimento: ");
        this.dtNasc = new Data(); // Supondo que Data tenha um construtor que lê a data
    }

    public Pessoa(String nome, Data nascimento, char sexo, String cpf){
        this.nome = nome;
        this.dtNasc = nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso!\n" + this.nome, "AVISO", JOptionPane.INFORMATION_MESSAGE);
    }

    public int years_old(Data today){
        
        if (today.month > this.dtNasc.month || 
            (today.month == this.dtNasc.month && today.day >= this.dtNasc.day)) {
            return today.year - this.dtNasc.year;
        } else {
            return today.year - this.dtNasc.year - 1;
        }
    }
}

