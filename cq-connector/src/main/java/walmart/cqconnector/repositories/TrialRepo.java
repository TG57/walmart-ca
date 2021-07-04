package walmart.cqconnector.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.stereotype.Repository;
import sun.java2d.pipe.SpanShapeRenderer;
import walmart.cqconnector.models.TrialModel;

@Repository
public interface TrialRepo extends CassandraRepository<TrialModel, Integer> {

}
