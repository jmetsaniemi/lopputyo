package com.lopputyo.lopputyo;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.*;
import java.util.Scanner;

@RestController
public class MyRestController {

    //luodaan tekstitiedostot, jonne tiedot lisätään

    File kurssiFile = new File("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\info.txt");
    File oppilasFile = new File("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\oppilasinfo.txt");

    //dumppifile on väliaikainen, jota käytetään ristiinhakuun
    File dumppiFile = new File("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\dump.txt");
    public MyRestController () throws FileNotFoundException{}


    // tässä haetaan kurssit, joita opettaa etsitty opettaja


    @GetMapping("kurssitOpettajalla")
    public String getCourseByTeacher(@RequestParam String kurssiOpettaja) throws IOException {
        Scanner reader = new Scanner(kurssiFile);
        PrintWriter dumpWriter = new PrintWriter(dumppiFile);
        dumpWriter.print("");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]);
            if(kurssiOpettaja.equals(tokens[2])){
                dumpWriter.print(line + System.lineSeparator());
                System.out.println(line);
            }
        }
        reader.close();
        dumpWriter.close();
        String temp  = Files.readString(Path.of("C:\\Users\\joona\\Työpöytä\\kevät_2022\\JAVA\\lopputyo\\lopputyo\\src\\main\\java\\com\\lopputyo\\lopputyo\\dump.txt"));
        if(temp.equals("")){
            return "Ei löydy";
        }else {
            return "<h3>" + temp.replaceAll("(\r\n|\r\n|\n\r)", "<br>") + "</h3>";
        }
    }



    // lisätään kurssi --> löytyy info.txt tiedostosta



    @PostMapping("addKurssi")
    public String addKurssi(@RequestParam int kurssiId, @RequestParam String kurssiNimi, @RequestParam String kurssiOpettaja) throws IOException {
        FileWriter fw = new FileWriter(kurssiFile, true);
        fw.write(kurssiId + " " + kurssiNimi + " " + kurssiOpettaja + System.lineSeparator());
        fw.close();
        return "Kurssi lisätty onnistuneesti.";
    }

    // lisätään oppilas, löytyy oppilasinfo.txt tiedostosta

    @PostMapping("addOppilas")
    public String addOppilas(@RequestParam String oppilasFn, @RequestParam String oppilasLn, @RequestParam int oppilasId) throws IOException {
        FileWriter fw = new FileWriter(oppilasFile, true);

        fw.write(oppilasFn + " " + oppilasLn + " " + oppilasId + System.lineSeparator());
        fw.close();
        return "Oppilas lisätty onnistuneesti.";
    }

    //haetaan kurssi nimellä

    @GetMapping("kurssiNimella")
    public String getCourseByName(@RequestParam String kurssiNimi) throws FileNotFoundException {

        //luodaan scanneri nimeltä reader, joka tutkii kurssiFileä
        Scanner reader = new Scanner(kurssiFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            //luetaan tekstitieostosta keskimmäinen 'tokeni', jolle tallentuu kurssin nimi (0 = id, 1 = kurssin nimi, 2= kurssin opettaja)
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1]+ " " + tokens[2]);
            if(kurssiNimi.equals(tokens[1])){
                System.out.println(line);
                reader.close();
                return  "<h3>"+ "Tulokset: " + "<br>" + line + "</h3>";
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
            System.out.println(tokens[0] + " " + tokens[1]+ " " + tokens[2]);
            if(kurssiId.equals(tokens[0])){
                System.out.println(line);
                reader.close();
                return "<h3>" + "Tulokset: " + "<br>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi ID:llä ei löydy kurssia.";
    }

    @GetMapping("oppilasNimella")
    public String studentByLastname (@RequestParam String oppilasLn) throws FileNotFoundException {
        Scanner reader = new Scanner(oppilasFile);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(" ");
            System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]);
            if(oppilasLn.equals(tokens[1])){
                System.out.println(line);
                reader.close();
                return  "<h3>"+ "Tulokset: " + "<br>" + line + "</h3>";
            }

        }
        reader.close();
        return "Antamallasi sukunimellä ei löydy oppilaita.";
    }



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
