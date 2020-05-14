package trhead;

import ui.CompetitionGUI;

public class AnimationCircle extends Thread{

	CompetitionGUI competitionGUI;
	
	public AnimationCircle(CompetitionGUI ui) {
		competitionGUI = ui;
	}
	
	@Override
	public void run() {
		while (!competitionGUI.ArrayIsFinish() && !competitionGUI.LinkedIsFinish() && !competitionGUI.TreeIsFinish()) {
			int j = 15;
			for (int i = 35; i > 15; i--) {
				competitionGUI.animationBigCircle(i);
				competitionGUI.animationSmallCircle(j+1);
				try {
					sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			j= 35;
			for (int i = 15; i < 35; i++) {
				competitionGUI.animationBigCircle(i);
				competitionGUI.animationSmallCircle(j-1);
				try {
					sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
