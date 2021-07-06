package walmart.cqconnector.models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table("walmart")
public class TrialModel {
    @PrimaryKey
    @Id
    @CsvBindByPosition( position = 0 )
    Integer skuId;

    @Column
    @CsvBindByPosition( position = 1 )
    Integer storeNo;

    @Column
    @CsvBindByPosition( position = 2 )
    String eligibility;

    public TrialModel(Integer skuId, int storeNo, String eligibility) {
        this.skuId = skuId;
        this.storeNo = storeNo;
        this.eligibility = eligibility;
    }

    public TrialModel(){

    }

}
