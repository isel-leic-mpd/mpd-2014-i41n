package pt.isel.mpd14.aula32;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        List<Product> prods = new LinkedList<Product>();
        prods.add(new Product(1, "Atum", 5.2, 100));
        prods.add(new Product(2, "Sardinha ", 15.2, 10));
        prods.add(new Product(3, "Olivas", 11.2, 100));
        prods.add(new Product(4, "Batatas", 13.7, 75));
        prods.add(new Product(5, "Eliecticos", 5.2, 100));

        /*
        prods.stream()
            .filter(new ReflectPredicate<>("unitsInStock", 100))
            .filter(new ReflectPredicate<>("unitPrice", 5.2))
            .forEach(System.out::println);
        */
        
        /*
        Predicate<Product> p = ReflectUtils.and(
                new ReflectPredicate<>("unitsInStock", 100),
                new ReflectPredicate<>("unitPrice", 5.2));
        
        prods.stream().filter(p).forEach(System.out::println);
        */
        
        ReflectUtils.reflect(prods)
            .filter("unitsInStock", 100)
            .filter("unitPrice", 5.2)
            .forEach(System.out::println);

    }
}
