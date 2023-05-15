/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
public class Filmi {
     LinkedList<Katalog> returnListInfoWidgets(String pathFile) {

        LinkedList<Katalog> tempInfoWidgets = new LinkedList<>();

        try {

            List<String> linesList = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
            linesList.remove(0);
            for (String tempRow : linesList) {
                String[] tempArrString = tempRow.split(",");
                String name = tempArrString[1];
                int year = Integer.parseInt(tempArrString[2]);
                int duration = Integer.parseInt(tempArrString[3]);
                String genre = tempArrString[4];
                Double rating = Double.parseDouble(tempArrString[5]);
                Katalog objWidgets = new Katalog(name, year, duration, genre, rating);
                tempInfoWidgets.add(objWidgets);

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return tempInfoWidgets;
    }
}
