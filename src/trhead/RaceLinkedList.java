package trhead;

import java.util.ArrayList;

import model.Competition;
import model.LinkedList;
import model.NodeLinkedList;
import ui.CompetitionGUI;

public class RaceLinkedList extends Thread {

	CompetitionGUI competitionGUI;
	Competition competition;
	LinkedList linkedList = new LinkedList();
	ArrayList<Long> numbers;

	public RaceLinkedList(CompetitionGUI ui, Competition c) {
		competitionGUI = ui;
		competition = c;
		numbers = competition.getData(competitionGUI.getNumber());
	}

	@Override
	public void run() {
		ArrayList<Long> data = competition.getData(competitionGUI.getNumber());
		if (competitionGUI.getAlgorithm().equals("Delete") || competitionGUI.getAlgorithm().equals("Search")) {
			if(competitionGUI.getMode().equals("Iterative")) {
				for (int i = 0; i < competitionGUI.getNumber(); i++) {
					linkedList.add(new NodeLinkedList(data.get(i)));
				}
			}else {
				for (int i = 0; i < competitionGUI.getNumber(); i++) {
					linkedList.addRecursive(data.get(i));
				}
			}
			
		}
		long start = System.currentTimeMillis();
		if (competitionGUI.getMode().equals("Iterative")) {
			if (competitionGUI.getAlgorithm().equals("Add")) {
				for (int i = 0; i < numbers.size(); i++) {
					linkedList.add(new NodeLinkedList(data.get(i)));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					linkedList.search(numbers.get(i));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					linkedList.delete(numbers.get(i));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
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
					linkedList.addRecursive(data.get(i));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					linkedList.searchRec(linkedList.getFirst(),numbers.get(i));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					linkedList.deleteRec(linkedList.getFirst(), numbers.get(i));
					linkedList.setProgress(i+1);
					competitionGUI.setProgressLinkedList(i+1);
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
		linkedList.setTime(time);
		competitionGUI.finishLinkedList(String.valueOf(time));
	}

}
