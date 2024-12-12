import java.util.ArrayList;

public class Pedido {
    private String codigo;
    private Aluno cliente;
    private Aluno entregador;
    private Sala sala;
    private ArrayList<Item> carrinho;
    private boolean entregue;

    public Pedido(String codigo, Aluno cliente, Sala sala,ArrayList<Item> carrinho){
        this.codigo = codigo;
        this.cliente = cliente;
        this.sala = sala;
        this.carrinho = carrinho;
        this.entregue = false;
        this.entregador = null;

    }

    public String getCodigo(){
        return this.codigo;
    }

    public Aluno getCliente(){
        return this.cliente;
    }

    public Aluno getEntregador(){
        return this.entregador;
    }

    public String toString() {
        StringBuilder produtos = new StringBuilder();
        for (Item i : this.carrinho) {
            produtos.append(i).append("\n");
        }
        String status = this.entregue ? "Entregue" : "Em aberto";

        return "Código: " + this.codigo + "\n" +
                "Produtos: \n" + produtos +
            "Status: " + status + "\n"+ 
                "Valor total: " + this.valorTotal();
    }

    public void atribuirEntregador(Aluno a){
        this.entregador = a;
    }

    public boolean disponivel(){

        if(this.entregue || this.entregador != null){
            return false;
        }
        return true;
    }

    public void setEntregue(){
        this.entregue = true;
    }

    public double valorTotal(){
        double valor_total = 0;
        for(Item i : this.carrinho){
            valor_total += i.valorTotal();
        }
        return  valor_total;
    }

    public void marcarComoEntregue(){
        this.entregue = true;
    }
    public void confirmar(){
        for(Item i : this.carrinho){
            i.getProduto().retirarDeEstoque(i.getQuantidade());
        }
    }
}
