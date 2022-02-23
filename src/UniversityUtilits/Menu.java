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

            System.out.println();
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

            System.out.println();
        }
    }

    //TODO VVV Actions of edit VVV
    private static void ChooseActionMenuForFaculty(University Univ){
        int Input = -1;
        Faculty TMPFacult;
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

            System.out.println();
        }
    }

    private static void ChooseActionMenuForCathedra(University Univ){
        int Input = -1;
        Cathedra TMPCathedra;
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

            System.out.println();
        }
    }

    private static void ChooseActionMenuForStudent(University Univ){
        int Input = -1;
        Student TMPStudent;
        Student TMPStudentMass[];
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
                    TMPStudentMass = SearchStudent(Univ);
                    TMPStudent = (Student) SpecifyObject(TMPStudentMass);
                    if(TMPStudent != null){
                        Univ.deleteStudent(TMPStudent);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    TMPStudentMass = SearchStudent(Univ);
                    TMPStudent = (Student) SpecifyObject(TMPStudentMass);
                    if(TMPStudent != null){
                        AskWhatParamInStudentToEdit(TMPStudent, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    private static void ChooseActionMenuForTeacher(University Univ){
        int Input = -1;
        Teacher TMPTeacher;
        Teacher TMPTeacherMass[];
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
                    TMPTeacherMass = SearchTeacher(Univ);
                    TMPTeacher = (Teacher) SpecifyObject(TMPTeacherMass);
                    if(TMPTeacher != null){
                        Univ.deleteTeacher(TMPTeacher);
                        Univ.saveAll();
                    }
                    break;
                case 3:
                    TMPTeacherMass = SearchTeacher(Univ);
                    TMPTeacher = (Teacher) SpecifyObject(TMPTeacherMass);
                    if(TMPTeacher != null){
                        AskWhatParamInTeacherToEdit(TMPTeacher, Univ);
                        //Univ.saveAll();
                    }
                    break;
                default:
                    break;
            }

            System.out.println();
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
                    FindByWhatTeacher(Univ);
                    break;
                case 2:
                    FindByWhatStudent(Univ);
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    private static void PrintAllHumanFromList(Human List[]){
        if(List == null){
            System.out.println("Не вдалося нікого знайти");
        }
        else{
            int Length = List.length;
            for(int i = 0; i < Length; i++){
                System.out.println(List[i]);
            }
        }
        System.out.println();
    }

    //TODO CHANGING WIP
    private static void FindByWhatStudent(University Univ){
        int Input = -1;
        String TMPName[] = null;
        int TMPCourse = 0;
        int TMPGroup = 0;
        Student ForAnswer[] = null;
        while (Input != 0) {
            System.out.println("Поточні параметри пошуку:");

            System.out.print("ПІБ: ");
            if(TMPName == null){
                System.out.println("параметр не задано");
            }
            else{
                System.out.println("\""+TMPName[0]+"_"+TMPName[1]+"_"+TMPName[2]+"\"");
            }

            System.out.print("Курс :");
            if(TMPCourse == 0){
                System.out.println("параметр не задано");
            }
            else{
                System.out.println(TMPCourse);
            }

            System.out.print("Група: ");
            if(TMPGroup == 0){
                System.out.println("параметр не задано");
            }
            else{
                System.out.println(TMPGroup);
            }

            System.out.println();

            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Запустити пошук");
            System.out.println("2] Встановити параметр для пошуку за ПІБ");
            System.out.println("3] Встановити параметр для пошуку за курсом");
            System.out.println("4] Встановити параметр для пошуку за групою");
            System.out.println("Попередження: за умови відміни встановлення параметра пошуку, він буде анульований");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    ForAnswer = Univ.getAllStudentsByParams(TMPName, TMPCourse, TMPGroup);
                    PrintAllHumanFromList(ForAnswer);
                    break;
                case 2:
                    TMPName = AskNameOfStudent();
                    break;
                case 3:
                    TMPCourse = AskCourseOfStudent();
                    break;
                case 4:
                    TMPGroup = AskGroupOfStudent();
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    private static void FindByWhatTeacher(University Univ) {
        int Input = -1;
        String TMPName[];
        Teacher ForAnswer[];
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Знайти за ПІБ");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPName = AskNameOfTeacher();
                    if(TMPName != null){
                        ForAnswer = Univ.getAllTeachers(TMPName);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }



    //TODO ^^^ Finder ^^^
    //TODO VVV Information VVV

    private static void StudentInfoMenu(University Univ){
        int Input = -1;
        Student ForAnswer[];
        Faculty TMPFacult;
        Cathedra TMPCathedra;
        int TMPCourse = 0;
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
                    ForAnswer = Univ.getAllStudentsByCourses();
                    PrintAllHumanFromList(ForAnswer);
                    break;
                case 2:
                    TMPFacult = SearchFaculty(Univ);
                    if(TMPFacult != null){
                        ForAnswer = Univ.getAllStudentsFromFaculty(TMPFacult);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                case 3:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        ForAnswer = Univ.getAllStudentsFromCathedraByCourses(TMPCathedra);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                case 4:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        ForAnswer = Univ.getAllStudentsFromCathedra(TMPCathedra);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                case 5:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        TMPCourse = AskCourseOfStudent();
                        if(TMPCourse != 0){
                            ForAnswer = Univ.getAllStudentsFromCathedraFromCourse(TMPCathedra, TMPCourse);
                            PrintAllHumanFromList(ForAnswer);
                        }
                    }
                    break;
                default:
                    break;
            }

            System.out.println();
        }
    }

    private static void TeacherInfoMenu(University Univ){
        int Input = -1;
        Faculty TMPFacult;
        Teacher ForAnswer[];
        Cathedra TMPCathedra;
        while (Input != 0) {
            System.out.println("0] Повернутись до попереднього меню");
            System.out.println("1] Вивести всіх викладачів факультета впорядкованих за алфавітом");
            System.out.println("2] Вивести всіх викладачів кафедри впорядкованих за алфавітом");
            System.out.println("Що ви бажаєте зробити");
            Input = DataInput.getInt(">");

            switch (Input) {
                case 1:
                    TMPFacult = SearchFaculty(Univ);
                    if(TMPFacult != null){
                        ForAnswer = Univ.getAllTeachersFromFaculty(TMPFacult);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                case 2:
                    TMPCathedra = SearchCathedra(Univ);
                    if(TMPCathedra != null){
                        ForAnswer = Univ.getAllTeachersFromCathedra(TMPCathedra);
                        PrintAllHumanFromList(ForAnswer);
                    }
                    break;
                default:
                    break;
            }

            System.out.println();
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
        System.out.println("Введіть назву факультету, 0 або пуста стрічка для відміни");
        String Name = DataInput.getSentence(">");
        if(Name.length() <= 0){
            return null;
        }
        try {
            int Nuller = Integer.parseInt(Name);
            if(Nuller == 0){
                return null;
            }
        } catch (NumberFormatException e) {

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
        System.out.println();
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
        System.out.println();
        return SearchFacult;
    }

    private static void AskWhatParamInFacultyToEdit(Faculty Facult, University Univ){
        int Input = -1;
        Faculty ForChange;
        String NameForChange;
        while (Input != 0) {
            PrintCurrentInformation(Facult);

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
            System.out.println();
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
        System.out.println("Введіть назву кафедри, 0 або пуста стрічка для відміни");
        String Name = DataInput.getSentence(">");
        if(Name.length() <= 0){
            return null;
        }
        try {
            int Nuller = Integer.parseInt(Name);
            if(Nuller == 0){
                return null;
            }
        } catch (NumberFormatException e) {

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
        System.out.println();
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
                System.out.println("Такої кафедри не існує, повторіть");
            }
        }
        System.out.println();
        return SearchCathedra;
    }

    private static void AskWhatParamInCathedraToEdit(Cathedra Cathed, University Univ){
        int Input = -1;
        Cathedra ForChange;
        String NameForChange;
        Faculty FacultyForChange;
        while (Input != 0) {
            PrintCurrentInformation(Cathed);

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
            System.out.println();
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
                System.out.println("Не корректна група, повторіть");
            }
        }
    }

    private static String[] AskNamePartOfStudent(University Univ){
        String NameOfStudent[];

        NameOfStudent = AskNameOfStudent();
        if(NameOfStudent == null){
            return null;
        }

        return NameOfStudent;
    }

    private static String[] AskNameOfHuman(){
        String Name[] = new String[3];
        Name[0] = DataInput.getWord("Прізвище:");
        if(Name[0].length() <= 0){
            return null;
        }
        try {
            int Nuller = Integer.parseInt(Name[0]);
            if(Nuller == 0){
                return null;
            }
        } catch (NumberFormatException e) {

        }
        Name[1] = DataInput.getWord("Ім'я:");
        if(Name[1].length() <= 0){
            return null;
        }
        try {
            int Nuller = Integer.parseInt(Name[1]);
            if(Nuller == 0){
                return null;
            }
        } catch (NumberFormatException e) {

        }
        Name[2] = DataInput.getWord("Побатькові:");
        if(Name[2].length() <= 0){
            return null;
        }
        try {
            int Nuller = Integer.parseInt(Name[2]);
            if(Nuller == 0){
                return null;
            }
        } catch (NumberFormatException e) {

        }
        return Name;
    }

    private static String[] AskNameOfStudent(){
        System.out.println("Введіть ПІБ студента, 0 або пуста стрічка для відміни");
        return AskNameOfHuman();
    }

    private static Student[] SearchStudent(University Univ){
        //TODO
        //TODO Clones allowed
        //TODO

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
        return SearchStudent;
    }

    private static void AskWhatParamInStudentToEdit(Student Stud, University Univ){
        int Input = -1;
        Student ForChange;
        String NameForChange[];
        Cathedra CathedraForChange;
        int CourseForChange;
        int GroupForChange;
        while (Input != 0) {
            PrintCurrentInformation(Stud);

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
            System.out.println();
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

        NameOfSTeacher = AskNameOfTeacher();
        if(NameOfSTeacher == null){
            return null;
        }

        return NameOfSTeacher;
    }

    private static String[] AskNameOfTeacher(){
        System.out.println("Введіть ПІБ викладача, 0 або пуста стрічка для відміни");
        return AskNameOfHuman();
    }

    private static Teacher[] SearchTeacher(University Univ){

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
        return SearchTeacher;
    }

    private static void AskWhatParamInTeacherToEdit(Teacher Teach, University Univ){
        int Input = -1;
        Teacher ForChange;
        String NameForChange[];
        Cathedra CathedraForChange;
        while (Input != 0) {
            PrintCurrentInformation(Teach);

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
            System.out.println();
        }
    }

    private static void PrintCurrentInformation(Faculty ForPrint){
        if(ForPrint != null){
            System.out.println("Поточна інформація:");
            System.out.println();
            System.out.println("Назва: \""+ForPrint.getName()+"\"");
            System.out.println();
        }
    }

    private static void PrintCurrentInformation(Cathedra ForPrint){
        if(ForPrint != null){
            System.out.println("Поточна інформація:");
            System.out.println();
            System.out.println("Назва: \""+ForPrint.getName()+"\"");
            System.out.println("Приписаний факультет: \""+ForPrint.getFaculty().getName()+"\"");
            System.out.println();
        }
    }

    private static void PrintCurrentInformationH(Human ForPrint){
        if(ForPrint != null){
            System.out.println("Поточна інформація:");
            System.out.println();
            System.out.println("ПІБ: \""+ForPrint.getName()[0]+"_"+ForPrint.getName()[1]+"_"+ForPrint.getName()[2]+"\"");
            System.out.println("Приписана кафедра: \""+ForPrint.getCathedra().getName()+"\"");
            System.out.println("Приписаний факультет: \""+ForPrint.getCathedra().getFaculty().getName()+"\"");
        }
    }

    private static void PrintCurrentInformation(Student ForPrint){
        if(ForPrint != null){
            PrintCurrentInformationH(ForPrint);
            System.out.println("Курс: "+ForPrint.getCourse());
            System.out.println("Група: "+ForPrint.getGroup());
            System.out.println();
        }
    }

    private static void PrintCurrentInformation(Teacher ForPrint){
        if(ForPrint != null){
            PrintCurrentInformationH(ForPrint);
            System.out.println();
        }
    }

    private static Object SpecifyObject(Object[] Mass){
        if(Mass.length == 1){
            return Mass[0];
        }
        int Input = -1;
        if (Mass == null){
            return null;
        }

        while (Input != 0) {

            System.out.println("Уточніть запит");
            System.out.println("0] Повернутись до попереднього меню");
            for(int i = 0; i < Mass.length; i++){
                System.out.println((i+1)+"] "+Mass[i]);
            }

            Input = DataInput.getInt(">");
            if(Input != 0){
                return Mass[Input-1];
            }

            System.out.println();
        }
        return null;
    }

}
