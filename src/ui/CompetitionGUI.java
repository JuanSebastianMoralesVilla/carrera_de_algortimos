package ui;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import model.Competition;
import trhead.AnimationCircle;
import trhead.Chronometer;
import trhead.RaceArrayList;
import trhead.RaceBinaryTree;
import trhead.RaceLinkedList;

public class CompetitionGUI {

	String algorithm;
	String mode;
	int number;
	boolean array = false;
	boolean linked = false; 
	boolean tree = false;

	@FXML
	private TextField txtNum;

	@FXML
	private RadioButton rdAdd;

	@FXML
	private ToggleGroup GruopA;

	@FXML
	private RadioButton rdDelete;

	@FXML
	private RadioButton rdSearch;

	@FXML
	private ToggleGroup GruopMode;

	@FXML
	private TextField txtArrayList;

	@FXML
	private TextField txtLinkedList;

	@FXML
	private TextField txtBynariTree;

	@FXML
	private TextField txtCronometre;

	@FXML
	private ProgressBar pbArrayList;

	@FXML
	private ProgressBar pbLinkedList;

	@FXML
	private ProgressBar pbBinaryTree;

	@FXML
	private TextField txtProgressArrayList;

	@FXML
	private TextField txtProgressLinkedList;

	@FXML
	private TextField txtProgressBst;
	
	@FXML
    private Circle bigCircle;

    @FXML
    private Circle smallCircle;

	public void initialize() {
		GruopA.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (GruopA.getSelectedToggle() != null) {
					RadioButton selectedRadioButton = (RadioButton) GruopA.getSelectedToggle();
					algorithm = selectedRadioButton.getText();
				}
			}
		});

		GruopMode.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (GruopMode.getSelectedToggle() != null) {
					RadioButton selectedRadioButton = (RadioButton) GruopA.getSelectedToggle();
					mode = selectedRadioButton.getText();
				}
			}
		});

	}

	@FXML
	void startRace(ActionEvent event) {
		number = Integer.parseInt(txtNum.getText());
		Competition competition = new Competition();
		RaceArrayList raceArray = new RaceArrayList(this, competition);
		raceArray.setDaemon(true);
		raceArray.start();
		RaceLinkedList raceLinked = new RaceLinkedList(this, competition);
		raceLinked.setDaemon(true);
		raceLinked.start();
		RaceBinaryTree raceTree = new RaceBinaryTree(this, competition);
		raceTree.setDaemon(true);
		raceTree.start();
		AnimationCircle animation = new AnimationCircle(this);
		animation.setDaemon(true);
		animation.start();
		Chronometer crono = new Chronometer(this);
		crono.setDaemon(true);
		crono.start();
	}

	public String getMode() {
		return mode;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean ArrayIsFinish() {
		return array;
	}
	
	public boolean LinkedIsFinish() {
		return linked;
	}
	
	public boolean TreeIsFinish() {
		return tree;
	}

	public void finishArrayList(String time) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtArrayList.setText(time);
				array = true;
			}
		});
	}
	
	public void finishLinkedList(String time) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtLinkedList.setText(time);
				linked = true;
			}
		});
	}
	
	public void finishBst(String time) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtBynariTree.setText(time);
				tree = true;
			}
		});
	}

	public void setProgressArray(int progress) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtProgressArrayList.setText(String.valueOf(progress));
				pbArrayList.setProgress((double) progress / number);
			}
		});
	}
	
	public void setProgressLinkedList(int progress) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtProgressLinkedList.setText(String.valueOf(progress));
				pbLinkedList.setProgress((double) progress / number);
			}
		});
	}
	
	public void setProgressBst(int progress) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				txtProgressBst.setText(String.valueOf(progress));
				pbBinaryTree.setProgress((double) progress / number);
			}
		});
	}
	
	public void animationBigCircle(int radius) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				bigCircle.setRadius(radius);
				if(radius < 25)
					bigCircle.toFront();
			}
		});
	}
	
	public void animationSmallCircle(int radius) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				smallCircle.setRadius(radius);
				if(radius < 25)
					smallCircle.toFront();
			}
		});
	}
	
	public void chronometer(String time) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				txtCronometre.setText(time);
			}
		});
	}
	
}
