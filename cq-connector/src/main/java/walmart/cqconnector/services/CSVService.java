package walmart.cqconnector.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CSVService {
    public Boolean saveCSVData( List<?> dataList );
}
