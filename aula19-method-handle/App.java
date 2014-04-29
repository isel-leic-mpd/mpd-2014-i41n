
import java.util.LinkedList;
import java.util.List;


/*
 * 1st version => specify behavior through a Functional Interface -- 
 * interface containing just one method.
 */
interface Comparator<T>
{
    int compare(T o1, T o2);
}


class Collections
{

    /*
     * 1st version => specify behavior through a Functional Interface -- 
     * interface containing just one method.
     */
    public static <T> void Sort(List<T> elems, Comparator<? super T> cmp)
    {
        for (int i = 1; i < elems.size(); i++)
            for (int j = i; j > 0 &&
                     cmp.compare(elems.get(j - 1), elems.get(j)) > 0; j--)
            {
                T t = elems.get(j-1);
                elems.set(j-1, elems.get(j));
                elems.set(j, t);
            }
    }
}

class App
{
    static <T> void print(Iterable<T> elems) {
        for(T elem : elems)
        {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public static void main(String [] args)
    {
        List<Student> a = new LinkedList<>();
        a.add(new Student(344, "Elias"));
        a.add(new Student(123, "Maria"));
        a.add(new Student(78, "Gil"));
        a.add(new Student(204, "Zé"));

        print(a);
        
        Collections.Sort(a, new CmpStdById()); // 1st version 
        Collections.Sort(a, App::CompareStdById); // 2nd version -- Method Handle
        Collections.Sort(a, (s1, s2) -> s1.nr - s2.nr); // 3rd version 
        // Collections.Sort(a, (s1, s2) -> s1.name.compareTo(s2.name)); // 3rd version 
        print(a);

    }

    /*
     * 2nd version =>  specify behavior through a method compliant with the delegate Comparison
     */
    private static int CompareStdById(Student s1, Student s2)
    {
        return s1.nr - s2.nr;
    }

    /*
     * 1st version => specify behavior through the implementation of the Interface Comparator
     */
    static class CmpStdById implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2)
        {
            return s1.nr - s2.nr;
        }
    }
}


class Student
{
    public final int nr;
    public final String name;

    public Student(int nr, String name)
    {
        this.nr = nr;
        this.name = name;
    }

    @Override
    public  String toString()
    {
        return nr + " " + name;
    }

    public static Student parse(String line)
    {
        int nr = Integer.parseInt(line.substring(0, 5));
        String name = line.substring(6);
        return new Student(nr, name);
    }
}