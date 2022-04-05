
package UniversityUtilits;

import java.util.Objects;

/**
 * class which consists information about a faculty and presents it
 */


public class Faculty {
    private String name;

    /**
     * consructor
     *
     * @param name name of the faculty
     */

    public Faculty(String name) {
        if(name != null) {
            name = name.toLowerCase();
        }
        this.name = name;
    }

    /**
     * copies information from faculty to this
     *
     * @param faculty specific faculty
     */

    public void copy(Faculty faculty){
        this.name = faculty.getName();
    }

    /**
     *
     * @return name of this faculty
     */

    public String getName() {
        return name;
    }

    /**
     * sets new name for this faculty
     *
     * @param name new name
     */

    public void setName(String name) {
        this.name = name;
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
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name);
    }

    /**
     *
     * @return information about this faculty
     */

    @Override
    public String toString() {
        return this.name;
    }
}
