import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.security.SecureRandom;
import java.io.IOException;
import java.lang.Character;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int navbar = -1;
        boolean Valid;
        Date time = new Date();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(time);
        String hour = new SimpleDateFormat("HH:mm:ss").format(time);
        do{
            try{
                System.out.println(hour +" - "+ date);
                System.out.println("  ******************************* ");
                System.out.println("|       Menu LOTOFÁCIL!           |");
                System.out.println("|   1) Apostar de 0 a 100         |");
                System.out.println("|   2) Apostar de A à Z           |");
                System.out.println("|   3) Apostar em par ou ímpar    |");
                System.out.println("|   0) Sair                       |");
                System.out.println("  ******************************* ");
                navbar = Integer.parseInt(input.nextLine());
                switch (navbar){
                    case 1:
                        System.out.println("******** LotoFácil ********");
                        System.out.println("Faça sua aposta de 0 à 100:");
                        int rand = new SecureRandom().nextInt(101);
                        int value = Integer.parseInt(input.nextLine());
                        if (value >= 0 && value < 101) {
                            if (value == rand) {
                                System.out.println(rand);
                                System.out.println("Parabéns seu número foi sorteado, você ganhou R$ 1.000,00 reais!");
                            } else
                                System.out.println("Que pena! O número sorteado foi:" + rand);
                        } else
                            System.err.println("Aposta inválida!");
                        break;
                    case 2:
                        char let = 'M';
                        System.out.println("******** LotoFácil ********");
                        System.out.println(" Faça sua aposta de A à Z:");
                        Valid = false;
                        while(!Valid){
                            try{
                                char letter = (char) System.in.read();
                                if(Character.isLetter(letter)){
                                    letter = Character.toUpperCase(letter);
                                    System.out.println("Letra selecionada é: "+ letter);
                                    if (letter == let){
                                        System.out.println("Letra premiada: "+let);
                                        System.out.println("Parabéns você ganhou: R$ 500,00");
                                    }else
                                        System.out.println("Que pena! A letrada premiada é: "+let);
                                }else
                                    System.err.println("Aposta inválida!");
                                Valid = true;
                            }catch (IOException e){
                                System.err.println("Opção inválida: " + e.getMessage());
                                input.next();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("******** LotoFácil ********");
                        System.out.println("Aposte em pares ou ímpares: ");
                        Valid = false;
                        while(!Valid){
                            try{
                                int num = Integer.parseInt(input.nextLine());
                                if (num % 2 == 0){
                                    System.out.println("Parabéns você ganhou R$: 100,00");
                                }else
                                    System.out.println("Que pena! O número digitado é impares e a premiação foi para números pares.");
                            Valid = true;
                            }catch (Exception e){
                                System.err.println("Opção inválida: " + e.getMessage());
                                input.next();
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Programa Finalizado!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }catch (NumberFormatException e) {
                System.err.println("Opção inválida: "+ e.getMessage());
            }finally {
                if (navbar != 0) {
                    input.nextLine();
                }
            }
        }while(navbar !=0);
        input.close();
    }
}