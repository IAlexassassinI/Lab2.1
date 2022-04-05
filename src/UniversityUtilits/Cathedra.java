package UniversityUtilits;


import java.util.Locale;
import java.util.Objects;

/**
 * class which consists information about cathedra and presents it
 */

public class Cathedra {

    private String name;
    private Faculty faculty;

    /**
     * constuctor
     *
     * @param name name of the cathedra
     * @param faculty faculty of the cathedra
     */

    public Cathedra(String name, Faculty faculty) {
        if(name != null) {
            name = name.toLowerCase();
        }
        this.name = name;
        this.faculty = faculty;
    }

    /**
     * copies information from cathedra to this
     *
     * @param cathedra specific cathedra
     */

    public void copy(Cathedra cathedra) {
        this.name = cathedra.getName();
        this.faculty = cathedra.getFaculty();
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
        Cathedra cathedra = (Cathedra) o;
        return Objects.equals(name, cathedra.name) && Objects.equals(faculty, cathedra.faculty);
    }

    /**
     *
     * @return name of this cathedra
     */

    public String getName() {
        return name;
    }

    /**
     * sets new name for this cathedra
     *
     * @param name new name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return faculty of this cathedra
     */

    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * sets new faculty for this cathedra
     *
     * @param faculty new faculty
     */

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     *
     * @return information about this cathedra
     */

    @Override
    public String toString() {
        return this.name;
    }
}

