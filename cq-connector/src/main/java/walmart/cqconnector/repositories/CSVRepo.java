package walmart.cqconnector.repositories;

import java.util.List;

public interface CSVRepo {
    public Boolean addCSVData( List<?> csvList );
}
