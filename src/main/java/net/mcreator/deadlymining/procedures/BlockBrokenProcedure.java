package net.mcreator.deadlymining.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.Difficulty;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.item.FlamingPickaxeItem;
import net.mcreator.deadlymining.enchantment.SuperHeatingEnchantment;
import net.mcreator.deadlymining.enchantment.SuperCoolingEnchantment;
import net.mcreator.deadlymining.enchantment.HeatingEnchantment;
import net.mcreator.deadlymining.enchantment.CoolingEnchantment;
import net.mcreator.deadlymining.block.FlamingOreBlock;
import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;
import java.util.HashMap;

@DeadlyminingModElements.ModElement.Tag
public class BlockBrokenProcedure extends DeadlyminingModElements.ModElement {
	public BlockBrokenProcedure(DeadlyminingModElements instance) {
		super(instance, 26);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BlockBroken!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BlockBroken!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double explodsionSize = 0;
		double offset = 0;
		offset = (double) 1;
		if ((((EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 0) && (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))))) {
			if ((world.getDifficulty() == Difficulty.PEACEFUL)) {
				explodsionSize = (double) 0;
				offset = (double) ((offset) * 0);
			} else if ((world.getDifficulty() == Difficulty.EASY)) {
				explodsionSize = (double) 2;
				offset = (double) ((offset) * 0.33);
			} else if ((world.getDifficulty() == Difficulty.NORMAL)) {
				explodsionSize = (double) 4;
			} else {
				explodsionSize = (double) 8;
				offset = (double) ((offset) * 3);
			}
			if ((new ItemStack(FlamingPickaxeItem.block, (int) (1))
					.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
				offset = (double) ((offset) * 3);
				explodsionSize = (double) ((explodsionSize) * 1.25);
			}
			if (((world.getDimension().getType().getId()) == 0)) {
				offset = (double) ((offset) * 1);
			} else if (((world.getDimension().getType().getId()) == (-1))) {
				offset = (double) ((offset) * 2.5);
				explodsionSize = (double) ((explodsionSize) * 1.25);
			} else {
				offset = (double) ((offset) * 2);
			}
			if ((1 <= (EnchantmentHelper.getEnchantmentLevel(HeatingEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
				offset = (double) ((offset) * (((EnchantmentHelper.getEnchantmentLevel(HeatingEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 0.5) + 1));
				explodsionSize = (double) ((explodsionSize) * (((EnchantmentHelper.getEnchantmentLevel(HeatingEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 0.05) + 1));
			}
			if ((1 <= (EnchantmentHelper.getEnchantmentLevel(CoolingEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
				offset = (double) ((offset) * (((EnchantmentHelper.getEnchantmentLevel(HeatingEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) / 0.05) + 1));
				explodsionSize = (double) ((explodsionSize) * (((EnchantmentHelper.getEnchantmentLevel(HeatingEnchantment.enchantment,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) / 0.025) + 1));
			}
			if ((1 <= (EnchantmentHelper.getEnchantmentLevel(SuperHeatingEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
				offset = (double) ((offset) * 1.5);
				explodsionSize = (double) ((explodsionSize) * 2.5);
			}
			if ((1 <= (EnchantmentHelper.getEnchantmentLevel(SuperCoolingEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
				offset = (double) ((offset) * 0.5);
				explodsionSize = (double) ((explodsionSize) * 0.25);
			}
			if ((Blocks.COAL_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if (((Math.random() <= (0.01 * (offset))) && (Math.random() <= (0.5 * (offset))))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((Blocks.IRON_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if ((Math.random() <= (0.01 * (offset)))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((Blocks.GOLD_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if (((Math.random() <= (0.3 * (offset))) && (Math.random() <= (0.05 * (offset))))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if (((Blocks.REDSTONE_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())
					|| (Blocks.REDSTONE_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
							.getBlock()))) {
				if (((Math.random() <= (0.5 * (offset))) && (Math.random() <= (0.05 * (offset))))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((Blocks.LAPIS_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if ((Math.random() <= (0.04 * (offset)))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((Blocks.EMERALD_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				for (int index0 = 0; index0 < (int) (Math.round(((Math.random() * 2) + 6))); index0++) {
					if ((Math.random() >= 0.5)) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"summon minecraft:slime ~ ~ ~ {Size:1}");
						}
					} else {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"summon minecraft:slime ~ ~ ~ {Size:0}");
						}
					}
				}
				for (int index1 = 0; index1 < (int) (Math.round(((Math.random() * 2) + 2))); index1++) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.EMERALD, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((Blocks.DIAMOND_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if ((Math.random() <= (0.05 * (offset)))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
					.getBlock())) {
				if ((Math.random() <= (0.01 * (offset)))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
			if ((FlamingOreBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())) {
				if (((Math.random() <= (0.5 * (offset))) && (Math.random() <= (0.05 * (offset))))) {
					if (world instanceof World && !world.getWorld().isRemote) {
						world.getWorld().createExplosion(null, (int) (x + 1), (int) (y + 1), (int) (z + 1), (float) (explodsionSize),
								Explosion.Mode.BREAK);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", (int) event.getPos().getX());
		dependencies.put("y", (int) event.getPos().getY());
		dependencies.put("z", (int) event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", event.getWorld().getWorld());
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
