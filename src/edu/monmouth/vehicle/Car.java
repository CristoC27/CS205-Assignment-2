package edu.monmouth.vehicle;

public class Car implements Vehicle {
	private int engineSize;
	private PowerTypes powerSource;
	public Car(PowerTypes powerSource, int engineSize) throws CarException {
		setEngineSize(engineSize);
		setPowerSource(powerSource);
	}
	@Override
	public void go() {
		System.out.println("Accelerator pressed");

	}

	@Override
	public void stop() {
		System.out.println("Braking");
	}

	@Override
	public PowerTypes powerBy() {
		return getPowerSource();
	}

	public int getEngineSize() {
		return engineSize;
	}
	
	public void setEngineSize(int engineSize) throws CarException {
		if (engineSize < VehicleConstants.MINSIZE) {
			throw new CarException("Error: Engine size is too small (less than " + VehicleConstants.MINSIZE + ")");
		}
		else if(engineSize > VehicleConstants.MAXSIZE) {
			throw new CarException("Error: Engine size is too large (less than " + VehicleConstants.MAXSIZE + ")");
		}
		else {
			this.engineSize = engineSize;
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
		if(o instanceof Car) {
			if(this == o) {
				return true;
			}
			else{
				Car obj = (Car) o;
				if(getEngineSize() == obj.getEngineSize() && powerBy() == obj.powerBy()) {
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
		return "Engine size: " + getEngineSize() + " | Power Source:  " + getPowerSource();
	}

}
