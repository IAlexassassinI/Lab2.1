package ProjectAlexandria;

import java.util.Arrays;
import java.util.Objects;

public class Human {

    private boolean isTeacher;
    private String[] name;
    private Cathedra cathedra;

    public Human(boolean isTeacher, String[] name, Cathedra cathedra) {
        this.isTeacher = isTeacher;
        this.name = name;
        this.cathedra = cathedra;
    }

    public void copy(Human human) {
        this.isTeacher = human.isTeacher();
        this.name = human.getName();
        this.cathedra = human.getCathedra();
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    public Faculty getFaculty() {
        return this.cathedra.getFaculty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return isTeacher == human.isTeacher && Arrays.equals(name, human.name) && Objects.equals(cathedra, human.cathedra);
    }

    @Override
    public String toString() {
        return this.name[0] + " " + this.name[1] + " " + this.name[2] + ", факультет: " + this.cathedra.getFaculty().toString() + ", кафедра: " + this.cathedra.toString();
    }
}
