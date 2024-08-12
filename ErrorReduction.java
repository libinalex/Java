

import java.util.*;


public class ErrorReduction {

    static class Employee {
        int error;
        int index;

        Employee(int error, int index) {
            this.error = error;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] errorScore = { 4, 4, 2, 5, 3 };
        int P = 2;
        int Q = 1;

        System.out.println(minProjects(n, errorScore, P, Q));
    }

    public static int minProjects(int n, int[] errorScore, int P, int Q) {
        int projects = 0;
        PriorityQueue<Employee> pq = new PriorityQueue<>(new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.error - e1.error;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Employee(errorScore[i], i));
        }

        while (!pq.isEmpty() && pq.peek().error > 0) {
            Employee e = pq.poll();
            e.error -= P;

            for (Employee emp : pq) {
                emp.error -= Q;
            }

            PriorityQueue<Employee> newPq = new PriorityQueue<>(new Comparator<Employee>() {
                public int compare(Employee e1, Employee e2) {
                    return e2.error - e1.error;
                }
            });

            for (Employee emp : pq) {
                if (emp.error > 0) {
                    newPq.add(emp);
                }
            }

            if (e.error > 0) {
                newPq.add(e);
            }

            pq = newPq;
            projects++;
        }

        return projects;
    }
}