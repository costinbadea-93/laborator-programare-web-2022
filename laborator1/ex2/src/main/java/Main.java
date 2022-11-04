import configuration.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MainService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MainService mainService = context.getBean(MainService.class);
        System.out.println("3 + 4 = " + mainService.sum(3, 4));
    }
}
