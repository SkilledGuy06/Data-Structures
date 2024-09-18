
public class Pikachu extends Pokemon
{
    
    //The extends keyword allows for inheritance.
    //What is inheritance? Inheritance is when you share the public interface of your super class. This a allows for a superclass-subclass relationship
    //This allows for a subclass superclass relationship
    
    public Pikachu(){
        super (35, 55, 30, 90);
        
    }
    
    public Pikachu(int inputHp, int inputAttack, int inputDefense, int inputSpeed ){
        super (inputHp, inputAttack, inputDefense, inputSpeed);
        
    }
    
    
    public void thunderbolt(Pikachu anyPoorPikachu){
        //Need to do math to make sure defense isn't too high
        int resultingLife = anyPoorPikachu.getHp() - (this.getAttack() - anyPoorPikachu.getDefense());
        anyPoorPikachu.setHp(resultingLife);
        
    }
}
