/* 207. Course Schedule
e.g. prerequisites[0] = [i,j], take j then i
coursenum are consecutive from 0..numCourses - 1
output : true if can finish all courses
 * Thought Process:
if DAG, can finish all courses, true
how to check if DAG ? if topo, DAG 
        // construct graph - adj list
v : course
e : requisites
indeg
outlst
        // topo
 * 
 */
package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class CourseSchedule {
    
    List<List<Integer>> outlsts;
    int[] indeg; // indeg[i] : i 's indegree
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        outlsts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            outlsts.add(new ArrayList<>());
        indeg = new int[numCourses];
        
        // construct graph
        buildGraph(prerequisites);
        
        // topo
        Set<Integer> res = topoSort(indeg, outlsts);
        
        return res.size() == numCourses;
    }    
    
    // bfs
    private Set<Integer> topoSort(int[] indeg, List<List<Integer>> outlsts) {
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cn = q.poll();
            for (int course : outlsts.get(cn)) {
                indeg[course]--;
                if (indeg[course] == 0)
                    q.add(course);
            }
            res.add(cn);
        }
        return res;
    }
    
    private void buildGraph(int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            int l = pre[0];
            indeg[l]++;
            int f = pre[1];
            outlsts.get(f).add(l);
        }
    }
    
}
