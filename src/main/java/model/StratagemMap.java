package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class StratagemMap extends ArrayList<Stratagem> implements Serializable {

	public StratagemMap() {
		super();
	}

	public StratagemMap(int i) {
		super(i);
	}

}
