package bukkit.tommytony.war.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tommytony.war.ZoneSetter;

import bukkit.tommytony.war.NoZoneMakerException;
import bukkit.tommytony.war.War;
import bukkit.tommytony.war.WarCommandHandler;

public class SetZoneCommand extends AbstractZoneMakerCommand {

	public SetZoneCommand(WarCommandHandler handler, CommandSender sender, String[] args) throws NoZoneMakerException {
		super(handler, sender, args);
	}

	@Override
	public boolean handle() {
		if (!(this.sender instanceof Player)) {
			return false;
		}

		Player player = (Player) this.sender;

		if (this.args.length == 0) {
			return false;
		} else if (this.args.length > 2) {
			return false;
		} else if (this.args.length == 1) {
			War.war.addWandBearer(player, this.args[0]);
		} else if (this.args.length == 2) {
			if (!this.args[1].equals("southeast") && !this.args[1].equals("northwest") && !this.args[1].equals("se") && !this.args[1].equals("nw") && !this.args[1].equals("corner1") && !this.args[1].equals("corner2") && !this.args[1].equals("c1") && !this.args[1].equals("c2") && !this.args[1].equals("pos1") && !this.args[1].equals("pos2") && !this.args[1].equals("wand")) {
				return false;
			}

			ZoneSetter setter = new ZoneSetter(player, this.args[0]);
			if (this.args[1].equals("northwest") || this.args[1].equals("nw")) {
				setter.placeNorthwest();
			} else if (this.args[1].equals("southeast") || this.args[1].equals("se")) {
				setter.placeSoutheast();
			} else if (this.args[1].equals("corner1") || this.args[1].equals("c1") || this.args[1].equals("pos1")) {
				setter.placeCorner1();
			} else if (this.args[1].equals("corner2") || this.args[1].equals("c2") || this.args[1].equals("pos2")) {
				setter.placeCorner2();
			} else if (this.args[1].equals("wand")) {
				War.war.addWandBearer(player, this.args[0]);
			}
		}

		return true;
	}
}