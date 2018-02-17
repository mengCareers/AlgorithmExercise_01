/* 690. Employee Importance
input : List<Employee> employees, int id
output: employee id 's total importance value
 * Thought Process:
v : employee
e : importance
 * Get :
list can only get element by idx
we can help search with a map
 */
package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class EmployeeImportance {

    Map<Integer, Integer> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, i);
        }
        Queue<Integer> pending = new LinkedList<>();
        pending.add(id);
        int res = 0;
        while (!pending.isEmpty()) {
            int t = pending.poll();
            Employee e = employees.get(map.get(t));
            res += e.importance;
            for (int s : e.subordinates) {
                pending.add(s);
            }

        }
        return res;
    }
}

class Employee {

    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
