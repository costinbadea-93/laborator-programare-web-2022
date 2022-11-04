import beans.MathService;
import config.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /**
         * Lazy vs Eager
         */
//        System.out.println("Before context creation!!!!");
//        MathService mathService = context.getBean(MathService.class);
//        System.out.println("Calling method from service : " + mathService.add(3, 4));

        /**
         * Beans Scopes : SINGLETON and PROTOTYPE
         */
        MathService mathService1 = context.getBean(MathService.class);
        MathService mathService2 = context.getBean(MathService.class);
        System.out.println("HasCode for mathService1 " + mathService1.hashCode());
        System.out.println("HasCode for mathService2 " + mathService2.hashCode());
    }
}
