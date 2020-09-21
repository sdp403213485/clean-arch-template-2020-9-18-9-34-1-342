package com.thoughtworks.cleanarch;

public class SchemaType {
    public static Schema create(String flag) throws Exception {
        switch(flag){
            case "l" :
                return new Schema(flag,"boolean",false);
            case "p" :
                return new Schema(flag,"int",0);
            case "d" :
                return new Schema(flag,"String","");
        }
        throw new Exception("格式错误");
    }


}

