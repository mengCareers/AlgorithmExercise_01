package Greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 *  Q:
n activities with start and finish, select max # of activities that can be performed by a single person
 *  Thought Process: 
always pick nxt act whose finish is least among remaining & start >= prev's finish.
 *  Get:
Greedy more efficient
 */

/**
 *
 * @author xinrong
 */
class Act {
    int start;
    int end;
    Act() {}
    Act(int s, int e) {
        start = s;
        end = e;
    }
}
public class ActivitySelectionProblem {
    public List<Act> printMaxAct(Act[] acts) {
        List<Act> res = new ArrayList<>();
        Arrays.sort(acts, new Comparator<Act>(){
            @Override
            public int compare(Act a, Act b) {
                if (a.end != b.end) return a.end - b.end;
                else                return a.start - b.start; 
            }
        });
        res.add(acts[0]);
        for (int i = 1; i < acts.length; i++) {
            if (acts[i].start >= res.get(res.size() - 1).end) res.add(acts[i]);
            /**
             * Wrong: Not compare with prev act BUT prev selected act
             */
        }
        return res;
    }
    public static void main(String[] args) {
        Act a1 = new Act(1, 2);
        Act a2 = new Act(3, 4);
        Act a3 = new Act(0, 6);
        Act a4 = new Act(5, 7);
        Act a5 = new Act(8, 9);
        Act a6 = new Act(5, 9);
        Act[] acts = {a1, a2, a3, a4, a5, a6};
        List<Act> res = new ActivitySelectionProblem().printMaxAct(acts);
        for (Act act : res) System.out.println(act.start + " " + act.end);
    }
}
