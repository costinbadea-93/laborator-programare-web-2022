package connectionImpl;

import connection.DBConnection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "oracle")
//@Qualifier("oracle")
public class OracleDBConnection implements DBConnection {
    @Override
    public void connectToDb() {
        System.out.println("connecting via oracle ...");
    }
}
