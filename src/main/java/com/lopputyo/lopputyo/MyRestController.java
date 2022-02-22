package com.lopputyo.lopputyo;

import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

@RestController
public class MyRestController {

    File kurssiFile = new File("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\info.txt");
    File oppilasFile = new File("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\oppilasinfo.txt");


    /*@GetMapping("Home")
    public String getInfo() {
        return "Welcome ";
    }




    @GetMapping("student")
    public Oppilaat getStudent() {
        return new Oppilaat("Joonas", "Metsäniemi", "6B", "132");
    }

    @GetMapping("student")
    public Oppilaat getKurssi() {
        return new Oppilaat("Joonas", "Metsäniemi", "6B", "132");
    }*/



   /* @PostMapping("addOppilasVoid")
    public void addOppilas (@RequestParam String oppilasFn, @RequestParam String oppilasLn, @RequestParam String oppilasLuokka, @RequestParam String kurssiId){
        Oppilaat f = new Oppilaat(oppilasFn, oppilasLn, oppilasLuokka, kurssiId);
       OppilasList.add(f);
    }*/

    @PostMapping("addKurssi")
    public String addKurssi(@RequestParam String kurssiId, @RequestParam String kurssiNimi) throws IOException {
        FileWriter fw = new FileWriter(kurssiFile, true);
        fw.write(kurssiId + " " + kurssiNimi + System.lineSeparator());
        fw.close();
        return "Kurssi lisätty onnistuneesti.";
    }

    @PostMapping("addOppilas")
    public String addKurssi(@RequestParam String oppilasFn, @RequestParam String oppilasLn, @RequestParam String oppilasId) throws IOException {
        FileWriter fw = new FileWriter(kurssiFile, true);
        fw.write(oppilasFn + " " + oppilasLn + " " + oppilasId + System.lineSeparator());
        fw.close();
        return "Oppilas lisätty onnistuneesti.";
    }

    @GetMapping("kurssiNimella")
    public String getCourseByName(@RequestParam String kurssiNimi) throws FileNotFoundException {
        Scanner reader = new Scanner(kurssiFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if(kurssiNimi.equals(tokens[1])){
                System.out.println(line);
                reader.close();
                return "<h3>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi nimellä ei löydy kurssia.";
    }

    @GetMapping("kurssiIDlla")
    public String getCourseByID(@RequestParam String kurssiId) throws FileNotFoundException {
        Scanner reader = new Scanner(kurssiFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]);
            if(kurssiId.equals(tokens[0])){
                System.out.println(line);
                reader.close();
                return "<h3>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy kurssia.";
    }

    /*@PostMapping("addOppilasKurssille")
    public void addOppilasKurssille(@RequestParam String oppilasLn, @RequestParam String kurssiId_oppilas, @RequestParam String oppilasFn, @RequestParam String kurssiId){
        
    }*/

    //@RequestMapping(value = "addOppilasTest")
    //public String addOppilas (@RequestBody String oppilasFn, @RequestBody String oppilasLn, @RequestBody String oppilasLuokka){

    //new Oppilaat  (oppilasFn, oppilasLn, oppilasLuokka);
    //return "Uusi olio: " + oppilasFn + " " + oppilasLn + " " + oppilasLuokka;

    //}

    //@PostMapping("addKurssi")
    //public void addKurssi(@RequestParam String kurssiNimi, @RequestParam String kurssiOpettaja){
    //Kurssit k = new Kurssit(kurssiNimi,kurssiOpettaja);
    //KurssiList.add(k);
    //}

    //@PostMapping("addOppilasPost")
    //public String addOppilas (@RequestBody Oppilaat p){
    //return p.getOppilasFn() + " " + p.getOppilasLn();
    //}

    /* @GetMapping("KurssiList")
    public List<Kurssit> getKurssiList() {
        return this.KurssiList;
    }*/

    /*@GetMapping("HomeList")
    public List<Oppilaat> getOppilasList() {
        return this.OppilasList;
    }*/
}
