
package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;


public class LocationCommand implements WurmServerMod, PlayerMessageListener {

    private static void handleSlashMessageLocation(Communicator chat, final Creature performer, final int tilex, final int tiley) {
        chat.sendNormalServerMessage("That tile is at " + tilex + ", " + tiley + ", are you on the surface? =" + performer.isOnSurface());
    }

    @Override
    public boolean onPlayerMessage(Communicator communicator, String message) {
        if (message.startsWith("/location")) {
            final Player player = communicator.getPlayer();
            handleSlashMessageLocation(communicator, player, player.getTileX(), player.getTileY());
            return true;
        }
        return false;
    }
}

/*
package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.creatures.Creature;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

public class LocationCommand implements WurmServerMod, PlayerMessageListener {

    @Override
    public void preInit() {
    }

    public static void handleSlashMessageLocation(Communicator chat, final Creature performer, final int tilex, final int tiley) {
        chat.sendNormalServerMessage("That tile is at " + tilex + ", " + tiley + ", are you on the surface? =" + performer.isOnSurface());
    }

    @Override
    public boolean onPlayerMessage(Communicator chat, String message, final Creature performer, final int tilex, final int tiley) {
        if (message.startsWith("/location")) {
            handleSlashMessageLocation(chat, performer, tilex, tiley);
            return true;
        }
        return false;
    }
}
*/

