package com.example.demo.Controllers;
import com.opencsv.bean.CsvBindByPosition;


public class CSVObject {

    @CsvBindByPosition(position = 0)
    private String skuId;

    @CsvBindByPosition(position = 1)
    private String storeNo;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    @Override
    public String toString(){
        return skuId + "\t" + storeNo;
    }
}
