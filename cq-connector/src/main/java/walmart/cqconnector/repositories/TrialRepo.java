package walmart.cqconnector.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import walmart.cqconnector.models.TrialModel;

@Repository
public interface TrialRepo extends CassandraRepository<TrialModel, Integer> {

//    public boolean savetoDB(TrialModel data);
}
