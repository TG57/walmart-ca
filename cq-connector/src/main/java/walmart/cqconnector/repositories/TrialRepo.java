package walmart.cqconnector.repositories;

import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.WriteResult;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import walmart.cqconnector.models.TrialModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TrialRepo extends CassandraRepository<TrialModel, Integer> {

}
