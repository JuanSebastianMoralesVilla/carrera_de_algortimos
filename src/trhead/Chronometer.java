package trhead;

import ui.CompetitionGUI;

public class Chronometer extends Thread {

	CompetitionGUI competitionGUI;

	public Chronometer(CompetitionGUI ui) {
		competitionGUI = ui;
	}

	@Override
	public void run() {
		boolean stop = true;
		
		int minutos = 0;
		int segundo = 0;
		int milesimas = 0;
		for (minutos = 0; minutos < 60 && stop; minutos++) {
			for (segundo = 0; segundo < 60 && stop; segundo++) {
				for (milesimas = 0; milesimas < 100 && stop; milesimas++) {
					competitionGUI.chronometer(minutos + ":" + segundo + ":" + milesimas);
					if(competitionGUI.ArrayIsFinish() && competitionGUI.LinkedIsFinish() && competitionGUI.TreeIsFinish()) {
						stop = false;
					}
					try {
						sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
