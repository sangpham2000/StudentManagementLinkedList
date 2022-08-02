public class Student {
    private int id;
    private String name;
    private int enrollmentYear;
    private double gpa;

    public Student() {
    }

    public Student(int id, String name, int enrollmentYear, double gpa) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien [id=" + id + ", name=" + name + ", enrollmentYear=" + enrollmentYear + ", gpa=" + gpa + "]";
    }

}