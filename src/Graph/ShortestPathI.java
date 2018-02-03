/*
 * Get :
 * paths : G = (V, E)
   edge weights func w()
   path p = v1 -> v2 -> v3
        has weight w(p) = ..
   Shortest path: from u to v
        a pth of min weight
 * Shortest path weight
    from u to v is 
        min(w(p) : all paths from u to v)
 * Shortest path Not Exist
    + Negative edge weights
    some shortest paths may not exist
    when weight minus cycle exist
    + No path from u to v
 * by Dynamic Programming
check optimal substructure first:
    a subpath of a shortest path is a shortest path
    proof: cut & paste (if or else exist..., contradiction)
 * Triangle inequality: 
*/
package Graph;

/**
 *
 * @author xinrong
 */
public class ShortestPathI {
    
}
