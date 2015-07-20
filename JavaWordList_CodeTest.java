package deloittecodetest;

import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lakshmi P Mamidanna
 */
public class DeloitteCodeTest {

    public static void main(String[] args) {
        
        String[] names = {"MARY", "JOE", "SIENNA", "PETER"};
        List<String> wordList = Arrays.asList(names);

        // Create a hash map
        Map<String, String> hm = new HashMap<String, String>();

        // Default Date
        String default_date = "1990-04-16";
        System.out.println("Default Date = " + default_date + "\n");
        
        for (String e : wordList) {
            String name = e.substring(0, 1).toUpperCase() + e.substring(1).toLowerCase();
            int name_length = name.length();
            int default_year = Integer.parseInt(default_date.substring(0, 4));
            int current_person_birth_year = default_year - name_length;
            
            String birth_date = current_person_birth_year + "-04-16";
            System.out.println("Name = " + name + " | Birth Year = " + current_person_birth_year);
            hm.put(name, birth_date);
        }

        System.out.println("\nMary was born in " + getBirthYear( hm.get("Mary") ) + " and is " + getAge( hm.get("Mary") ) + " years old.");
        System.out.println("Joe was born in " + getBirthYear( hm.get("Joe") ) + " and is " + getAge( hm.get("Joe") ) + " years old.");
        System.out.println("Sienna was born in " + getBirthYear( hm.get("Sienna") ) + " and is " + getAge( hm.get("Sienna") ) + " years old.");
        System.out.println("Peter was born in " + getBirthYear( hm.get("Peter") ) + " and is " + getAge( hm.get("Peter") ) + " years old. \n\n");
    }
    
    public static int getBirthYear( Object birth_date ) {
        String birth_date_str = birth_date.toString();
        int birthYear = Integer.parseInt(birth_date_str.substring(0, 4));
        return birthYear;
    }
    
    public static int getAge( Object birth_date_obj ) {
        String birth_date = birth_date_obj.toString();

        // For BirthDate
        int yearDOB = Integer.parseInt(birth_date.substring(0, 4));
        int monthDOB = Integer.parseInt(birth_date.substring(5, 7));
        int dayDOB = Integer.parseInt(birth_date.substring(8, 10));

        // For Current Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        java.util.Date date = new java.util.Date();
        int thisYear = Integer.parseInt(dateFormat.format(date));

        dateFormat = new SimpleDateFormat("MM");
        date = new java.util.Date();
        int thisMonth = Integer.parseInt(dateFormat.format(date));

        dateFormat = new SimpleDateFormat("dd");
        date = new java.util.Date();
        int thisDay = Integer.parseInt(dateFormat.format(date));

        // Create "age" variable and set to the Current year minus Birth Year
        int age = thisYear - yearDOB;

        // If Current Month < Birth Month
        // Then Reduce the "age" by 1
        // As they haven't had their birthday this year yet
        if (thisMonth < monthDOB) {
            age = age - 1;
        }
        
        // If Birth Month == Current Month
        // Then Check the day if they had Birthday yet
        // If Current Day < Birth Day
        // Then Reduce the "age" by 1
        // As they haven't had their birthday this year yet
        if (thisMonth == monthDOB && thisDay < dayDOB) {
                age = age - 1;
        }

        // Return the exact "age"
        return age;
    }

}
