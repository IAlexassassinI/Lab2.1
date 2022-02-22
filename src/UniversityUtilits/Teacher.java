package UniversityUtilits;

public class Teacher extends Human {

    public Teacher(String[] name, Cathedra cathedra) {
        super(true, name, cathedra);
    }

    @Override
    public String toString() {
        return "викладач: " + super.toString();
    }
}
