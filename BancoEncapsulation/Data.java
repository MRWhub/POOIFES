import javax.swing.JOptionPane;
import java.util.Scanner;

public class Data {
    private int day;
    private int month;
    private int year;

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

    public int get_day(){
        return this.day;

    }
        public int get_month(){
        return this.month;

    }
        public int get_year(){
        return this.year;

    }
    public boolean older_than(Data d2) {
        if (this.get_year() < d2.get_year()) {
            return true;
        } else if (this.get_year() > d2.get_year()) {
            return false;
        }

        if (this.get_month() < d2.get_month()) {
            return true;
        } else if (this.get_month() > d2.get_month()) {
            return false;
        }

        if (this.get_day() < d2.get_day()) {
            return true;
        } else if (this.get_day() > d2.get_day()) {
            return false;
        }

        return false;
    }
}

