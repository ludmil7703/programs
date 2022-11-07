package ExamPreparation;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKey {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String key= scanner.nextLine();

        String input= scanner.nextLine();

        while (!input.equals("Generate")){
            String[] command=input.split(">>>") ;
            String instruction=command[0];
            switch (instruction){
                case "Contains":
                    String substring=command[1];

                    if(key.contains(substring)){
                        System.out.printf("%s contains %s%n",key,substring);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperLower=command[1];
                    int startIndex=Integer.parseInt(command[2]);
                    int endIndex=Integer.parseInt(command[3]);
                    StringBuilder temp=new StringBuilder(key);

                    StringBuilder sub=new StringBuilder(key.substring(startIndex,endIndex));

                    if(upperLower.equals("Lower")){
                        sub= new StringBuilder(sub.toString().toLowerCase());
                        temp.replace(startIndex,endIndex, String.valueOf(sub));
                        key= temp.toString();
                        System.out.println(key);
                    }
                    if (upperLower.equals("Upper")){
                        sub=new StringBuilder(sub.toString().toUpperCase());
                        temp.replace(startIndex,endIndex,String.valueOf(sub));
                        key= temp.toString();
                        System.out.println(key);
                    }

                    break;
                case "Slice":
                    int startInd=Integer.parseInt(command[1]);
                    int endInd=Integer.parseInt(command[2]);
                    StringBuilder slice=new StringBuilder(key);
                    slice.delete(startInd,endInd);
                    key=slice.toString();
                    System.out.println(key);

                    break;
                default:break;
            }


            input= scanner.nextLine();
        }
        System.out.println("Your activation key is: "+key);
    }
}
