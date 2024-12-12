import java.util.ArrayList;
import java.util.Random;

public class Sistema {
   private ArrayList<Aluno> alunos;
   private ArrayList<Admin> adms;
   private ArrayList<Produto> prdts;
   private ArrayList<Pedido> pedidos;
    private ArrayList<Sala> salas;

    public Sistema() {
        this.alunos = new ArrayList<>();
        this.adms = new ArrayList<>();
        this.prdts = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public void addPedido(Pedido p){this.pedidos.add(p);}

    public void addSalas(Sala s){this.salas.add(s);}

    public void addAdmin(Admin a) {
        this.adms.add(a);
    }

    public void addAluno(Aluno a){this.alunos.add(a);}

    public void addProduto(Produto p){this.prdts.add(p);}

    public boolean sistemaVazio() {
        return this.adms.size() == 0;
    }

    public Aluno getAluno(String cpf) {
        for(Aluno a : this.alunos) {
            if (cpf.equals(a.getCPF())) return a;
        }

        return null;
    }

    public Sala getSala(String sala){

        String bloco = sala.substring(0, 1);
        String salaNumero = sala.substring(1, 3);
        String andar = sala.substring(3);


        for(Sala s : this.salas) {
            if(bloco.equals(s.getBloco()) && salaNumero.equals(s.getSala()) && andar.equals(s.getAndar())){
                return  s;
            }
        }

        return null;

    }



    public Admin getAdmin(String cpf) {
        for(Admin a : this.adms) {
            if (cpf.equals(a.getCPF())) return a;
        }

        return null;
    }

    public Produto getProduto(String code) {
        for(Produto p : this.prdts) {
            if (code.equals(p.getCode())) return p;
        }

        return null;
    }

    public Pedido getPedido(String code){
        for(Pedido p : this.pedidos){
            if(code.equals(p.getCodigo())) return p;
        }
        return null;
    }

    public void listarSalas(){
        for(Sala s : this.salas) {
            System.out.println(s);
        }
    }

    public void listarProdutos(){
        for(Produto p : this.prdts){
            System.out.println(p);
        }
    }
    public ArrayList<Pedido> filtrarPedidos(boolean disponivel){
        ArrayList<Pedido> disponiveis_entrega = new ArrayList<>();
        for(Pedido p : this.pedidos){
            if(p.disponivel()){
                disponiveis_entrega.add(p);
            }
        }
        return disponiveis_entrega;
    }
    public ArrayList<Pedido> filtrarPedidos(Aluno a){
        ArrayList<Pedido> pedidos1 = new ArrayList<>();
        for(Pedido p : this.pedidos){
            if(p.getCliente().getCPF().equals(a.getCPF())){
                pedidos1.add(p);
            }
        }
        return pedidos1;
    }



    public String generateProductCode(){

        return "PROD-" + (this.prdts.size() + 1);

    }

    public String generateOrderCode() {
        return "PEDIDO-" + (this.pedidos.size() + 1);
    }


}
