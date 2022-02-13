package ProjectAlexandria;

public class University {

    private String name;
    private Faculty[] faculties;
    private Cathedra[] cathedras;
    private Student[] students;
    private Teacher[] teachers;

    public University() {
        this.faculties = new Faculty[0];
        this.cathedras = new Cathedra[0];
        this.students = new Student[0];
        this.teachers = new Teacher[0];
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

    public Teacher[] getAllTeachers(String[] name) {
        if(name.length != 3)return null;
        Teacher[] res = null;
        for(Teacher teacher : this.teachers) {
            if(teacher.getName()[0].equals(name[0]) && teacher.getName()[1].equals(name[1]) && teacher.getName()[2].equals(name[2])) res = addTeacherToArray(res, teacher);
        }
        return res;
    }

    private Student[] addStudentToArray(Student[] students, Student student) {
        Student[] res = new Student[students == null ? 1 : students.length];
        for(int i = 0; i < students.length; i++) {
            res[i] = students[i];
        }
        res[students.length] = student;
        return res;
    }

    private Teacher[] addTeacherToArray(Teacher[] teachers, Teacher teacher) {
        Teacher[] res = new Teacher[teachers == null ? 1 : teachers.length];
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
                if(chars1.length > chars2.length && i == minLength -1)return 1;
                else if(chars1.length < chars2.length && i == minLength -1)return -1;
                else continue;
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
        return 0;
    }
}
