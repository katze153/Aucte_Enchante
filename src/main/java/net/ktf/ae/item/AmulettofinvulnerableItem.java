
package net.ktf.ae.item;

import net.ktf.ae.procedures.AmulettofinvulnerableWhileBaubleIsEquippedTickProcedure;
import net.ktf.ae.procedures.LvlProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class AmulettofinvulnerableItem extends Item implements ICurioItem {
	public AmulettofinvulnerableItem() {
		super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal(""));
		list.add(Component.literal("max lvl = 4"));
		list.add(Component.literal("lvl 1 -> lvl 2 = 4 AP"));
        list.add(Component.literal("lvl 2 -> lvl 3 = 4 AP"));
        list.add(Component.literal("lvl 3 -> lvl 4 = 4 AP"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LvlProcedure.execute(itemstack);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
        AmulettofinvulnerableWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity(), stack);
	}



}
