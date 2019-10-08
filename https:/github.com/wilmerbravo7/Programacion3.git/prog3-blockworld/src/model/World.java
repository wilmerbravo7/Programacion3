package model;
/**
 * Mundo de bloques
 * @author Wilmer Fabricio Bravo Shuira 29577276N
 * @version 1.0
 */
public class World {
  
	/**
	 * Nombre del mundo
	 */
  private String name;
  
  /**
   * Constructor del World
   * @param name nombre del mundo
   */
  public World(String name){
    this.name = name;
  }
  /**
   * 
   * @return the name
   */
  public String getName(){
    return name;
  }
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	World other = (World) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return name;
}
//Para los bloques
//Map<Location,block>blicks = new HashMap<Location,Block>();
//Para los items
//Map<Location,ItemStack> items = new HashMap<Location,itemStack>();
//Superficie array heightMap[][]
  

}
