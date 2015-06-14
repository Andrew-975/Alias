package com.example.andrew_975.alias.entities;
import com.orm.SugarRecord;
/**
 * Created by Yohan on 10.05.2015.
 */
public class Description extends SugarRecord<Description> {

    private int descrId;

    private String descrText;

    public Description(int descrId,String descrText) {
        this.descrId = descrId;
        this.descrText = descrText;
    }

    public Description() {

    }

    public int getDescrId() {
        return descrId;
    }

    public String getDescrText() {
        return descrText;
    }

    public void setDescrId(int descrId) {
        this.descrId = descrId;
    }

    public void setDescrText(String descrText) {
        this.descrText = descrText;
    }
}
