package main;

public class Building extends Thing {
	Player myPlayer;
	public final int BASE = 1;
	public final int FARM = 2;
	public final int QUARRY = 3;
	public final int LUMBERMILL = 4;
	public final int TOWER = 5;
	public final int BARRACKS = 6;
	public final int RANGE = 7;
	public final int HOSPITAL = 8; 
	private int type;
	private int timetic=0;
	private int unittic=0;
	private int unitreq;

	private int unittomake;
	private boolean creatingunits=false;

	public Building(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type=type;
	}
	public void tic(){
		if(type==BASE){
			timetic++;
			if(timetic==20){
				myPlayer.resource().addGold(2);
				timetic=0;
			}
		}
		else if(type==FARM){
			timetic++;
			if(timetic==20){
				myPlayer.resource().addFood(4);
				timetic=0;
			}
		}
		else if(type==QUARRY){
			timetic++;
			if(timetic==20){
				myPlayer.resource().addStone(5);
				timetic=0;
			}
		}
		else if(type==LUMBERMILL){
			timetic++;
			if(timetic==20){
				myPlayer.resource().addWood(5);
				timetic=0;
			}
		}
		else if(type==TOWER){
			timetic++;
			if(timetic==20){
				//ATTACK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				timetic=0;
			}

		}
		if(type==BASE||type==BARRACKS||type==RANGE||type==HOSPITAL){
			if(creatingunits==true){
				unittic++;
				if(unittic==unitreq){
					//ADD THE UNIT THE THE WORLD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					unittic=0;
					unitreq=0;
					creatingunits=false;
				}
			}
		}
	}
	public Player getPlayer(){
		return myPlayer;
	}
	public void createUnit(int unit){
		if (type==1){
			if(unit ==Unit.WORKER){
				unitreq=20*5;
				unittomake=unit;
				creatingunits=true;
			}
		}
		if (type==6){
			if(unit ==Unit.WARRIOR){
				unitreq=20*10;
				unittomake=unit;
				creatingunits=true;
			}
			else if(unit ==Unit.KNIGHT){
				unitreq=20*30;
				unittomake=unit;
				creatingunits=true;
			}
		}
		if(type==7){
			if(unit ==Unit.ARCHER){
				unitreq=20*10;
				unittomake=unit;
				creatingunits=true;
			}
			else if(unit ==Unit.CROSSBOW){
				unitreq=20*40;
				unittomake=unit;
				creatingunits=true;
			}
		}
		if(type==8){
			if(unit ==Unit.MEDIC){
				unitreq=20*20;
				unittomake=unit;
				creatingunits=true;
			}
			else if(unit ==Unit.SHAMAN){
				unitreq=20*120;
				unittomake=unit;
				creatingunits=true;
			}
		}
	}
}
