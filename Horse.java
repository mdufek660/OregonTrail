public class Horse
{
  private String horseName = "";
  private int healthOfHorse=0;
  private boolean horseAlive=false;
  private int horseNumber=0;
  
  public Horse(String nameOfHorse, int horseNumberTemp)
  {
    horseName=nameOfHorse;
    healthOfHorse=100;
    horseAlive=true;
    horseNumber=horseNumberTemp;
  }
  
  public String getHorseName()
  {
    return(horseName);
  }
  
  public int getHorseHealth()
  {
    return(healthOfHorse);
  }
  
  public int getHorseNumber()
  {
    return(horseNumber);
  }
  
  public boolean damageHorse(int damageDoneToHorse, Horse w)
  {
    healthOfHorse-=damageDoneToHorse;
    if (healthOfHorse<=0)
    {
      horseAlive=false;
      w = null;
    }
    return(horseAlive);
  }
  
  public void healHorse(int healingHorse)
  {
    healthOfHorse+=healingHorse;
  }
  
  
  
  
}