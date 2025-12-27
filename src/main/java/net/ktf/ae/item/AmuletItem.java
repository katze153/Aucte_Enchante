
package net.ktf.ae.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.ktf.ae.procedures.LvlProcedure;
import net.ktf.ae.procedures.AmuletWhileBaubleIsEquippedTickProcedure;
import net.ktf.ae.procedures.AmuletBaubleIsUnequippedProcedure;

import java.util.List;

public class AmuletItem extends Item implements ICurioItem {
	public AmuletItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal(""));
		list.add(Component.literal("max lvl = 5"));
		list.add(Component.literal("lvl 1 -> lvl 2 = 2 AP"));
		list.add(Component.literal("lvl 2 -> lvl 3 = 3 AP"));
		list.add(Component.literal("lvl 3 -> lvl 4 = 4 AP"));
		list.add(Component.literal("lvl 4 -> lvl 5 = 5 AP"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LvlProcedure.execute(itemstack);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		AmuletWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		AmuletBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
