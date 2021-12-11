import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    static ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>();
    public static void intializeVisited(int maxRow, int maxCol) {
        for(int i=0; i < maxRow; i++) {
            visited.add(new ArrayList<Boolean>());
            for (int j=0;  j < maxCol; j++) {
                //visited.get(i).add(new ArrayList<Boolean>());
                visited.get(i).add(false);
                visited.get(i).set(j, false);
            }
        }
    }
     
    public static int countConnected(List<List<Integer>> matrix ,int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.size() || col >= matrix.get(0).size()) {
            return 0;
        }
        if (matrix.get(row).get(col) == 0) {
            return 0;
        }
        if (visited.get(row).get(col) == true) {
            return 0;
        }
        int count = 1;
        visited.get(row).set(col, true);
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++){
                    count += countConnected(matrix, row+i,col+j);
            }
        }
        return count;
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        intializeVisited( matrix.size(),  matrix.get(0).size());
        int res = -1;
        for (int i=0; i < matrix.size(); i++) {
            for (int j=0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1 && visited.get(i).get(j) == false) {
                    int s = countConnected(matrix, i, j);
                    res = Math.max(res,s);
                }
            }
            System.out.println();
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
