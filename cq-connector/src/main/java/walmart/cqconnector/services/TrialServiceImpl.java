package walmart.cqconnector.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walmart.cqconnector.models.TrialModel;
import walmart.cqconnector.repositories.TrialRepo;

@Service
public class TrialServiceImpl implements TrialService {
    @Autowired
    TrialRepo repository;
    //send interface for autowire
    @Override
    public boolean savetoDb(TrialModel data) {
        return data==repository.save(data);
    }
}
