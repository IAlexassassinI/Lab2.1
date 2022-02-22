package UniversityUtilits;

import java.util.Locale;
import java.util.Objects;

public class Cathedra {

    private String name;
    private Faculty faculty;

    public Cathedra(String name, Faculty faculty) {
        if(name != null) {
            name = name.toLowerCase();
        }
        this.name = name;
        this.faculty = faculty;
    }

    public void copy(Cathedra cathedra) {
        this.name = cathedra.getName();
        this.faculty = cathedra.getFaculty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cathedra cathedra = (Cathedra) o;
        return Objects.equals(name, cathedra.name) && Objects.equals(faculty, cathedra.faculty);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

