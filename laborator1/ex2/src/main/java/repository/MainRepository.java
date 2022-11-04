package repository;

import org.springframework.stereotype.Repository;

@Repository
public class MainRepository {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
}
