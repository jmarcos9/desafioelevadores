package segundoPeriodo.Elevadores;

public class Elevadores {

    private String idElevador;
    private int andarAtualA;
    private int andarAtualB;
    private boolean ligadoA;
    private boolean ligadoB;
    private boolean prioritario;



    public Elevadores(int andarAtualA, int andarAtualB) {
        this.andarAtualA = andarAtualA;
        this.andarAtualB = andarAtualB;
    }

    public String getIdElevador(String a) {
        return idElevador;
    }

    public void setIdElevador(String idElevador) {
        this.idElevador = idElevador;
    }

    public int getAndarAtualA() {
        return andarAtualA;
    }

    public void setAndarAtualA(int andarAtualA) {
        this.andarAtualA = andarAtualA;
    }

    public boolean isLigadoA() {
        return ligadoA;
    }

    public int getAndarAtualB() {
        return andarAtualB;
    }

    public void setAndarAtualB(int andarAtualB) {
        this.andarAtualB = andarAtualB;
    }

    public void setLigadoA(boolean ligadoA) {
        this.ligadoA = ligadoA;
    }

    public boolean isLigadoB() {
        return ligadoB;
    }

    public void setLigadoB(boolean ligadoB) {
        this.ligadoB = ligadoB;
    }

    public boolean isPrioritario(String a) {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    void ligarA(){
        ligadoA = true;
    }

    void desligarA(){
        ligadoA = false;
    }

    void ligarB(){
        ligadoB = true;
    }

    void desligarB(){
        ligadoB = false;
    }

    public void ligarDesligarA() {
        if (isLigadoA()) {
            desligarA();
            //ligar();
        } else {
            //desligar();
            ligarA();
        }
    }

    public void ligarDesligarB() {
        if (isLigadoB()) {
            desligarB();
            //ligar();
        } else {
            //desligar();
            ligarB();
        }
    }

    void prioritaridade(){
        prioritario = true;
    }






}
