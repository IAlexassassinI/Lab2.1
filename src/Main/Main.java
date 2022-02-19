package Main;

import UniversityUtilits.DataFile;
import UniversityUtilits.Menu;
import UniversityUtilits.University;

public class Main {

    public static void main(String[] args) {

        University CurrentUniversity = null;
        DataFile ForLoad = new DataFile("KMA.txt");
        try {
            CurrentUniversity = ForLoad.LoadAll();
        } catch (Exception e){
            CurrentUniversity = new University("KMA", "KMA.txt");
        }

        Menu.MainMenu(CurrentUniversity);

    }
}
