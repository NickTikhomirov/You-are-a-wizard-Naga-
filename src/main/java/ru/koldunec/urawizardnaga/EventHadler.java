package ru.koldunec.urawizardnaga;

import net.daveyx0.primitivemobs.entity.monster.EntityEnchantedBook;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.SetMetadata;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import twilightforest.entity.EntityTFDeathTome;

import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber
public class EventHadler {

    @SubscribeEvent
    public static void lootInject(LootTableLoadEvent e){
        if(e.getName().equals(new ResourceLocation("twilightforest","structures/useless"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:magic_crystal"),
                            2,
                            0,
                            new LootFunction[]{
                                    new SetMetadata(new LootCondition[0],new RandomValueRange(1,7)),
                                    new SetCount(new LootCondition[0],new RandomValueRange(1))},
                            new LootCondition[0],
                            "ebob:crystal2"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:magic_crystal"),
                            2,
                            0,
                            new LootFunction[]{
                                    new SetMetadata(new LootCondition[0],new RandomValueRange(0)),
                                    new SetCount(new LootCondition[0],new RandomValueRange(5,7))},
                            new LootCondition[0],
                            "ebob:crystal"));
            return;
        }


        //-------------------------
        //--------- Lich ----------
        //-------------------------
        if(e.getName().equals(new ResourceLocation("twilightforest","entities/lich"))){
            e.getTable().addPool(
                    new LootPool(new LootEntry[]{
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_hat_necromancy"),1,0, new LootFunction[0],new LootCondition[0],"ebob:necrohat"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_robe_necromancy"),1,0, new LootFunction[0],new LootCondition[0],"ebob:necrobe"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_leggings_necromancy"),1,0, new LootFunction[0],new LootCondition[0],"ebob:necropants"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_boots_necromancy"),1,0, new LootFunction[0],new LootCondition[0],"ebob:necroboots"),
                    },new LootCondition[0], new RandomValueRange(1,2),new RandomValueRange(0,1),"ebob:armor"));
            e.getTable().addPool(getLootPool("lich","splels"));
            e.getTable().getPool("bones").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:firebomb"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(5,7))},new LootCondition[0],"ebob:bomb"));
            e.getTable().getPool("bones").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:grand_crystal"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(4,5))},new LootCondition[0],"ebob:grand"));
            e.getTable().addPool(new LootPool(new LootEntry[]{
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_conjurer"),3,0,new LootFunction[0],new LootCondition[0],"ebob:ring1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_siphoning"),3,0,new LootFunction[0],new LootCondition[0],"ebob:ring2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_extraction"),3,0,new LootFunction[0],new LootCondition[0],"ebob:ring3"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_paladin"),3,0,new LootFunction[0],new LootCondition[0],"ebob:ring4"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_leeching"),3,0,new LootFunction[0],new LootCondition[0],"ebob:ring5"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_warding"),2,0,new LootFunction[0],new LootCondition[0],"ebob:amulet1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_auto_shield"),2,0,new LootFunction[0],new LootCondition[0],"ebob:amulet2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_arcane_defence"),2,0,new LootFunction[0],new LootCondition[0],"ebob:amulet3"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_lich"),2,0,new LootFunction[0],new LootCondition[0],"ebob:amulet4"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:siphon_upgrade"),2,0,new LootFunction[0],new LootCondition[0],"ebob:up1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:melee_upgrade"),2,0,new LootFunction[0],new LootCondition[0],"ebob:up2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_minion_health"),2,0,new LootFunction[0],new LootCondition[0],"ebob:head")
            }, new LootCondition[0], new RandomValueRange(2,2), new RandomValueRange(0,0),"ebob:lichloot"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_room/common"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:magic_crystal"),
                            1,0,
                            new LootFunction[]{
                                    new SetMetadata(new LootCondition[0],new RandomValueRange(0,0)),
                                    new SetCount(new LootCondition[0],new RandomValueRange(5,7))}, new LootCondition[0],"ebob:crystals"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:firebomb"),
                            1,0,
                            new LootFunction[]{
                                    new SetCount(new LootCondition[0],new RandomValueRange(3,5))}, new LootCondition[0],"ebob:bomb"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_room/uncommon"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:grand_crystal"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(2,3))},new LootCondition[0],"ebob:grand"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_room/rare"))){
            e.getTable().addPool(new LootPool(new LootEntry[]{
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_auto_shield"),1,0,new LootFunction[0],new LootCondition[0],"ebob:amulet1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_warding"),1,0,new LootFunction[0],new LootCondition[0],"ebob:amulet2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_banishing"),2,0,new LootFunction[0],new LootCondition[0],"ebob:amulet3"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_conjurer"),1,0,new LootFunction[0],new LootCondition[0],"ebob:ring1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_hat_sorcery"),1,0,new LootFunction[0],new LootCondition[0],"ebob:hatsorc")
            }, new LootCondition[0], new RandomValueRange(1,2),new RandomValueRange(0,0), "ebob:rare"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_room/ultrarare"))){
            e.getTable().addPool(new LootPool(new LootEntry[]{
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:armour_upgrade"),1,0,new LootFunction[0],new LootCondition[0],"ebob:amulet1"),
                    }, new LootCondition[0], new RandomValueRange(1,2),new RandomValueRange(0,0), "ebob:urare"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_library/tower_library"))){
            e.getTable().addPool(getLootPool("lich_lib","splels"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_library/rare"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_wisdom"),3,0,new LootFunction[0],new LootCondition[0],"ebob:amulet1"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_conjurer"),1,0,new LootFunction[0],new LootCondition[0],"ebob:amulet2"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:attunement_upgrade"),2,0,new LootFunction[0],new LootCondition[0],"ebob:up1"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:arcane_tome"),3,0, new LootFunction[]{new SetMetadata(new LootCondition[0],new RandomValueRange(2))},new LootCondition[0],"ebob:tome"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_library/common"))){
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:identification_scroll"),3,0,
                    new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(1,2))},new LootCondition[0], "ebob:scroll"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tower_library/ultrarare"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_experience_tome"),4,0,new LootFunction[0],new LootCondition[0],"ebob:amulet1"));
            return;
        }


        //-------------------------
        //--------- Naga ----------
        //-------------------------
        if(e.getName().equals(new ResourceLocation("twilightforest","entities/naga"))){
            e.getTable().addPool(new LootPool(new LootEntry[]{
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:range_upgrade"),10,0,
                            new LootFunction[0],new LootCondition[0], "ebob:up1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:condenser_upgrade"),10,0,
                            new LootFunction[0],new LootCondition[0], "ebob:up2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:blast_upgrade"),10,0,
                            new LootFunction[0],new LootCondition[0], "ebob:up3"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_recovery"),5,0,
                            new LootFunction[0],new LootCondition[0], "ebob:amulet1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_battlemage"),5,0,
                            new LootFunction[0],new LootCondition[0], "ebob:ring1"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_growth"),10,0,
                            new LootFunction[0],new LootCondition[0], "ebob:ring2"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_abseiling"),5,0,
                            new LootFunction[0],new LootCondition[0], "ebob:ring3"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_poison"),7,0,
                            new LootFunction[0],new LootCondition[0], "ebob:ring4"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_robe_earth"),3,0,
                            new LootFunction[0],new LootCondition[0], "ebob:robe1"),
            }, new LootCondition[0], new RandomValueRange(2,3),new RandomValueRange(0,0), "ebob:ebob"));
            return;
        }


        //---------------------------
        //--------- Forest ----------
        //---------------------------
        if(e.getName().equals(new ResourceLocation("twilightforest","structures/hedge_maze/common"))){
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:poison_bomb"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(5,7))},new LootCondition[0],"ebob:bomb1"));
            e.getTable().getPool("main").addEntry(
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:smoke_bomb"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(5,7))},new LootCondition[0],"ebob:bomb2"));
            return;
        }


        if(e.getName().equals(new ResourceLocation("twilightforest","structures/hedge_maze/rare"))){
            e.getTable().addPool(getLootPool("hedge","splels"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("wizard_leggings_earth"),2,0,new LootFunction[0],new LootCondition[0],"ebob:epants"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("wizard_robes_earth"),1,0,new LootFunction[0],new LootCondition[0],"ebob:erobe"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:arcane_tome"),1,0,new LootFunction[]{new SetMetadata(new LootCondition[0],new RandomValueRange(1,2))},new LootCondition[0],"ebob:tome"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_abseiling"),1,0, new LootFunction[0],new LootCondition[0], "ebob:ring"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_light"),1,0, new LootFunction[0],new LootCondition[0], "ebob:ring2"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/hedge_maze/ultrarare"))){
            e.getTable().addPool(getLootPool("hedge2","splels"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("wizard_leggings_earth"),2,0,new LootFunction[0],new LootCondition[0],"ebob:epants"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("wizard_robes_earth"),1,0,new LootFunction[0],new LootCondition[0],"ebob:erobe"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:arcane_tome"),1,0,new LootFunction[]{new SetMetadata(new LootCondition[0],new RandomValueRange(1))},new LootCondition[0],"ebob:tome"));
            e.getTable().addPool(new LootPool(new LootEntry[]{
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_hat_healing"),1,0, new LootFunction[0],new LootCondition[0],"ebob:healhat"),
                    new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_boots_healing"),1,0, new LootFunction[0],new LootCondition[0],"ebob:healboot"),
            },new LootCondition[0], new RandomValueRange(1,1),new RandomValueRange(0),"ebob:armor"));

            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/hedge_maze/uncommon"))){
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:grand_crystal"),1,0,new LootFunction[]{new SetCount(new LootCondition[0],new RandomValueRange(3,4))},new LootCondition[0],"ebob:grand"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tree_cache/rare"))){
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_storm"),100,0,new LootFunction[0],new LootCondition[0],"ebob:charm1"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:charm_silk_touch"),100,0,new LootFunction[0],new LootCondition[0],"ebob:charm2"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_glide"),100,0,new LootFunction[0],new LootCondition[0],"ebob:charm3"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_glide"),100,0,new LootFunction[0],new LootCondition[0],"ebob:charm4"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_wisdom"),33,0,new LootFunction[0],new LootCondition[0],"ebob:charm5"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_mana_return"),75,0,new LootFunction[0],new LootCondition[0],"ebob:charm6"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:attunement_upgrade"),33,0,new LootFunction[0],new LootCondition[0],"ebob:up1"));
            e.getTable().getPool("main").addEntry(new LootEntryItem(Item.getByNameOrId("ebwizardry:armour_upgrade"),66,0,new LootFunction[0],new LootCondition[0],"ebob:up2"));
            e.getTable().addPool(getLootPool("tree","ebob:magik"));
            return;
        }
        if(e.getName().equals(new ResourceLocation("twilightforest","structures/tree_cache/ultrarare"))){
            e.getTable().addPool(getLootPool("tree2","ebob:magik"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","entities/questing_ram_rewards"))){
            e.getTable().addPool(getLootPool("ram_add","ebob:magik"));
            return;
        }



        //-------------------------
        //--------- MINO ----------
        //-------------------------

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/labyrinth_vault/rare"))){
            e.getTable().addPool(getLootPool("labyrinth_secret","ebob:magik"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/labyrinth_room/rare")) ||
              e.getName().equals(new ResourceLocation("twilightforest","structures/labyrinth_dead_end/rare"))){
            e.getTable().addPool(getLootPool("mino_room","ebob:magik"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","entities/minoshroom"))){
            e.getTable().addPool(getLootPool("mino","ebob:magik"));
            return;
        }



        //--------------------------
        //--------- Hydra ----------
        //--------------------------
        if(e.getName().equals(new ResourceLocation("twilightforest","entities/hydra"))){
            e.getTable().addPool(
                    new LootPool(new LootEntry[]{
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_disintegration"),10,0, new LootFunction[0],new LootCondition[0],"ebob:ring1"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_combustion"),10,0, new LootFunction[0],new LootCondition[0],"ebob:ring2"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_fire_melee"),10,0, new LootFunction[0],new LootCondition[0],"ebob:ring3"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_fire_protection"),10,0, new LootFunction[0],new LootCondition[0],"ebob:ring4"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:ring_fire_biome"),10,0, new LootFunction[0],new LootCondition[0],"ebob:ring5"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_robe_fire"),15,0, new LootFunction[0],new LootCondition[0],"ebob:robe"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:wizard_leggings_fire"),15,0, new LootFunction[0],new LootCondition[0],"ebob:leggings"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:arcane_tome"),7,0,new LootFunction[]{new SetMetadata(new LootCondition[0],new RandomValueRange(2))},new LootCondition[0],"ebob:tome"),
                            new LootEntryItem(Item.getByNameOrId("ebwizardry:amulet_recovery"),5,0, new LootFunction[0],new LootCondition[0], "ebob:amulet1"),
                    },new LootCondition[0], new RandomValueRange(2,3),new RandomValueRange(0),"ebob:magik"));
            e.getTable().addPool(getLootPool("hydra","majik"));
            return;
        }


        //--------------------------
        //--------- GHAST ----------
        //--------------------------
        if(e.getName().equals(new ResourceLocation("twilightforest","structures/darktower_boss/rare"))){
            e.getTable().addPool(getLootPool("ghast","ebob:bobeb"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/darktower_cache/rare"))){
            e.getTable().addPool(getLootPool("ghast_c","ebob:bobeb"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/darktower_key/rare"))){
            e.getTable().addPool(getLootPool("ghast_k","ebob:bobeb"));
            return;
        }


        //----------------------------
        //--------- KNIGHTS ----------
        //----------------------------

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/stronghold_boss/stronghold_boss"))){
            e.getTable().addPool(getLootPool("knight","ebob:bobeb"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/stronghold_cache/stronghold_cache"))){
            e.getTable().addPool(getLootPool("knight_lair","ebob:bobeb"));
            return;
        }

        if(e.getName().equals(new ResourceLocation("twilightforest","structures/stronghold_room/stronghold_room"))){
            e.getTable().addPool(getLootPool("knight_lair","ebob:bobeb"));
            return;
        }

    }




    @SubscribeEvent
    public void bookDrop(LivingDropsEvent e){
        if(net.minecraftforge.fml.common.Loader.isModLoaded("primitivemobs")
            && e.getEntityLiving().getClass().equals(EntityEnchantedBook.class)){
            if(urawizardnaga.random.nextInt(5)==0){
                e.getDrops().clear();
                LootEntryTable a = openTable("book2");
                List<ItemStack> b = new ArrayList<ItemStack>();
                List<EntityItem> c = e.getDrops();
                a.addLoot(b,urawizardnaga.random,new LootContext(0, (WorldServer) e.getEntity().world, new LootTableManager(null),e.getEntityLiving(),null,null));
                for(ItemStack i: b){
                    c.add(new EntityItem(e.getEntity().world,e.getEntity().posX,e.getEntity().posY,e.getEntity().posZ,i));
                }
            }
        } else if(e.getEntityLiving().getClass().equals(EntityTFDeathTome.class)){
            if(urawizardnaga.random.nextInt(3)==0){
                e.getDrops().clear();
                LootEntryTable a = openTable("book");
                List<ItemStack> b = new ArrayList<ItemStack>();
                List<EntityItem> c = e.getDrops();
                a.addLoot(b,urawizardnaga.random,new LootContext(0, (WorldServer) e.getEntity().world, new LootTableManager(null),e.getEntityLiving(),null,null));
                for(ItemStack i: b){
                    c.add(new EntityItem(e.getEntity().world,e.getEntity().posX,e.getEntity().posY,e.getEntity().posZ,i));
                }
            }
        }
    }

    private static LootPool getLootPool(String tablename, String poolname){
        return new LootPool(new LootEntry[]{openTable(tablename)}, new LootCondition[0],new RandomValueRange(1), new RandomValueRange(0), poolname);
    }

    private static LootEntryTable openTable(String r){
        return (new LootEntryTable(new ResourceLocation(urawizardnaga.MODID,r),1,0,new LootCondition[0],r));
    }
}
