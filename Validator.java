public interface Validator {
    static void validateOperand(String operation, Double... operands) throws InvalidOperandException{
        switch(operation){
            case "Division": for(double operand: operands) {
                if(operand == 0d) throw new InvalidOperandException(); 
            }
            break;
        }
    }
}

class InvalidOperandException extends Exception {
    public InvalidOperandException(){
        super();
    }
}