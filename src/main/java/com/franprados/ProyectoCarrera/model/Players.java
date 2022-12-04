package com.franprados.ProyectoCarrera.model;

import javax.swing.JOptionPane;

import com.franprados.ProyectoCarrera.PrimaryController;

import javafx.scene.image.ImageView;

public class Players extends Thread {

	protected int id;
	protected String name;
	protected int age;
	protected int dorsal;
	protected String nationality;
	
	protected ImageView image;
	protected PrimaryController cars;
	
	protected boolean continuar = true;

	public Players() {}
	
	public Players(ImageView image, PrimaryController cars) {
		this.image = image;
		this.cars = cars;
	}

	public Players(int id, String name, int age, int dorsal, String nationality, ImageView image, PrimaryController cars, boolean continuar) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dorsal = dorsal;
		this.nationality = nationality;
		this.image = image;
		this.cars = cars;
		this.continuar = continuar;
	}

	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", age=" + age + ", dorsal=" + dorsal + ", nationality="
				+ nationality + ", image=" + image + ", cars=" + cars + "]";
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
					
				if (car1 < cars.getFinish().getLayoutX() - 80 && car2 < cars.getFinish().getLayoutX() - 80
						&& car3 < cars.getFinish().getLayoutX() - 88 && car4 < cars.getFinish().getLayoutX() - 88) {
					image.setLayoutX(image.getLayoutX() + 10);
				}else {
					break;
				}
				
				if (image.getLayoutX() >= cars.getFinish().getLayoutX() - 80) {
					if (car1 > car2) {
						//JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Fernando Alonso");
						JOptionPane.showMessageDialog(null, "El ganador ha sido Fernando Alonso");

					} else if (car2 > car1) {
						//JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Carlos Sainz");
						JOptionPane.showMessageDialog(null, "El ganador ha sido Carlos Sainz");
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	//DETENER
	public boolean stopHilo() {
		return continuar = false;
	}
	
	//REANUDAR
	public boolean restartHilo() {
		return continuar = false;
	}
}
