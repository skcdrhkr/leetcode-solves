package graphs;

import java.util.ArrayList;
import java.util.List;

public class OrgModification {
    static class Employee {
        public int employeeId;
        public boolean isEngineer;
        public List<Employee> reportees;
    }

    public Employee modifyOrg(Employee root) {
        List<Employee> reportees = root.reportees;
        List<Employee> newReportees = new ArrayList<>();
        for(Employee reportee: reportees) {
            Employee down = modifyOrg(reportee);
        }
        if(root.isEngineer) {
            return root;
        }
        return root;
    }

}
