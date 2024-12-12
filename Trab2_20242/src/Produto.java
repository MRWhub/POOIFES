

public class Produto {
    private String codigo;
    private String nome;
    private int quantidade;
    private double valor;

    public Produto(String nome, int quantidade, double valor, String codigo) {

        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;
    }

    public String toString() {
        return this.codigo + ": " + this.nome + "(QTD): "+ this.quantidade;

    }
    public String getNome(){
        return this.nome;
    }
    public double getValor(){
        return this.valor;
    }
    public boolean verificaEstoque(int qntd){
        if(this.quantidade >= qntd) {
            return true;
        }
        return false;
    }
    public void retirarDeEstoque(int qntd) {
        if(this.quantidade >= qntd) {
            this.quantidade -= qntd;
        }
    }

    public String getCode(){

        return this.codigo;
    }

}
