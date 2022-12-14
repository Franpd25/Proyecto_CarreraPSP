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

	/**
	 * En este método nos encargamos de inicializar las variables
	 * de los 4 hilos y ejecutar a la misma vez la creación
	 * de los propios hilos citados anteriormente.
	 * También, indicamos que cuando se ejecuta el hilo,
	 * el botón iniciar cambia su texto a CONTANDO y los demás
	 * botones se deshabilitan.
	 */
	@FXML
	private void buttonStart() {
		
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
		restart.setDisable(true);
	}

	/**
	 * En este método nos encargamos de detener y reanudar el hilo con el mismo botón.
	 * Para ello, cuando detenemos el hilo, los botones cambian su
	 * texto y se deshabilitan y cuando lo reanudamos continúa 
	 * el hilo por su ejecución y los botones cambian al igual que
	 * el botón de detener.
	 */
	@FXML
	private void buttonStop() {

		if (stop.getText().equals("DETENER")) {
			j1.stopHilo();
			j2.stopHilo();
			j3.stopHilo();
			j4.stopHilo();

			start.setText("DETENIDO");
			stop.setText("REANUDAR");
			restart.setDisable(false);

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

	/**
	 * En este método nos encargamos de reiniciar el hilo principal,
	 * para ello, seteamos los valores a 0, una vez que el hilo
	 * principal haya alcanzado el objetivo final.
	 * Cambiamos el texto de dichos botones y deshabilitamos los
	 * botones de detener y reiniciar.
	 */
	@FXML
	private void buttonRestart() {
		
		if (restart.getText().equals("REINICIAR")) {
			start.setText("INICIAR");
			stop.setText("DETENER");
			start.setDisable(false);
			stop.setDisable(true);
			restart.setDisable(true);
			
			car1.setLayoutX(0);
			car2.setLayoutX(0);
			car3.setLayoutX(0);
			car4.setLayoutX(0);
		}
	}
}
