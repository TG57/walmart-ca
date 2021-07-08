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
        Boolean ans=true;
        CassandraBatchOperations batchOps = cTemplate.batchOps();
        //batchOps = cTemplate.batchOps()
        for(int i=0;i<data.size();i++) {
            batchOps.insert(data.get(i));
            if((i+1)%200==0 || i==data.size()-1) {
                ans = ans & batchOps.execute().wasApplied();
                batchOps = cTemplate.batchOps();
            }
        }
        return  ans;
    }
}
