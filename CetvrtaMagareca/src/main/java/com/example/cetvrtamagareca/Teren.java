package com.example.cetvrtamagareca;

public class Teren {
    private String ime;
    private boolean osvetljenost;

    public Teren(String data) {
        if(data.indexOf('O')!=-1){
            osvetljenost=true;
            ime=data.substring(0,data.indexOf('-'));
        }else{
            osvetljenost=false;
            ime=data;
        }
    }

    @Override
    public String toString() {
        if(osvetljenost){
            return ime+" (O)";
        }
        return ime;
    }
}
