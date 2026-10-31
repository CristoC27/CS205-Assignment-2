package edu.monmouth.vehicle;

public class Boat implements Vehicle {
	private int boatLength;
	private PowerTypes powerSource;
	public Boat(PowerTypes powerSource, int boatLength) throws BoatException {
		setPowerSource(powerSource);
		setBoatLength(boatLength);
		
	}
	@Override
	public void go() {
		System.out.println("Engine started");	}

	@Override
	public void stop() {
		System.out.println("Anchor dropped");
	}

	@Override
	public PowerTypes powerBy() {
		return getPowerSource();
	}

	public int getBoatLength() {
		return boatLength;
	}

	public void setBoatLength(int boatLength) throws BoatException {
		if (boatLength < VehicleConstants.MINLENGTH){
			throw new BoatException("Error: Boat length too short (less than " + VehicleConstants.MINLENGTH + ")");
		}
		else if (boatLength > VehicleConstants.MAXLENGTH){
			throw new BoatException("Error: Boat length too long (greater than " + VehicleConstants.MAXLENGTH + ")");
		}
		else {
			this.boatLength = boatLength;
			}
	}

	public PowerTypes getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(PowerTypes powerSource) {
		this.powerSource = powerSource;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Boat) {
			if(this == o) {
				return true;
			}
			else{
				Boat obj = (Boat) o;
				if(getBoatLength() == obj.getBoatLength() && powerBy() == obj.powerBy()) {
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
		return "Boat Length: " + getBoatLength() + " | Power Source:  " + getPowerSource();
	}
	

}
