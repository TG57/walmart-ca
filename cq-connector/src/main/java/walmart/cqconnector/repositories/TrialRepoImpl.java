//package walmart.cqconnector.repositories;
//
//import org.springframework.data.cassandra.core.CassandraBatchOperations;
//import org.springframework.data.cassandra.core.CassandraOperations;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.data.cassandra.core.WriteResult;
//import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
//import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
//import org.springframework.stereotype.Repository;
//import walmart.cqconnector.models.TrialModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TrialRepoImpl extends SimpleCassandraRepository<TrialModel,Integer> {
//    private final CassandraTemplate cassandraTemplate;
//
//    public TrialRepoImpl(
//            final CassandraTemplate cassandraTemplate,
//            CassandraEntityInformation<TrialModel, Integer> metadata,
//            CassandraOperations operations ) {
//        super(metadata, operations);
//        this.cassandraTemplate = cassandraTemplate;
//    }
//
//    @Override
//    public <S extends TrialModel> List<S> insert(Iterable<S> trialModel ){
//        final CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
//        List<S> arrayList = new ArrayList();
//
//        for(S entity : trialModel) {
//            batchOps.insert(entity);
//            arrayList.add(entity);
//        }
//
//        WriteResult ans = batchOps.execute();
//        System.out.println(ans);
//        return arrayList;
//    }
//}
