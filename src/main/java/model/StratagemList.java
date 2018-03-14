package model;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class StratagemList extends ArrayList<Stratagem> {

	public void initialize(String dataOrigin) {

		if (dataOrigin.equals("hardcoded list")) {

			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre1", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("nombre2", "wasd", 1, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
		}
	}

}
