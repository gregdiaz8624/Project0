package com.revature.app;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Gregory Diaz's Bank Application!");
		
		Scanner in = new Scanner(System.in);
	      
        // Display the menu
        System.out.println("Choose one of the following");
        
        System.out.println("[1] Register");
        System.out.println("[2] Log In Returning  Customer");
        System.out.println("[3] Log In Employee");
        System.out.println("[4] Quit");
   
        System.out.println("Please enter your choice:");
        
        //Get user's choice
        int choice=in.nextInt();
        
        //
        Scanner unInput = new Scanner(System.in);
        
        switch (choice) {
            case 1: System.out.println("Inches to Centieters"); 
            		System.out.println("Input a value for inch: ");
            		double inch = unInput.nextDouble();
            		double cmeters = inch * 2.54;
            		System.out.println(inch + " inch is " + cmeters + " centimeters");
            		break;
            case 2: System.out.println("Fahrenheit to Celsius"); 
		    		System.out.println("Input a value for Fahrenheit: ");
		    		double far = unInput.nextDouble();
		    		double cel = (far - 32) * (0.5556);
		    		System.out.println(far + " Fahrenheit is " + cel + " Celsius");
		    		break;
            case 3: System.out.println("Grams to Ounces"); 
		    		System.out.println("Input a value for Grams: ");
		    		double gram = unInput.nextDouble();
		    		double ounc = (gram * 0.035274);
		    		System.out.println(gram + " Grams is " + ounc + " Ounces");
		    		break;
            case 4: System.out.println("Miles to Kilometers"); 
		    		System.out.println("Input a value for Miles: ");
		    		double miles = unInput.nextDouble();
		    		double kilo = (miles * 1.60934);
		    		System.out.println(miles + " Miles is " + kilo + " Kilometers");
		    		break;
            case 5: System.out.println("Thank you and Goodbye");
            		break;
            default: System.out.println("Invalid choice"); 
                    break;
        }//end of switch
       
	}

}
