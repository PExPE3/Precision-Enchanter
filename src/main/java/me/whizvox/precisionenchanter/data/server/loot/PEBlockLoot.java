package me.whizvox.precisionenchanter.data.server.loot;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import me.whizvox.precisionenchanter.common.PrecisionEnchanter;
import me.whizvox.precisionenchanter.common.registry.PEBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;

public class PEBlockLoot extends BlockLootSubProvider {

  private final List<Block> knownBlocks;

  protected PEBlockLoot() {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    knownBlocks = new ObjectArrayList<>();
    ForgeRegistries.BLOCKS.getKeys().stream()
        .filter(loc -> loc.getNamespace().equals(PrecisionEnchanter.MOD_ID))
        .map(ForgeRegistries.BLOCKS::getValue)
        .forEach(knownBlocks::add);
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return knownBlocks;
  }

  @Override
  protected void generate() {
    dropSelf(PEBlocks.ENCHANTERS_WORKBENCH.get());
    dropSelf(PEBlocks.PRECISION_GRINDSTONE.get());
  }

}
