/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Ridho
 */
public class TestExecutePython {

    public static void main(String[] a) {
        String s = null;
        try {

            Path currentRelativePath = Paths.get("");
            String rootPath = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current relative path is: " + currentRelativePath.toAbsolutePath().toString());

            // run the Unix "ps -ef" command
            Process p = Runtime.getRuntime().exec("python " + rootPath + "\\python\\numbers.py");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            System.exit(-1);
        }
    }

}
