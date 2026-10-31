package edu.monmouth.vehicle;

public class Motorcycle implements Vehicle {
	private PowerTypes powerSource;
	private int maxSpeed;
	
	public Motorcycle(PowerTypes powerSource, int maxSpeed) {
		setPowerSource(powerSource);
		setMaxSpeed(maxSpeed);
	}
	@Override
	public void go() {
		System.out.println("Accelerator handle twisted");
	}
	@Override
	public void stop() {
		System.out.println("Brakes applied");
	}
	public PowerTypes getPowerSource() {
		return powerSource;
	}
	public void setPowerSource(PowerTypes powerSource) {
		this.powerSource = powerSource;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public PowerTypes powerBy(){
		return getPowerSource();
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Motorcycle) {
			if(this == o) {
				return true;
			}
			else{
				Motorcycle obj = (Motorcycle) o;
				if(getMaxSpeed() == obj.getMaxSpeed() && powerBy() == obj.powerBy()) {
					return true;
				}
				else {
					return false;
				}
			
			}
		}
		else {
			return false;
		}
	}	
	@Override
	public String toString() {
		return "Max speed: "+ getMaxSpeed() + "| Power source: "+ powerBy();
	}
}
