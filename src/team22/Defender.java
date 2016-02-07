package team22;

import hockey.Util;
import hockey.api.IPlayer;
import hockey.api.Position;
import hockey.model.Player;

public class Defender extends DaPlayer {
	boolean wehaveit = true;

	public Defender(String name) {
		super(name);
	}

	// Number of defender
	public int getNumber() {
		return 10;
	}

	// Make left defender left handed, right defender right handed.
	public boolean isLeftHanded() {
		return getIndex() == 1;
	}

	// Initiate
	public void init() {
		setAimOnStick(false);
	}

	// Defender intelligence
	public void step() {
		IPlayer holder = getPuck().getHolder();
		if(holder != null) {
			wehaveit = ! holder.isOpponent();
		}
		
		if(hasPuck() || (!wehaveit && getPuck().getX() > 1000)) {
			// setMessage("Ima center!");
			super.step();
			return;
		}
		
		// setMessage("lalala..");
		skate(-1500, 0, 300);
	}
}
