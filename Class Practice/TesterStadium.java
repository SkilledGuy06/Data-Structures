
public class TesterStadium
{
    
    public static void main(String[] args){
        
        Pikachu bob = new Pikachu();
        Pikachu jimmy = new Pikachu();
        
        System.out.println("Battle Music Initialized");
        System.out.println("Jimmy Hp:" + jimmy.getHp() );
        
        bob.thunderbolt(jimmy);
        
        System.out.println("Bob attack Jimmy with thunderbolt");
        
        System.out.println("Jimmy Hp:" + jimmy.getHp() );
        
        jimmy.thunderbolt(bob);
        
        
    }
}
