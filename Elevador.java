package segundoPeriodo.Elevadores;

public class Elevadores {

    private int idElevador;
    private int andarAtual;
    private boolean ligadoA;
    private boolean ligadoB;
    private boolean prioritario;

    public Elevadores(int andarAtual,/*int andarAtualA, int andarAtualB,*/ int idElevador, boolean prioritario) {
        this.andarAtual = andarAtual;
        this.idElevador = idElevador;
        this.prioritario = prioritario;
    }


    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getIdElevador() {
        return idElevador;
    }

    public void setIdElevador(int idElevador) {
        this.idElevador = idElevador;
    }

    public boolean isLigadoA() {
        return ligadoA;
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

    public boolean isPrioritario() {
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

    public double calcularEsforco (int andarUsuario, int andarDestino){
        double esforco = 0;

        if (this.andarAtual <= andarUsuario && andarDestino > andarUsuario){
            esforco = ((andarUsuario - this.andarAtual) + (andarDestino - andarUsuario)) * 1.25;//ok
            System.out.println();
        } else if (this.andarAtual <= andarUsuario && andarDestino < andarUsuario){
            esforco = ((andarUsuario - this.andarAtual) * 1.25) + (andarUsuario - andarDestino);//ok
        } else if (this.andarAtual > andarUsuario && andarDestino > andarUsuario){
            esforco = (this.andarAtual - andarUsuario) + ((andarDestino - andarUsuario) * 1.25);//ok
        } else if (this.andarAtual > andarUsuario && andarDestino < andarUsuario) {
            esforco = ((this.andarAtual - andarUsuario)) + ((andarUsuario - andarDestino));//ok
        }
        return esforco;
    }

}
