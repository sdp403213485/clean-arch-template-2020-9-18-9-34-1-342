package com.thoughtworks.cleanarch;

import javax.xml.validation.SchemaFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {

    private List<Arg> argList = new ArrayList<>();
    private String args;

    public Args(String args) throws Exception {
        this.args = args;
        this.argList = inputArgsParse(args);
    }

    public List<Arg> inputArgsParse(String args) throws Exception {
        List<String> inputArgs =this.splitArgs(args);
        for(String inputArg: inputArgs ){
            Arg arg = getArg(inputArg);
            checkRepeatFlag(argList,arg);
            argList.add(arg);
        }
        return argList;
    }

    private Arg getArg(String inputArg) throws Exception {
        try {
            return Arg.of(Arrays.asList(inputArg.split(" ")));
        }catch (Exception e){
            Schema schema = SchemaType.create(inputArg.trim());
            return new Arg(inputArg,schema.getDefaultValue(),schema.getValueType());
        }
    }

    private void checkRepeatFlag(List<Arg> argList, Arg arg) throws Exception {
        for (Arg arg1:argList){
            checkFlag(arg1,arg);
        }
    }
    private void checkFlag(Arg arg1,Arg arg) throws Exception {
        if(arg1.getFlag().equals(arg.getFlag())){
            throw new Exception("格式错误");
        }
    }

    private List<String> splitArgs( String args){
        return  Arrays.stream(args.split("-"))
                .filter(p->p.length()!=0)
                .collect(Collectors.toList());
    }

    public List<Arg> getArgList() {
        return argList;
    }


}
