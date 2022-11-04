package service;

import connection.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final DBConnection dbConnection;

    @Autowired
    public MainService(@Qualifier("oracle") DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void connectToDb() {
        dbConnection.connectToDb();
    }
}
