package ProjectAlexandria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class DataFile {
    private University Univ;
    private String FPath;

    public DataFile(String FilePath, University Univers) {
        this.Univ = Univers;
        this.FPath = FilePath;
    }

    /*
    name of university
    facults
    cathedras
    students
    teachers
     */
    public void SaveAll() throws  Exception{
        FileWriter FW = new FileWriter(FPath);

        FW.write(Univ.name+"\n");
        SaveFaculties(FW);
        SaveCathedras(FW);
        SaveStudents(FW);
        SaveTeachers(FW);

        FW.close();
    }

    /*
    length of elems
    {
    name
    number
    }
     */
    private void SaveFaculties(FileWriter FW) throws Exception{
        int Length = Univ.faculties.length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.faculties[i].name+"\n");
            FW.write(Univ.faculties[i].number+"\n");
        }
    }

    /*
    length of elems
    {
    name
    number
    length of facults
        {
        number of facult
        }
    }
     */
    private void SaveCathedras(FileWriter FW) throws Exception{
        int Length = Univ.cathedras.length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.cathedras[i].name+"\n");
            FW.write(Univ.cathedras[i].number+"\n");

            FW.write(Univ.cathedras[i].facultys.length+"\n");
            for(int j = 0; j < Univ.cathedras[i].facultys.length; j++){
                FW.write(Univ.cathedras[i].facultys[j].number+"\n");
            }
        }
    }

    /*
    whithout line isTeacher beacause its obviously

    length of elems
    {
    name
    name
    name
    number of cathedra
    course
    group
    }
     */
    private void SaveStudents(FileWriter FW) throws Exception{
        int Length = Univ.students.length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.students[i].name[0]+"\n");
            FW.write(Univ.students[i].name[1]+"\n");
            FW.write(Univ.students[i].name[2]+"\n");

            FW.write(Univ.students[i].cathedra.number+"\n");

            FW.write(Univ.students[i].course+"\n");
            FW.write(Univ.students[i].group+"\n");
        }
    }

    /*
    whithout line isTeacher beacause its obviously

    length of elems
    {
    name
    name
    name

    number of cathedra
    }
     */
    private void SaveTeachers(FileWriter FW) throws Exception{
        int Length = Univ.teachers.length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.teachers[i].name[0]+"\n");
            FW.write(Univ.teachers[i].name[1]+"\n");
            FW.write(Univ.teachers[i].name[2]+"\n");

            FW.write(Univ.teachers[i].cathedra.number+"\n");
        }
    }

    public University LoadAll() throws Exception{
        FileReader FR = new FileReader(FPath);
        BufferedReader BR = new BufferedReader(FR);
        University Res = new University();

        Res.name = BR.readLine();
        Res.faculties = LoadFaculties(BR);
        Res.cathedras = LoadCathedras(BR, Res);
        Res.students = LoadStudents(BR,Res);
        Res.teachers = LoadTeachers(BR, Res);

        FR.close();
        BR.close();
        return Res;
    }

    private Faculty[] LoadFaculties(BufferedReader BR) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Faculty newFaculties[] = new Faculty[Length];
        for(int i = 0; i < Length; i++){
            newFaculties[i] = new Faculty();
            newFaculties[i].name = BR.readLine();
            newFaculties[i].number = Integer.parseInt(BR.readLine());
        }
        return newFaculties;
    }

    private Cathedra[] LoadCathedras(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Cathedra newCathedras[] = new Cathedra[Length];
        for(int i = 0; i < Length; i++){
            newCathedras[i] = new Cathedra();
            newCathedras[i].name = BR.readLine();
            newCathedras[i].number = Integer.parseInt(BR.readLine());
            int LengthOfFac = Integer.parseInt(BR.readLine());
            Faculty newFacult[] = new Faculty[LengthOfFac];
            for(int j = 0; j < LengthOfFac; j++){
                int elem = Integer.parseInt(BR.readLine());
                newFacult[i] = Un.faculties[elem];
            }
            newCathedras[i].facultys = newFacult;
        }
        return newCathedras;
    }

    private Student[] LoadStudents(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Student newStudents[] = new Student[Length];
        for(int i = 0; i < Length; i++){
            newStudents[i] = new Student();
            newStudents[i].isTeacher = false;
            newStudents[i].name[0] = BR.readLine();
            newStudents[i].name[1] = BR.readLine();
            newStudents[i].name[2] = BR.readLine();
            newStudents[i].cathedra = Un.cathedras[Integer.parseInt(BR.readLine())];
            newStudents[i].course = Integer.parseInt(BR.readLine());
            newStudents[i].group = Integer.parseInt(BR.readLine());
        }
        return newStudents;
    }

    private Teacher[] LoadTeachers(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Teacher newTeachers[] = new Teacher[Length];
        for(int i = 0; i < Length; i++){
            newTeachers[i] = new Teacher();
            newTeachers[i].isTeacher = true;
            newTeachers[i].name[0] = BR.readLine();
            newTeachers[i].name[1] = BR.readLine();
            newTeachers[i].name[2] = BR.readLine();
            newTeachers[i].cathedra = Un.cathedras[Integer.parseInt(BR.readLine())];
        }
        return newTeachers;
    }


}
