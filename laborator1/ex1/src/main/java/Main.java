import beans.Car;
import config.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /**
         * DI -> DEPENDENCY INJECTION (using IOC inversion of control)
         * AOP -> ASPECT ORIENTED PROGRAMMING
         */

        /**
         * ADD BEANS IN CONTEXT:
         * 1.@Bean
         * 2.Stereotype annotations(@Component, @Service, @Repository, @Controller etc);
         */

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /**
         * Retrieve a bean from context:
         * -by name
         * -by class
         */
//        Car bmw = (Car) context.getBean("BMW");
//        Car audi = (Car) context.getBean("audi");
        Car c = context.getBean(Car.class);
//        System.out.println(bmw);
        System.out.println(c);
    }
}
