import static java.lang.System.out;

/**
 * Created by Stephen White on 11/2/2016.
 *
 * Goal: To be able to solve an nQueens problem with 4-12 queens
 *
 */
public class NQueensSolver implements INQueensSolver {

    @Override
    public boolean[][] nQueens(int n) {
        return nQueensRecursive(n, new boolean[n][n], 0, 0);
    }

    @Override
    public boolean[][] nQueensRecursive(int n, boolean[][] prior, int column, int row) {
        int count = 0; // keep track of the number of queens are in the array

        // increment the count based on how many queens are present in prior
        for (int rowVal = 0; rowVal < n; rowVal++) {
            for (int colVal = 0; colVal < n; colVal++) {
                if (prior[colVal][rowVal]) count++; // if there is a queen here, increment count
            }
        }

        // BASE CASE: is the board solved?
        // it will be if n and count are the same
        if (n == count) return prior;

        count = 0; // reset count to check for any queens already present in each column
        // check for any queens already present in each column
        for(int i=0; i<n; i++){
            if(prior[column][i]) count++;
        }

        // create a checkpoint that can be utilized for backtracking
        // this is a "working copy" of the array that we can mess with
        boolean[][] checkPoint = new boolean[n][n];

        // put all of the items that are in prior into this working copy
        for(int rowVal=0; rowVal<n; rowVal++){
            for(int colVal=0; colVal<n; colVal++){
                checkPoint[colVal][rowVal] = prior[colVal][rowVal]; // set the proper values
            }
        }

        // if there is already a queen present, call the recursive method accordingly starting
        // in the next column
        if(count == 1){
            // overwrite our checkpoint with the recursive call
            checkPoint = nQueensRecursive(n, prior, column+1, 0);
            if(checkPoint != null) return checkPoint; // if there were no problems, we have the solution!
        }

        // fun work step coming up!
        // Loop through the number of rows in this column
        for(int i=0; i<n; i++){
            // check if we can place a queen at this very spot within the column
            if(isSafe(column,i,prior)){
                // reset checkpoint for each loop
                checkPoint = new boolean[n][n];

                // put items in checkpoint
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        checkPoint[y][x] = prior[y][x];
                    }
                }

                checkPoint[column][i] = true; // place the queen
                // set this checkpoint to a recursive call to to the solver
                checkPoint = nQueensRecursive(n, checkPoint, column+1, 0);
                if(checkPoint != null) return checkPoint; // if there were no problems, return the answer
            }
        }
        // take care of the situation in which there was no solution found and return null
        return null;
    }


    public void printArray(boolean[][] array) {

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[j][i]) {
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // HELPER METHODS TO THE RESCUE!!!!

    // check to see if a queen can be placed in a certain spot
    public boolean isSafe(int col, int row, boolean[][] prior){
        // check row
        if (!checkRow(col, row, prior)) return false;

        //check column
        if (!checkColumn(col, row, prior)) return false;

        //check diagonals
        if (!checkAllDiags(col, row, prior)) return false;

        return true;
    }

    // HELPER HELPER METHODS TO THE RESCUE-MORE!
    public boolean checkRow(int col, int row, boolean[][] prior){
        try{
            // check all values to the right of what was entered
            for (int colVal = col; colVal<prior.length ; colVal++ ){
                if(prior[colVal][row] == true){
                    return false;
                }
            }
            // check all values to the left of what was entered
            for (int colVal = col; colVal>=0; colVal-- ){
                if(prior[colVal][row] == true){
                    return false;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return true;
    }

    public boolean checkColumn(int col, int row, boolean[][] prior){
        try{
            // check all values to the bottom of what was entered
            for (int rowVal = row; rowVal<prior[0].length ; rowVal++ ){
                if(prior[col][rowVal] == true){
                    return false;
                }
            }
            // check all values to the top of what was entered
            for (int rowVal = row; rowVal>=0; rowVal-- ){
                if(prior[col][rowVal] == true){
                    return false;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return true;
    }

    public boolean checkAllDiags(int col, int row, boolean[][] prior){
        try{
            if (!checkUpperLeftDiag(col, row, prior)) return false;
            if (!checkUpperRightDiag(col, row, prior)) return false;
            if (!checkLowerLeftDiag(col, row, prior)) return false;
            if (!checkLowerRightDiag(col, row, prior)) return false;

        }
        catch (ArrayIndexOutOfBoundsException e){}
        return  true;
    }

    public boolean checkUpperLeftDiag(int col, int row, boolean[][] prior){
        try{
            int colTracker = col;
            int rowTracker = row;
            for(int colVal = col; colVal>=0; col--){
                if(prior[colTracker][rowTracker] == true) return false;
                colTracker-=1;
                rowTracker-=1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return true;
    }

    public boolean checkUpperRightDiag(int col, int row, boolean[][] prior){
        try {
            int colTracker = col;
            int rowTracker = row;
            for (int colVal = col; colVal < prior.length; col++) {
                if (prior[colTracker][rowTracker] == true) return false;
                colTracker += 1;
                rowTracker -= 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return  true;
    }

    public boolean checkLowerLeftDiag(int col, int row, boolean[][] prior){
        try{
            int colTracker = col;
            int rowTracker = row;
            for (int colVal = col; colVal >= 0; col--) {
                if (prior[colTracker][rowTracker] == true) return false;
                colTracker -= 1;
                rowTracker += 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return true;
    }

    public boolean checkLowerRightDiag(int col, int row, boolean[][] prior){
        try{
            int colTracker = col;
            int rowTracker = row;
            for (int colVal = col; colVal < prior.length; col++) {
                if (prior[colTracker][rowTracker] == true) return false;
                colTracker += 1;
                rowTracker += 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
        return true;
    }

    // Main method for testing
    public static void main(String[] args){
        NQueensSolver solver = new NQueensSolver();
        boolean[][] arr = new boolean[5][5];
        //arr[0][0] = true;
        boolean[][] solvedProblem = solver.nQueens(4);

        out.println("\t  0\t\t  1\t\t  2\t\t  3");
        /*for(int i = 0; i<4; i++)
        { System.out.print(i);
            for(int j = 0; j<4; j++)
            {
                System.out.print("\t" + solvedProblem[j][i] + " ");
            }
            System.out.println();
        }*/
        out.println("\nBelow is the boolean array converted into the actual solution");
        solver.printArray(solvedProblem);
    }
}
