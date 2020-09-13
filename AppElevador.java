package segundoPeriodo.Elevadores;



import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AppElevador {

    static Scanner sc = new Scanner(System.in);
    static Elevadores elevadores = new Elevadores(0,0);
    static byte opcao = 0;
    static int andarUsuario;
    static int andarDestino;
    static double esforcoB = 0;
    static double esforcoA = 0;
    public static void main(String[] args) throws InterruptedException {

        do {
            System.out.println("Opção: \n*** 1 - Ligar/Desligar Elevador: A \n*** 2 - Ligar/Desligar Elevador: B" +
                    "\n*** 3 - Solicitar Elevador");
            System.out.print("Entre com a opção: ");
            opcao = sc.nextByte();

            switch (opcao){
                case 1:
                    ligarDesligarElevadorA();
                    break;
                case 2:
                    ligarDesligarElevadorB();

                    break;
                case 3:
                    solicitarElevador();
                    break;
                case 4:
                    calcularEsforcoA();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Programa encerrado");
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static boolean ligarDesligarElevadorA() throws InterruptedException {

        if (elevadores.isLigadoA() == false) {
            System.out.println("Elevador A: Ligado");
            elevadores.ligarDesligarA();
            elevadores.setPrioritario(true);
            System.out.printf("Andar atual: %d - Terreo\n",elevadores.getAndarAtualA());
        } else {
            elevadores.ligarDesligarA();
            System.out.println("Elevador A: Desligado");
        }return true;
    }

    public static boolean ligarDesligarElevadorB() throws InterruptedException {
        if (elevadores.isLigadoA() == false){
            System.out.println("Elevador: (A) Deve ser ligado Primeiro");
            return true;
        }

        if (elevadores.isLigadoB() == false) {
            System.out.println("Elevador B: Ligado");
            elevadores.ligarDesligarB();
            System.out.printf("Andar atual B: %d - Terreo\n",elevadores.getAndarAtualB());
        } else {
            elevadores.ligarDesligarB();
            System.out.println("Elevador B: Desligado");
        }return true;

    }

    public static void statusElevadores(){
        if (elevadores.isLigadoA() && elevadores.isLigadoB()){
            System.out.println("andar elevador A: " + elevadores.getAndarAtualA());
            System.out.println("andar elevador B: " + elevadores.getAndarAtualB());
        } else if (elevadores.isLigadoA()){
            System.out.println("andar elevador A: " + elevadores.getAndarAtualA());
        } else {
            System.out.println("andar elevador B: " + elevadores.getAndarAtualB());
        }
    }

    public static void solicitarElevador(){

        statusElevadores();

        if (elevadores.getAndarAtualA() > 5){
            elevadores.ligarB();
        }

        System.out.println("|*****************|");
        System.out.println("|**** 10 ** 9 ****|");
        System.out.println("|****  8 ** 7 ****|");
        System.out.println("|****  6 ** 5 ****|");
        System.out.println("|****  4 ** 3 ****|");
        System.out.println("|****  2 ** 1 ****|");
        System.out.println("|**  0  Terreo  **|");
        System.out.println("|*****************|");
        System.out.print("Informe o andar que Você está: ");
        andarUsuario = sc.nextInt();

        boolean infvalida = false;

        System.out.println("|*****************|");
        System.out.println("|**** 10 ** 9 ****|");
        System.out.println("|****  8 ** 7 ****|");
        System.out.println("|****  6 ** 5 ****|");
        System.out.println("|****  4 ** 3 ****|");
        System.out.println("|****  2 ** 1 ****|");
        System.out.println("|**  0  Terreo  **|");
        System.out.println("|*****************|");
        System.out.print("Informe o andar Destino: ");
        andarDestino = sc.nextInt();

        menorEsfoco();

        //calcularEsforcoA();
        //calcularEsforcoB();

    }

    public static void calcularEsforcoA(){

        if (elevadores.getAndarAtualA() <= andarUsuario && andarDestino > andarUsuario){
            esforcoA = ((andarUsuario - elevadores.getAndarAtualA()) + (andarDestino - andarUsuario)) * 1.25;//ok
            System.out.println();
        } else if (elevadores.getAndarAtualA() <= andarUsuario && andarDestino < andarUsuario){
            esforcoA = ((andarUsuario - elevadores.getAndarAtualA()) * 1.25) + (andarUsuario - andarDestino);//ok
        } else if (elevadores.getAndarAtualA() > andarUsuario && andarDestino > andarUsuario){
            esforcoA = (elevadores.getAndarAtualA() - andarUsuario) + ((andarDestino - andarUsuario) * 1.25);//ok
        } else if (elevadores.getAndarAtualA() > andarUsuario && andarDestino < andarUsuario) {
            esforcoA = ((elevadores.getAndarAtualA() - andarUsuario)) + ((andarUsuario - andarDestino));//ok
        } else if (andarUsuario == andarDestino){
            System.out.println("Destino não pode ser igual ao Andar do usuário");
            return;
        }
        System.out.println(esforcoA);
        elevadores.setAndarAtualA(andarDestino);
    }

    public static void calcularEsforcoB(){

        if (elevadores.getAndarAtualB() <= andarUsuario && andarDestino > andarUsuario){
            esforcoB = ((andarUsuario - elevadores.getAndarAtualB()) + (andarDestino - andarUsuario)) * 1.25;//ok
            System.out.println();
        } else if (elevadores.getAndarAtualB() <= andarUsuario && andarDestino < andarUsuario){
            esforcoB = ((andarUsuario - elevadores.getAndarAtualB()) * 1.25) + (andarUsuario - andarDestino);//ok
        } else if (elevadores.getAndarAtualB() > andarUsuario && andarDestino > andarUsuario){
            esforcoB = (elevadores.getAndarAtualB() - andarUsuario) + ((andarDestino - andarUsuario) * 1.25);//ok
        } else if (elevadores.getAndarAtualB() > andarUsuario && andarDestino < andarUsuario) {
            esforcoB = ((elevadores.getAndarAtualB() - andarUsuario)) + ((andarUsuario - andarDestino));//ok
        } else if (andarUsuario == andarDestino){
            System.out.println("Destino não pode ser igual ao Andar do usuário");
            return;
        }
        System.out.println(esforcoB);
        elevadores.getAndarAtualB();
    }

    public static void menorEsfoco(){
        if (esforcoA <= esforcoB){
            System.out.println(elevadores.isPrioritario(elevadores.getIdElevador("A")));
            System.out.printf("Andar da Solicitação: %dº - Andar Destino: %dº - Atendimento Elevador %s: \n", andarUsuario, andarDestino, elevadores.getIdElevador("AE"));
        } else {
            System.out.println(elevadores.isPrioritario(elevadores.getIdElevador("B")));
            System.out.printf("B Andar da Solicitação: %d - Andar Destino %d - Atendimento Elevador %s: ", andarUsuario, andarDestino, elevadores.getIdElevador("B"));

        }
    }



    /*public static boolean ativarPrioridade(){
        boolean prioridade;



        /*if (elevador.isLigadoA() == true && elevador.isLigadoB() == false){
            elevador.setIdElevador("A");
            System.out.printf("Atendimento Elevador: %s\n",elevador.getIdElevador());
        }

        if (elevador.isLigadoB() == true && elevador.isLigadoA() == false){
            elevador.setIdElevador("B");
            System.out.printf("Atendimento Elevador: %s\n",elevador.getIdElevador());

        }

        if (elevador.isLigadoA() == true && elevador.isLigadoB() == true){
            elevador.setIdElevador("A");
            System.out.printf("Atendimento Elevador: %s\n",elevador.getIdElevador());

        }





    }*/





   /* public static void solicitarElevador(){
        if (elevadores.isLigadoA() == false && elevadores.isLigadoB() == false){
            System.out.println("*******  ATENÇÃO *******");
            System.out.println("* Ligar Elevadores A/B *");
            System.out.println("************************");
            //System.out.println(elevador.isLigadoA() + "" + elevador.isLigadoB());
            return;
        }



        /*if (elevador.isLigadoA()==true){
            //System.out.println("Ligado");
        } else {
            System.out.println("************************");
            System.out.println("** Ligue  Elevador: A **");
            System.out.println("************************");
            return;
        }

        if (elevador.isLigadoB()==true){
            //System.out.println("Ligado");
        } else {
            System.out.println("************************");
            System.out.println("** Ligue  Elevador: B **");
            System.out.println("************************");
            return;
        }



        int andarDestino;
        int andarUsuario;
        System.out.println("|*****************|");
        System.out.println("|**** 10 ** 9 ****|");
        System.out.println("|****  8 ** 7 ****|");
        System.out.println("|****  6 ** 5 ****|");
        System.out.println("|****  4 ** 3 ****|");
        System.out.println("|****  2 ** 1 ****|");
        System.out.println("|**  0  Terreo  **|");
        System.out.println("|*****************|");
        System.out.print("Informe o andar que Você está: ");
        andarUsuario = sc.nextInt();


        System.out.println("|*****************|");
        System.out.println("|**** 10 ** 9 ****|");
        System.out.println("|****  8 ** 7 ****|");
        System.out.println("|****  6 ** 5 ****|");
        System.out.println("|****  4 ** 3 ****|");
        System.out.println("|****  2 ** 1 ****|");
        System.out.println("|**  0  Terreo  **|");
        System.out.println("|*****************|");
        System.out.print("Informe o andar Destino: ");
        andarDestino = sc.nextInt();

        calcularEsforcoA();


        elevadores.setAndarAtualA(andarDestino);
       //ativarPrioridade();


    }*/




}



