

package UniversityUtilits;

import java.util.Arrays;
import java.util.Objects;

/**
 * class which consists information about a human and presents it
 */

public class Human {

    private boolean isTeacher;
    private String[] name;
    private Cathedra cathedra;

    /**
     * constuctor
     *
     * @param isTeacher is human a teacher
     * @param name name of the human
     * @param cathedra specific cathedra
     */

    public Human(boolean isTeacher, String[] name, Cathedra cathedra) {
        if(name != null) {
            for(int i = 0; i < name.length;i++){
                if(name[i] != null) {
                    if(name[i].length() > 0) {
                        name[i] = name[i].toLowerCase();
                        name[i] = Character.toUpperCase(name[i].charAt(0)) + name[i].substring(1);
                    }
                }
            }
        }
        this.isTeacher = isTeacher;
        this.name = name;
        this.cathedra = cathedra;
    }

    /**
     * copies information from human to this
     *
     * @param human specific human
     */

    public void copy(Human human) {
        this.isTeacher = human.isTeacher();
        this.name = human.getName();
        this.cathedra = human.getCathedra();
    }

    /**
     *
     * @return is this human teacher
     */

    public boolean isTeacher() {
        return isTeacher;
    }

    /**
     *
     * @return name of this human
     */

    public String[] getName() {
        return name;
    }

    /**
     * sets new name for this human
     *
     * @param name new name
     */

    public void setName(String[] name) {
        this.name = name;
    }

    /**
     *
     * @return cathedra of this human
     */

    public Cathedra getCathedra() {
        return cathedra;
    }

    /**
     * sets new cathedra to this human
     *
     * @param cathedra new cathedra
     */

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    /**
     *
     * @return faculty of this human
     */

    public Faculty getFaculty() {
        return this.cathedra.getFaculty();
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
        Human human = (Human) o;
        return isTeacher == human.isTeacher && Arrays.equals(name, human.name) && Objects.equals(cathedra, human.cathedra);
    }

    /**
     *
     * @return information about this human
     */

    @Override
    public String toString() {
        return this.name[0] + " " + this.name[1] + " " + this.name[2] + ", факультет: " + this.cathedra.getFaculty().toString() + ", кафедра: " + this.cathedra.toString();
    }
}
