package edu.monmouth.vehicle;

public interface Vehicle {
	void go();
	void stop();
	PowerTypes powerBy();
	boolean equals(Object o);
}
