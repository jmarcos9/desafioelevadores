package segundoPeriodo.Elevadores;
import java.util.Scanner;

public class AppElevador {

    static Scanner sc = new Scanner(System.in);
    static Elevador elevador1 = new Elevador(1,false,false, 1);
    static Elevador elevador2 = new Elevador(2,false,false, 1);
    static byte opcao = 0;
    static int andarUsuario;
    static int andarDestino;

    static double esforcoB = 0;
    static double esforcoA = 0;

    public static void main(String[] args) throws InterruptedException {

        do {
            System.out.println("\nOpção: \n*** 1 - Ligar/Desligar Elevador: 1 \n*** 2 - Ligar/Desligar Elevador: 2" +
                    "\n*** 3 - Solicitar Elevador \n*** 4 - Status Elevador  ");
            System.out.print("Entre com a opção: ");
            opcao = sc.nextByte();

            switch (opcao){
                case 1:
                    ligarDesligarElevador1();
                    break;
                case 2:
                    ligarDesligarElevador2();
                    break;
                case 3:
                    solicitarElevador();
                    break;
                case 4:
                    statusElevador();
                    break;
                case 5:
                    definirElevadorPrioritario();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static void solicitarElevador(){
        elevador1.getAndarAtual();
        if (elevador1.isLigado() == false){
            elevador1.ligarDesligar();
        } else if (elevador1.isLigado() == true && elevador2.isLigado() == false){
            elevador2.ligarDesligar();
        }
        menu();
    }

    public static void menu(){


        do {
            //statusElevador();
            System.out.println();
            System.out.println("|*****************|\n|**** 10 ** 9 ****|\n|****  8 ** 7 ****|\n|****  6 ** 5 ****|");
            System.out.println("|****  4 ** 3 ****|\n|****  2 ** 1 ****|\n|*****************|");
            System.out.print("Informe o andar que Você está: ");
            andarUsuario = sc.nextInt();

            System.out.println("|*****************|\n|**** 10 ** 9 ****|\n|****  8 ** 7 ****|\n|****  6 ** 5 ****|");
            System.out.println("|****  4 ** 3 ****|\n|****  2 ** 1 ****|\n|*****************|");
            System.out.print("Informe o andar Destino: ");
            andarDestino = sc.nextInt();

            if (andarDestino == andarUsuario){
                System.out.println("Andar de Destino não pode ser o mesmo andar do Usuário!");
                return;
            }
            calcEsforco1();
            calcEsforco2();
            System.out.printf("ESFORÇO ELEVADOR: 1 %.2f  \nESFORÇO ELEVADOR: 2 %.2f \n", esforcoA, esforcoB);
            System.out.println();

            seletorAtendimento();

            System.out.println();
            return;
        }while (true);

    }

    public static boolean ligarDesligarElevador1(){

        if (elevador1.isLigado() == false) {
            System.out.printf("Elevador 1: Ligado - Andar atual: %dº \n",elevador1.getAndarAtual());
            elevador1.ligarDesligar();
        } else {
            elevador1.ligarDesligar();
            elevador1.setAndarAtual(1);
            System.out.printf("Elevador 1: Desligado - Andar atual: %dº \n",elevador1.getAndarAtual());
        }return true;

    }

    public static boolean ligarDesligarElevador2(){

        if (elevador2.isLigado() == false) {
            elevador2.ligarDesligar();
            System.out.printf("Elevador 2: Ligado - Andar atual: %dº \n",elevador2.getAndarAtual());
        } else {
            elevador2.ligarDesligar();
            elevador2.setAndarAtual(1);
            System.out.printf("Elevador 2: Desligado - Andar atual: %dº \n",elevador2.getAndarAtual());
        }return true;
    }

    public static void calcEsforco1(){
        esforcoA = elevador1.calcularEsforco(andarUsuario, andarDestino);
        //elevador1.setAndarAtual(andarDestino);
    }

    public static void calcEsforco2(){
        esforcoB = elevador2.calcularEsforco(andarUsuario, andarDestino);
    }

    public static void seletorAtendimento(){
        if (esforcoA <= esforcoB){
            elevador1.setAndarAtual(andarDestino);
            //elevador2.setAndarAtual(1);
            elevador2.ligarDesligar();
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: 1", andarUsuario, andarDestino);
        } else {
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: 2\n", andarUsuario, andarDestino);
            elevador2.setAndarAtual(andarDestino);
            ligarDesligarElevador1();
        }
    }

    public static void definirElevadorPrioritario() {
        if (elevador1.isLigado() == false || elevador2.isLigado() == false) {
            System.out.println("Para ativar a prioridade os dois Elevadores devem estar Ligados");
            return;
        }

        System.out.println("Ativar Prioridade: ");
        System.out.println("Digite 1 para Ativar Prioridade Elevador: 1");
        System.out.println("Digite 2 para Ativar Prioridade Elevador: 2");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            elevador1.ativarPrioridade();
            System.out.println("Elevador 1 - Prioritário");
            System.out.println();
            ligarDesligarElevador2();
        }
    }

    public static void statusElevador(){
        if (elevador1.isLigado()){
            System.out.printf("Elevador: 1 Ligado no %dº Andar: \n", elevador1.getAndarAtual());
        }

        if (elevador2.isLigado()){
            System.out.printf("Elevador: 2 Ligado no %dº andar: \n", elevador2.getAndarAtual());
        }
    }


}
