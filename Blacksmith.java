import java.util.concurrent.TimeUnit;
import java.lang.String;
import javax.swing.JOptionPane;
import java.util.Random;

public class Blacksmith extends Gun
{
  private static Gun a = Wagon.getGun(0);
  private static Gun b = Wagon.getGun(1);
  private static Gun c = Wagon.getGun(2);
  private static Gun d = Wagon.getGun(3);
  private static Gun e = Wagon.getGun(4);
  private static Gun f = Wagon.getGun(5);
  private static Gun g = Wagon.getGun(6);
  private static Gun h = Wagon.getGun(7);
  private static Gun i = Wagon.getGun(8);
  private static Gun j = Wagon.getGun(9);
  String input;
  
  
  
  public Blacksmith()
  {
  }
  
  public static Wagon enterBlacksmith(Wagon myWagon, int priceMod)
  {
    
    String gunsYouHave="";
    double test = a.getHealth();
    JOptionPane.showMessageDialog(null, test);
    gunsYouHave=listGuns();                              
    return(myWagon);
  }
  
  
  
  
  
  
  /* * * * * * * * * * * *
   * The following method*
   * Creates a general   *
   * Method for listing  *
   * The guns your wagon *
   * Has available       *
   * * * * * * * * * * * */
  
  public static String listGuns()
  {
    String gunsYouHave="";
    if(a.getHealth()>0)
    {
      gunsYouHave+=("\n [01] " +a.getName() + " which does " + a.getDamage() + " damage");
    }
    if(b.getHealth()>0)
    {
      gunsYouHave+=("\n [02] " +b.getName() + " which does " + b.getDamage() + " damage");
    }
    if(c.getHealth()>0)
    {
      gunsYouHave+=("\n [03] " +c.getName() + " which does " + c.getDamage() + " damage");
    }
    if(d.getHealth()>0)
    {
      gunsYouHave+=("\n [04] " +d.getName() + " which does " + d.getDamage() + " damage");
    }
    if(e.getHealth()>0)
    {
      gunsYouHave+=("\n [05] " +e.getName() + " which does " + e.getDamage() + " damage");
    }
    if(f.getHealth()>0)
    {
      gunsYouHave+=("\n [06] " +f.getName() + " which does " + f.getDamage() + " damage");
    }
    if(g.getHealth()>0)
    {
      gunsYouHave+=("\n [07] " +g.getName() + " which does " + g.getDamage() + " damage");
    }
    if(h.getHealth()>0)
    {
      gunsYouHave+=("\n [08] " +h.getName() + " which does " + h.getDamage() + " damage");
    }
    if(i.getHealth()>0)
    {
      gunsYouHave+=("\n [09] " +i.getName() + " which does " + i.getDamage() + " damage");
    }
    if(j.getHealth()>0)
    {
      gunsYouHave+=("\n [10] " +j.getName() + " which does " + j.getDamage() + " damage");
    }
    JOptionPane.showMessageDialog(null, "Welcome to the blacksmith! These are the guns you have:" + gunsYouHave);
    return(gunsYouHave);
  }
}