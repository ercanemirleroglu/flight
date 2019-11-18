package com.project.flight.model;

public class Flight {

    private int id;

    private String flt_no;

    private String departuer_date;

    private String dep_port;

    private String arr_port;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlt_no() {
        return flt_no;
    }

    public void setFlt_no(String flt_no) {
        this.flt_no = flt_no;
    }

    public String getDepartuer_date() {
        return departuer_date;
    }

    public void setDepartuer_date(String departuer_date) {
        this.departuer_date = departuer_date;
    }

    public String getDep_port() {
        return dep_port;
    }

    public void setDep_port(String dep_port) {
        this.dep_port = dep_port;
    }

    public String getArr_port() {
        return arr_port;
    }

    public void setArr_port(String arr_port) {
        this.arr_port = arr_port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ID=" + id +
                ", FLT_NO='" + flt_no + '\'' +
                ", DEPARTUER_DATE=" + departuer_date +
                ", DEP_PORT='" + dep_port + '\'' +
                ", ARR_PORT='" + arr_port + '\'' +
                ", STATUS='" + status + '\'' +
                '}';
    }
}
