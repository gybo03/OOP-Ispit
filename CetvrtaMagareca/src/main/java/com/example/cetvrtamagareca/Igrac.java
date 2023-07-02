package com.example.cetvrtamagareca;

public class Igrac implements Comparable<Igrac> {
    private char pol;
    private int pozicija;
    private String ime_Prezime;
    private String nacionalnost;

    public Igrac(String data,char pol) {
        this.pol=pol;
        pozicija= Integer.parseInt((data.substring(0,data.indexOf(','))));
        nacionalnost=data.substring(data.indexOf(',')+1,data.lastIndexOf(','));
        ime_Prezime=data.substring(data.lastIndexOf(',')+1);
    }

    @Override
    public String toString() {
        return pozicija+".("+nacionalnost+")"+ime_Prezime+"("+pol+")";
    }

    public char getPol() {
        return pol;
    }

    @Override
    public int compareTo(Igrac that) {
        if(this.pozicija>that.pozicija){
            return 1;
        }else if(this.pozicija< that.pozicija){
            return -1;
        }
        return 1;
    }
}
