/* 458.Poor Pigs
N sources with exactly one of them sending bad signal
x receivers to detect which source is sending bad
a receiver can be configured to pick up signals from any number of sources
bad signal will permanently damage a receiver within minitesToDie minutes after received
output : minimum x if given minutesToTest minutes to test
GOT:
for one pig, # of tests allowed : 
    T = minutesToTest / minutesToDie
? how many states can we generate with x pigs and t T tests to cover N scenarios
    (T + 1)^x
aim to find minimum x such that (T + 1)^x >= N
    x = ceil(logN / log(T + 1))
 * GOT:
Explanations:
For one pig, it can make at most minutesToTest / minutesToDie tests.
And, there are most minutesToTest / minutesToDie + 1 states. (may die in each test or alive after all tests)
We assume there are n pigs, then there are (minutesToTest / minutesToDie + 1) ^ x states in total
We aim to find the minimum x such that (minutesToTest / minutesToDie + 1) ^ x >= buckets

Math related:
The change of base rule :
Java Math.log :
Math.log(double a) : return the natural logarithm (base e) of a double value.
 * 
 */
package Brainteaser;

import static java.lang.Math.ceil;
import static java.lang.Math.log;

/**
 *
 * @author xinrong
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {        
        return (int) ceil(log(buckets)/log(minutesToTest / minutesToDie + 1));
    }
}
