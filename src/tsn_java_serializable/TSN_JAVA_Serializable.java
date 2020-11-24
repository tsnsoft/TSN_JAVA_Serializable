package tsn_java_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TSN_JAVA_Serializable {

    public static void main(String[] args) {
        Employee[] staff = new Employee[2]; // Массив сотрудников

        Employee anna = new Employee("Anna Joken", 50000, 1989, 10, 1);
        
        Director carl = new Director("Carl Hacker", 80000, 1987, 12, 15);
        carl.setSecretary(anna);

        staff[0] = carl;
        staff[1] = anna;

        try {
            // Сброс данных объекта staff в файл (сериализация данных)
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            out.writeObject(staff);
            out.close();

            // Чтение сериализованных данных из файла в объект (десериализация данных)
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee[] newStaff = (Employee[]) in.readObject(); // Новый список
            in.close();

            newStaff[1].raiseSalary(10); // Увеличим секретарю зарплату на 10 %

            // Вывод на экран массива объектов newStaff
            for (Employee e : newStaff) {
                System.out.println(e);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
