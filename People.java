import java.util.concurrent.TimeUnit;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*List of available careers:
 * 1 for banker
 * 2 for doctor
 * 3 for merchant
 * 4 for hunter
 * 5 for forager */
 
public class People
{
  String personsName, career;
  String[] careerNames = {"none" , "Banker", "Doctor", "Merchant", "Hunter", "Forager"};
  int personsHealth, personsBonusType;
  boolean stillAlive;
  public People ()
  {
  }
  
  public People(int health, int bonusType, String input, boolean alive)
  {
   personsHealth = health;
   personsBonusType= bonusType;
   personsName= input;
   stillAlive=alive;
   career = careerNames[bonusType];
  }
  
  public static People createPerson(int tempHealth, int bonusType, String newName, boolean alive)
  {
    People temp = new People(tempHealth, bonusType, newName, alive);
    return(temp);
  }
  
  public void setName(String input)
  {
    personsName = input;
  }
  
  public void setAlive(boolean alive)
  {
    stillAlive = alive;
  }
  
  public void setHealth(int temp)
  {
    personsHealth = temp;  
  }
  
  public void setBonus(int temp)
  {
    personsBonusType = temp;
  }
  
  public int getHealth()
  {
    return(personsHealth);
  }
  
  public int getBonus()
  {
    return(personsBonusType);
  }
  
  public String getName()
  {
    return(personsName);
  }
  
  public Boolean getAlive()
  {
    return(stillAlive);
  }
  
  public String  getCareer()
  {
    return(career);
  }
  
  
}