
import java.lang.String;
import javax.swing.JOptionPane;
import java.util.Random;

public class Gun
{
  private int ammoCapacity, quality, accuracy, power, type, reloadTime;
  private String typeName;
  private double damage, health;
  
  public Gun()
  {
   ammoCapacity = 1;
   quality = 100; 
   accuracy = 0;
   power = 0; //
   health= 100;
   damage= 0;
   reloadTime = 0; //
   typeName="default";
   type = 0; //Type refers to type of gun. 0=musket, 1=rifle, 2=winchester, 3=shotgun
  }
  
  public Gun(int tempType, int tempHealth, int tempQuality)
  {
    type = tempType;
    health = tempHealth;
    quality = tempQuality;
    if(type == 0) //makes a musket
    {
      accuracy=15;
      power=60;
      reloadTime=20;
      ammoCapacity=1;
      typeName="Musket";
    }
    else
    {
      if(type == 1) //makes a rifle
      {
       accuracy=80;
       power=55;
       reloadTime=20;
       ammoCapacity=1;
       typeName="Hunting Rifle";
      }
      else
      {
        if(type == 2) //makes a winchester
        {
          accuracy=65;
          power=40;
          reloadTime=40;
          ammoCapacity=6;
          typeName="Winchester";
        }
        else
        {
          if(type ==3) //makes a shotgun
          {
            accuracy=15;
            power=90;
            reloadTime=15;
            ammoCapacity=2;
            typeName="Shotgun";
          }
          else
          {
            accuracy=0;
            power=0;
            reloadTime=0;
            ammoCapacity=0;
          }
        }
      }
    }
   damage = power*(1 +(quality/Math.pow(10,2)));  
   if (health<=10)
    {
      damage*=.1;
    }
    else
    {
      if(health<=33)
      {
        damage*=.3;
      }
      else
      {
        if(health<=67)
        {
         damage*=.5;
        }
        else
        {
          if(health<=90)
          {
            damage*=.75;
          }
        }
      }
    }
    damage = StringMod.roundNumbersDouble(damage, 1);
    }
  
  public Gun(int tempType, int tempHealth, int tempQuality, String name)
  {
    type = tempType;
    health = tempHealth;
    quality = tempQuality;
    typeName = name;
    if(type == 0) //makes a musket
    {
      accuracy=15;
      power=60;
      reloadTime=20;
      ammoCapacity=1;
      
    }
    else
    {
      if(type == 1) //makes a rifle
      {
       accuracy=80;
       power=55;
       reloadTime=20;
       ammoCapacity=1;
       //typeName="Hunting Rifle";
      }
      else
      {
        if(type == 2) //makes a winchester
        {
          accuracy=65;
          power=40;
          reloadTime=40;
          ammoCapacity=6;
          //typeName="Winchester";
        }
        else
        {
          if(type ==3) //makes a shotgun
          {
            accuracy=15;
            power=90;
            reloadTime=15;
            ammoCapacity=2;
            //typeName="Shotgun";
          }
          else
          {
            accuracy=0;
            power=0;
            reloadTime=0;
            ammoCapacity=0;
            typeName="Failed to create gun!";
          }
        }
      }
    }
   damage = power*(1 +(quality/Math.pow(10,2)));  
   if (health<=10)
    {
      damage*=.1;
    }
    else
    {
      if(health<=33)
      {
        damage*=.3;
      }
      else
      {
        if(health<=67)
        {
         damage*=.5;
        }
        else
        {
          if(health<=90)
          {
            damage*=.75;
          }
        }
      }
    }
    damage = StringMod.roundNumbersDouble(damage, 1);
    }
  
  public Gun makeGun(int tempType, int tempQuality, double tempHealth, Gun a)
  {
    
    a.setHealth(tempHealth);
    a.setQuality(tempQuality);
    type = tempType;
    a.setType(tempType);
    a.setName(tempType, null);
    
    if(type == 0) //makes a musket
    {
      a.setAccuracy(15);
      a.setPower(60);
      a.setReload(20);
      a.setAmmoCapacity(1);
    }
    else
    {
      if(type == 1) //makes a rifle
      {
        a.setAccuracy(80);
        a.setPower(55);
        a.setReload(20);
        a.setAmmoCapacity(1);
      }
      else
      {
        if(type == 2) //makes a winchester
        {
          a.setAccuracy(65);
          a.setPower(40);
          a.setReload(40);
          a.setAmmoCapacity(6);
        }
        else
        {
          if(type ==3) //makes a shotgun
          {
            a.setAccuracy(15);
            a.setPower(90);
            a.setReload(15);
            a.setAmmoCapacity(2);
          }
          else
          {
            a.setAccuracy(0);
            a.setPower(0);
            a.setReload(0);
            a.setAmmoCapacity(0);
          }
        }
      }
    }
    
   damage = power*(1 +(quality/Math.pow(10,2)));  
   if (health<=10)
    {
      damage*=.1;
    }
    else
    {
      if(health<=33)
      {
        damage*=.3;
      }
      else
      {
        if(health<=67)
        {
         damage*=.5;
        }
        else
        {
          if(health<=90)
          {
            damage*=.75;
          }
        }
      }
    }
    damage = StringMod.roundNumbersDouble(damage, 1);
    a.setDamage(damage);
    return(a);
  }
      
      
  public int getReload()
  {
    return(reloadTime);
  }
  
  public double getHealth()
  {
    return(health);
  }
  
  public int getAmmoCapacity()
  {
    return(ammoCapacity);
  }
  
  public int getQuality()
  {
    return(quality);
  }
  
  public int getAccuracy()
  {
    return(accuracy);
  }
  
  public int getPower()
  {
    return(power);
  }
  
  public int getType()
  {
    return(type);
  }
  
  public void setName(int type, String input)
  {
    if(type == 0)
    {typeName = "Musket";}
    
    if(type == 1)
    {typeName = "Marksman Rifle";}
    
    if(type == 2)
    {typeName = "Winchester";}
    
    if(type == 3)
    {typeName = "Shotgun";}
    
    if(type > 3  || type < 0)
    {typeName = "Null";}
    
    if(input != null)
    {
      typeName = input;
    }
  }
  
  public String getName()
  {
    return(typeName);
  }
  
  public void setHealth(double temp)
  {
    health = temp;
  }
  
  public void setAmmoCapacity(int temp)
  {
    ammoCapacity = temp;
  }
  
  public void setQuality(int temp)
  {
    quality = temp;
  }
  
  public void setAccuracy(int temp)
  {
    accuracy = temp;
  }
  
  public void setPower(int temp)
  {
    power = temp;
  }
  
  public double getDamage()
  {
    return(damage);
  }
  
  public void setReload(int tempReload)
  {
    reloadTime=tempReload;
  }
  
  public void setType(int typeTemp)
  {
    type = typeTemp;
  }
  
  public void setDamage(double tempDamage)
  {
    damage = tempDamage;
  }
  
  public double calculateDamage(Gun temp)
  {
   double damage = temp.getDamage();
   int power = temp.getPower();
   int accuracy = temp.getAccuracy();
   int quality = temp.getQuality();
   double health = temp.getHealth();
   int capacity = temp.getAmmoCapacity();
   int reloadTime = temp.getReload();
   
   damage = power*(accuracy/Math.pow(10,2))*(1+(quality/Math.pow(5,2)))*capacity*(60/reloadTime);
   
   if (health<=10)
    {
      damage*=.1;
    }
    else
    {
      if(health<=33)
      {
        damage*=.3;
      }
      else
      {
        if(health<=67)
        {
         damage*=.5;
        }
        else
        {
          if(health<=90)
          {
            damage*=.75;
          }
        }
      }
    }
    damage = StringMod.roundNumbersDouble(damage, 1);
    return(damage);
  }
  
  
}
          