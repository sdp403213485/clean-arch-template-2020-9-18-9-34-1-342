package com.thoughtworks.cleanarch;

import java.util.List;

public class Arg {
    private String flag;
    private Object value;
    private String type;

    public Arg(String flag, Object value) {
        this.flag = flag;
        this.value = value;
    }


    public static Arg of(List<String> asList) {
        return new Arg(asList.get(0),asList.get(1));
    }

    @Override
    public String toString() {
        return "Arg{" +
                "flag='" + flag + '\'' +
                ", value=" + value +
                '}';
    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }
}