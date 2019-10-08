package model;

import java.util.*;
import java.lang.Math;

/**
 * Clase que representa una posicion en el mundo tridimensional
 * @author Wilmer Fabricio Bravo Shuira 29577276N
 *
 */
public class Location{
	  /**
	   * Longitud  : Variable x
	   */
      private double x;
      /**
       * Elevacion : Variable y
       */
      private double y;
      /**
       * Latitud : Variable z
       */
      private double z;
      /**
       * World :mundo de bloques
       */
      private World world;
      /**
       * Elevacion maxima : UPPER_Y_VALUE
       */
      public static final double UPPER_Y_VALUE = 255.0;
      /**
       * Nivel del mar : SEA_LEVEL
       */
      public  static final double SEA_LEVEL = 63.0;
    
      /**
       * Constructor de la clase Location
       * @param w Mundo de bloques
       * @param x Longitud
       * @param y Elevación
       * @param z Latitud
       */
    public Location(World w, double x, double y, double z){
      
      this.world = w;
      setX(x);
      if(y < 0 ) {
    	  setY(0);  	  
      } else if(y > UPPER_Y_VALUE) {
    	  setY(UPPER_Y_VALUE);
      } else {
    	  setY(y);
      }
      setZ(z);
    }
    /**
     * Constructor de copia
     * @param l localizacion que vamos a copiar
     */
    public Location(Location l){
      
      world = l.world;
      x = l.x;
      if(y < 0) {
    	  setY(0);
      } else if(y > UPPER_Y_VALUE){
    	  setY(UPPER_Y_VALUE);
     	} else {
    	  setY(l.y);
      }
      z = l.z;
    }

 
    /**
     * Añadimos una localizacion en el mundo
     * @param l Location pasada por parametro
     * @return posicion suma de ambas
     */
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
    /**
     * Distancia entre dos localizaciones
     * @param l localización con la que calcularemos la distancia
     * @return distancia entre dos localizaciones
     */
    public double distance(Location l){
    	
      if(l.getWorld() == null || getWorld() == null){//Aquir podemos utilizar otra cosa
        System.out.println("Cannot measure distance to a null world");
        return -1.0;
       } else if (l.getWorld() != getWorld()){
            System.out.print("Cannot measure distance between"+ world.getName() + "and" + l.world.getName());
            return -1.0;
          }
          
          double dx = x - l.x;
          double dy = y - l.y;
          double dz = z - l.z;
          return Math.sqrt(dx*dx + dy*dy +dz*dz);
        }
    
    /**
     * 
     * @return the World
     */
    public World getWorld(){
      return world;
    }
    /**
     * 
     * @return the X
     */
    public double getX(){
      return x;
    }
    /**
     * 
     * @return the Y
     */
    public double getY(){
      return y;
    }
    /**
     * 
     * @return the Z
     */
    public double getZ(){
      return z;
    }
    /**
     * 
     * @param w the W to set
     */
    public void setWorld(World w){
      if (w == null) {
    	  this.world = null;
      } else {
    	  world = w;
      }
    }
    /**
     * 
     * @param x the X to set
     */
    public void setX(double x){
      this.x = x;
    }
    /**
     * 
     * @param y the Y to set
     */
    public void setY(double y){
    	if(y < 0) {
    		this.y = 0;
    	} else if(y > UPPER_Y_VALUE) {
    		this.y = UPPER_Y_VALUE;
    	} else if(y > SEA_LEVEL) {
    		this.y = y;
    	}else  if(y < SEA_LEVEL){
    		this.y = y;
    	}
    }
    /**
     * 
     * @param z the Z to set
     */
    public void setZ(double z){
      this.z = z;
    }
    
    /**
     * Longitud de la localización
     * @return longitud de la localizacion
     */
    public final double length(){
      return Math.sqrt(x*x + y*y +z*z);
    }
    
    /**
     * Multiplicamos una longitud por un double
     * @param factor que multiplica a la localizacion
     * @return multiplicamos
     */
    public Location multiply(double factor){
      x *= factor;
      setY(y * factor);
      z *= factor;
      return this;
    }
   
    /**
     * substraemos las localizaciones de los mundos
     * @param l localizacion que vamos a susbtraer
     * @return substraemos
     */
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

    /**
     * ponemos todos los parametros a cero
     * @return devolvemos cero
     */
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
