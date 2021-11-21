//TODO Add Package later
import java.util.Scanner;
import java.util.*;

public class Calculator{
    static Scanner sc;
    Map<String, String> operationDescription;
    
    /*
        This is the default Constructor used to initiate the calculator class
    */
    public Calculator(){
        sc = new Scanner(System.in);
    }
    /*
        This method is used to load the basic supported operations so that it is easier to render
    */
    private void loadSupportedOperationDescription(){
        this.operationDescription = new TreeMap<>();
        operationDescription.put("OP1","Addition of two Numbers X and Y");
        operationDescription.put("OP2","Subtraction of two Numbers X from Y");
        operationDescription.put("OP3","Division of two Numbers X by Y");
        operationDescription.put("OP4","Multiplication of two Numbers X and Y");
        operationDescription.put("OP5","X% of Y");
        operationDescription.put("OP6","What Percent of Y is X");
        operationDescription.put("OP7","What is the Percentage increase or decrease from X to Y");
        operationDescription.put("OP8","Clear and Try Again");
        operationDescription.put("OP9","Exit");
        
    }
    /*
        This method is used to render the supported operation
    */
    private void renderSupportedOperations() {
        this.operationDescription.forEach((optionCode, option) -> {
            System.out.println(optionCode+"->"+option);
        });
    }
    private int getSelectedOperation(){
        System.out.println("Enter Option (1-8)");
        return this.sc.nextInt();
    }
    private void renderErrorMessage(String message){
        System.out.println(message);
    }
    /*
        Entry point for the calculator
    */
    private void beginCalculator(){
        loadSupportedOperationDescription();
        boolean tryAgain = true;
        boolean formatError = false;
        try{
            System.out.println("\n \n \n ** Welcome to a Simple Calculator Program! **");
            System.out.println("This calculator can do the following operations \n \n");
            System.out.println();
            while(tryAgain){
                //This is done to flush the scanner
                this.sc = new Scanner(System.in);
                renderSupportedOperations();
                
                int option = 0;
                try{
                    option = getSelectedOperation();
                }catch(InputMismatchException ime){
                    System.out.println("\n \n \n **** Please choose your option in valid format **** \n \n \n");
                    System.out.println();
                    continue;
                }
                
                String optionCode = "OP"+option;
                if(optionCode.equals("OP8")) {
                    System.out.println("\n \n \n **** Trying Again **** \n \n \n");
                    continue;
                }else if(optionCode.equals("OP9")) break;
                CalculatorOperations co = new CalculatorOperations();
                System.out.println("You have selected the following Operation \n"+"***  "+this.operationDescription.get(optionCode)+"  ***");
                co.processOperation(optionCode);
                
                System.out.println("Do you want to Try Again? (Y/N)");
                String tryAgainOption = this.sc.next();
                if(tryAgainOption.equalsIgnoreCase("N")) tryAgain = false;
            }
            System.out.println("\n \n *** Thank you for using Calculator. BuBye ***");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            this.sc.close();
        }
    }
    
    public static void main(String args[]){
        Calculator calcInstance = new Calculator();
        calcInstance.beginCalculator();
    }
}