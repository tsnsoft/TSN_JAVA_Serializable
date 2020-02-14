package tsn_java_serializable;

public class Director extends Employee {

    private static final long serialVersionUID = 1L;
    private Employee secretary;

    public Director(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        secretary = null;
    }

    public void setSecretary(Employee s) {
        secretary = s;
    }

    public String toString() {
        return super.toString() + "[secretary=" + secretary + "]";
    }

}
