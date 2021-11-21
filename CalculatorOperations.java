import java.util.*;

public class CalculatorOperations implements Input, Validator{
    Scanner sc;
    //Constructor to initialize
    public CalculatorOperations(){
        this.sc = Calculator.sc;
    }
    //CommonMethod for all the operations
    public void processOperation(String opCode){
       boolean repeat = true;
        while(repeat){
            try{
                this.sc = new Scanner(System.in);
                System.out.println("Enter Operand X");
                double X = getDouble();
                System.out.println("Enter Operand Y");
                double Y = getDouble();
                double result = 0.0d;
                switch(opCode){
                    case "OP1": result = X + Y;
                    break;
                    case "OP2": result = Y - X;
                    break;
                    case "OP3": Validator.validateOperand("Division", Y); result = X / Y;
                    break;
                    case "OP4": result = X * Y;
                    break;
                    case "OP5": case "OP6": case "OP7": result = this.processPercentageOperation(opCode, X, Y);
                    break; 
                }
                System.out.println("Your result is ");
                System.out.println(result);
                repeat = false;
            }catch(InputMismatchException ime){
                System.out.println("Please enter the operand in a valid format \nTry Again from the beginning");
                continue;
            }catch(InvalidOperandException ioe){
                System.out.println("Operand not valid for given operation \nTry Again from the beginning");
                continue;
            }catch(Exception e){
                System.out.println("Exception in CalcOperations");
                System.out.println(e);
            }    
        } 
    }
    //Method for Percentage operations
    private double processPercentageOperation(String opCode, double X, double Y) throws Exception{
        switch(opCode){
            case "OP5": return (X/100) * Y;
            case "OP6": Validator.validateOperand("Division", Y); return (X*100) / Y;
            case "OP7": Validator.validateOperand("Division", X); return ((Y - X) * 100) / X;
        }
        return 0.0d;
    } 
    
    @Override
    public double getDouble(){
        return this.sc.nextDouble();
    }
}