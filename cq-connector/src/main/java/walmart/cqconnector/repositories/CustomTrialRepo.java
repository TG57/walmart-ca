package walmart.cqconnector.repositories;

import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.WriteResult;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import walmart.cqconnector.models.TrialModel;

import java.util.List;

@Repository
public class CustomTrialRepo {

    @Autowired
    private CassandraOperations cTemplate;

    public Boolean insertInBatch(List<TrialModel> data){
        CassandraBatchOperations batchOps  = cTemplate.batchOps();
        for(TrialModel x:data){
            batchOps.delete(x);
        }
        batchOps.execute();
        return false;
    }
}
