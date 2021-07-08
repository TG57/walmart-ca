package walmart.cqconnector.utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.web.multipart.MultipartFile;
import walmart.cqconnector.models.CSVObject;
import walmart.cqconnector.responses.CustomResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static int counter;

    public List<?> extractData( MultipartFile file ,Class targetClass){

        List<?> data=null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(targetClass)
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
// work in progress for saving CSV data
    public int saveCSVFile(List<CSVObject> csv) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        File file = new File(
                "src/main/resources/csv_"+ counter +".csv");

//        try (OutputStream os = new FileOutputStream(file)) {
//            os.write(csv.getBytes());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try (
                Writer writer = Files.newBufferedWriter(Paths.get("currentCSV.csv"));
        ) {
            StatefulBeanToCsv<CSVObject> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();


            beanToCsv.write(csv);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
