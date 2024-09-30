import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int inp = 0;
        while (inp != 2){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose your level:\n\t0 - [0, 100], 7 tries\n\t[0, 1000], 10 tries\n\t2 = exit");
            inp = sc.nextInt();
            if (inp == 0){
                mainGame(0, 100, 7);
            }else if(inp == 1){
                mainGame(0, 1000, 10);
            }
        }
    }
    static void mainGame(int min, int max, int att){
        int move, res, corr;
        boolean won = false;
        System.out.println("You're playing on [" + min + ", " + max + "] difficulty with " + att + " attempts");
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        corr = abs(rnd.nextInt()) % max;
        while (att > 0){
            move = sc.nextInt();
            res = makeMove(move, corr);
            if (res == 0){
                won = true;
                break;
            }
            att--;
            System.out.println("You have " + att + " tries left!");
        }
        if (!won) {
            System.out.println("You lost!");
        }
    }
    static int makeMove(int move, int corr){
        if(move > corr){
            System.out.println("Number i guessed is less!");
            return 1;
        } else if (move < corr){
            System.out.println("Number i guessed is greater!");
            return -1;
        } else {
            System.out.println("You won!");
            return 0;
        }
    }
}