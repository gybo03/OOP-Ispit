package com.example.cetvrtamagareca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private String filePathM;
    private String filePAthZ;
    private String filePathT;

    private ObservableList<Igrac> igraci= FXCollections.observableArrayList();

    private ObservableList<Teren> tereni=FXCollections.observableArrayList();

    public Reader(String filePathM, String filePAthZ, String filePathT) {
        this.filePathM = filePathM;
        this.filePAthZ = filePAthZ;
        this.filePathT = filePathT;
    }

    public ObservableList<Igrac> ucitajIgrace() throws FileNotFoundException {
        File muski=new File(filePathM);
        File zenski=new File(filePAthZ);
        Scanner muskiS=new Scanner(muski);
        Scanner zenskiS = new Scanner(zenski);

        while(muskiS.hasNextLine()){
            igraci.add(new Igrac(muskiS.nextLine(),'M'));
        }
        while(zenskiS.hasNextLine()){
            igraci.add(new Igrac(zenskiS.nextLine(),'Z'));
        }

        Collections.sort(igraci);

        return FXCollections.observableArrayList(igraci);
    }

    public ObservableList<Teren> ucitajTerene() throws FileNotFoundException {
        File file=new File(filePathT);
        Scanner scanner=new Scanner(file);
        while(scanner.hasNextLine()){
            tereni.add(new Teren(scanner.nextLine()));
        }
        return FXCollections.observableArrayList(tereni);
    }

    public ObservableList<Igrac> filteriraj(String textField, boolean musko, boolean zensko) {
        ArrayList<Igrac> filteri = new ArrayList<>();
        if(musko){
            for (Igrac igrac:igraci) {
                if(igrac.getPol()=='M'){
                    filteri.add(igrac);
                }
            }
        }
        if(zensko){
            for (Igrac igrac:igraci) {
                if(igrac.getPol()=='Z'){
                    filteri.add(igrac);
                }
            }
        }
        if (!textField.equals("")) {
            for (Igrac igrac : igraci) {
                if (!igrac.toString().toLowerCase().contains(textField.toLowerCase())) {
                    filteri.remove(igrac);
                }
            }
        }

        Collections.sort(filteri);
        return FXCollections.observableArrayList(filteri);
    }
}
