package segundoPeriodo.Elevadores;

public class Elevador {

    private int idElevador;
    private boolean ligado;
    private boolean prioritario;
    private int andarAtual;

    public Elevador(int idElevador, boolean ligado, boolean prioritario, int andarAtual) {
        this.idElevador = idElevador;
        this.ligado = false;
        this.prioritario = false;
        this.andarAtual = 1;
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

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public void ligarDesligar(){
        ligado = (true);
    }

    public void ativarPrioridade(){
        prioritario = true;
    }

    public void desativarPrioridade(){
        prioritario = false;
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
