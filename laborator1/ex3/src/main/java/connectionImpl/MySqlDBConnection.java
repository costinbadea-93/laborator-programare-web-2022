package connectionImpl;

import connection.DBConnection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mysql")
//@Qualifier("mysql")
public class MySqlDBConnection implements DBConnection {
    @Override
    public void connectToDb() {
        System.out.println("Connection via mysql...");
    }
}
