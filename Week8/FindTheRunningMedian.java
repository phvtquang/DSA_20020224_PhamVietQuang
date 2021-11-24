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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
     
    public static void addNumber(int number, PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ) {
        if (maxPQ.size() == 0 || number < (int)maxPQ.peek()) {
            maxPQ.add(number);
        } else {
            minPQ.add(number);
        }
    }
    
    public static void rebalance(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ) {
        PriorityQueue biggerPQ = maxPQ.size() > minPQ.size() ? maxPQ : minPQ;
        PriorityQueue smallerPQ = maxPQ.size() > minPQ.size() ? minPQ : maxPQ;
        if(biggerPQ.size() - smallerPQ.size() >= 2) {
            smallerPQ.add(biggerPQ.poll());
        }
    }
    
    public static double getMedian(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ) {
        PriorityQueue biggerPQ = maxPQ.size() > minPQ.size() ? maxPQ : minPQ;
        PriorityQueue smallerPQ = maxPQ.size() > minPQ.size() ? minPQ : maxPQ;
        if (biggerPQ.size() == smallerPQ.size()) {
            return ((int)biggerPQ.peek()+(int)smallerPQ.peek())/2.0;
        } else
        {
            return (int)biggerPQ.peek();
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        
        List<Double> res = new ArrayList<>();
    
        int  N = a.size();
        PriorityQueue<Integer> maxPQ = new PriorityQueue(N/2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue(N/2 + 1);
        for(int i=0; i<N; i++) {
            addNumber(a.get(i),maxPQ,minPQ);
            rebalance(maxPQ,minPQ);
            res.add(getMedian(maxPQ,minPQ));
        } 
        return res;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
