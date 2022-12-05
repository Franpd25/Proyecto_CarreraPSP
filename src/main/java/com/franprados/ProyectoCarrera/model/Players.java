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
		return "Identificador Jugador = " + id + "\n" +
					"Nombre Jugador = " + name + "\n" +
					"Edad Jugador = " + age + "\n" +
					"Dorsal Jugador = " + dorsal + "\n" +
					"Nacionalidad Jugador = " + nationality + "\n" +
					"Etiqueta = " + image + "\n" +
					"Coche Jugador = " + cars;
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
				Thread.sleep((int)(Math.random() * 1000));
				car1 = (int) cars.getCar1().getLayoutX();
				car2 = (int) cars.getCar2().getLayoutX();
				car3 = (int) cars.getCar3().getLayoutX();
				car4 = (int) cars.getCar4().getLayoutX();
					
				if (car1 < cars.getFinish().getLayoutX() - 80 && car2 < cars.getFinish().getLayoutX() - 80
						&& car3 < cars.getFinish().getLayoutX() - 80 && car4 < cars.getFinish().getLayoutX() - 80) {
					image.setLayoutX(image.getLayoutX() + 10);
				}else {
					break;
				}
				
				if (image.getLayoutX() >= cars.getFinish().getLayoutX() - 80) {
					if (car1 > car2) {
						JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Fernando Alonso");

					} else if (car1 > car3) {
						JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Fernando Alonso");
						
					} else if (car1 > car4) {
						JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Fernando Alonso");
							
					} else {
						
						if (car2 > car1) {
							JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Carlos Sainz");
							
						} else if (car2 > car3) {
							JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Carlos Sainz");
							
						} else if (car2 > car4) {
							JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Carlos Sainz");
							
						} else {
							
							if (car3 > car1) {
								JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Max Verstappen");
								
							} else if (car3 > car2) {
								JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Max Verstappen");
								
							} else if (car3 > car4) {
								JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Max Verstappen");
								
							} else {
								
								if (car4 > car1) {
									JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Lewis Hamilton");
									
								} else if (car4 > car2) {
									JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Lewis Hamilton");
									
								} else if (car4 > car3) {
									JOptionPane.showInputDialog(null, "ENHORABUENA!!", "El ganador ha sido Lewis Hamilton");
								}
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Este método se encargar de parar el hilo
	 * principal mediante una variable.
	 * @return true si se ha parado el hilo, false si no se
	 * ha llegado a parar dicho hilo.
	 */
	public boolean stopHilo() {
		return continuar = false;
	}
	
	/**
	 * Este método se encargar de reanudar el hilo
	 * principal mediante una variable.
	 * @return true si se ha reanudado el hilo, false si no se
	 * ha llegado a reanudar dicho hilo.
	 */
	public boolean restartHilo() {
		return continuar = false;
	}
}
