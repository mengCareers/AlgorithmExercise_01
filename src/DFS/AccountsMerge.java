/*721. Accounts Merge
Java DFS template for Connected Component
 * Find Connected Components,
 *   For each account, draw the edge from the first email to all other emails
 * Thought Process:
 * when do we merge accounts ? 
 * the 1st string equal + one of email addres equal
 * what is node in the graph ?
 * edge is the connection, node is the entity
 * edge if name equal, node is the email
 * smells like UF more
 */
package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class AccountsMerge {
    
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList(new String[]{"A", "a", "b"}));
        accounts.add(Arrays.asList(new String[]{"B", "e"}));
        accounts.add(Arrays.asList(new String[]{"A", "b", "d"}));
        accounts.add(Arrays.asList(new String[]{"C", "f"}));
        List<List<String>> res = accountsMerge(accounts);
        System.out.println(res);
    }
    
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>(); // to construct answer
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = "";
            
            for (int i = 0; i < account.size(); i++) {
                String email = account.get(i);
                if (i == 0) {
                    name = email;
                    continue;
                }
                if (i == 1) {
                    graph.computeIfAbsent(email, x -> new ArrayList<>());
                    emailToName.put(email, name);
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
                graph.get(account.get(1)).add(email);
                emailToName.put(email, name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                
                visited.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while (!stack.isEmpty()) {
                    String cur = stack.pop();
                    component.add(cur);
                    for (String nei : graph.get(cur)) {
                        
                        if (!visited.contains(nei)) {
                            stack.push(nei);
                            visited.add(nei);
                        }
                    }
                }
                
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                res.add(component);
            }
        }
        return res;
    }
    
}
