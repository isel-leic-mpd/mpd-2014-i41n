package pt.isel.mpd14.probe.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import junit.framework.Assert;
import junit.framework.TestCase;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.probe.test.model.Student;
import pt.isel.mpd14.probe.test.model.StudentDto;

/**
 * Unit test for Binder class.
 */
public class BinderTest extends TestCase{
    
    final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public void test_bind_student_to_studentDto() throws ParseException, IllegalArgumentException, IllegalAccessException, InstantiationException
    {
        /*
         Arrange
        */
        Student s1 = new Student(31531, sdf.parse("05-6-1994"), "Jose Cocacola", null);
        Map<String, Object> s1fields = Binder.getFieldsValues(s1);
        /*
          Act
        */
        StudentDto s2 = Binder.bindToFields(StudentDto.class, s1fields);
        System.out.println(s2);
        
        /*
        if(s2.id != s1.id){
            throw new IllegalStateException();
        }
        */
        Assert.assertEquals(s1.id, s2.id);
        Assert.assertEquals(s1.name, s2.name);
        Assert.assertEquals(null, s2.birthDate);

    }
}
