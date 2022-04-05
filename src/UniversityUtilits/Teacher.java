

package UniversityUtilits;

/**
 * class which consists information about teacher and presents it
 */

public class Teacher extends Human {

    /**
     * constuctor
     *
     * @param name name of the human
     * @param cathedra specific cathedra
     */

    public Teacher(String[] name, Cathedra cathedra) {
        super(true, name, cathedra);
    }

    /**
     *
     * @return information about this teacher
     */

    @Override
    public String toString() {
        return "викладач: " + super.toString();
    }
}
