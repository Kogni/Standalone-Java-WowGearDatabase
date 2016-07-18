package Threads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import Various.Item;
import Various.Model_Producer;

public class Thread_IdentifyItem extends Thread {
	
	Item ResultHolder;
	Model_Producer Model_Producer;
	
	public Thread_IdentifyItem( Item ResultHolder, Model_Producer Model_Producer ) {
		
		this.ResultHolder = ResultHolder;
		this.Model_Producer = Model_Producer;
		
	}
	
	public void run() {
		
		int Location;
		int QualityLocation = 0;
		
		System.out.println( "Identifiserer item" );
		//quality
		Location = ResultHolder.Unknown.indexOf("greyname");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"GreyQuality"+ ResultHolder.Unknown.substring((Location+("greyname").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("GreyQuality");
			Location = ResultHolder.Unknown.indexOf("greyname");
		}
		Location = ResultHolder.Unknown.indexOf("whitename");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"WhiteQuality"+ ResultHolder.Unknown.substring((Location+("whitename").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("WhiteQuality");
			Location = ResultHolder.Unknown.indexOf("whitename");
		}
		Location = ResultHolder.Unknown.indexOf("greenname");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"GreenQuality"+ ResultHolder.Unknown.substring((Location+("whitename").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("GreenQuality");
			Location = ResultHolder.Unknown.indexOf("greenname");
		}
		Location = ResultHolder.Unknown.indexOf("bluename");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"BlueQuality"+ ResultHolder.Unknown.substring((Location+("bluename").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("BlueQuality");
			Location = ResultHolder.Unknown.indexOf("bluename");
		}
		Location = ResultHolder.Unknown.indexOf("purplename");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"PurpleQuality"+ ResultHolder.Unknown.substring((Location+("purplename").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("PurpleQuality");
			Location = ResultHolder.Unknown.indexOf("purplename");
		}
		Location = ResultHolder.Unknown.indexOf("orangename");
		while ( Location > -1 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.substring(0, Location) +"OrangeQuality"+ ResultHolder.Unknown.substring((Location+("orangename").length()), ResultHolder.Unknown.length());
			QualityLocation = ResultHolder.Unknown.indexOf("OrangeQuality");
			Location = ResultHolder.Unknown.indexOf("orangename");
		}
		
		int StartItemName = ResultHolder.Unknown.indexOf("&quot;&gt;", QualityLocation);
		int EndItemName = ResultHolder.Unknown.indexOf("&lt;/span");
		ResultHolder.Name = ResultHolder.Unknown.substring(StartItemName+("&quot;&gt;".length()), EndItemName);
		ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("&quot;&gt;"+ResultHolder.Name, "");
		//System.out.println("Item name: "+this.Name);
		
		
		//item propertis
		
		ResultHolder.Quality = ResultHolder.Class_Identifier.FindItemQuality(ResultHolder.Unknown);
		if ( ResultHolder.Quality != null ) {
			//System.out.println("Dette item er Quality: "+Quality);
			ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(ResultHolder.Quality, "");
		}
		
		int GlyphLoc = ResultHolder.Unknown.indexOf("Glyph of ");
		if ( GlyphLoc > 0 ) {
			ResultHolder.ItemType = "Glyph";
		}
		
		ResultHolder.ItemLevel = ResultHolder.Class_Identifier.FindItemLvl(ResultHolder.Unknown);
		if ( ResultHolder.ItemLevel > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("<level>"+ResultHolder.ItemLevel+"</level>", "");
		}
		
		ResultHolder.Bind = ResultHolder.Class_Identifier.FindItemBind(ResultHolder.Unknown);
		if ( ResultHolder.Bind != null ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(ResultHolder.Bind, "");
		}
		
		ResultHolder.Slot = ResultHolder.Class_Identifier.FindItemSlot(ResultHolder.Unknown);
		if ( ResultHolder.Slot != null ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Slot, "");
		}
		
		if ( ResultHolder.ItemType == null ) {
			ResultHolder.ItemType = ResultHolder.Class_Identifier.FindItemType(ResultHolder.Unknown);
			if ( ResultHolder.ItemType != null ) {
				//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(ItemType, "");
			}
		}
		
		ResultHolder.Unique = ResultHolder.Class_Identifier.FindItemUnique(ResultHolder.Unknown);
		if ( ResultHolder.Unique == true ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Unique", "");
		}
		
		ResultHolder.LevelReq = ResultHolder.Class_Identifier.FindLevelReq(ResultHolder.Unknown);
		if ( ResultHolder.LevelReq > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Requires Level "+ResultHolder.LevelReq, "");
			//System.out.println("Dette item er LevelReq: "+LevelReq);
		}
		
		//stats
		ResultHolder.Armor = ResultHolder.Class_Identifier.FindItemArmor(ResultHolder.Unknown);
		if ( ResultHolder.Armor > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Armor+" Armor", "");
			//System.out.println("Dette item har Armor="+Armor);
		}
		
		ResultHolder.Stamina = ResultHolder.Class_Identifier.FindItemStamina(ResultHolder.Unknown);
		if ( ResultHolder.Stamina > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Stamina+" Stamina", "");
			//System.out.println("Dette item har Stamina="+Stamina);
		}
		
		ResultHolder.Intellect = ResultHolder.Class_Identifier.FindItemIntellect(ResultHolder.Unknown);
		if ( ResultHolder.Intellect > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Intellect+" Intellect", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.Spirit = ResultHolder.Class_Identifier.FindItemSpirit(ResultHolder.Unknown);
		if ( ResultHolder.Spirit > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Spirit+" Spirit", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.Agility = ResultHolder.Class_Identifier.FindItemAgility(ResultHolder.Unknown);
		if ( ResultHolder.Agility > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Agility+" Agility", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.Strength = ResultHolder.Class_Identifier.FindItemStrength(ResultHolder.Unknown);
		if ( ResultHolder.Strength > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst(Strength+" Strength", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.Effect = ResultHolder.Class_Identifier.FindItemEffect(ResultHolder.Unknown);
		if ( ResultHolder.Effect == true ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Effect", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.SpellPower = ResultHolder.Class_Identifier.FindItemSpell(ResultHolder.Unknown);
		if ( ResultHolder.SpellPower > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases spell power by "+SpellPower, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.HasteRating = ResultHolder.Class_Identifier.FindItemHaste(ResultHolder.Unknown);
		if ( ResultHolder.HasteRating > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Improves haste rating by "+HasteRating, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.CritRating = ResultHolder.Class_Identifier.FindItemCrit(ResultHolder.Unknown);
		if ( ResultHolder.CritRating > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Improves critical strike rating by "+CritRating, "");
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases your critical strike rating by "+CritRating, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.HitRating = ResultHolder.Class_Identifier.FindItemHit(ResultHolder.Unknown);
		if ( ResultHolder.HitRating > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Improves hit rating by "+HitRating, "");
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases your hit rating by "+HitRating, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.AttackPower = ResultHolder.Class_Identifier.FindItemAP(ResultHolder.Unknown);
		if ( ResultHolder.AttackPower > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases attack power by "+AttackPower, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.ExpertRate = ResultHolder.Class_Identifier.FindItemExpR(ResultHolder.Unknown);
		if ( ResultHolder.ExpertRate > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases your expertise rating by "+ExpertRate, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.PenetRate = ResultHolder.Class_Identifier.FindItemPenetR(ResultHolder.Unknown);
		if ( ResultHolder.PenetRate > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Increases armor penetration rating by "+PenetRate, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.MP5 = ResultHolder.Class_Identifier.FindItemMP5(ResultHolder.Unknown);
		if ( ResultHolder.MP5 > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replaceFirst("Restores "+MP5+" mana per 5 sec.", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.Tankitem = ResultHolder.Class_Identifier.CheckTankItem(ResultHolder.Unknown);
		
		//sockets
		ResultHolder.SocketYellow = ResultHolder.Class_Identifier.FindItemSocketY(ResultHolder.Unknown);
		if ( ResultHolder.SocketYellow > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("Yellow Socket", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.SocketRed = ResultHolder.Class_Identifier.FindItemSocketR(ResultHolder.Unknown);
		if ( ResultHolder.SocketRed > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("Red Socket", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.SocketBlue = ResultHolder.Class_Identifier.FindItemSocketB(ResultHolder.Unknown);
		if ( ResultHolder.SocketBlue > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("Blue Socket", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.SocketMeta = ResultHolder.Class_Identifier.FindItemSocketM(ResultHolder.Unknown);
		if ( ResultHolder.SocketMeta > 0 ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("Meta Socket", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.SocketBonusAmount = ResultHolder.Class_Identifier.FindItemSocketBonusAmount(ResultHolder.Unknown);
		if ( ResultHolder.SocketBonusAmount > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replace("Socket Bonus: +"+SocketBonusAmount, "");
			//System.out.println("Dette item har SocketBonusAmount="+SocketBonusAmount);
		}
		
		ResultHolder.SocketBonusType = ResultHolder.Class_Identifier.FindItemSocketBonusType(ResultHolder.Unknown);
		if ( ResultHolder.SocketBonusType != null ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replace(SocketBonusType, "");
			//System.out.println("Dette item har SocketBonusType="+SocketBonusType);
		}
		
		ResultHolder.MinDmg = ResultHolder.Class_Identifier.FindItemMinDmg(ResultHolder.Unknown);
		if ( ResultHolder.MinDmg > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replace(MinDmg+" - ", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.MaxDmg = ResultHolder.Class_Identifier.FindItemMaxDmg(ResultHolder.Unknown);
		if ( ResultHolder.MaxDmg > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replace(MaxDmg+" Damage", "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}
		
		ResultHolder.WpnSpeed = ResultHolder.Class_Identifier.FindItemSpeed(ResultHolder.Unknown);
		if ( ResultHolder.WpnSpeed > 0 ) {
			//ResultHolder.Unknown = ResultHolder.Unknown.replace("Speed "+WpnSpeed, "");
			//System.out.println("Dette item har Intellect="+Intellect);
		}

		ResultHolder.Classes.put("Death Knight", false);
		ResultHolder.Classes.put("Druid", false);
		ResultHolder.Classes.put("Hunter", false);
		ResultHolder.Classes.put("Mage", false);
		ResultHolder.Classes.put("Paladin", false);
		ResultHolder.Classes.put("Priest", false);
		ResultHolder.Classes.put("Rogue", false);
		ResultHolder.Classes.put("Shaman", false);
		ResultHolder.Classes.put("Warlock", false);
		ResultHolder.Classes.put("Warrior", false);
		
		ResultHolder.keyIterator = ResultHolder.Classes.keySet().iterator();

	    int RequiredC = 0;
		while (ResultHolder.keyIterator.hasNext()) {
			String Klassen = (String) ResultHolder.keyIterator.next(); // her er nøkkelen.
			ResultHolder.Classes.put(Klassen, ResultHolder.Class_Identifier.FindItemClass(ResultHolder.Unknown, Klassen));
			boolean Required = ResultHolder.Classes.get(Klassen); // her er verdien.);
			if ( Required == true ) {
				ResultHolder.Unknown = ResultHolder.Unknown.replace(Klassen, "");
				RequiredC ++;
			}
		}
		if ( RequiredC == 0 ) {
			ResultHolder.keyIterator = ResultHolder.Classes.keySet().iterator();
			while (ResultHolder.keyIterator.hasNext()) {
				String Klassen = (String) ResultHolder.keyIterator.next(); // her er nøkkelen.
				//ResultHolder.Classes.put(Klassen, true);
			}
		}
		ResultHolder.keyIterator = ResultHolder.Classes.keySet().iterator();
		
		ResultHolder.RequiredProf = ResultHolder.Class_Identifier.FindItemProf(ResultHolder.Unknown);
		if ( ResultHolder.RequiredProf != null ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace(ResultHolder.RequiredProf, "");
		}
		
		ResultHolder.Unknown = ResultHolder.Unknown.replace("&lt", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("&quot", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("&gt", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("br /", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("br/", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("/span", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("&amp", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("nbsp", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace(":", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace(";", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("span class=", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("div class=", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("&", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("/div", " ");

		ResultHolder.Unknown = ResultHolder.Unknown.replace("<wowitem>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("wowitem", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("wowitemlive", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("iname", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("wowrttxt", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<arcane_resist>0</arcane_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<armor>0</armor>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<block>0</block>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<charges1>-1</charges1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<charges1>0</charges1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<charges2>0</charges2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<charges3>0</charges3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<common_mob></common_mob>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<common_percent></common_percent>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<depreciated>0</depreciated>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<description></description>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("ResultHolder.Unknown Item&lt;br/&gt;&lt;span class=&quot;akznotice&quot;&gt;Item display is courtesy &lt;a href=&quot;http://wow.allakhazam.com/&quot;&gt;wow.allakhazam.com&lt;/a&gt;.", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_high2>0</dmg_high2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_high3>0</dmg_high3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_high1>0</dmg_high1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_low2>0</dmg_low2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_low3>0</dmg_low3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_low1>0</dmg_low1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_resist>0</dmg_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_resist2>0</dmg_resist2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_resist3>0</dmg_resist3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<fire_resist>0</fire_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<frost_resist>0</frost_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<gemid>0</gemid>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<holy_resist>0</holy_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<image></image>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("itemeffectlink", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("Equip", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("a href=", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<buyprice>0</buyprice>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("</display_html>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_deDE>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("</display_html_deDE>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_esES>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("ResultHolder.Unknown Item", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("akznotice", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("akznotice", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace(" http //wow.allakhazam.com/ ", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<name2></name2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<name3></name3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<name4></name4>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<nature_resist>0</nature_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<zoneid></zoneid></>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<updated></updated>", "");
		for ( int Y = 0 ; Y < 200 ; Y++ ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("<ResultHolder.Unknown_"+Y+"></ResultHolder.Unknown_"+Y+">", "");
			ResultHolder.Unknown = ResultHolder.Unknown.replace("<ResultHolder.Unknown_"+Y+">0</ResultHolder.Unknown_"+Y+">", "");
			ResultHolder.Unknown = ResultHolder.Unknown.replace("<ResultHolder.Unknown_"+Y+">-1</ResultHolder.Unknown_"+Y+">", "");
		}
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("?", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("ì", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("©", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("°", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("ê", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("³", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("¼", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("µ", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<ispvpvendor>0</ispvpvendor>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<isqfodder>0</isqfodder>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<iscrafted>0</iscrafted>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<isquested>0</isquested>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<israid>0</israid>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<isstatic>0</isstatic>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<isworld>0</isworld>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<isvendor>0</isvendor>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<unique>0</unique>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<total_percent></total_percent>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<total_drops></total_drops>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<toolid>0</toolid>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<strength>0</strength>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<stamina>0</stamina>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spirit>0</spirit>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellpower>0</spellpower>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellhitrating>0</spellhitrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellhasterating>0</spellhasterating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spelleffect1>0</spelleffect1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spelleffect2>0</spelleffect2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spelleffect3>0</spelleffect3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spelldmg>0</spelldmg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcritrating>0</spellcritrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<slots>0</slots>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<shieldblockrating>0</shieldblockrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<shadowdmg>0</shadowdmg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<shadow_resist>0</shadow_resist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<resiliencerating>0</resiliencerating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<rangehitrating>0</rangehitrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<rangecritrating>0</rangecritrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<rangeattack>0</rangeattack>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<parryrating>0</parryrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<naturedmg>0</naturedmg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<modtargetresist>0</modtargetresist>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<meleehitrating>0</meleehitrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<meleecritrating>0</meleecritrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<manaregen>0</manaregen>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<mana>0</mana>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<intellect>0</intellect>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<hitrating>0</hitrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<healthregen>0</healthregen>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<health>0</health>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<healing>0</healing>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<hasterating>0</hasterating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<frostdmg>0</frostdmg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<firedmg>0</firedmg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<expertiserating>0</expertiserating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<ds>0</ds>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dodgerating>0</dodgerating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<defenserating>0</defenserating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<critrating>0</critrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<attackpower>0</attackpower>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<attack>0</attack>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<armorpenrating>0</armorpenrating>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<armorpenetration>0</armorpenetration>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<arcanedmg>0/<arcanedmg>", "");
		                         //<arcanedmg>0</arcanedmg>
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<agility>0</agility>", "");
		for ( int Y = 0 ; Y <= 40 ; Y++ ) {
			ResultHolder.Unknown = ResultHolder.Unknown.replace("<stat"+Y+"_value>0</stat"+Y+"_value>", "");
			ResultHolder.Unknown = ResultHolder.Unknown.replace("<stat"+Y+"_stat>0</stat"+Y+"_stat>", "");
		}
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<startquest>0</startquest>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<notes></notes>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<opened>0</opened>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<randomsuf>0</randomsuf>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<randprop>0</randprop>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<recskill_amount>0</recskill_amount>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<recskill_skill>0</recskill_skill>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<req_spell>0</req_spell>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<reqfaction>0</reqfaction>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<reqfactionlvl>0</reqfactionlvl>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<reqpvprank>0</reqpvprank>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<source>live</source>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellact1>0</spellact1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellact2>0</spellact2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellact3>0</spellact3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown1>0</spellcooldown1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown2>0</spellcooldown2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown3>0</spellcooldown3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown1>-1</spellcooldown1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown2>-1</spellcooldown2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcooldown3>-1</spellcooldown3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgroup1>0</spellcoolgroup1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgroup2>0</spellcoolgroup2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgroup3>0</spellcoolgroup3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgrouptime1>-1</spellcoolgrouptime1>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgrouptime2>-1</spellcoolgrouptime2>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<spellcoolgrouptime3>-1</spellcoolgrouptime3>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<stacksize>1</stacksize>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<speed>0</speed>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<statcount>0</statcount>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_high>0</dmg_high>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_avg>0</dmg_avg>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dmg_low>0</dmg_low>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<dps>0</dps>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<unique></unique>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<stats></stats>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<icon>/images/icons/404.png</icon>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_zhTW> wow.allakhazam.com </display_html_zhTW>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_zhCN> wow.allakhazam.com </display_html_zhCN>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_koKR> wow.allakhazam.com </display_html_koKR>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_frFR> wow.allakhazam.com </display_html_frFR>", "");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("<display_html_esES> wow.allakhazam.com </display_html_esES>", "");
		
		ResultHolder.Unknown = ResultHolder.Unknown.replace("/a ", " ");
		ResultHolder.Unknown = ResultHolder.Unknown.replace("  ", "");
		
		//System.out.println("Uidentifisert tekst: "+ResultHolder.Unknown);
		
		//Model_Producer.OutputItems( ResultHolder );
		
		OutputItems( ResultHolder );
		
	}
	
	public void OutputItems( Item Itemet ) {
		
		//System.out.println("Bedt om å skrive ut til filen "+filenameTo);
		try {
			File filen = new File ( "Items/"+Itemet.Name+".txt" );
			if ( !filen.exists()) {
				filen.createNewFile();
			}
			FileOutputStream Skrivefilen = new FileOutputStream ( filen, true );
			PrintStream utfil = new PrintStream ( Skrivefilen ); //feil har ikke med GUI å gjøre
			
			if ( Itemet.Name.length() < 50 ) {
				if ( Itemet.Class_Identifier.IsEquippable(Itemet.Unknown)) {
					System.out.println("Skriver ut "+Itemet.Name+" "+Itemet.ItemType+" "+Itemet.Slot);
					utfil.println(Itemet.Name);
					utfil.println(Itemet.ItemLevel);
					utfil.println(Itemet.ItemType);
					utfil.println(Itemet.Slot);
					utfil.println(Itemet.Quality);
					utfil.println(Itemet.Bind);
					utfil.println(Itemet.Unique);
					utfil.println(Itemet.LevelReq);
					utfil.println(Itemet.Effect);
					utfil.println(Itemet.Tankitem);
					
					utfil.println(Itemet.Armor);
					utfil.println(Itemet.Stamina);
					utfil.println(Itemet.Intellect);
					utfil.println(Itemet.Spirit);
					utfil.println(Itemet.Agility);
					utfil.println(Itemet.Strength);
					utfil.println(Itemet.SpellPower);
					utfil.println(Itemet.HasteRating);
					utfil.println(Itemet.CritRating);
					utfil.println(Itemet.HitRating);
					utfil.println(Itemet.AttackPower);
					utfil.println(Itemet.ExpertRate);
					utfil.println(Itemet.PenetRate);
					utfil.println(Itemet.MP5);
					
					utfil.println(Itemet.SocketYellow);
					utfil.println(Itemet.SocketRed);
					utfil.println(Itemet.SocketBlue);
					utfil.println(Itemet.SocketMeta);
					utfil.println(Itemet.SocketBonusType);
					utfil.println(Itemet.SocketBonusAmount);
					
					utfil.println(Itemet.MinDmg);
					utfil.println(Itemet.MaxDmg);
					utfil.println(Itemet.WpnSpeed);
					
					//System.out.println("Hasnext?="+Itemet.keyIterator.hasNext());
					while ( Itemet.keyIterator.hasNext()) {
						String Klassen = (String) Itemet.keyIterator.next(); // her er nøkkelen.
						//System.out.println("Sjekker class requirement "+Klassen);
						boolean Required = Itemet.Classes.get(Klassen); // her er verdien.);
						//System.out.println(Klassen+": "+Required);
						utfil.println(Klassen); // her er nøkkelen.
						utfil.println(Required); // her er verdien.); // her er verdien.
					}
					utfil.println(Itemet.RequiredProf);
					
					utfil.println(Itemet.Unknown);

					utfil.close ( );
				}
			}
		} catch ( Exception e ) {
			System.out.println("Exception");
			System.out.println("Kunne ikke lese fil b");
			System.out.println ( "Throwable message: " + e.getMessage ( ) );
			System.out.println ( "Throwable cause: " + e.getCause ( ) );
			System.out.println ( "Throwable class: " + e.getClass ( ) );
			if ( e.getStackTrace ( ) != null ){
				System.out.println ( "Exception origin: ");
				System.out.println ( "Class: " + e.getStackTrace ( )[0].getClassName ( ) );
				System.out.println ( "Method: " + e.getStackTrace ( )[0].getMethodName ( ) );
				System.out.println ( "Line: " + e.getStackTrace ( )[0].getLineNumber ( ) );
			}
			for ( int y = 1 ; y < e.getStackTrace().length ; y++ ) {
				System.out.println (" ");
				System.out.println ( "Origin stack "+y+": ");
				System.out.println ( "Class: " + e.getStackTrace ( )[y].getClassName ( ) );
				System.out.println ( "Method: " + e.getStackTrace ( )[y].getMethodName ( ) );
				System.out.println ( "Line: " + e.getStackTrace ( )[y].getLineNumber ( ) );
			}
		}
		
	}

}
