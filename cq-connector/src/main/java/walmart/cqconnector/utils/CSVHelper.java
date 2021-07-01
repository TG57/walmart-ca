package walmart.cqconnector.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;
import walmart.cqconnector.models.CSVObject;
import walmart.cqconnector.responses.CustomResponse;

import java.io.*;
import java.util.List;

public class CSVHelper {

    public static int counter;

    public List<?> extractData( MultipartFile file ,Class targetClass){

        List<?> data=null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<CSVObject> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVObject.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            data = csvToBean.parse();
            for(int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public int saveCSVFile(MultipartFile csv){
        File file = new File(
                "src/main/resources/csv_"+ counter +".csv");

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(csv.getBytes());
            counter++;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

}
