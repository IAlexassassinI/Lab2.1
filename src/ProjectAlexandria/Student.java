package ProjectAlexandria;

import java.util.Objects;

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
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", group=" + group +
                '}';
    }
}
