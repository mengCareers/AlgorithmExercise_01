/* recursive
 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class BinaryRepresentationofNum {
    public static void main(String[] args) {
        new BinaryRepresentationofNum().toBinary(10);
    }
    public void toBinary(int n) {
        if (n > 1)
            toBinary(n / 2);
        System.out.println(n % 2);
    }
}
 