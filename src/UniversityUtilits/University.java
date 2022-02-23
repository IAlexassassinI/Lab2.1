package UniversityUtilits;

public class University {

    private String name;
    //private final String file;
    private Faculty[] faculties;
    private Cathedra[] cathedras;
    private Student[] students;
    private Teacher[] teachers;
    private DataFile dataFile;

    public University(String name, String file) {
        this.name = name;
        //this.file = file;
        this.faculties = new Faculty[0];
        this.cathedras = new Cathedra[0];
        this.students = new Student[0];
        this.teachers = new Teacher[0];
        this.dataFile = new DataFile(file, this);
    }

    void setName(String name) {
        this.name = name;
    }

    void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    void setCathedras(Cathedra[] cathedras) {
        this.cathedras = cathedras;
    }

    void setStudents(Student[] students) {
        this.students = students;
    }

    void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public Cathedra[] getCathedras() {
        return cathedras;
    }

    public Student[] getStudents() {
        return students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void addFaculty(Faculty faculty) {
        Faculty[] temp = new Faculty[this.faculties.length+1];
        for(int i = 0; i < this.faculties.length; i++) {
            temp[i] = this.faculties[i];
        }
        temp[this.faculties.length] = faculty;
        this.faculties = temp;
    }

    public void addCathedra(Cathedra cathedra) {
        Cathedra[] temp = new Cathedra[this.cathedras.length+1];
        for(int i = 0; i < this.cathedras.length; i++) {
            temp[i] = this.cathedras[i];
        }
        temp[this.cathedras.length] = cathedra;
        this.cathedras = temp;
    }

    public void addStudent(Student student) {
        Student[] temp = new Student[this.students.length+1];
        int position = 0;
        for(int i = 0; i < this.students.length; i++) {
            if(compare(this.students[i].getName()[0], student.getName()[0]) > 0) {
                break;
            }
            if(compare(this.students[i].getName()[0], student.getName()[0]) == 0 && compare(this.students[i].getName()[1], student.getName()[1]) > 0) {
                break;
            }
            if(compare(this.students[i].getName()[0], student.getName()[0]) == 0 && compare(this.students[i].getName()[1], student.getName()[1]) == 0 && compare(this.students[i].getName()[2], student.getName()[2]) > 0) {
                break;
            }
            position++;
            temp[i] = this.students[i];
        }

        for(int i = position; i < this.students.length; i++){
            temp[i+1] = this.students[i];
        }

        temp[position] = student;
        this.students = temp;
    }

    public Faculty getFaculty(String name) {
        for(int i = 0; i < this.faculties.length; i++) {
            if(this.faculties[i].getName().equals(name))return this.faculties[i];
        }
        return null;
    }

    public Cathedra getCathedra(String name) {
        for(int i = 0; i < this.cathedras.length; i++) {
            if(this.cathedras[i].getName().equals(name))return this.cathedras[i];
        }
        return null;
    }

    public Cathedra getCathedra(Faculty faculty) {
        for(int i = 0; i < this.cathedras.length; i++) {
            if(this.cathedras[i].getFaculty().equals(faculty))return this.cathedras[i];
        }
        return null;
    }

    public void addTeacher(Teacher teacher) {
        Teacher[] temp = new Teacher[this.teachers.length+1];
        int position = 0;
        for(int i = 0; i < this.teachers.length; i++) {
            if(compare(this.teachers[i].getName()[0], teacher.getName()[0]) > 0) {
                break;
            }
            if(compare(this.teachers[i].getName()[0], teacher.getName()[0]) == 0 && compare(this.teachers[i].getName()[1], teacher.getName()[1]) > 0) {
                break;
            }
            if(compare(this.teachers[i].getName()[0], teacher.getName()[0]) == 0 && compare(this.teachers[i].getName()[1], teacher.getName()[1]) == 0 && compare(this.teachers[i].getName()[2], teacher.getName()[2]) > 0) {
                break;
            }
            position++;
            temp[i] = this.teachers[i];
        }

        for(int i = position; i < this.teachers.length; i++){
            temp[i+1] = this.teachers[i];
        }

        temp[position] = teacher;
        this.teachers = temp;
    }

    public Student[] getAllStudents(String[] name) {
        if(name.length != 3)return null;
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getName()[0].equals(name[0]) && student.getName()[1].equals(name[1]) && student.getName()[2].equals(name[2])) res = addStudentToArray(res, student);
        }
        return res;
    }

    public Student[] getAllStudents(int course) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCourse() == course) res = addStudentToArray(res, student);
        }
        return res;
    }

    public Student[] getAllStudents(Cathedra cathedra, int group) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCathedra().equals(cathedra) && student.getGroup() == group) res = addStudentToArray(res, student);
        }
        return res;
    }

    //TODO previous method replace by next

    /*public Student[] getAllStudentsFromGroup(int group) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getGroup() == group) res = addStudentToArray(res, student);
        }
        return res;
    }*/

    //TODO previous method replace by next

    public Student[] getAllStudentsByParams(String[] name, int course, int group) {
        Student[] res = null;
        for(Student student : this.students) {
            boolean isNamesEqual = false;
            boolean isCoursesEqual = false;
            boolean isGroupsEqual = false;
            if(name == null)isNamesEqual = true;
            else if(student.getName()[0].equals(name[0]) && student.getName()[1].equals(name[1]) && student.getName()[2].equals(name[2]))isNamesEqual = true;
            if(course == 0 || student.getCourse() == course)isCoursesEqual = true;
            if(group == 0 || student.getGroup() == group)isGroupsEqual = true;
            if(isNamesEqual && isCoursesEqual && isGroupsEqual)res = addStudentToArray(res, student);
        }
        return res;
    }

    public Teacher[] getAllTeachers(String[] name) {
        if(name.length != 3)return null;
        Teacher[] res = null;
        for(Teacher teacher : this.teachers) {
            if(teacher.getName()[0].equals(name[0]) && teacher.getName()[1].equals(name[1]) && teacher.getName()[2].equals(name[2])) res = addTeacherToArray(res, teacher);
        }
        return res;
    }

    public void deleteFaculty(Faculty faculty) {
        Object[] objects = deleteAllElementsFromArray(this.faculties, faculty);
        if(objects == null) {
            this.faculties = new Faculty[0];
            return;
        }
        this.faculties = new Faculty[objects.length];
        for(int i = 0; i < objects.length; i++) {
            this.faculties[i] = (Faculty) objects[i];
        }
    }

    public void deleteCathedra(Cathedra cathedra) {
        Object[] objects = deleteAllElementsFromArray(this.cathedras, cathedra);
        if(objects == null) {
            this.cathedras = new Cathedra[0];
            return;
        }
        this.cathedras = new Cathedra[objects.length];
        for(int i = 0; i < objects.length; i++) {
            this.cathedras[i] = (Cathedra) objects[i];
        }
    }

    public void deleteTeacher(Teacher teacher) {
        Object[] objects = deleteAllElementsFromArray(this.teachers, teacher);
        if(objects == null) {
            this.teachers = new Teacher[0];
            return;
        }
        this.teachers = new Teacher[objects.length];
        for(int i = 0; i < objects.length; i++) {
            this.teachers[i] = (Teacher) objects[i];
        }
    }

    public void deleteStudent(Student student) {
        Object[] objects = deleteAllElementsFromArray(this.students, student);
        if(objects == null) {
            this.students = new Student[0];
            return;
        }
        this.students = new Student[objects.length];
        for(int i = 0; i < objects.length; i++) {
            this.students[i] = (Student) objects[i];
        }
    }

    public void editFaculty(Faculty faculty, Faculty newFaculty) {
        for(Faculty f : this.faculties) {
            if(f.equals(faculty))f.copy(newFaculty);
        }
    }

    public void editCathedra(Cathedra cathedra, Cathedra newCathedra) {
        for(Cathedra c : this.cathedras) {
            if(c.equals(cathedra))c.copy(newCathedra);
        }
    }

    public void editTeacher(Teacher teacher, Teacher newTeacher) {
        for(Teacher t : this.teachers) {
            if(t.equals(teacher))t.copy(newTeacher);
        }
    }

    public void editStudent(Student student, Student newStudent) {
        for(Student s : this.students) {
            if(s.equals(student))s.copy(newStudent);
        }
    }

    public Student[] getAllStudentsByCourses() {
        Student[] res = new Student[this.students.length];
        int id = 0;
        for(int i = 1; i <= 6; i++) {
            for(Student student : this.students){
                if(student.getCourse() == i)res[id++] = student;
            }
        }
        return res;
    }

    public Student[] getAllStudentsFromFaculty(Faculty faculty) {
        Student[] res = null;
        for (Student student : this.students) {
            if(student.getFaculty().equals(faculty)) res = addStudentToArray(res, student);
        }
        return res;
    }

    public Teacher[] getAllTeachersFromFaculty(Faculty faculty) {
        Teacher[] res = null;
        for (Teacher teacher : this.teachers) {
            if(teacher.getFaculty().equals(faculty)) res = addTeacherToArray(res, teacher);
        }
        return res;
    }

    public Student[] getAllStudentsFromCathedraByCourses(Cathedra cathedra) {
        Human[] humans = getAllHumansFromCathedra(getAllStudentsByCourses(), cathedra);
        if(humans == null)return null;
        Student[] students = new Student[humans.length];
        for(int i = 0; i < humans.length; i++) {
            students[i] = (Student) humans[i];
        }
        return students;
    }

    public Student[] getAllStudentsFromCathedra(Cathedra cathedra) {
        Human[] humans = getAllHumansFromCathedra(this.students, cathedra);
        if(humans == null)return null;
        Student[] students = new Student[humans.length];
        for(int i = 0; i < humans.length; i++) {
            students[i] = (Student) humans[i];
        }
        return students;
    }

    public Teacher[] getAllTeachersFromCathedra(Cathedra cathedra) {
        Human[] humans =  getAllHumansFromCathedra(this.teachers, cathedra);
        if(humans == null)return null;
        Teacher[] teachers = new Teacher[humans.length];
        for(int i = 0; i < humans.length; i++) {
            teachers[i] = (Teacher) humans[i];
        }
        return teachers;
    }
    public Student[] getAllStudentsFromCathedraFromCourse(Cathedra cathedra, int course) {
        Student[] res = null;
        Human[] humans = getAllHumansFromCathedra(this.students, cathedra);
        if(humans == null)return null;
        Student[] students = new Student[humans.length];
        for(int i = 0; i < humans.length; i++) {
            students[i] = (Student) humans[i];
        }
        for(Student student : students) {
            if(student.getCourse() == course)res = addStudentToArray(res, student);
        }
        return res;
    }

    public Student[] getAllStudentsFromCourse(int course) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCourse() == course)res = addStudentToArray(res, student);
        }
        return res;
    }

    public void saveAll() {
        boolean isError;
        do {
            isError = false;
            try {
                dataFile.SaveAll();
            } catch (Exception e) {
                isError = true;
            }
        } while(isError);
    }

    private Human[] getAllHumansFromCathedra(Human[] humans, Cathedra cathedra) {
        Human[] res = null;
        for(Human human : humans) {
            if(human.getCathedra().equals(cathedra))res = addHumanToArray(res, human);
        }
        return res;
    }

    /*public static void main(String[] args) {

    }*/

    private Object[] deleteAllElementsFromArray(Object[] objects, Object object) {
        for(int i = 0; i < objects.length; i++) {
            if(objects[i].equals(object)){
                objects = deleteElementFromArray(objects, i);
                i--;
            }
        }
        return objects;
    }

    private Object[] deleteElementFromArray(Object[] objects, int id) {
        Object[] temp = new Object[objects.length-1];
        for(int i = 0; i < id; i++){
            temp[i] = objects[i];
        }
        for(int i = id; i < temp.length; i++) {
            temp[i] = objects[i+1];
        }
        return temp;
    }

    private Human[] addHumanToArray(Human[] humans, Human human) {
        if(humans == null)return new Human[]{human};
        Human[] res = new Human[humans.length+1];
        for(int i = 0; i < humans.length; i++) {
            res[i] = humans[i];
        }
        res[humans.length] = human;
        return res;
    }

    private Student[] addStudentToArray(Student[] students, Student student) {
        if(students == null)return new Student[]{student};
        Student[] res = new Student[students.length+1];
        for(int i = 0; i < students.length; i++) {
            res[i] = students[i];
        }
        res[students.length] = student;
        return res;
    }

    private Teacher[] addTeacherToArray(Teacher[] teachers, Teacher teacher) {
        if(teachers == null)return new Teacher[]{teacher};
        Teacher[] res = new Teacher[teachers.length+1];
        for(int i = 0; i < teachers.length; i++) {
            res[i] = teachers[i];
        }
        res[teachers.length] = teacher;
        return res;
    }

    /*
    compares two strings
     */

    public static int compare(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int minLength;
        if(chars1.length > chars2.length)minLength = chars2.length;
        else minLength = chars1.length;
        for(int i = 0; i < minLength; i++){
            if(Character.toLowerCase(chars1[i]) == Character.toLowerCase(chars2[i])){
                continue;
            }
            if(Character.toLowerCase(chars1[i]) == 'ґ') {
                if (Character.toLowerCase(chars2[i]) != 1075) chars1[i] = 1075;
                else return 1;
            }
            else if(Character.toLowerCase(chars1[i]) == 'є'){
                if (Character.toLowerCase(chars2[i]) != 1077) chars1[i] = 1077;
                else return 1;
            }
            else if(Character.toLowerCase(chars1[i]) == 'і'){
                if (Character.toLowerCase(chars2[i]) != 1080) chars1[i] = 1080;
                else return 1;
            }
            else if(Character.toLowerCase(chars1[i]) == 'ї'){
                if (Character.toLowerCase(chars2[i]) != 1081) chars1[i] = 1081;
                else return -1;
            }
            if(Character.toLowerCase(chars2[i]) == 'ґ') {
                if (Character.toLowerCase(chars1[i]) != 1075) chars2[i] = 1075;
                else return -1;
            }
            else if(Character.toLowerCase(chars2[i]) == 'є'){
                if (Character.toLowerCase(chars1[i]) != 1077) chars2[i] = 1077;
                else return -1;
            }
            else if(Character.toLowerCase(chars2[i]) == 'і'){
                if (Character.toLowerCase(chars1[i]) != 1080) chars2[i] = 1080;
                else return -1;
            }
            else if(Character.toLowerCase(chars2[i]) == 'ї'){
                if (Character.toLowerCase(chars1[i]) != 1081) chars2[i] = 1081;
                else return 1;
            }
            return Character.toLowerCase(chars1[i]) - Character.toLowerCase(chars2[i]);
        }
        if(chars1.length > chars2.length)return 1;
        if(chars1.length < chars2.length)return -1;
        return 0;
    }
}
