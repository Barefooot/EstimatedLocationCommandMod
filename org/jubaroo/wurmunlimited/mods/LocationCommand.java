package org.jubaroo.wurmunlimited.mods;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.Server;
import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.zones.NoSuchZoneException;
import com.wurmonline.server.zones.Zone;
import com.wurmonline.server.zones.Zones;
import org.gotti.wurmunlimited.modloader.interfaces.PlayerMessageListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

public abstract class LocationCommand implements WurmServerMod, PlayerMessageListener {

    @Override
    public void preInit() {
    }

    public boolean onPlayerMessage(Communicator chat, String message, final Creature performer, final int tilex, final int tiley, final short action) {
        if (message.startsWith("/location")) {
            switch (action) {
            }
            chat.sendNormalServerMessage("That tile is at " + tilex + ", " + tiley + ", you surfaced=" + performer.isOnSurface());
        }
        int zid = -1;
        try {
            final Zone z = Zones.getZone(tilex, tiley, true);
            zid = z.getId();
        } catch (NoSuchZoneException ex6) {
        }

        final int surf = Server.surfaceMesh.getTile(tilex, tiley);
        final int cave = Server.caveMesh.getTile(tilex, tiley);
        final int rock = Server.rockMesh.getTile(tilex, tiley);
        final int caveCeil = Tiles.decodeData(cave);
        final String cavename = Tiles.getTile(Tiles.decodeType(cave)).tiledesc;
        if (performer.getPower() >= 4) {
            String msg = "ZoneId=" + zid + " Surface=" + Tiles.decodeHeight(surf) + ", rock=" + Tiles.decodeHeight(rock) + " cave=" + Tiles.decodeHeight(cave) + " ceiling=" + caveCeil;
            if (performer.getPower() >= 5) {
            }
            chat.sendNormalServerMessage("That tile is at " + tilex + ", " + tiley + ", you surfaced=" + performer.isOnSurface());
            return true;
        }
        return false;
    }
}

