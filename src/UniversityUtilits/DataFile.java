package UniversityUtilits;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * For save and load from file
 */
public class DataFile {

    private University Univ;
    private String FPath;

    /**
     * Create object for save and load
     * @param FilePath
     * @param Univers
     */
    public DataFile(String FilePath, University Univers) {
        this.Univ = Univers;
        this.FPath = FilePath;
    }

    /**
     * Create object for save and load
     * @param FilePath
     */
    public DataFile(String FilePath) {
        this.Univ = null;
        this.FPath = FilePath;
    }

    /**
     * SaveAll
     *
     name of university
     facults
     cathedras
     students
     teachers
     *
     * @throws Exception
     */
    public void SaveAll() throws  Exception{
        if(Univ == null){
            return;
        }

        FileWriter FW = new FileWriter(FPath);

        FW.write(Univ.getName()+"\n");
        SaveFaculties(FW);
        SaveCathedras(FW);
        SaveStudents(FW);
        SaveTeachers(FW);

        FW.close();
    }

    /**
     * SaveFaculties
     *
     length of elems
     {
     name
     }
     *
     * @param FW
     * @throws Exception
     */
    private void SaveFaculties(FileWriter FW) throws Exception{
        int Length = Univ.getFaculties().length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.getFaculties()[i].getName()+"\n");
        }
    }

    /**
     * SaveCathedras
     *
     length of elems
     {
     name
     number of facult
     }
     *
     * @param FW
     * @throws Exception
     */
    private void SaveCathedras(FileWriter FW) throws Exception{
        int Length = Univ.getCathedras().length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            FW.write(Univ.getCathedras()[i].getName()+"\n");

            Faculty TMPFacult = Univ.getCathedras()[i].getFaculty();
            for(int j = 0; j < Univ.getFaculties().length; j++){
                if(TMPFacult.equals(Univ.getFaculties()[j])){
                    FW.write(j+"\n");
                    break;
                }
            }
        }
    }

    /**
     * SaveStudents
     *
     length of elems
     {
     name
     name
     name
     number of cathedra
     course
     group
     }
     *
     * @param FW
     * @throws Exception
     */
    private void SaveStudents(FileWriter FW) throws Exception{
        int Length = Univ.getStudents().length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            String TMPName[] = Univ.getStudents()[i].getName();
            FW.write(TMPName[0]+"\n");
            FW.write(TMPName[1]+"\n");
            FW.write(TMPName[2]+"\n");

            Cathedra TMPCathedra = Univ.getStudents()[i].getCathedra();
            for(int j = 0; j < Univ.getCathedras().length; j++){
                if(TMPCathedra.equals(Univ.getCathedras()[j])){
                    FW.write(j+"\n");
                    break;
                }
            }

            //FW.write(Univ.getStudents()[i].cathedra.number+"\n");

            FW.write(Univ.getStudents()[i].getCourse()+"\n");
            FW.write(Univ.getStudents()[i].getGroup()+"\n");
        }
    }

    /**
     * SaveTeachers
     *
     length of elems
     {
     name
     name
     name
     number of cathedra
     }
     *
     * @param FW
     * @throws Exception
     */
    private void SaveTeachers(FileWriter FW) throws Exception{
        int Length = Univ.getTeachers().length;
        FW.write(Length+"\n");
        for(int i = 0; i < Length; i++){
            String TMPName[] = Univ.getTeachers()[i].getName();
            FW.write(TMPName[0]+"\n");
            FW.write(TMPName[1]+"\n");
            FW.write(TMPName[2]+"\n");


            Cathedra TMPCathedra = Univ.getTeachers()[i].getCathedra();
            for(int j = 0; j < Univ.getCathedras().length; j++){
                if(TMPCathedra.equals(Univ.getCathedras()[j])){
                    FW.write(j+"\n");
                    break;
                }
            }

        }
    }

    /**
     * LoadAll
     * @return
     * @throws Exception
     */
    public University LoadAll() throws Exception{
        FileReader FR = new FileReader(FPath);
        BufferedReader BR = new BufferedReader(FR);

        String TMPName = BR.readLine();

        University Res = new University(TMPName, TMPName+".txt");

        LoadFaculties(BR, Res);
        LoadCathedras(BR, Res);
        LoadStudents(BR,Res);
        LoadTeachers(BR, Res);

        FR.close();
        BR.close();
        return Res;
    }

    /**
     * LoadFaculties
     * @param BR
     * @param Un
     * @throws Exception
     */
    private void LoadFaculties(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Faculty ResFacultys[] = new Faculty[Length];
        for(int i = 0; i < Length; i++){
            String TMPName = BR.readLine();
            ResFacultys[i] = new Faculty(TMPName);
        }
        Un.setFaculties(ResFacultys);
    }

    /**
     * LoadCathedras
     * @param BR
     * @param Un
     * @throws Exception
     */
    private void LoadCathedras(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Cathedra ResCathedras[] = new Cathedra[Length];
        for(int i = 0; i < Length; i++){
            String TMPName = BR.readLine();
            Faculty TMPFaculty = Un.getFaculties()[Integer.parseInt(BR.readLine())];
            ResCathedras[i] = new Cathedra(TMPName, TMPFaculty);
        }
        Un.setCathedras(ResCathedras);
    }

    /**
     * LoadStudents
     * @param BR
     * @param Un
     * @throws Exception
     */
    private void LoadStudents(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Student Students[] = new Student[Length];
        for(int i = 0; i < Length; i++){
            String TMPName[] = new String[3];
            TMPName[0] = BR.readLine();
            TMPName[1] = BR.readLine();
            TMPName[2] = BR.readLine();
            Cathedra TMPCathedra = Un.getCathedras()[Integer.parseInt(BR.readLine())];
            int TMPCourse = Integer.parseInt(BR.readLine());
            int TMPGroup = Integer.parseInt(BR.readLine());
            Student TMPStud = new Student(TMPName, TMPCathedra, TMPCourse, TMPGroup);
            Students[i] = TMPStud;
        }
        Un.setStudents(Students);
    }

    /**
     * LoadTeachers
     * @param BR
     * @param Un
     * @throws Exception
     */
    private void LoadTeachers(BufferedReader BR, University Un) throws Exception{
        int Length = Integer.parseInt(BR.readLine());
        Teacher Teachers[] = new Teacher[Length];
        for(int i = 0; i < Length; i++){
            String TMPName[] = new String[3];
            TMPName[0] = BR.readLine();
            TMPName[1] = BR.readLine();
            TMPName[2] = BR.readLine();
            Cathedra TMPCathedra = Un.getCathedras()[Integer.parseInt(BR.readLine())];
            Teacher TMPTeacher = new Teacher(TMPName, TMPCathedra);
            Teachers[i] = TMPTeacher;
        }
        Un.setTeachers(Teachers);
    }


}
