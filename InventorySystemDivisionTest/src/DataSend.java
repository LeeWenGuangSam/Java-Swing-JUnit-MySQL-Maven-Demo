import java.util.ArrayList;

public class DataSend {
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	public DataSend() {
		
	}
	
	public void addWeapon(Weapon weapon)
	{
		weapons.add(weapon);
	}
	
	public ArrayList<Weapon> getWeapons()
	{
		return weapons;
	}
	
	public String toString()
	{
		//String weaponText;
		for(int i = 0; i < weapons.size(); i++)
		{
			System.out.println(weapons.get(i));
		}
		return "No weapons yet";
	}
}
