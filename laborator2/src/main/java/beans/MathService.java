package beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
//@Lazy
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MathService {

    @PostConstruct
    public void init() {
        System.out.println("Math service has been created!!!");
    }

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}
