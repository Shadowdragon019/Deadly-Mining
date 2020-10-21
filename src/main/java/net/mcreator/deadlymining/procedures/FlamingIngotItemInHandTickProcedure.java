package net.mcreator.deadlymining.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;
import java.util.Collection;

@DeadlyminingModElements.ModElement.Tag
public class FlamingIngotItemInHandTickProcedure extends DeadlyminingModElements.ModElement {
	public FlamingIngotItemInHandTickProcedure(DeadlyminingModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlamingIngotItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.FIRE_RESISTANCE)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity)))) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 1);
		}
	}
}
