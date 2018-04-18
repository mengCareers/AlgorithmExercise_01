/*
Given a rectangular on a 2D coordinate, write a function to return (x, y) pair so that the distribution of the return value is uniform within the rectangular.
Followup 1: What if you are given multiple non-overlapping rectangular areas? How to generate uniformly distributed (x, y) pair?
Followup 2: What if you are given an arbitrary shaped area?
 * Thought Process:
Within the same equality of opportunity, we divide into small parts and pick sample.
That is, sample the x coordinate and the y coordinate.
Mention that rectangle might not be alighned along the axes, we need transformation.
Followup 1: randomly choose one of the rectangle (probability is proportional to its area)
            use the previous function
Followup 2: find the mininmal rectangle or circle that covers the shape given and then randomly sample,
            discard points that are not lying inside the shape
 * 
 */
package RandomAlgo;

/**
 *
 * @author xinrong
 */
public class GenerateRandomXYwithinArea {
    
}
