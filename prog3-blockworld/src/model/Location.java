package model;
//Tener en cuenta la documentacion de la practica mirarlo bien
//package Location;
import java.util.*;
import java.lang.Math;


public class Location{
  //Parte privada del programa.
  //Para cada atributo tenemos que comentar su finalidad
      private double x;
      private double y;
      private double z;
      private World world;
//Parte publica del programa.
    public static final double UPPER_Y_VALUE = 255.0;
    public  static final double SEA_LEVEL = 63.0;
    //Constructor por parametros
    //Comentar que es lo que hace cada metodo
    public Location(World w, double x, double y, double z){
      world = w;
      setX(x);
      if(y < 0 || y > UPPER_Y_VALUE) {
    	  setY(0);
      } else {
    	  setY(y);
      }
      setZ(z);
    }
    //Constructor de copia
    public Location(Location l){
      //No se si es con punto o con ->
      world = l.world;
      x = l.x;
      y = l.y;
      z = l.z;
    }
    //Añadir una localizacion. Equivalente en con el operador += en c++
    public Location add(Location l){
      if(l.world != world){
        System.out.println("Cannot add Locations of differing worlds");
      } else {
        x += l.x;
        setY(y + l.y);
        z += l.z;
      }
      return this;
    }
    //Calcular distancia
    public double distance(Location l){
    	
      if(l.getWorld() == null || getWorld() == null){//Aquir podemos utilizar otra cosa
        System.out.println("Cannot measure distance to a null world");
        return -1.0;
       } else if (l.getWorld() != getWorld()){
            System.out.print("Cannot measure distance between"+ world.getName() + "and" + l.world.getName());
            //Queda por implementar la clase world.
            return -1.0;
          }
          
          double dx = x - l.x;
          double dy = y - l.y;
          double dz = z - l.z;
          return Math.sqrt(dx*dx + dy*dy +dz*dz);
        }
    //Get de cada uno de los atributos privados
    public World getWorld(){
      return world;
    }
    public double getX(){
      return x;
    }
    public double getY(){
      return y;
    }
    public double getZ(){
      return z;
    }
    //Set de cada uno de los atributos privados
    public void setWorld(World w){
      world = w;
    }
    public void setX(double x){
      this.x = x;
    }
    public void setY(double y){
    	if(y < 0 || y > UPPER_Y_VALUE) {
    		this.y = 0; 
    	} else {
    		this.y = y;
    	}
    }
    public void setZ(double z){
      this.z = z;
    }
    //Calcular longitud
    public final double length(){
      return Math.sqrt(x*x + y*y +z*z);
    }
    //Multiplicar por un numero la localizacion
    public Location multiply(double factor){
      x *= factor;
      setY(y * factor);
      z *= factor;
      return this;
    }
    //Obtenemos un localizacion
    public Location substract(Location l){
      if(l.world != world){
        System.out.println("Cannot substract Locations of differing worlds.");
      } else {
        x -= l.x;
        setY(y - l.y);
        z -= l.z;
      }
      return this;
    }

    //Poner la localizacion a cero
    public Location zero(){
      x = y = z = 0.0;
      return this;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((world == null) ? 0 : world.hashCode());
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Location other = (Location) obj;
		if (world == null) {
			if (other.world != null)
				return false;
		} else if (!world.equals(other.world))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location{world="+world+ ",x=" + x + ",y=" + y + ",z=" + z + "}";
	}
	
   
}
