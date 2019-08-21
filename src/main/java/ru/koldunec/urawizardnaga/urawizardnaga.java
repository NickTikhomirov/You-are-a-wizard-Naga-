package ru.koldunec.urawizardnaga;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = urawizardnaga.MODID, name = urawizardnaga.NAME, version = urawizardnaga.VERSION, dependencies =
        "required-after:twilightforest; "+
        "required-after:ebwizardry")
public class urawizardnaga
{
    public static final String MODID = "urawizardnaga";
    public static final String NAME = "You are a wizard, Naga";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "ru.koldunec.urawizardnaga.ClientProxy", serverSide = "ru.koldunec.urawizardnaga.CommonProxy")
    public static CommonProxy proxy;
    public static Random random = new Random();

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
