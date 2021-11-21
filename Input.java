public interface Input {
    default double getDouble(){return 1.0;}
    default int getNumber(){return 1;}
    default String getString(){return "";}
    default char getChar(){return 'c';}
}