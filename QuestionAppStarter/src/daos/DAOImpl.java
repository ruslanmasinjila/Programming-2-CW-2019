/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.Repository;

import model.SimpleNumericQuestion;
import model.SimpleTextQuestion;

/**
 *
 * @author ruslan
 */
public class DAOImpl implements DAOInterface {

    static final char DELIMITER = ',';
    String STQ = "STQ";
    String SNQ = "SNQ";

    public Repository load(String filename) {
        Repository repository = new Repository();

        try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] temp;
            String line = br.readLine();
            while (line != null) {
                temp = line.split(Character.toString(DELIMITER));

                int id = Integer.parseInt(temp[0]);
                String questionText = stripQuotes(temp[1]);
                String topicArea = stripQuotes(temp[2]);
                String label = stripQuotes(temp[3]);

                if (label.equals(STQ)) {
                    String simpleTextResponse = stripQuotes(temp[4]);
                    SimpleTextQuestion simpleTextQuestion = new SimpleTextQuestion(id, questionText, topicArea, simpleTextResponse);
                    repository.add(simpleTextQuestion);
                } else {
                    int simpleNumericResponse = Integer.parseInt(temp[4]);
                    SimpleNumericQuestion simpleNumericQuestion = new SimpleNumericQuestion(id, questionText, topicArea, simpleNumericResponse);
                    repository.add(simpleNumericQuestion);
                }

                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
    }

    public void store(String filename, Repository repository) {

        try ( PrintWriter output = new PrintWriter(filename)) {
            output.print(repository.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static void main(String[] args) {
        DAOImpl dAOImpl = new DAOImpl();

        Repository repository = new Repository();

        repository = dAOImpl.load("questions.txt");

        System.out.println(repository.toString());

    }

}
