package br.edu.ifba.synchcourse;

public class StationThread implements Runnable{
	
	private Station station;
	
	
	public StationThread(Station station){
		this.setStation(station);
	}
	
	private void setStation(Station station) {
		this.station = station;
	}
	
	private Station getStation() {
		return this.station;
	}	
	
	
	public void run() {
		try {
			this.getStation().execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
