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
                    "\n*** 3 - Ativar/Desativar Prioridade \n*** 4 - Solicitar Elevador " +
                    "\n*** 5 - Status Elevador \n*** 0 - Sair  ");
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
                    seletorPrioridade();
                    break;
                case 4:
                    solicitarElevador();
                    break;
                case 5:
                    statusElevador();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static void solicitarElevador(){

        if (elevador1.isLigado() ==  false && elevador2.isLigado() == false){
            System.out.println("Pelo menos um elevador deve estar ligado!");
            return;
        }
        statusElevador();

        do {
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
            System.out.printf("ESFORÇO ELEVADOR: (1) %.2f  \nESFORÇO ELEVADOR: (2) %.2f \n", esforcoA, esforcoB);
            System.out.println();

            seletorAtendimento();

            System.out.println();
            return;
        }while (true);
    }

    public static void ligarDesligarElevador1(){
        do {
            try {
                System.out.print("(1) Liga / (2) Desliga: ");
                opcao = sc.nextByte();
                break;
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
                sc.next();
                break;
            }
        } while (true);

        if (opcao == 1){
            if (elevador1.isLigado() == true){
                System.out.println("Elevador já está Ligado!");
                return;
            }

            if (elevador2.isLigado()==true){
                elevador1.setPrioritario(false);
            } else {
                elevador1.setPrioritario(true);
            }
            elevador1.setLigado(true);
            System.out.println("Elevador (1) - Ligado");
        } else if (opcao == 2){
            if (elevador1.isLigado() == false){
                System.out.println("Elevador não está ligado!");
                return;
            }
            elevador1.setLigado(false);
            System.out.println("Elevador (1) - Desligado");
        }
    }

    public static void ligarDesligarElevador2(){
        do {
            try {
                System.out.print("(1) Liga / (2) - Desliga: ");
                opcao = sc.nextByte();
                break;
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
                sc.next();
                break;
            }
        } while (true);

        if (opcao == 1){
            if (elevador2.isLigado() == true){
                System.out.println("Elevador já está Ligado");
                return;
            }
            if (elevador1.isLigado()==true){
                elevador2.setPrioritario(false);
            } else {
                elevador2.setPrioritario(true);
            }
            elevador2.setLigado(true);
            System.out.println("Elevador (2) - Ligado");
        } else if (opcao == 2){
            if (elevador2.isLigado() == false){
                System.out.println("Elevador não está ligado!");
                return;
            }
            elevador2.setLigado(false);
            System.out.println("Elevador (2) - Desligado");
        }
    }

    public static void seletorPrioridade(){

        do {
            try {
                System.out.println("Seletor de Prioridade:\n(1) - Para ativar prioridade para elevador 1: " +
                        "\n(2) - Para ativar prioridade para elevador 2: \n(3) - Para desativar prioridade elevador 1:" +
                        "\n(4) - Para desativar prioridade elevador 2:");
                System.out.print("Opção: ");
                opcao = sc.nextByte();
                break;
            } catch (Exception e) {
                System.out.println("Digite apenas números");
                sc.next();
                break;
            }
        } while (true);

        if (opcao == 1){
            if (elevador2.isPrioritario() == true){
                System.out.println("Elevador: (2) Já está ativado como prioritário!");
                return;
            }
            if (elevador1.isPrioritario() == true){
                System.out.println("Elevador está ativado como prioritário!");
                return;
            }
            elevador1.setPrioritario(true);
            elevador2.setPrioritario(false);
            elevador2.setLigado(false);
            System.out.println("Prioridade ativada para Elevador: (1)");
        } else if (opcao == 2){
            if (elevador1.isPrioritario() == true){
                System.out.println("Elevador: (1) está ativado como prioritário!");
                return;
            }
            if (elevador2.isPrioritario() == true){
                System.out.println("Elevador está ativado como prioritário!");
                return;
            }
            elevador2.setPrioritario(true);
            elevador1.setPrioritario(false);
            elevador1.setLigado(false);

            System.out.println("Prioridade ativada para Elevador: (2)");
        } else if (opcao == 3){
            if (elevador1.isPrioritario() == false){
                System.out.println("Prioridade não ativada para elevador: (1)");
                return;
            }
            elevador1.setPrioritario(false);
            System.out.println("Prioridade desativada para elevador: (1)");
        } else if (opcao == 4){
            if (elevador2.isPrioritario() == false){
                System.out.println("Prioridade não ativada para elevador: (2)");
                return;
            }
            elevador2.setPrioritario(false);
            System.out.println("Prioridade desativada para elevador: (2)");
        }
    }

    public static void calcEsforco1(){
        esforcoA = elevador1.calcularEsforco(andarUsuario, andarDestino);
    }

    public static void calcEsforco2(){
        esforcoB = elevador2.calcularEsforco(andarUsuario, andarDestino);
    }

    public static void seletorAtendimento(){
        if (esforcoA <= esforcoB){
            elevador1.setAndarAtual(andarDestino);
            elevador1.setLigado(true);
            elevador1.setPrioritario(true);
            elevador2.setLigado(false);
            elevador2.setPrioritario(false);
            elevador2.setAndarAtual(1);
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: (1)", andarUsuario, andarDestino);
        } else {
            elevador2.setLigado(true);
            elevador2.setAndarAtual(andarDestino);
            elevador2.setPrioritario(true);
            elevador1.setLigado(false);
            elevador1.setPrioritario(false);
            elevador1.setAndarAtual(1);
            System.out.printf("Andar de Solicitação: %dº, Andar de Destino %dº, Elevador: (2)\n", andarUsuario, andarDestino);
        }
    }

    public static void statusElevador(){
        if (elevador1.isLigado() == true){
            System.out.printf("Elevador: (1) Ligado no %dº Andar: \n", elevador1.getAndarAtual());
        } else {
            System.out.printf("Elevador: (1) Desligado no %dº Andar: \n", elevador1.getAndarAtual());
        }

        if (elevador2.isLigado() == true){
            System.out.printf("Elevador: (2) Ligado no %dº Andar: \n", elevador2.getAndarAtual());
        } else {
            System.out.printf("Elevador: (2) Desligado no %dº Andar: \n", elevador2.getAndarAtual());
        }

        if (elevador1.isPrioritario() == true){
            System.out.println("Elevador: (1) - Definido como Prioritário");
        } else if (elevador2.isPrioritario() == true){
            System.out.println("Elevador: (2) - Definido como Prioritário");
        } else {
            System.out.println("Não há elevador ativado como Prioritpario");
        }
    }
}
