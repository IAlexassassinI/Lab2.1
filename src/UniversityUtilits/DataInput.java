package UniversityUtilits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    private static String error = "Incorrect input value!";

    public static Byte getByte() {
        boolean isByte = false;
        Byte value = null;
        do {
            String s = getString();
            try {
                value = Byte.valueOf(s);
                isByte = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isByte);
        return value;
    }

    public static Byte getByte(String announcment) {
        boolean isByte = false;
        Byte value = null;
        do {
            String s = getString(announcment);
            try {
                value = Byte.valueOf(s);
                isByte = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isByte);
        return value;
    }

    public static Short getShort() {
        boolean isShort = false;
        Short value = null;
        do {
            String s = getString();
            try {
                value = Short.valueOf(s);
                isShort = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isShort);
        return value;
    }

    public static Short getShort(String announcment) {
        boolean isShort = false;
        Short value = null;
        do {
            String s = getString();
            try {
                value = Short.valueOf(s);
                isShort = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isShort);
        return value;
    }

    public static Integer getInt(){
        boolean isInt = false;
        Integer value = null;
        do {
            String s = getString();
            try {
                value = Integer.valueOf(s);
                isInt = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isInt);
        return value;
    }

    public static Integer getInt(String announcment){
        boolean isInt = false;
        Integer value = null;
        do {
            String s = getString(announcment);
            try {
                value = Integer.valueOf(s);
                isInt = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isInt);
        return value;
    }

    public static Long getLong() {
        boolean isLong = false;
        Long value = null;
        do {
            String s = getString();
            try {
                value = Long.valueOf(s);
                isLong = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isLong);
        return value;
    }

    public static Long getLong(String announcment) {
        boolean isLong = false;
        Long value = null;
        do {
            String s = getString(announcment);
            try {
                value = Long.valueOf(s);
                isLong = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isLong);
        return value;
    }

    public static Float getFloat() {
        boolean isFloat = false;
        Float value = null;
        do {
            String s = getString();
            try {
                value = Float.valueOf(s);
                isFloat = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isFloat);
        return value;
    }

    public static Float getFloat(String announcment) {
        boolean isFloat = false;
        Float value = null;
        do {
            String s = getString(announcment);
            try {
                value = Float.valueOf(s);
                isFloat = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isFloat);
        return value;
    }

    public static Double getDouble(){
        boolean isDouble = false;
        Double value = null;
        do {
            String s = getString();
            try {
                value = Double.valueOf(s);
                isDouble = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isDouble);
        return value;
    }

    public static Double getDouble(String announcment){
        boolean isDouble = false;
        Double value = null;
        do {
            String s = getString(announcment);
            try {
                value = Double.valueOf(s);
                isDouble = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isDouble);
        return value;
    }

    public static char getChar() {
        String s;
        do {
            s = getString();
            if(s.length() != 1) System.out.println(error);
        } while(s.length() != 1);
        return s.charAt(0);
    }

    public static char getChar(String announcment) {
        String s;
        do {
            s = getString(announcment);
            if(s.length() != 1) System.out.println(error);
        } while(s.length() != 1);
        return s.charAt(0);
    }

    public static String getString(){
        String res = "";
        boolean isString = false;
        do {
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                res = br.readLine();
                isString = true;
            } catch (IOException e) {
                System.out.println(error);
            }
        } while(!isString);
        return res;
    }

    public static String getString(String announcment){
        String res = "";
        boolean isString = false;
        do {
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.print(announcment);
                res = br.readLine();
                isString = true;
            } catch (IOException e) {
                System.out.println(error);
            }
        } while(!isString);
        return res;
    }

    public static Boolean getBoolean(String trueValue, String falseValue){
        Boolean value = null;
        do {
            String s = getString();
            if(s.equals(trueValue)){
                value = true;
            }
            else if(s.equals(falseValue)){
                value = false;
            }
            else {
                System.out.println(error);
            }
        } while(value == null);
        return value;
    }

    public static Boolean getBoolean(String announcment, String trueValue, String falseValue){
        Boolean value = null;
        do {
            String s = getString(announcment);
            if(s.equals(trueValue)){
                value = true;
            }
            else if(s.equals(falseValue)){
                value = false;
            }
            else {
                System.out.println(error);
            }
        } while(value == null);
        return value;
    }

    public static String getError() {
        return error;
    }

    public static void setError(String error) {
        DataInput.error = error;
    }
}
