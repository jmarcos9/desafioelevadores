package segundoPeriodo.Elevadores;
import java.util.Scanner;

public class AppElevador {

    static Scanner sc = new Scanner(System.in);
    static Elevadores elevadorA = new Elevadores(0, 1, false);
    static Elevadores elevadorB = new Elevadores(0, 2, false);
    static byte opcao = 0;
    static int andarUsuario;
    static int andarDestino;

    static double esforcoB = 0;
    static double esforcoA = 0;

    public static void main(String[] args) throws InterruptedException {

        do {
            System.out.println("\nOpção: \n*** 1 - Ligar/Desligar Elevador: A \n*** 2 - Ligar/Desligar Elevador: B" +
                    "\n*** 3 - Solicitar Elevador \n*** 4 - Status Elevador  ");
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
                    statusElevadores();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static boolean ligarDesligarElevadorA(){
        if (elevadorA.isLigadoA() == false) {
            System.out.println("Elevador A: Ligado");
            elevadorA.ligarDesligarA();
            System.out.printf("Andar atual: %d - Terreo\n",elevadorA.getAndarAtual());
        } else {
            elevadorA.ligarDesligarA();
            elevadorA.setAndarAtual(0);
            System.out.printf("Andar atual A: %d - Terreo\n",elevadorA.getAndarAtual());
            System.out.println("Elevador A: Desligado");
        }return true;
    }

    public static boolean ligarDesligarElevadorB(){
        if (elevadorA.isLigadoA() == false){
            System.out.println("Elevador: (A) Deve ser ligado Primeiro");
            return true;
        }

        if (elevadorB.isLigadoB() == false) {
            System.out.println("Elevador B: Ligado");
            elevadorB.ligarDesligarB();
            System.out.printf("Andar atual B: %d - Terreo\n",elevadorB.getAndarAtual());
        } else {
            elevadorB.ligarDesligarB();
            System.out.println("Elevador B: Desligado");
        }return true;
    }

    public static void solicitarElevador(){
        elevadorA.getAndarAtual();
        if (elevadorA.isLigadoA() == false){
            elevadorA.ligarA();
        } else if (elevadorA.isLigadoA() == true && elevadorB.isLigadoB() == false){
            elevadorB.ligarB();
        }
        menu();
    }

    public static void menu(){
        do {
            statusElevadores();
            System.out.println();
            System.out.println("|*****************|\n|**** 10 ** 9 ****|\n|****  8 ** 7 ****|\n|****  6 ** 5 ****|");
            System.out.println("|****  4 ** 3 ****|\n|****  2 ** 1 ****|\n|**  0  Terreo  **|\n|*****************|");
            System.out.print("Informe o andar que Você está: ");
            andarUsuario = sc.nextInt();

            System.out.println("|*****************|\n|**** 10 ** 9 ****|\n|****  8 ** 7 ****|\n|****  6 ** 5 ****|");
            System.out.println("|****  4 ** 3 ****|\n|****  2 ** 1 ****|\n|**  0  Terreo  **|\n|*****************|");
            System.out.print("Informe o andar Destino: ");
            andarDestino = sc.nextInt();

            if (andarDestino == andarUsuario){
                System.out.println("Andar de Destino não pode ser o mesmo andar do Usuário!");
                return;
            }
            calcEsforcoA();
            calcEsforcoB();
            System.out.printf("ESFORÇO ELEVADOR: A %.2f  \nESFORÇO ELEVADOR: B %.2f \n", esforcoA, esforcoB);
            System.out.println();
            seletorAtendimento();
            System.out.println();
            return;
        }while (true);

    }

    public static void calcEsforcoA(){
        esforcoA = elevadorA.calcularEsforco(andarUsuario, andarDestino);
        elevadorA.setAndarAtual(andarDestino);
    }

    public static void calcEsforcoB(){
        esforcoB = elevadorB.calcularEsforco(andarUsuario, andarDestino);
    }

    public static void seletorAtendimento(){
        if (esforcoA <= esforcoB){
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: A", andarUsuario, andarDestino);
            elevadorA.setAndarAtual(andarDestino);
            elevadorB.setAndarAtual(0);
            elevadorB.desligarB();
        } else {
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: B", andarUsuario, andarDestino);
            elevadorB.setAndarAtual(andarDestino);
            elevadorA.setAndarAtual(0);
            elevadorA.desligarA();
        }
    }

    public static void statusElevadores(){
        if (elevadorA.isLigadoA() == true ){
            System.out.printf("Elevador: A Ligado no %dº Andar: \n", elevadorA.getAndarAtual());
        }

        if (elevadorB.isLigadoB() == true){
            System.out.printf("Elevador: B Ligado no %dº andar: \n", elevadorB.getAndarAtual());
        }

        if (elevadorA.isLigadoA() == false ){
            System.out.printf("Elevador: A Desligado no %dº Andar: \n", elevadorA.getAndarAtual());
        }
        if (elevadorB.isLigadoB() == false){
            System.out.printf("Elevador: B Desligado no %dº Andar: \n", elevadorB.getAndarAtual());
        }
    }

}
