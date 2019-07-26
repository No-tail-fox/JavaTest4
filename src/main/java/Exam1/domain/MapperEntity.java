package Exam1.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="stock_list")
public class MapperEntity {
    @Column(name = "Stock_Code")
    String Stock_Code;
    @Id
    @GeneratedValue(generator = "jdbc")
    int Stock_id;

    public String getStock_Code() {
        return Stock_Code;
    }

    public void setStock_Code(String stock_Code) {
        Stock_Code = stock_Code;
    }

    public int getStock_id() {
        return Stock_id;
    }

    public void setStock_id(int stock_id) {
        Stock_id = stock_id;
    }
}
