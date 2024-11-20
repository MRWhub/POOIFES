import javax.swing.JOptionPane;
import java.util.Scanner;

public class Data {
    int day;
    int month;
    int year;

    // Construtor com parâmetros
    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Construtor sem parâmetros
    public Data() {
        // Exibe a mensagem antes de pedir os dados


        Scanner scan_int = new Scanner(System.in);
        System.out.print("Digite o dia: ");
        this.day = scan_int.nextInt();
        System.out.print("Digite o mês: ");
        this.month = scan_int.nextInt();
        System.out.print("Digite o ano: ");
        this.year = scan_int.nextInt();

   
    }

    public void print_birhtdate(Pessoa p) {
        JOptionPane.showMessageDialog(null, "Data de Nascimento de " + p.nome + ": \n" + this.day + '/' + this.month + '/' + this.year, "!", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean older_than(Data d2) {
        if (this.year < d2.year) {
            return true;
        } else if (this.year > d2.year) {
            return false;
        }

        if (this.month < d2.month) {
            return true;
        } else if (this.month > d2.month) {
            return false;
        }

        if (this.day < d2.day) {
            return true;
        } else if (this.day > d2.day) {
            return false;
        }

        return false;
    }
}

