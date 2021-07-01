package walmart.cqconnector.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walmart.cqconnector.repositories.CSVRepo;

import java.util.List;

@Service
public class CSVServiceImpl implements CSVService{

    @Autowired
    CSVRepo csvRepo;

    @Override
    public Boolean saveCSVData( List<?> dataList ) {
        return csvRepo.addCSVData(dataList);
    }
}
