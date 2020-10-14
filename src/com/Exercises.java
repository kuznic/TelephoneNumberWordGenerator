package com;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Exercises{
    public static void main(String[] args) {
        tNumberWordGenerator();

    }



    static void tNumberWordGenerator()  {
        char[] two = {'A', 'B', 'C'};
        char[] three = {'D', 'E', 'F'};
        char[] four = {'G', 'H', 'I'};
        char[] five = {'J', 'K', 'L'};
        char[] six = {'M', 'N', 'O'};
        char[] seven = {'P','R','S'};
        char[] eight = {'T', 'U', 'V'};
        char[] nine = {'W','X','Y'};


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 7 digit number:");
        String phoneNumber = scanner.next();

        if(!phoneNumber.matches("[2-9]{7}")){
            System.out.println("Invalid telephone number entered");
            return;
        }

        String[] telephoneNumber = phoneNumber.split("");
        int count = 0;

        File generatedWords = new File("numberwords.txt");



        while(count < 2187){
            StringBuilder builder = new StringBuilder();
            try(FileWriter writeGeneratedWord = new FileWriter("numberwords.txt",true); Scanner readWords = new Scanner(generatedWords))

            {
                Random random = new Random();
                for (String s : telephoneNumber) {
                    switch (s) {
                        case "2":
                            builder.append(two[random.nextInt(3)]);
                            break;
                        case "3":
                            builder.append(three[random.nextInt(3)]);
                            break;
                        case "4":
                            builder.append(four[random.nextInt(3)]);
                            break;
                        case "5":
                            builder.append(five[random.nextInt(3)]);
                            break;
                        case "6":
                            builder.append(six[random.nextInt(3)]);
                            break;
                        case "7":
                            builder.append(seven[random.nextInt(3)]);
                            break;
                        case "8":
                            builder.append(eight[random.nextInt(3)]);
                            break;
                        case "9":
                            builder.append(nine[random.nextInt(3)]);
                    }

                }
                if(readWords.hasNextLine()){
                    while(readWords.hasNextLine()){
                        if(readWords.nextLine().equals(builder.toString())){
                            break;

                        }
                    }
                    writeGeneratedWord.write(builder.toString() + "\n");
                    count++;

                }else{
                    writeGeneratedWord.write(builder.toString() + "\n");
                }


            } catch (EOFException e){
                e.getMessage();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}

