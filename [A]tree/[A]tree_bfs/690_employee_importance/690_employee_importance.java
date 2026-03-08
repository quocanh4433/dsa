
import java.util.*;

@SuppressWarnings("unused")
class EmployeeImportance {
    /*
        time O(n)
        space O(n)
    */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(); // <id, Employee>

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int total = 0;

        while (!q.isEmpty()) {
            Employee e = map.get(q.poll());
            total += e.importance;
            for (Integer i : e.subordinates) {
                q.offer(i);
            }
        }

        return total;
    }
}

class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
};
