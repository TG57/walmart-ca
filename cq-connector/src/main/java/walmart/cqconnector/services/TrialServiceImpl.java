package walmart.cqconnector.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walmart.cqconnector.models.TrialModel;
import walmart.cqconnector.repositories.TrialRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TrialServiceImpl implements TrialService {
    @Autowired
    TrialRepo repository;

    Optional<TrialModel> response;

    @Override
    public boolean savetoDb(TrialModel data) {
        if(repository.existsById(data.getSkuId())){
            return false;
        }
        return data==repository.save(data);
    }

//    public boolean updateDb(TrialModel data){
//        return false;
//    }

    @Override
    public TrialModel findinDb(Integer id) {
        if(repository.existsById(id)) {
            response = repository.findById(id);
            return response.get();
        }
        return null;
    }

    @Override
    public boolean sendBatch(List<TrialModel> data) {
//        TrialRepoImpl customRepo = new TrialRepoImpl();
        repository.insert(data);
        return false;
    }

}
