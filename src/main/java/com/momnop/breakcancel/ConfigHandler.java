package com.momnop.breakcancel;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConfigHandler
{
    public static Configuration configuration;
    public static boolean canBreakBlocks = false;
    public static boolean canBreakBlocksAffectCreative = true;
    public static boolean showBlockOutlines = false;
    public static boolean showBlockOutlinesAffectCreative = true;
    
    public static void init(File file)
    {
        if (configuration == null)
        {
            configuration = new Configuration(file);
            loadConfiguration();
        }
    }
    
    public static void loadConfiguration()
    {	
    	canBreakBlocks = configuration.getBoolean(ConfigInfo.CAN_BREAK_BLOCKS_NAME, Configuration.CATEGORY_GENERAL, canBreakBlocks, ConfigInfo.CAN_BREAK_BLOCKS_DESC);
    	canBreakBlocksAffectCreative = configuration.getBoolean(ConfigInfo.CAN_BREAK_BLOCKS_AFFECT_CREATIVE_NAME, Configuration.CATEGORY_GENERAL, canBreakBlocksAffectCreative, ConfigInfo.CAN_BREAK_BLOCKS_AFFECT_CREATIVE_DESC);
    	showBlockOutlines = configuration.getBoolean(ConfigInfo.SHOW_BLOCK_OUTLINES_NAME, Configuration.CATEGORY_GENERAL, showBlockOutlines, ConfigInfo.SHOW_BLOCK_OUTLINES_DESC);
    	showBlockOutlinesAffectCreative = configuration.getBoolean(ConfigInfo.SHOW_BLOCK_OUTLINES_AFFECT_CREATIVE_NAME, Configuration.CATEGORY_GENERAL, showBlockOutlinesAffectCreative, ConfigInfo.SHOW_BLOCK_OUTLINES_AFFECT_CREATIVE_DESC);
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase("breakcancel"))
        {
            loadConfiguration();
        }
    }
}