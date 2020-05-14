package trhead;

import java.util.ArrayList;

import model.BinaryTree;
import model.Competition;
import model.NodeTree;
import ui.CompetitionGUI;

public class RaceBinaryTree extends Thread {

	CompetitionGUI competitionGUI;
	Competition competition;
	BinaryTree tree = new BinaryTree();
	ArrayList<Long> numbers;

	public RaceBinaryTree(CompetitionGUI ui, Competition c) {
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
					tree.add(new NodeTree(data.get(i)));
				}
			}else {
				for (int i = 0; i < competitionGUI.getNumber(); i++) {
					tree.addRec(tree.getRoot(), data.get(i));
				}
			}
			
		}
		long start = System.currentTimeMillis();
		if (competitionGUI.getMode().equals("Iterative")) {
			if (competitionGUI.getAlgorithm().equals("Add")) {
				for (int i = 0; i < numbers.size(); i++) {
					tree.add(new NodeTree(data.get(i)));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					tree.search(numbers.get(i));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					tree.delete(numbers.get(i));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
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
					tree.addRec(tree.getRoot(), data.get(i));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (competitionGUI.getAlgorithm().equals("Search")) {
				for (int i = 0; i < numbers.size(); i++) {
					tree.searchRec(tree.getRoot(),numbers.get(i));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < numbers.size(); i++) {
					tree.deleteRec(tree.getRoot(), numbers.get(i));
					tree.setProgress(i+1);
					competitionGUI.setProgressBst(i+1);
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
		tree.setTime(time);
		competitionGUI.finishBst(String.valueOf(time));
	}

}
