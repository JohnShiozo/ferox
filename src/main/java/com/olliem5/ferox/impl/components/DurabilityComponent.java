package com.olliem5.ferox.impl.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.olliem5.ferox.api.component.Component;
import com.olliem5.ferox.api.component.FeroxComponent;
import com.olliem5.ferox.api.setting.Setting;
import com.olliem5.ferox.api.util.render.font.FontUtil;

/**
 * @author Manesko
 * @author olliem5
 */

@FeroxComponent(name = "Durability",description = "Shows the durability of the item you have in your hand on screen")
public class DurabilityComponent extends Component {
    public static final Setting<DurabilityModes> durabilitymode = new Setting<>("Mode","Mode", DurabilityModes.Normal);

    public DurabilityComponent() {
        this.addSettings(
                durabilitymode
        );
    }

    private int durability;

    @Override
    public void render() {
        String renderString;

        int maxDurability = mc.player.getHeldItemMainhand().getMaxDamage();
        this.durability = maxDurability - mc.player.getHeldItemMainhand().getItemDamage();

        switch (durabilitymode.getValue()) {
            case Normal:
                renderString = "Durability " + ChatFormatting.WHITE + this.durability;
                this.setWidth((int) FontUtil.getStringWidth(renderString));
                this.setHeight((int) FontUtil.getStringHeight(renderString));
                drawString(renderString);
                break;
            case OnlyNumber:
                renderString = "" + ChatFormatting.WHITE + this.durability;
                this.setWidth((int) FontUtil.getStringWidth(renderString));
                this.setHeight((int) FontUtil.getStringHeight(renderString));
                drawString(renderString);
                break;
        }
    }

    public enum DurabilityModes {
        Normal,
        OnlyNumber
    }
}
