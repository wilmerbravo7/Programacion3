package model;

/**
 * Clase del jugador del Block World
 * @author wfbs1
 *
 */
public class Player {
	/**
	 * Nombre del jugador
	 */
	private String name;
	/**
	 * Cantidad de vida del jugador
	 */
	private double health;
	/**
	 * Constructor de la clase Player
	 * @param name Nombre del jugador
	 */
	public Player(String name) {
		this.name = name;
		health = 20;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the health
	 */
	public double getHealth() {
		return health;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param health the health to set
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(health);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Double.doubleToLongBits(health) != Double.doubleToLongBits(other.health))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", health=" + health + "]";
	}
	

}
