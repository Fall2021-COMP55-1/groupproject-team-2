public enum PowerType {
	DOUBLESHOT, TRIPLESHOT, POWERSHOT, INCREASESPEED, EXTRAHEALTH, NONE;        
	
	//This class will be used to determine if the player has collected a power up which will aid in their survival 
	
	public String toString() {
		switch(this) {
			case DOUBLESHOT: return "doubleshot";
			case TRIPLESHOT: return "tripleshot";
			case POWERSHOT: return "powershot";
      		case INCREASESPEED: return "increasespeed";
      		case EXTRAHEALTH: return "extrahealth"; //added this case because I think it makes sense for one of the powertypes to be extra health
      		case NONE: return "none";				//feel free to erase EXTRAHEALTH it if would be too hard to implement
		}
		return "n/a";
	}
}

