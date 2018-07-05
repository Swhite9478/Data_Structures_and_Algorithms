import static java.lang.System.out;

/**
 * Created by Stephen White on 11/3/2016.
 *
 * Goal: Time how long it takes to solve N values between 4-12
 *       100 times.
 *
 */
public class NQueensTimeTest {
    public static void main(String[] args) {
        // set up the solver that will be doing all of the work in this program
        NQueensSolver solver = new NQueensSolver();
        long startTimeMillis;
        long startTime;
        long endTime;
        long endTimeMillis;

        // time how long it takes to solve n=4 100 times
        out.print(" 4 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(4);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=5 100 times
        out.print(" 5 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(5);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=6 100 times
        out.print(" 6 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(6);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=7 100 times
        out.print(" 7 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(7);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=8 100 times
        out.print(" 8 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(8);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=9 100 times
        out.print(" 9 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(9);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=10 100 times
        out.print("10 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(10);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=11 100 times
        out.print("11 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(11);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

        // time how long it takes to solve n=12 100 times
        out.print("12 Queens 10 times: ");
        for(int i=0; i<10; i++) {
            //startTimeMillis = System.currentTimeMillis();
            startTime = System.nanoTime();
            for (int j = 0; j < 100; j++) {
                solver.nQueens(12);
            }
            endTime = System.nanoTime();
            //endTimeMillis = System.currentTimeMillis();
            out.print((endTime - startTime) +",");
        }
        out.println("\n");

    }
}
