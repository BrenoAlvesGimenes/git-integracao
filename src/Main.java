import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean jogofinalizado = false;
        int pontos = 0;
        int cartas = 0;
        int totalcartas = 5;
        int tentativas = 7;

        while (true) {
            System.out.println("\n[1] Acerte o número aleatório");
            System.out.println("[2] Mostrar pontos");
            System.out.println("[3] 21");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            int escolhaJogo = scan.nextInt();

            while (tentativas > -1) {
                if (escolhaJogo == 1) {  // jogo número aleatório
                    int jogo = (int) (Math.random() * 100);
                    System.out.print("Digite um número entre 0 a 100: ");
                    int pergunta = scan.nextInt();

                    if (pergunta == jogo) {
                        System.out.println("Parabéns! Você ganhou, o número era " + jogo);
                        tentativas = 7;
                        pontos++;
                        break;
                    }

                    if (tentativas == 0) {
                        System.out.println("Que pena, você perdeu, o número era " + jogo);
                        tentativas = 7;
                        break;
                    }

                    if (jogo > pergunta) {
                        System.out.println("O número é maior que " + pergunta);
                        tentativas--;
                    }

                    if (jogo < pergunta) {
                        System.out.println("O número é menor que " + pergunta);
                        tentativas--;
                    }
                } // jogo número aleatório

                if (escolhaJogo == 2) { // pontos
                    System.out.println("Você tem o total de " + pontos + " pontos");
                    break;
                } // pontos

                if (escolhaJogo == 3) { // 21
                    if (jogofinalizado == false) {
                        System.out.print("Começar o jogo? (Sim) (Não): ");
                        String pergunta = scan.nextLine();

                        if (pergunta.equalsIgnoreCase("sim")) {
                            while (totalcartas > 0 && jogofinalizado == false) {
                                int jogo = (int) (Math.random() * 10);
                                System.out.println("Total de cartas: " + totalcartas + " (se chegar a 0 o jogo acaba)");
                                System.out.print("Receber carta? : ");
                                String pergunta2 = scan.nextLine();
                                cartas += jogo;
                                totalcartas--;


                                if (pergunta2.equalsIgnoreCase("nao")) {
                                    if (cartas > 21) {
                                        System.out.print("O total de número das cartas é de " + cartas + ". Você perdeu, que pena ");
                                        jogofinalizado = true;
                                        break;
                                    } else {
                                        System.out.print("O total de número das cartas é de " + cartas + ". Parabéns, você ganhou!");
                                        pontos++;
                                        jogofinalizado = true;
                                        break;
                                    }
                                }
                            }
                        }

                        if (pergunta.equalsIgnoreCase("Não")) {
                            System.out.print("Saindo...");
                            jogofinalizado = true;
                            break;
                        }

                        if (totalcartas == 0 && cartas > 21) {
                            System.out.println("Você ultrapassou o número 21, que pena!");
                            jogofinalizado = true;
                            break;
                        } else if (totalcartas == 0 && cartas < 21) {
                            System.out.println("Parabéns! Você conseguiu " + cartas + "! Você ganhou!");
                            jogofinalizado = true;
                            pontos++;
                            break;
                        } if (jogofinalizado == true && cartas == 0) {
                            System.out.println("Você não pegou nenhuma carta, você se acha o esperto é?");
                        }
                    }
                } jogofinalizado = false; // 21

                if (escolhaJogo == 4) {
                    return;
                }
            }
        }
    }
}
