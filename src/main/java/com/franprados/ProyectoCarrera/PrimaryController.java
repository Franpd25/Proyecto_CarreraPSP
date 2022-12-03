package com.franprados.ProyectoCarrera;

import java.net.URL;
import java.util.ResourceBundle;

import com.franprados.ProyectoCarrera.model.Players;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PrimaryController implements Initializable {

	Players j1;
	Players j2;
	Players j3;
	Players j4;

	@FXML
	private ImageView car1;
	@FXML
	private ImageView car2;
	@FXML
	private ImageView car3;
	@FXML
	private ImageView car4;
	@FXML
	private Pane finish;

	@FXML
	private Button start;
	@FXML
	private Button stop;
	@FXML
	private Button restart;

	@SuppressWarnings("exports")
	public ImageView getCar1() {
		return car1;
	}

	@SuppressWarnings("exports")
	public ImageView getCar2() {
		return car2;
	}

	@SuppressWarnings("exports")
	public ImageView getCar3() {
		return car3;
	}

	@SuppressWarnings("exports")
	public ImageView getCar4() {
		return car4;
	}

	@SuppressWarnings("exports")
	public Pane getFinish() {
		return finish;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		stop.setDisable(true);
		restart.setDisable(true);
	}

	@FXML
	private void buttonStart() {
		
		car1.setLayoutX(0);
		car2.setLayoutX(0);
		car3.setLayoutX(0);
		car4.setLayoutX(0);

		j1 = new Players(car1, this);
		j2 = new Players(car2, this);
		j3 = new Players(car3, this);
		j4 = new Players(car4, this);

		j1.start();
		j2.start();
		j3.start();
		j4.start();

		start.setText("CONTANDO");
		start.setDisable(true);
		stop.setDisable(false);
		restart.setDisable(false);
	}

	@FXML
	private void buttonStop() {
		
		if (stop.getText().equals("DETENER")) {
			j1.stopHilo();
			j2.stopHilo();
			j3.stopHilo();
			j4.stopHilo();

			start.setText("DETENIDO");
			stop.setText("REANUDAR");

		} else {

			if (stop.getText().equals("REANUDAR")) {
				j1.restartHilo();
				j2.restartHilo();
				j3.restartHilo();
				j4.restartHilo();

				j1 = new Players(car1, this);
				j2 = new Players(car2, this);
				j3 = new Players(car3, this);
				j4 = new Players(car4, this);

				j1.start();
				j2.start();
				j3.start();
				j4.start();

				start.setText("CONTANDO");
				stop.setText("DETENER");
				start.setDisable(true);
				stop.setDisable(false);
				restart.setDisable(false);
			}
		}
	}

	@FXML
	private void buttonRestart() {
		
		if (restart.getText().equals("REINICIAR")) {
			this.buttonStart();
			
		} else {
			this.buttonStop();
		}
	}
}
