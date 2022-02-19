package UniversityUtilits;

public class Student extends Human {

    private int course;
    private int group;

    public Student(String[] name, Cathedra cathedra, int course, int group) {
        super(false, name, cathedra);
        this.course = course;
        this.group = group;
    }

    public void copy(Student student) {
        super.copy(student);
        this.course = student.getCourse();
        this.group = student.getGroup();
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return course == student.course && group == student.group;
    }

    @Override
    public String toString() {
        return "студент: " + super.toString() + ", курс: " + this.course + ", група: " + this.group;
    }
}
