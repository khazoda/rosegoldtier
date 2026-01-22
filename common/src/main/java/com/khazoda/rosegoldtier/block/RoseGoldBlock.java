package com.khazoda.rosegoldtier.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RoseGoldBlock extends Block {
  public RoseGoldBlock() {
    super(Properties.of().strength(3.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.METAL).requiresCorrectToolForDrops());
  }
}
