package generalPOJO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmployeeUtility {

    //Serialization of ArrayList of Employee objects
    public boolean addEmployee(String fileName, ArrayList<Employee> employeeList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fileName);

            oos = new ObjectOutputStream(fos);

            oos.writeObject(employeeList);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    // De-Serialization of ArrayList of Employee objects and return matched EMployee Object
    public Employee viewEmployeeById(String fileName, int employeeId) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        ArrayList<Employee> listOfEmployees = null;
        Employee emp = null;

        try {

            fis = new FileInputStream(fileName);

            ois = new ObjectInputStream(fis);

            listOfEmployees = (ArrayList<Employee>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (Employee empLocal : listOfEmployees) {
            if (empLocal.getEmployeeId() == employeeId) {
                return empLocal;
            }
        }
        return emp;

    }
}

