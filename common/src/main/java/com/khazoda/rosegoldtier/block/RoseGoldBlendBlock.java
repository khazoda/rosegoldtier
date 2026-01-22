package com.khazoda.rosegoldtier.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RoseGoldBlendBlock extends Block {
  public RoseGoldBlendBlock() {
    super(Properties.of().strength(2.5f).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops());
  }
}
