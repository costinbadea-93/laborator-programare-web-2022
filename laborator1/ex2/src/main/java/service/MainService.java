package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.MainRepository;

@Service
public class MainService {

    /**
     * We can use autowired:
     *  -on field
     *  -on constructor
     *  -on setter
     */

//    @Autowired
    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public int sum(int n1, int n2) {
      System.out.println("Computing and returning result ....");
      return mainRepository.sum(n1, n2);
    }

//    @Autowired
//    public void setMainRepository(MainRepository mainRepository) {
//        this.mainRepository = mainRepository;
//    }
}
