import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        int sumh1 = 0;
        int h1size = 0;
        for (int i=0; i<h1.size(); i++) {
            sumh1 += h1.get(i);
        }
        
        int sumh2 = 0;
        int h2size = 0;
        for (int i=0; i<h2.size(); i++) {
            sumh2 += h2.get(i);
        }
        
        int sumh3 = 0;
        int h3size = 0;
        for (int i=0; i<h3.size(); i++) {
            sumh3 += h3.get(i);
        }
        
        while (sumh1 > 0 && sumh2 > 0 && sumh3 > 0) {
            if  (sumh1 == sumh2 && sumh2 == sumh3) {
                return sumh1;
            }
            int minH = Math.min(Math.min(sumh1,sumh2),sumh3);
            while (sumh1 > minH && h1size < h1.size()) {
                sumh1 -= h1.get(h1size);
                h1size++;
            }  
            while (sumh2 > minH && h2size < h2.size()) {
                sumh2 -= h2.get(h2size);
                h2size++;
            }  
            while (sumh3 > minH && h3size < h3.size()) {
                sumh3 -= h3.get(h3size);
                h3size++;
            }   
            
        }
        if  (sumh1 == sumh2 && sumh2 == sumh3) {
            return sumh1;
        }
        return 0;
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
