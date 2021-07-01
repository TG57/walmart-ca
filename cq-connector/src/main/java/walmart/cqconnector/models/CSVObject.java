package walmart.cqconnector.models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CSVObject {
    @CsvBindByPosition( position = 0 )
    private String skuId;

    @CsvBindByPosition( position = 1 )
    private String storeNo;

}
