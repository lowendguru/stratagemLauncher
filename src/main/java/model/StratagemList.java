package model;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class StratagemList extends ArrayList<Stratagem> {

	public StratagemList initialize(String dataOrigin) {

		if (dataOrigin.equals("default")) {
			// TYPES: 1 support, 2 defensive, 3 offensive, 4 special

			// SUPPORT
			add(new Stratagem("Resupply", "sswd", 1, "48px-Strat_Resupply_mk1.png"));
			add(new Stratagem("MG-94 Machine Gun", "saswd", 1, "48px-Strat_MG-94_Machine_Gun_mk1.png"));
			add(new Stratagem("MGX-42 Machine Gun", "saswwa", 1, "48px-Strat_MGX-42_Machine_Gun_Mk1.png"));
			add(new Stratagem("LAS-98 Laser Cannon", "saswa", 1, "48px-Strat_LAS-98_Laser_Cannon_mk1.png"));
			add(new Stratagem("AC-22 Dum-Dum", "saswwd", 1, "48px-Strat_AC-22_Dum-Dum_mk1.png", true));
			add(new Stratagem("Obliterator Grenade Launcher", "sawas", 1,
					"48px-Strat_Obliterator_Grenade_Launcher_mk1.png"));
			add(new Stratagem("M-25 Rumbler", "sawaa", 1, "48px-Strat_M-25_Rumbler_mk1.png", true));
			add(new Stratagem("FLAM-40 Incinerator", "sasda", 1, "48px-Strat_FLAM-40_Incinerator_mk1.png"));
			add(new Stratagem("TOX-13 Avenger", "sasdd", 1, "48px-Strat_TOX-13_Avenger_mk1.png", true));
			add(new Stratagem("RL-112 Recoilless Rifle", "sadda", 1, "48px-Strat_RL-112_Recoilless_Rifle_mk1.png"));
			add(new Stratagem("EAT-17", "sadws", 1, "48px-Strat_EAT-17_mk1.png"));
			add(new Stratagem("MLS-4X Commando", "sawsd", 1, "48px-Strat_MLS-4X_Commando_mk1.png", true));
			add(new Stratagem("AD-334 Guard Dog", "swawds", 1, "48px-Strat_AD-334_Guard_Dog_mk1.png", true));
			add(new Stratagem("AD-289 Angel", "swaads", 1, "48px-Strat_AD-289_Angel_mk1.png", true));
			add(new Stratagem("Resupply Pack", "swssd", 1, "48px-Strat_Resupply_Pack_mk1.png"));
			add(new Stratagem("LIFT-850 Jump Pack", "swwsw", 1, "48px-Strat_LIFT-850_Jump_Pack_mk1.png"));
			add(new Stratagem("SH-32 Directional Kinetic Shield", "swadas", 1,
					"48px-Strat_SH-32_Directional_Kinetic_Shield_mk1.png", true));
			add(new Stratagem("SH-20 Shield Generator Pack", "swadad", 1,
					"48px-Strat_SH-20_Shield_Generator_Pack_mk1.png"));
			add(new Stratagem("REP-80", "ssads", 1, "48px-Strat_REP-80_mk1.png"));
			add(new Stratagem("REC-6 Demolisher", "sadww", 1, "48px-Strat_REC-6_Demolisher_mk1.png", true));
			add(new Stratagem("EXO-44 Walker Exosuit", "sdwass", 1, "48px-Strat_EXO-44_Walker_Exosuit_mk1.png"));
			add(new Stratagem("EXO-48 Obsidian Exosuit", "sdwasa", 1, "48px-Strat_EXO-48_Obsidian_Exosuit_mk1.png",
					true));
			add(new Stratagem("EXO-51 Lumberer Exosuit", "sdwasd", 1, "48px-Strat_EXO-51_Lumberer_Exosuit_mk1.png",
					true));
			add(new Stratagem("MC-109 Hammer Motorcycle", "sdsaaw", 1, "48px-Strat_MC-109_Hammer_Motorcycle_mk1.png",
					true));
			add(new Stratagem("TD-110 Bastion", "sdsawd", 1, "48px-Strat_TD-110_Bastion_mk1.png", true));
			add(new Stratagem("M5 APC", "sdsaad", 1, "48px-Strat_M5_APC_mk1.png"));
			add(new Stratagem("M5-32 HAV", "sdsaws", 1, "48px-Strat_M5-32_HAV_mk1.png"));

			// DEFENSIVE

			add(new Stratagem("Humblebee UAV drone", "awd", 2, "48px-Strat_Humblebee_UAV_drone_mk1.png", true));
			add(new Stratagem("Distractor Beacon", "asd", 2, "48px-Strat_Distractor_Beacon_mk1.png"));
			add(new Stratagem("AT-47 Anti-Tank Emplacement", "aawwda", 2,
					"48px-Strat_AT-47_Anti-Tank_Emplacement_mk1.png", true));
			add(new Stratagem("A/MG-II Minigun Turret", "aswda", 2, "48px-Strat_A_MG-II_Minigun_Turret_mk1.png"));
			add(new Stratagem("A/RX-34 Railcannon Turret", "aswad", 2, "48px-Strat_A_RX-34_Railcannon_Turret_mk1.png"));
			add(new Stratagem("A/GL-8 Launcher Turret", "aswdds", 2, "48px-Strat_A_GL-8_Launcher_Turret_mk1.png"));
			add(new Stratagem("A/AC-6 Tesla Tower", "asswda", 2, "48px-Strat_A_AC-6_Tesla_Tower_mk1.png"));
			add(new Stratagem("Airdropped Anti-Personnel Mines", "adsw", 2,
					"48px-Strat_Airdropped_Anti-Personnel_Mines_mk1.png"));
			add(new Stratagem("Thunderer Smoke Round", "dswws", 2, "48px-Strat_Thunderer_Smoke_Round_mk1.png"));
			add(new Stratagem("Anti-Personnel Barrier", "adssd", 2, "48px-Strat_Anti-Personnel_Barrier_mk1.png", true));
			add(new Stratagem("Airdropped Stun Mines", "adws", 2, "48px-Strat_Airdropped_Stun_Mines_mk1.png"));

			// OFFENSIVE
			add(new Stratagem("Static Field Conductors", "dwas", 3, "48px-Strat_Static_Field_Conductors_mk1.png"));
			add(new Stratagem("Heavy Airstrike", "dwsda", 3, "48px-Strat_Airstrike_mk1.png"));
			add(new Stratagem("Vindicator Dive Bomb", "ddd", 3, "48px-Strat_Vindicator_Dive_Bomb_mk1.png"));
			add(new Stratagem("Strafing Run", "ddw", 3, "48px-Strat_Strafing_Run_mk1.png"));
			add(new Stratagem("Incendiary Bombs", "dwad", 3, "48px-Strat_Incendiary_Bombs_mk1.png"));
			add(new Stratagem("Heavy Strafing Run", "ddsw", 3, "48px-Strat_Heavy_Strafing_Run_mk1.png"));
			add(new Stratagem("Close Air Support", "ddsa", 3, "48px-Strat_Close_Air_Support_mk1.png", true));
			add(new Stratagem("Missile Barrage", "dsssas", 3, "48px-Strat_Missile_Barrage_mk1.png", true));
			add(new Stratagem("Thunderer Barrage", "dswwas", 3, "48px-Strat_Thunderer_Barrage_mk1.png"));
			add(new Stratagem("Sledge Precision Artillery", "dwawsd", 3,
					"48px-Strat_Sledge_Precision_Artillery_mk1.png", true));
			add(new Stratagem("Orbital Laser Strike", "dwawda", 3, "48px-Strat_Orbital_Laser_Strike_mk1.png"));
			add(new Stratagem("Shredder Missile Strike", "dadassd", 3, "48px-Strat_Shredder_Missile_Strike_mk1.png"));
			add(new Stratagem("Railcannon Strike", "dswsa", 3, "48px-Strat_Railcannon_Strike_mk1.png"));

			// SPECIAL
			add(new Stratagem("Reinforce", "wsdaw", 4, "48px-Strat_Reinforce_mk1.png"));
			add(new Stratagem("NUX-223 Hellbomb", "wadsws", 4, "48px-Strat_NUX-223_Hellbomb_mk1.png"));
			add(new Stratagem("ME-1 'Sniffer' Metal Detector", "ssdw", 4,
					"48px-Strat_ME-1_Sniffer_Metal_Detector_mk1.png"));
			add(new Stratagem("Emergency Beacon", "wsdw", 4, "48px-Strat_Emergency_Beacon_mk1.png"));

		}
		return this;
	}

}
