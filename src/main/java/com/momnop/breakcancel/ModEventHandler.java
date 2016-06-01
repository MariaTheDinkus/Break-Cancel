package com.momnop.breakcancel;

import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEventHandler {
	
	@SubscribeEvent
	public void breakSpeedEvent(BreakSpeed event) {
		if (!event.getEntityPlayer().capabilities.isCreativeMode && ConfigHandler.canBreakBlocks == false) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void breakBlockEvent(BreakEvent event) {
		if (event.getPlayer().capabilities.isCreativeMode && ConfigHandler.canBreakBlocksAffectCreative == false) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void blockOutlineEvent(DrawBlockHighlightEvent event) {
		if (!event.getPlayer().capabilities.isCreativeMode && ConfigHandler.showBlockOutlines == false) {
			event.setCanceled(true);
		} else if (event.getPlayer().capabilities.isCreativeMode && ConfigHandler.showBlockOutlinesAffectCreative == false) {
			event.setCanceled(true);
		}
	}
}
