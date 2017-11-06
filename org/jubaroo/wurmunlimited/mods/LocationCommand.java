
package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

public class LocationCommand implements WurmServerMod, PlayerMessageListener {

    @Override
    public boolean onPlayerMessage(Communicator communicator, String message) {
        if (message.startsWith("/location")) {
            final Player player = communicator.getPlayer();
            communicator.sendNormalServerMessage("Your coordinates on the server are " + player.getTileX() + ", " + player.getTileY() + ", above ground = " + player.isOnSurface());
            return true;
        }
        return false;
    }
}
