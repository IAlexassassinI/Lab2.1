

package UniversityUtilits;

/**
 * class which operates by students, teachers, faculties and cathedras
 */

public class University {

    private String name;
    private Faculty[] faculties;
    private Cathedra[] cathedras;
    private Student[] students;
    private Teacher[] teachers;
    private DataFile dataFile;

    /**
     *  constructor
     * @param name name of the university
     * @param file name of saving file
     */

    public University(String name, String file) {
        this.name = name;
        this.faculties = new Faculty[0];
        this.cathedras = new Cathedra[0];
        this.students = new Student[0];
        this.teachers = new Teacher[0];
        this.dataFile = new DataFile(file, this);
    }

    /**
     * sets new name of the university
     *
     * @param name name of the university
     */

    void setName(String name) {
        this.name = name;
    }

    /**
     * sets new faculties
     *
     * @param faculties array of faculties
     */

    void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    /**
     * sets new cathedras
     *
     * @param cathedras array of cathedras
     */

    void setCathedras(Cathedra[] cathedras) {
        this.cathedras = cathedras;
    }

    /**
     * sets new students
     *
     * @param students array of students
     */

    void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * sets new teachers
     *
     * @param teachers array of teachers
     */

    void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    /**
     *
     * @return name of the university
     */

    public String getName() {
        return name;
    }

    /**
     *
     * @return array of faculties
     */

    public Faculty[] getFaculties() {
        return faculties;
    }

    /**
     *
     * @return array of cathedras
     */

    public Cathedra[] getCathedras() {
        return cathedras;
    }

    /**
     *
     * @return array of students
     */

    public Student[] getStudents() {
        return students;
    }

    /**
     *
     * @return array of teachers
     */

    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * adds new faculty
     *
     * @param faculty new faculty
     */

    public void addFaculty(Faculty faculty) {
        Faculty[] temp = new Faculty[this.faculties.length+1];
        for(int i = 0; i < this.faculties.length; i++) {
            temp[i] = this.faculties[i];
        }
        temp[this.faculties.length] = faculty;
        this.faculties = temp;
    }

    /**
     * adds new cathedra
     *
     * @param cathedra new cathedra
     */

    public void addCathedra(Cathedra cathedra) {
        Cathedra[] temp = new Cathedra[this.cathedras.length+1];
        for(int i = 0; i < this.cathedras.length; i++) {
            temp[i] = this.cathedras[i];
        }
        temp[this.cathedras.length] = cathedra;
        this.cathedras = temp;
    }

    /**
     * adds new student by alphabet
     *
     * @param student new student
     */

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

    /**
     *
     * @param name name of the faculty
     * @return faculty from array by name
     */

    public Faculty getFaculty(String name) {
        for(int i = 0; i < this.faculties.length; i++) {
            if(this.faculties[i].getName().equals(name))return this.faculties[i];
        }
        return null;
    }

    /**
     *
     * @param name name of the cathedra
     * @return cathedra from array by name
     */

    public Cathedra getCathedra(String name) {
        for(int i = 0; i < this.cathedras.length; i++) {
            if(this.cathedras[i].getName().equals(name))return this.cathedras[i];
        }
        return null;
    }

    /**
     *
     * @param faculty faculty
     * @return cathedra from array by faculty
     */

    public Cathedra getCathedra(Faculty faculty) {
        for(int i = 0; i < this.cathedras.length; i++) {
            if(this.cathedras[i].getFaculty().equals(faculty))return this.cathedras[i];
        }
        return null;
    }

    /**
     * adds new teacher to array by alphabet
     *
     * @param teacher new teacher
     */

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

    /**
     *
     * @param name name of the students
     * @return array of students by name
     */

    public Student[] getAllStudents(String[] name) {
        if(name.length != 3)return null;
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getName()[0].equals(name[0]) && student.getName()[1].equals(name[1]) && student.getName()[2].equals(name[2])) res = addStudentToArray(res, student);
        }
        return res;
    }

    /**
     *
     * @param course course of the students
     * @return array of students by course
     */

    public Student[] getAllStudents(int course) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCourse() == course) res = addStudentToArray(res, student);
        }
        return res;
    }

    /**
     *
     * @param cathedra cathedra of the students
     * @param group group of the students
     * @return array of students by cathedra and group
     */

    public Student[] getAllStudents(Cathedra cathedra, int group) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCathedra().equals(cathedra) && student.getGroup() == group) res = addStudentToArray(res, student);
        }
        return res;
    }

    /**
     * sorts students by alphabet
     */

    public void sortStudents() {
        for(int i = 0; i < students.length; i++) {
            for(int j = 0; j < students.length -1-i; j++){
                if(compare(this.students[j].getName()[0], this.students[j+1].getName()[0]) > 0) {
                    swap(this.students, j, j+1);
                    continue;
                }
                if(compare(this.students[j].getName()[0], this.students[j+1].getName()[0]) == 0 && compare(this.students[j].getName()[1], this.students[j+1].getName()[1]) > 0) {
                    swap(this.students, j, j+1);
                    continue;
                }
                if(compare(this.students[j].getName()[0], this.students[j+1].getName()[0]) == 0 && compare(this.students[j].getName()[1], this.students[j+1].getName()[1]) == 0 && compare(this.students[j].getName()[2], this.students[j+1].getName()[2]) > 0) {
                    swap(this.students, j, j+1);
                }
            }
        }
    }

    /**
     * sorts teachers by alphabet
     */

    public void sortTeachers() {
        for(int i = 0; i < teachers.length; i++) {
            for(int j = 0; j < teachers.length -1-i; j++){
                if(compare(this.teachers[j].getName()[0], this.teachers[j+1].getName()[0]) > 0) {
                    swap(this.teachers, j, j+1);
                    continue;
                }
                if(compare(this.teachers[j].getName()[0], this.teachers[j+1].getName()[0]) == 0 && compare(this.teachers[j].getName()[1], this.teachers[j+1].getName()[1]) > 0) {
                    swap(this.teachers, j, j+1);
                    continue;
                }
                if(compare(this.teachers[j].getName()[0], this.teachers[j+1].getName()[0]) == 0 && compare(this.teachers[j].getName()[1], this.teachers[j+1].getName()[1]) == 0 && compare(this.teachers[j].getName()[2], this.teachers[j+1].getName()[2]) > 0) {
                    swap(this.teachers, j, j+1);
                }
            }
        }
    }

    /**
     * swaps two objects in array
     *
     * @param array array of objects
     * @param id1 index of first object in array
     * @param id2 index of second object in array
     */

    private void swap(Object[] array, int id1, int id2) {
        Object temp = array[id1];
        array[id1] = array[id2];
        array[id2] = temp;
    }

    /**
     *
     * @param name name of students
     * @param course course of students
     * @param group group of students
     * @return array of the students by params
     */

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

    /**
     *
     * @param name name of the teachers
     * @return array of teachers by name
     */

    public Teacher[] getAllTeachers(String[] name) {
        if(name.length != 3)return null;
        Teacher[] res = null;
        for(Teacher teacher : this.teachers) {
            if(teacher.getName()[0].equals(name[0]) && teacher.getName()[1].equals(name[1]) && teacher.getName()[2].equals(name[2])) res = addTeacherToArray(res, teacher);
        }
        return res;
    }

    /**
     * deletes exact faculty from array
     *
     * @param faculty exact faculty
     */

    public void deleteFaculty(Faculty faculty) {
        deleteCathedras(faculty);
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

    private void deleteCathedras(Faculty faculty) {
        for(Cathedra cathedra : this.cathedras) {
            if(cathedra.getFaculty().equals(faculty))deleteCathedra(cathedra);
        }
    }

    /**
     * deletes exact cathedra from array
     *
     * @param cathedra exact cathedra
     */

    public void deleteCathedra(Cathedra cathedra) {
        deleteStudents(cathedra);
        deleteTeachers(cathedra);
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

    private void deleteTeachers(Cathedra cathedra) {
        for(Teacher teacher : this.teachers) {
            if(teacher.getCathedra().equals(cathedra))deleteTeacher(teacher);
        }
    }

    private void deleteStudents(Cathedra cathedra) {
        for(Student student : this.students) {
            if(student.getCathedra().equals(cathedra))deleteStudent(student);
        }
    }

    /**
     * deletes exact teacher from array
     *
     * @param teacher teacher
     */

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

    /**
     * deletes exact student from array
     *
     * @param student student
     */

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

    /**
     * copies information from new faculty to faculty
     * @param faculty faculty
     * @param newFaculty new faculty
     */

    public void editFaculty(Faculty faculty, Faculty newFaculty) {
        for(Faculty f : this.faculties) {
            if(f.equals(faculty))f.copy(newFaculty);
        }
    }

    /**
     * copies information from new cathedra to cathedra
     * @param cathedra cathedra
     * @param newCathedra new cathedra
     */

    public void editCathedra(Cathedra cathedra, Cathedra newCathedra) {
        for(Cathedra c : this.cathedras) {
            if(c.equals(cathedra))c.copy(newCathedra);
        }
    }

    /**
     * copies information from new teacher to teacher
     * @param teacher teacher
     * @param newTeacher new teacher
     */

    public void editTeacher(Teacher teacher, Teacher newTeacher) {
        for(Teacher t : this.teachers) {
            if(t.equals(teacher))t.copy(newTeacher);
        }
    }

    /**
     * copies information from new student to student
     * @param student student
     * @param newStudent new student
     */

    public void editStudent(Student student, Student newStudent) {
        for(Student s : this.students) {
            if(s.equals(student))s.copy(newStudent);
        }
    }

    /**
     *
     * @return array of students by courses
     */

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

    /**
     *
     * @param faculty faculty
     * @return array of students from specific faculty
     */

    public Student[] getAllStudentsFromFaculty(Faculty faculty) {
        Student[] res = null;
        for (Student student : this.students) {
            if(student.getFaculty().equals(faculty)) res = addStudentToArray(res, student);
        }
        return res;
    }

    /**
     *
     * @param faculty faculty
     * @return array of teachers from specific faculty
     */

    public Teacher[] getAllTeachersFromFaculty(Faculty faculty) {
        Teacher[] res = null;
        for (Teacher teacher : this.teachers) {
            if(teacher.getFaculty().equals(faculty)) res = addTeacherToArray(res, teacher);
        }
        return res;
    }

    /**
     *
     * @param cathedra cathedra
     * @return array of students from secific cathedra by courses
     */

    public Student[] getAllStudentsFromCathedraByCourses(Cathedra cathedra) {
        Human[] humans = getAllHumansFromCathedra(getAllStudentsByCourses(), cathedra);
        if(humans == null)return null;
        Student[] students = new Student[humans.length];
        for(int i = 0; i < humans.length; i++) {
            students[i] = (Student) humans[i];
        }
        return students;
    }

    /**
     *
     * @param cathedra cathedra
     * @return array of students from specific cathedra
     */

    public Student[] getAllStudentsFromCathedra(Cathedra cathedra) {
        Human[] humans = getAllHumansFromCathedra(this.students, cathedra);
        if(humans == null)return null;
        Student[] students = new Student[humans.length];
        for(int i = 0; i < humans.length; i++) {
            students[i] = (Student) humans[i];
        }
        return students;
    }

    /**
     *
     * @param cathedra cathedra
     * @return array of teachers from specific cathedra
     */

    public Teacher[] getAllTeachersFromCathedra(Cathedra cathedra) {
        Human[] humans =  getAllHumansFromCathedra(this.teachers, cathedra);
        if(humans == null)return null;
        Teacher[] teachers = new Teacher[humans.length];
        for(int i = 0; i < humans.length; i++) {
            teachers[i] = (Teacher) humans[i];
        }
        return teachers;
    }

    /**
     *
     * @param cathedra cathedra
     * @param course course
     * @return array of students from specific cathedra and course
     */

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

    /**
     *
     * @param course course
     * @return array of students from specific course
     */

    public Student[] getAllStudentsFromCourse(int course) {
        Student[] res = null;
        for(Student student : this.students) {
            if(student.getCourse() == course)res = addStudentToArray(res, student);
        }
        return res;
    }

    /**
     * saves all information in saving file
     */

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

    /**
     *
     * @param humans array of humans
     * @param cathedra cathedra
     * @return array of humans from specific cathedra
     */

    private Human[] getAllHumansFromCathedra(Human[] humans, Cathedra cathedra) {
        Human[] res = null;
        for(Human human : humans) {
            if(human.getCathedra().equals(cathedra))res = addHumanToArray(res, human);
        }
        return res;
    }

    /**
     * deletes object from array
     *
     * @param objects array of objects
     * @param object object
     * @return new array of objects
     */

    private Object[] deleteAllElementsFromArray(Object[] objects, Object object) {
        for(int i = 0; i < objects.length; i++) {
            if(objects[i].equals(object)){
                objects = deleteElementFromArray(objects, i);
                i--;
            }
        }
        return objects;
    }

    /**
     * deletes object from array
     *
     * @param objects array of objects
     * @param id index of object in array
     * @return new array of objects
     */

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

    /**
     * adds new human to array by alphabet
     *
     * @param humans array of humans
     * @param human new human
     * @return new array of humans
     */

    private Human[] addHumanToArray(Human[] humans, Human human) {
        if(humans == null)return new Human[]{human};
        Human[] res = new Human[humans.length+1];
        for(int i = 0; i < humans.length; i++) {
            res[i] = humans[i];
        }
        res[humans.length] = human;
        return res;
    }

    /**
     * adds new student to array by alphabet
     *
     * @param students array of the students
     * @param student new student
     * @return new array of students
     */

    private Student[] addStudentToArray(Student[] students, Student student) {
        if(students == null)return new Student[]{student};
        Student[] res = new Student[students.length+1];
        for(int i = 0; i < students.length; i++) {
            res[i] = students[i];
        }
        res[students.length] = student;
        return res;
    }

    /**
     * adds new teacher to array by alphabet
     *
     * @param teachers array of teachers
     * @param teacher new teacher
     * @return new array of teachers
     */

    private Teacher[] addTeacherToArray(Teacher[] teachers, Teacher teacher) {
        if(teachers == null)return new Teacher[]{teacher};
        Teacher[] res = new Teacher[teachers.length+1];
        for(int i = 0; i < teachers.length; i++) {
            res[i] = teachers[i];
        }
        res[teachers.length] = teacher;
        return res;
    }

    /**
     * compares two strings
     *
     * @param s1 first string
     * @param s2 second strings
     * @return result of comparing
     */

    public static int compare(String s1, String s2) {
        s1 = s1.replaceAll("\'", "");
        s2 = s2.replaceAll("\'", "");
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int minLength;
        if(chars1.length > chars2.length)minLength = chars2.length;
        else minLength = chars1.length;
        /*for(int i = 0; i < minLength; i++){
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
        if(chars1.length < chars2.length)return -1;*/
        return 0;
    }
}
