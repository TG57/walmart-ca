package walmart.cqconnector.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter

@Table("walmart")
public class TrialModel {
    @PrimaryKey
    Integer skuId;
    @Column
    int storeNo;
    @Column
    String eligibility;

    public TrialModel(Integer skuId, int storeNo, String eligibility) {
        this.skuId = skuId;
        this.storeNo = storeNo;
        this.eligibility = eligibility;
    }

}
