package trhead;

import java.util.ArrayList;

import model.Arraylist;
import model.Competition;
import ui.CompetitionGUI;

public class RaceArrayList extends Thread {

	CompetitionGUI competitionGUI;
	Competition competition;
	Arraylist array = new Arraylist();
	ArrayList<Long> numbers;

	public RaceArrayList(CompetitionGUI ui, Competition c) {
		competitionGUI = ui;
		competition = c;
		numbers = competition.getData(competitionGUI.getNumber());
	}

	@Override
	public void run() {
		ArrayList<Long> data = competition.getData(competitionGUI.getNumber());
		if (competitionGUI.getAlgorithm().equals("Delete") || competitionGUI.getAlgorithm().equals("Search")) {
			for (int i = 0; i < competitionGUI.getNumber(); i++) {
				array.addNum(data.get(i));
			}
		}
		long start = System.currentTimeMillis();
		if (competitionGUI.getMode().equals("Iterative")) {
			if (competitionGUI.getAlgorithm().equals("Add")) {
				for (int i = 0; i < numbers.size(); i++) {
					array.addNum(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					array.searchIterative(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					array.deleteIterative(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			if (competitionGUI.getAlgorithm().equals("Add")) {
				for (int i = 0; i < numbers.size(); i++) {
					array.addNum(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					array.searchRec(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					array.removeRec(numbers.get(i));
					array.setProgress(i+1);
					competitionGUI.setProgressArray(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		long finish = System.currentTimeMillis();
		long time = finish - start;
		array.setTime(time);
		competitionGUI.finishArrayList(String.valueOf(time));
	}

}
