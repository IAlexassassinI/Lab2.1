package UniversityUtilits;

public class Menu {

    //TODO add go to main menu
    public static void MainMenu(University Univ) {
        int Input = -1;
        while (Input != 0) {
            System.out.println("0] Завершити програму");
            System.out.println("1] Створити/додати/видалити/редагувати елемент бази даних");
            System.out.println("2] Знайти студента/викладача");
            System.out.println("3] Вивести інформацію о студентах");
            System.out.println("4] Вивести інформацію о викладачах");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    GlobalEditMenu(Univ);
                    break;
                case 2:
                    FindWhoMenu(Univ);
                    break;
                case 3:
                    StudentInfoMenu(Univ);
                    break;
                case 4:
                    TeacherInfoMenu(Univ);
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void GlobalEditMenu(University Univ){
        int Input = -1;
        while (Input != 0) {
            System.out.println("Що ви бажаєте створити/додати/видалити/редагувати?");
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Факультет");
            System.out.println("2] Кафедру факультета");
            System.out.println("3] Студента");
            System.out.println("4] Викладача");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    ChooseActionMenuForFaculty(Univ);
                    break;
                case 2:
                    ChooseActionMenuForCathedra(Univ);
                    break;
                case 3:
                    ChooseActionMenuForStudent(Univ);
                    break;
                case 4:
                    ChooseActionMenuForTeacher(Univ);
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    //TODO VVV Actions of edit VVV
    private static void ChooseActionMenuForFaculty(University Univ){
        int Input = -1;
        Faculty TMPFacult = null;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Додати факультет");
            System.out.println("2] Видалити факультет");
            System.out.println("3] Редагувати факультет");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPFacult = AddFullFaculty(Univ);
                    if(TMPFacult != null){
                        Univ.addFaculty(TMPFacult);
                        Univ.saveAll();
                    }

                    break;
                case 2:
                    TMPFacult = SearchFaculty(Univ);
                    if(TMPFacult != null){
                        Univ.deleteFaculty(TMPFacult);
                        Univ.saveAll();
                    }

                    break;
                case 3:
                    TMPFacult = SearchFaculty(Univ);
                    if(TMPFacult != null){
                        AskWhatParamInFacultyToEdit(TMPFacult, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void ChooseActionMenuForCathedra(University Univ){
        int Input = -1;
        Cathedra TMPCathedra = null;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Додати кафедру");
            System.out.println("2] Видалити кафедру");
            System.out.println("3] Редагувати кафедру");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPCathedra = AddFullCathedra(Univ);
                    if(TMPCathedra != null){
                        Univ.addCathedra(TMPCathedra);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        Univ.deleteCathedra(TMPCathedra);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        AskWhatParamInCathedraToEdit(TMPCathedra, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void ChooseActionMenuForStudent(University Univ){
        int Input = -1;
        Student TMPStudent = null;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Додати студента");
            System.out.println("2] Видалити студента");
            System.out.println("3] Редагувати студента");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPStudent = AddFullStudent(Univ);
                    if(TMPStudent != null){
                        Univ.addStudent(TMPStudent);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    TMPStudent = SearchStudent(Univ);
                    if(TMPStudent != null){
                        Univ.deleteStudent(TMPStudent);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    TMPStudent = SearchStudent(Univ);
                    if(TMPStudent != null){
                        AskWhatParamInStudentToEdit(TMPStudent, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void ChooseActionMenuForTeacher(University Univ){
        int Input = -1;
        Teacher TMPTeacher = null;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Додати викладача");
            System.out.println("2] Видалити викладача");
            System.out.println("3] Редагувати викладача");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPTeacher = AddFullTeacher(Univ);
                    if(TMPTeacher != null){
                        Univ.addTeacher(TMPTeacher);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    TMPTeacher = SearchTeacher(Univ);
                    if(TMPTeacher != null){
                        Univ.deleteTeacher(TMPTeacher);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    TMPTeacher = SearchTeacher(Univ);
                    if(TMPTeacher != null){
                        AskWhatParamInTeacherToEdit(TMPTeacher, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }
    //TODO ^^^ Actions of edit ^^^
    //TODO VVV Finder VVV

    private static void FindWhoMenu(University Univ){
        int Input = -1;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Знайти викладача");
            System.out.println("2] Знайти студента");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:

                    break;
                case 2:

                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void FindByWhatStudent(University Univ){
        int Input = -1;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Знайти за ПІБ");
            System.out.println("2] Знайти за курсом");
            System.out.println("3] Знайти за групою");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    //TODO ^^^ Finder ^^^
    //TODO VVV Information VVV

    private static void StudentInfoMenu(University Univ){
        int Input = -1;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Вивести всіх студентів впорядкованих за курсами");
            System.out.println("2] Вивести всіх студентів факультета впорядкованих за алфавітом");
            System.out.println("3] Вивести всіх студентів кафедри впорядкованих за курсами");
            System.out.println("4] Вивести всіх студентів кафедри впорядкованих за алфавітом");
            System.out.println("5] Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    Univ.getAllStudentsByCourses();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    private static void TeacherInfoMenu(University Univ){
        int Input = -1;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Вивести всіх викладачів факультета впорядкованих за алфавітом");
            System.out.println("2] Вивести всіх викладачів кафедри впорядкованих за алфавітом");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:

                    break;
                case 2:

                    break;
                default:
                    break;
            }

            System.out.println("");
        }
    }

    //TODO ^^^ Information ^^^

    //TODO VVV VVV VVV
    private static Faculty AddFullFaculty(University Univ){
        Faculty Res;
        String NameOfFaculty = AskNamePartOfFaculty(Univ);
        if(NameOfFaculty == null){
            return null;
        }
        Res = new Faculty(NameOfFaculty);
        return Res;
    }

    private static String AskNamePartOfFaculty(University Univ){
        String NameOfFaculty;
        while(true){
            NameOfFaculty = AskNameOfFaculty();
            if(NameOfFaculty == null){
                return null;
            }
            Faculty SearchFacult = Univ.getFaculty(NameOfFaculty);
            if(SearchFacult == null){
                break;
            }
            else{
                System.out.println("Такий факультет вже існує повторіть");
            }
        }
        return NameOfFaculty;
    }

    private static String AskNameOfFaculty(){
        System.out.println("Введіть назву факультету, 0 для відміни");
        String Name = DataInput.getString(">");
        if(Name.charAt(0) == '0'){
            return null;
        }
        return Name;
    }

    private static Faculty SearchFaculty(University Univ){
        System.out.println("Доступні факультети:");

        for (int i = 0; i < Univ.getFaculties().length; i++){
            if((i % 3) == 0){
                System.out.print("\n");
            }
            System.out.print(Univ.getFaculties()[i]+"; ");
        }
        Faculty SearchFacult;
        while(true){
            String NameOfFaculty = AskNameOfFaculty();
            if(NameOfFaculty == null){
                return null;
            }
            SearchFacult = Univ.getFaculty(NameOfFaculty);
            if(SearchFacult != null){
                break;
            }
            else{
                System.out.println("Такого факультету не існує, повторіть");
            }
        }
        return SearchFacult;
    }

    private static void AskWhatParamInFacultyToEdit(Faculty Facult, University Univ){
        int Input = -1;
        Faculty ForChange = null;
        String NameForChange = null;
        while (Input != 0) {
            System.out.println("Виберіть параметр який бажаєте змінити");
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Змінити назву факултету");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    NameForChange = AskNamePartOfFaculty(Univ);
                    if(NameForChange != null){
                        ForChange = new Faculty(NameForChange);
                        Univ.editFaculty(Facult, ForChange);
                        Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }
            System.out.println("");
        }
    }
    //TODO ^^^ ^^^ ^^^
    //TODO VVV VVV VVV

    private static Cathedra AddFullCathedra(University Univ){
        Cathedra Res;

        String NameOfCathedra = AskNamePartOfCathedra(Univ);
        if(NameOfCathedra == null){
            return null;
        }

        System.out.println("Виберіть приписаний факультет");
        Faculty FacultyOfCathedra = SearchFaculty(Univ);
        if(FacultyOfCathedra == null){
            return null;
        }

        Res = new Cathedra(NameOfCathedra, FacultyOfCathedra);
        return Res;
    }

    private static String AskNamePartOfCathedra(University Univ){
        String NameOfCathedra;
        while(true){
            NameOfCathedra = AskNameOfCathedra();
            if(NameOfCathedra == null){
                return null;
            }
            Cathedra SearchCathedra = Univ.getCathedra(NameOfCathedra);
            if(SearchCathedra == null){
                break;
            }
            else{
                System.out.println("Така кафедра вже існує повторіть");
            }
        }
        return NameOfCathedra;
    }

    private static String AskNameOfCathedra(){
        System.out.println("Введіть назву кафедри, 0 для відміни");
        String Name = DataInput.getString(">");
        if(Name.charAt(0) == '0'){
            return null;
        }
        return Name;
    }

    private static Cathedra SearchCathedra(University Univ){
        System.out.println("Доступні кафедри:");

        for (int i = 0; i < Univ.getCathedras().length; i++){
            if((i % 3) == 0){
                System.out.print("\n");
            }
            System.out.print(Univ.getCathedras()[i]+"; ");
        }
        Cathedra SearchCathedra;
        while(true){
            String NameOfCathedra = AskNameOfCathedra();
            if(NameOfCathedra == null){
                return null;
            }
            SearchCathedra = Univ.getCathedra(NameOfCathedra);
            if(SearchCathedra != null){
                break;
            }
            else{
                System.out.println("Такого факультету не існує, повторіть");
            }
        }
        return SearchCathedra;
    }

    private static void AskWhatParamInCathedraToEdit(Cathedra Cathed, University Univ){
        int Input = -1;
        Cathedra ForChange = null;
        String NameForChange = null;
        Faculty FacultyForChange = null;
        while (Input != 0) {
            System.out.println("Виберіть параметр який бажаєте змінити");
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Змінити назву кафедри");
            System.out.println("2] Змінити приписаний факультет");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    NameForChange = AskNamePartOfCathedra(Univ);
                    if(NameForChange != null){
                        ForChange = new Cathedra(NameForChange, Cathed.getFaculty());
                        Univ.editCathedra(Cathed, ForChange);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    FacultyForChange = SearchFaculty(Univ);
                    if(FacultyForChange != null){
                        ForChange = new Cathedra(Cathed.getName(), FacultyForChange);
                        Univ.editCathedra(Cathed, ForChange);
                        Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }
            System.out.println("");
        }
    }

    //TODO ^^^ ^^^ ^^^
    //TODO VVV VVV VVV

    private static Student AddFullStudent(University Univ){
        Student Res;

        String NameOfStudent[] = AskNamePartOfStudent(Univ);
        if(NameOfStudent == null){
            return null;
        }

        System.out.println("Виберіть до якої кафедри приписан студент");
        Cathedra CathedraOfStudent = SearchCathedra(Univ);
        if(CathedraOfStudent == null){
            return null;
        }

        int Course = AskCourseOfStudent();
        if(Course == 0){
            return null;
        }

        int Group = AskGroupOfStudent();
        if(Group == 0){
            return null;
        }

        Res = new Student(NameOfStudent, CathedraOfStudent, Course, Group);
        return Res;
    }

    private static int AskCourseOfStudent(){
        System.out.println("Введіть курс, 0 для відміни");
        int Res;
        while (true){
            Res = DataInput.getInt(">");
            if(Res == 0){
                return 0;
            }
            else if( 1 <= Res && Res <= 6){
                return Res;
            }
            else {
                System.out.println("Не корректний курс, повторіть");
            }
        }
    }

    private static int AskGroupOfStudent(){
        System.out.println("Введіть групу, 0 для відміни");
        int Res;
        while (true){
            Res = DataInput.getInt(">");
            if(Res == 0){
                return 0;
            }
            else if( 1 <= Res){
                return Res;
            }
            else {
                System.out.println("Не корректний курс, повторіть");
            }
        }
    }

    private static String[] AskNamePartOfStudent(University Univ){
        String NameOfStudent[];
        while(true){
            NameOfStudent = AskNameOfStudent();
            if(NameOfStudent == null){
                return null;
            }
            Student SearchStudents[] = Univ.getAllStudents(NameOfStudent);
            if(SearchStudents == null){
                break;
            }
            else{
                System.out.println("Студент з таким ПІБ вже існує, повторіть");
            }
        }
        return NameOfStudent;
    }

    private static String[] AskNameOfStudent(){
        System.out.println("Введіть ПІБ студента, 0 для відміни");
        String Name[] = new String[3];
        Name[0] = DataInput.getString("Прізвище:");
        if(Name[0].charAt(0) == '0'){
            return null;
        }
        Name[1] = DataInput.getString("Ім'я:");
        if(Name[1].charAt(0) == '0'){
            return null;
        }
        Name[2] = DataInput.getString("Побатькові:");
        if(Name[2].charAt(0) == '0'){
            return null;
        }
        return Name;
    }

    private static Student SearchStudent(University Univ){

        Student SearchStudent[];
        while(true){
            String NameOfStudent[] = AskNameOfStudent();
            if(NameOfStudent == null){
                return null;
            }
            SearchStudent = Univ.getAllStudents(NameOfStudent);
            if(SearchStudent != null){
                break;
            }
            else{
                System.out.println("Такого студента не існує, повторіть");
            }
        }
        return SearchStudent[0];
    }

    private static void AskWhatParamInStudentToEdit(Student Stud, University Univ){
        int Input = -1;
        Student ForChange = null;
        String NameForChange[] = null;
        Cathedra CathedraForChange = null;
        int CourseForChange = 0;
        int GroupForChange = 0;
        while (Input != 0) {
            System.out.println("Виберіть параметр який бажаєте змінити");
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Змінити ПІБ");
            System.out.println("2] Змінити кафедру до якої приписаний студент");
            System.out.println("3] Змінити курс");
            System.out.println("4] Змінити групу");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    NameForChange = AskNamePartOfStudent(Univ);
                    if(NameForChange != null){
                        ForChange = new Student(NameForChange, Stud.getCathedra(), Stud.getCourse(), Stud.getGroup());
                        Univ.editStudent(Stud, ForChange);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    CathedraForChange = SearchCathedra(Univ);
                    if(CathedraForChange != null){
                        ForChange = new Student(Stud.getName(), CathedraForChange, Stud.getCourse(), Stud.getGroup());
                        Univ.editStudent(Stud, ForChange);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    CourseForChange = AskCourseOfStudent();
                    if(CourseForChange != 0){
                        ForChange = new Student(Stud.getName(), Stud.getCathedra(), CourseForChange, Stud.getGroup());
                        Univ.editStudent(Stud, ForChange);
                        Univ.saveAll();
                    }
                    break;
                case 4:
                    GroupForChange = AskGroupOfStudent();
                    if(GroupForChange != 0){
                        ForChange = new Student(Stud.getName(), Stud.getCathedra(), Stud.getCourse(), GroupForChange);
                        Univ.editStudent(Stud, ForChange);
                        Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }
            System.out.println("");
        }
    }

    //TODO ^^^ ^^^ ^^^
    //TODO VVV VVV VVV

    private static Teacher AddFullTeacher(University Univ){
        Teacher Res;

        String NameOfTeachers[] = AskNamePartOfTeacher(Univ);
        if(NameOfTeachers == null){
            return null;
        }

        System.out.println("Виберіть до якої кафедри приписан викладача");
        Cathedra CathedraOfTeacher = SearchCathedra(Univ);
        if(CathedraOfTeacher == null){
            return null;
        }

        Res = new Teacher(NameOfTeachers, CathedraOfTeacher);
        return Res;
    }

    private static String[] AskNamePartOfTeacher(University Univ){
        String NameOfSTeacher[];
        while(true){
            NameOfSTeacher = AskNameOfTeacher();
            if(NameOfSTeacher == null){
                return null;
            }
            Teacher SearchTeacher[] = Univ.getAllTeachers(NameOfSTeacher);
            if(SearchTeacher == null){
                break;
            }
            else{
                System.out.println("Викладач з таким ПІБ вже існує, повторіть");
            }
        }
        return NameOfSTeacher;
    }

    private static String[] AskNameOfTeacher(){
        System.out.println("Введіть ПІБ викладача, 0 для відміни");
        String Name[] = new String[3];
        Name[0] = DataInput.getString("Прізвище:");
        if(Name[0].charAt(0) == '0'){
            return null;
        }
        Name[1] = DataInput.getString("Ім'я:");
        if(Name[1].charAt(0) == '0'){
            return null;
        }
        Name[2] = DataInput.getString("Побатькові:");
        if(Name[2].charAt(0) == '0'){
            return null;
        }
        return Name;
    }

    private static Teacher SearchTeacher(University Univ){

        Teacher SearchTeacher[];
        while(true){
            String NameOfTeacher[] = AskNameOfTeacher();
            if(NameOfTeacher == null){
                return null;
            }
            SearchTeacher = Univ.getAllTeachers(NameOfTeacher);
            if(SearchTeacher != null){
                break;
            }
            else{
                System.out.println("Такого викладача не існує, повторіть");
            }
        }
        return SearchTeacher[0];
    }

    private static void AskWhatParamInTeacherToEdit(Teacher Teach, University Univ){
        int Input = -1;
        Teacher ForChange = null;
        String NameForChange[] = null;
        Cathedra CathedraForChange = null;
        int CourseForChange = 0;
        int GroupForChange = 0;
        while (Input != 0) {
            System.out.println("Виберіть параметр який бажаєте змінити");
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Змінити ПІБ");
            System.out.println("2] Змінити кафедру до якої приписаний викладач");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    NameForChange = AskNamePartOfTeacher(Univ);
                    if(NameForChange != null){
                        ForChange = new Teacher(NameForChange, Teach.getCathedra());
                        Univ.editTeacher(Teach, ForChange);
                        Univ.saveAll();
                    }
                    break;
                case 2:
                    CathedraForChange = SearchCathedra(Univ);
                    if(CathedraForChange != null){
                        ForChange = new Teacher(Teach.getName(), CathedraForChange);
                        Univ.editTeacher(Teach, ForChange);
                        Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }
            System.out.println("");
        }
    }


}
