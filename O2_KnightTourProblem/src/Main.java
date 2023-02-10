import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Keep the number below 7 if you want it to be done today.");
        System.out.println("How large should the board be (n)? ");
        int n = scanner.nextInt();
         */
        int n = 5;
        Tour tour = new Tour(n);

/*
        Random R = new Random();
        int i = R.nextInt(n);
        int j = R.nextInt(n);
*/

        boolean start = tour.findRoute(2, 2);

        System.out.println(tour);
        if (!start)
            System.out.println("Error in the code");

    }
}