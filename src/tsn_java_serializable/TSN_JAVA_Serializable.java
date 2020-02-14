package tsn_java_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TSN_JAVA_Serializable {

    public static void main(String[] args) {
        Employee[] staff = new Employee[2];

        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        
        Director carl = new Director("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);

        staff[0] = carl;
        staff[1] = harry;

        try {
            // Сброс данных объекта staff в файл (сериализация данных)
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            out.writeObject(staff);
            out.close();

            // Чтение сериализованных данных из файла в объект (десериализация данных)
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee[] newStaff = (Employee[]) in.readObject();
            in.close();

            newStaff[1].raiseSalary(10);

            for (Employee e : newStaff) {
                System.out.println(e);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
