package generalPOJO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Employee implements Serializable {

    private int employeeId;
    private String name;
    private float appraisalRating;

    public Employee(int employeeId, String name, float appraisalRating) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.appraisalRating = appraisalRating;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", appraisalRating=" + appraisalRating + "]";
    }

}

