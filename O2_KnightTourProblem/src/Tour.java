import java.util.LinkedList;
import java.util.Queue;

public class Tour {

    int n;
    int Free = 0;
    int jumpNumber =1;
//    int used = 2;
//    int route = 3;
    int B[][]; // Makes an empty board

    // Makes a chessboard with all free 
    public Tour(int n) {

        this.n = n;
        B = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = Free;
            }
        }
    }

    // Queue to hold the numbers
    Queue<Integer> jump = new LinkedList();

    boolean findRoute(int i, int j) {
        // Sett opp et sluttpunkt for brettet
        // n^2
        if (jumpNumber >= (n*n)) {
            B[i][j] = jumpNumber;
            return true;
        }

            B[i][j] = 0;

//        if (jumpNumber == 1) {
//            B[i][j] = 1;
//        }
//        else
//            B[i][j] = used;

        /*
        To opp, en høyre - DONE
        To høyre, en opp - DONE
        To høyre, en ned - DONE
        To ned, en høyre - DONE
        To ned, en venstre - DONE
        To venstre, en ned - DONE
        To venstre, en opp - DONE
        To opp, en venstre - DONE
        (-) er opp/bakover
         */

        int dI[] = { -2, -1, 1, 2,  2,  1, -1, -2 }; // Hvillen rad.
        int dJ[] = {  1,  2, 2, 1, -1, -2, -2, -1 }; // Hvilken kolonne

        for (int k = 0; k < 8; k++) {
            int newI = i + dI[k];
            int newJ = j + dJ[k];

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && B[newI][newJ] == Free) {
                B[i][j] = jumpNumber;
                jumpNumber++;
                if (findRoute(newI, newJ)) {
//                   B[i][j] = route;
                   return true;
                }
                jumpNumber--;
                B[i][j] = Free;
            }
        }
        return false;
    }

    public String toString() {
        String result = " ";
        int res;
        for (int i = 0; i < n; i++) {
            result += "\n";
            for (int j = 0; j < n; j++) {
/*
                if (B[i][j] == route) {
                    result += B[i][j] + " ";
                }
                else
*/
                  result += B[i][j] + " ";
            }
        }
        return result;
    }
}
