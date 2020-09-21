package com.thoughtworks.cleanarch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {

    private List<Arg> argList = new ArrayList<>();
    private String args;

    public Args(String args) {
        this.args = args;
        this.argList = inputArgsParse(args);
    }

    public List<Arg> inputArgsParse(String args) {
        List<String> inputArgs = Arrays.stream(args.split("-"))
                .filter(p->p.length()!=0)
                .collect(Collectors.toList());
        for(String inputArg: inputArgs ){
            Arg arg = Arg.of(Arrays.asList(inputArg.split(" ")));
            this.argList.add(arg);
        }
        return this.argList;
    }

    public Boolean checkInput( List<String> inputOrderList){
        if(inputOrderList.size()!=2){
            return false;
        }
        if(inputOrderList.get(1).contains("-")){
            return false;
        }
        return true;
    }

    public List<Arg> getArgList() {
        return argList;
    }

    public String getArgs() {
        return args;
    }



}