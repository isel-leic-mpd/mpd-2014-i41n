package probe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {

    final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) 
            throws ParseException, IllegalAccessException, InstantiationException
    {
        /*
         Arrange
        */
        Student s1 = new Student(31531, sdf.parse("05-6-1994"), "Jose Cocacola", null);
        Map<String, Object> s1fields = Binder.getFieldsValues(s1);
        /*
          Act
        */
        StudentDto s2 = Binder.bindTo(StudentDto.class, s1fields);
        System.out.println(s2);
        
        /*
        if(s2.id != s1.id){
            throw new IllegalStateException();
        }
        */
        assert s2.id == s1.id;
        assert s2.name.equals(s1.name);
        assert s1.birthDate.equals(s2.birthDate);
    }
}

class StudentDto {

    int id;
    String birthDate;
    String name;

    @Override
    public String toString() {
        return "StudentDto{" + "id=" + id + ", birthDate=" + birthDate + ", name=" + name + '}';
    }
    
}

class Grade {
}

class Course {
}

class Student {

    final int id;
    final Date birthDate;
    final List<Grade> grades;
    final String name;
    final Course course;

    public Student(int id, Date birthDate, String name, Course course) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.course = course;
        this.grades = new LinkedList<>();
    }
}
