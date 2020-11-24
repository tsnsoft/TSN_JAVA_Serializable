package tsn_java_serializable;

public class Director extends Employee {

    private static final long serialVersionUID = 1L;
    private Employee secretary;

    public Director(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.secretary = null;
    }

    public void setSecretary(Employee s) {
        this.secretary = s;
    }

    @Override
    public String toString() {
        return super.toString() + "[secretary=" + secretary + "]";
    }

}
