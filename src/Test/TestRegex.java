/*
 * Thought Process:
 * 
 */
package Test;

/**
 *
 * @author xinrong
 */
public class TestRegex {

    public static void main(String[] args) {
        String line = "\"MSA\",\"Akron, OH\",\"OH\",2.70160573734783,\"Akron, OH\",NA,NA";
        String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        for (String t : tokens) {
            System.out.println("> " + t);
        }
    }
}
