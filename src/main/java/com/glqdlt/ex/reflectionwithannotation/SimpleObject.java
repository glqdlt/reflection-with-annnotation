package com.glqdlt.ex.reflectionwithannotation;

import lombok.Data;

import java.util.Date;

/**
 * @author glqdlt
 * 2019-02-19
 */
public class SimpleObject {
    public String getStringType() {
        return stringType;
    }

    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public Integer getIntegerType() {
        return integerType;
    }

    public void setIntegerType(Integer integerType) {
        this.integerType = integerType;
    }

    public int getIntType() {
        return intType;
    }

    public void setIntType(int intType) {
        this.intType = intType;
    }

    public long getLongType() {
        return longType;
    }

    public void setLongType(long longType) {
        this.longType = longType;
    }

    public Long getLongObjectType() {
        return longObjectType;
    }

    public void setLongObjectType(Long longObjectType) {
        this.longObjectType = longObjectType;
    }

    public Date getDateType() {
        return dateType;
    }

    public void setDateType(Date dateType) {
        this.dateType = dateType;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }


    public void setNotMethod(String notMethod) {
        this.notMethod = notMethod;
    }

    @IndexAnnotation
    private String stringType;

    @IndexAnnotation
    private Integer integerType;
    @IndexAnnotation(getMethodNamePrefix = "pipe")
    private int intType;
    public String pipeIntType(){
        int _t = this.intType;
        switch (_t){
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            default:
                return String.valueOf(_t+"_String");
        }
    }

    private long longType;

    @IndexAnnotation
    private Long longObjectType;
    @IndexAnnotation
    private Date dateType;
    @IndexAnnotation(getMethodNamePrefix = "is")
    private boolean used;
    @IndexAnnotation(parseSkip = true)
    private String skip;

    @IndexAnnotation
    private String notMethod;
}
