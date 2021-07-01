package walmart.cqconnector.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CSVRepoImpl implements CSVRepo{
    @Override
    public Boolean addCSVData( List<?> csvList ) {
        // todo: insert data of this list to casandra db
        return null;
    }
}
