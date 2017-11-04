package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.creatures.Creature;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

public abstract class LocationCommand implements WurmServerMod, PlayerMessageListener {

    @Override
    public void preInit() {
    }

    public boolean onPlayerMessage (Communicator chat, String message, final Creature performer, final int tilex, final int tiley, final short action) {
        if (message.startsWith("/location")) {
            switch (action) {
            }
            chat.sendNormalServerMessage("That tile is at " + tilex + ", " + tiley + ", are you on the surface? =" + performer.isOnSurface());
        }

        return true;
    }
}
