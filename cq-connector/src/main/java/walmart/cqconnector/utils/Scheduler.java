package walmart.cqconnector.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import walmart.cqconnector.services.CSVService;

import java.io.IOException;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    CSVService csvService;

    @Scheduled(fixedRate = 6*60000)
    public void pushCSVToDB() throws IOException {
        System.out.println(CSVHelper.counter);
        List<?> data=null;
        // todo: read csv files from resource folder and use CSV helper to extract data in list format.
        csvService.saveCSVData(data);
    }

}
