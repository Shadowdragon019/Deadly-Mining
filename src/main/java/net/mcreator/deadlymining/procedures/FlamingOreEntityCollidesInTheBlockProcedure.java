package net.mcreator.deadlymining.procedures;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;
import java.util.Collection;

@DeadlyminingModElements.ModElement.Tag
public class FlamingOreEntityCollidesInTheBlockProcedure extends DeadlyminingModElements.ModElement {
	public FlamingOreEntityCollidesInTheBlockProcedure(DeadlyminingModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlamingOreEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotionMultiplier(null, new Vec3d(0.25D, (double) 0.05F, 0.25D));
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
			if ((!(entity instanceof ItemEntity))) {
				entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 1);
			}
		}
	}
}
