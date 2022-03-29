package UniversityUtilits;

public class Student extends Human {

    private int course;
    private int group;

    /**
     * constructor
     *
     * @param name name of the student
     * @param cathedra cathedra of the student
     * @param course course of the student
     * @param group group of the student
     */

    public Student(String[] name, Cathedra cathedra, int course, int group) {
        super(false, name, cathedra);
        this.course = course;
        this.group = group;
    }

    /**
     * copies information from student to this
     *
     * @param student specific student
     */

    public void copy(Student student) {
        super.copy(student);
        this.course = student.getCourse();
        this.group = student.getGroup();
    }

    /**
     *
     * @return course of this student
     */

    public int getCourse() {
        return course;
    }

    /**
     * sets new course to this student
     *
     * @param course new course
     */

    public void setCourse(int course) {
        this.course = course;
    }

    /**
     *
     * @return group of this student
     */

    public int getGroup() {
        return group;
    }

    /**
     * sets new group of this student
     *
     * @param group new group
     */

    public void setGroup(int group) {
        this.group = group;
    }

    /**
     *
     * @param o specific object
     * @return are this and o the same or consist the same information
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return course == student.course && group == student.group;
    }

    /**
     *
     * @return information about this student
     */

    @Override
    public String toString() {
        return "студент: " + super.toString() + ", курс: " + this.course + ", група: " + this.group;
    }
}
