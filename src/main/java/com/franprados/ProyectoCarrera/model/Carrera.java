package com.franprados.ProyectoCarrera.model;

import com.franprados.ProyectoCarrera.PrimaryController;
import com.franprados.ProyectoCarrera.utils.Dialog;

import javafx.scene.image.ImageView;

public class Carrera extends Thread {

	protected int id;
	protected String name;
	protected int nLaps;
	
	protected ImageView image;
	protected PrimaryController cars;
	protected boolean continuar = true;

	public Carrera() {}
	
	public Carrera(ImageView image, PrimaryController cars) {
		this.image = image;
		this.cars = cars;
	}
	
	public Carrera(int id, String name, int nLaps, ImageView image, PrimaryController cars) {
		this.id = id;
		this.name = name;
		this.nLaps = nLaps;
		this.image = image;
		this.cars = cars;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int car1 = 0;
		int car2 = 0;
		int car3 = 0;
		int car4 = 0;
				
		while (continuar) {
					
			try {
				sleep((int)(Math.random() * 1000));
				car1 = (int) cars.getCar1().getLayoutX();
				car2 = (int) cars.getCar2().getLayoutX();
				car3 = (int) cars.getCar3().getLayoutX();
				car4 = (int) cars.getCar4().getLayoutX();
					
				if (car1 < cars.getFinish().getLayoutX() - 90 && car2 < cars.getFinish().getLayoutX() - 90
						&& car3 < cars.getFinish().getLayoutX() - 90 && car4 < cars.getFinish().getLayoutX() - 90) {
					image.setLayoutX(image.getLayoutX() + 10);
				}else {
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public boolean stopHilo() {
		return continuar = false;
	}
	
	public boolean restartHilo() {
		return continuar = false;
	}
	
	public boolean resumeHilo() {
		return continuar = true;
	}
}
