package UniversityUtilits;

import java.util.Objects;

public class Faculty {
    private String name;

    public Faculty(String name) {
        if(name != null) {
            name = name.toLowerCase();
        }
        this.name = name;
    }

    public void copy(Faculty faculty){
        this.name = faculty.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
