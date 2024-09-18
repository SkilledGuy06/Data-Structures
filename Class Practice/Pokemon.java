
public class Pokemon
{
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    
    public Pokemon(int userHp, int userAttack, int userDefense, int userSpeed){
        hp = userHp;
        attack = userAttack;
        defense = userDefense;
        speed = userSpeed;
    }
    
    public int getHp(){
        return hp;
    }
    
    public void setHp(int inputHp){
        hp = inputHp;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getDefense(){
        return defense;
    }
}