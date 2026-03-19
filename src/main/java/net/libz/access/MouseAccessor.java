package net.libz.access;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public interface MouseAccessor {

    public void libZ_Rework_1_21_11$setMousePosition(int x, int y);

}
