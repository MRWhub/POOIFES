public class Item {
    private Produto produto;
    private int quantidade;

    public Item (Produto p, int quantidade){
        this.produto = p;
        this.quantidade = quantidade;

    }

    public double valorTotal(){
        return this.quantidade * this.produto.getValor();
    }

    public Produto getProduto(){
        return this.produto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    public String toString(){
        return "Produto " + this.produto.getCode()+": "+this.produto.getNome()+" (QTD: " + this.quantidade+")";
    }
}


