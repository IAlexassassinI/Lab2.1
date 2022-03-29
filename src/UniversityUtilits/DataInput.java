package UniversityUtilits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class DataInput {

    private static String error = "Incorrect input value!";

    /**
     * asks to write byte value
     *
     * @return byte value
     */

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

    /**
     * asks to write byte value
     *
     * @param announcement string which will be written before
     * @return byte value
     */

    public static Byte getByte(String announcement) {
        boolean isByte = false;
        Byte value = null;
        do {
            String s = getString(announcement);
            try {
                value = Byte.valueOf(s);
                isByte = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isByte);
        return value;
    }

    /**
     * asks to write short value
     *
     * @return short
     */

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

    /**
     * asks to write short value
     *
     * @param announcement string which will be written before
     * @return short value
     */

    public static Short getShort(String announcement) {
        boolean isShort = false;
        Short value = null;
        do {
            String s = getString(announcement);
            try {
                value = Short.valueOf(s);
                isShort = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isShort);
        return value;
    }

    /**
     * asks to write integer value
     *
     * @return integer value
     */

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

    /**
     * asks to write integer value
     *
     * @param announcement string which will be written before
     * @return integer value
     */

    public static Integer getInt(String announcement){
        boolean isInt = false;
        Integer value = null;
        do {
            String s = getString(announcement);
            try {
                value = Integer.valueOf(s);
                isInt = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isInt);
        return value;
    }

    /**
     * asks to write long value
     *
     * @return long value
     */

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

    /**
     * asks to write long value
     *
     * @param announcement string which will be written before
     * @return long value
     */

    public static Long getLong(String announcement) {
        boolean isLong = false;
        Long value = null;
        do {
            String s = getString(announcement);
            try {
                value = Long.valueOf(s);
                isLong = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isLong);
        return value;
    }

    /**
     * asks to write float value
     *
     * @return float value
     */

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

    /**
     * asks to write float value
     *
     * @param announcement string which will be written before
     * @return float value
     */

    public static Float getFloat(String announcement) {
        boolean isFloat = false;
        Float value = null;
        do {
            String s = getString(announcement);
            try {
                value = Float.valueOf(s);
                isFloat = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isFloat);
        return value;
    }

    /**
     * asks to write double value
     *
     * @return double value
     */

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

    /**
     * asks to write double value
     *
     * @param announcement string which will be written before
     * @return double value
     */

    public static Double getDouble(String announcement){
        boolean isDouble = false;
        Double value = null;
        do {
            String s = getString(announcement);
            try {
                value = Double.valueOf(s);
                isDouble = true;
            } catch (Exception e){
                System.out.println(error);
            }
        } while(!isDouble);
        return value;
    }

    /**
     * asks to write char value
     *
     * @return char value
     */

    public static char getChar() {
        String s;
        do {
            s = getString();
            if(s.length() != 1) System.out.println(error);
        } while(s.length() != 1);
        return s.charAt(0);
    }

    /**
     * asks to write char value
     *
     * @param announcement string which will be written before
     * @return char value
     */

    public static char getChar(String announcement) {
        String s;
        do {
            s = getString(announcement);
            if(s.length() != 1) System.out.println(error);
        } while(s.length() != 1);
        return s.charAt(0);
    }

    /**
     * asks to write string value
     *
     * @return string value
     */

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

    /**
     * asks to write string value
     *
     * @param announcement string which will be written before
     * @return string value
     */

    public static String getString(String announcement){
        String res = "";
        boolean isString = false;
        do {
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                System.out.print(announcement);
                res = br.readLine();
                isString = true;
            } catch (IOException e) {
                System.out.println(error);
            }
        } while(!isString);
        return res;
    }

    /**
     * asks to write word value
     *
     * @return word value
     */

    public static String getWord() {
        String res = "";
        boolean isWord = false;
        do {
            String str = getString();
            if(str.length() <= 0)return str;
            StringTokenizer tokens = new StringTokenizer(str, " ");
            if(tokens.countTokens() != 1) {
                System.out.println(error);
                continue;
            }
            res = tokens.nextToken();
            if(!isWord(res)) System.out.println(error);
            else isWord = true;
        } while(!isWord);
        return res;
    }

    /**
     * asks to write word value
     *
     * @param announcement string which will be written before
     * @return word value
     */

    public static String getWord(String announcement) {
        String res = "";
        boolean isWord = false;
        do {
            String str = getString(announcement);
            if(str.length() <= 0)return str;
            StringTokenizer tokens = new StringTokenizer(str, " ");
            if(tokens.countTokens() != 1) {
                System.out.println(error);
                continue;
            }
            res = tokens.nextToken();
            if(!isWord(res)) System.out.println(error);
            else isWord = true;
        } while(!isWord);
        return res;
    }

    /**
     * asks to write sentence value
     *
     * @return sentence value
     */

    public static String getSentence() {
        StringBuilder res = new StringBuilder();
        boolean isSentence = true;
        do {
            isSentence = true;
            String str = getString();
            if(str.length() <= 0)return str;
            StringTokenizer tokens = new StringTokenizer(str, " ");
            if(tokens.countTokens() <= 0) {
                System.out.println(error);
                isSentence = false;
            }
            else {
                res.delete(0, res.length());
                while(tokens.hasMoreTokens()) {
                    String s = tokens.nextToken();
                    if(isWord(s)){
                        res.append(s);
                        if(tokens.hasMoreTokens()) res.append(" ");
                    }
                    else {
                        System.out.println(error);
                        isSentence = false;
                        break;
                    }
                }
            }
        } while(!isSentence);
        return res.toString();
    }

    /**
     * asks to write sentence value
     *
     * @param announcement string which will be written before
     * @return sentence value
     */

    public static String getSentence(String announcement) {
        StringBuilder res = new StringBuilder();
        boolean isSentence = true;
        do {
            isSentence = true;
            String str = getString(announcement);
            if(str.length() <= 0)return str;
            StringTokenizer tokens = new StringTokenizer(str, " ");
            if(tokens.countTokens() <= 0) {
                System.out.println(error);
                isSentence = false;
            }
            else {
                res.delete(0, res.length());
                while(tokens.hasMoreTokens()) {
                    String s = tokens.nextToken();
                    if(isWord(s)){
                        res.append(s);
                        if(tokens.hasMoreTokens()) res.append(" ");
                    }
                    else {
                        System.out.println(error);
                        isSentence = false;
                        break;
                    }
                }
            }
        } while(!isSentence);
        return res.toString();
    }

    /**
     *
     * @param s string
     * @return is string a word
     */

    private static boolean isWord(String s) {
        if(s == null)return false;
        if(s.length() <= 0)return false;
        for(char c : s.toCharArray()) {
            if(!(Character.isLetter(c) || c == '.' || c == '\'' || c == '-' || Character.isDigit(c)))return false;
        }
        return true;
    }

    /**
     *
     * @param trueValue true value
     * @param falseValue false value
     * @return boolean value
     */

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

    /**
     *
     * @param announcement string which will be written before
     * @param trueValue true value
     * @param falseValue false value
     * @return boolean value
     */

    public static Boolean getBoolean(String announcement, String trueValue, String falseValue){
        Boolean value = null;
        do {
            String s = getString(announcement);
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

    /**
     *
     *
     * @return error string
     */

    public static String getError() {
        return error;
    }

    /**
     * sets new error
     *
     * @param error new error
     */

    public static void setError(String error) {
        DataInput.error = error;
    }
}
