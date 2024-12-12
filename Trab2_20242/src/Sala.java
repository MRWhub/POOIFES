public class Sala {
    private String bloco;
    private String sala;
    private String andar;

    public Sala(String bloco,String sala,String andar){

        this.andar = andar;
        this.sala = sala;
        this.bloco = bloco;
    }

    public String getBloco(){
        return this.bloco;
    }
    public String getSala(){
        return this.sala;
    }
    public String getAndar(){
        return this.andar;
    }
    public String toString() {
        return this.bloco+this.sala+this.andar;

    }
}

