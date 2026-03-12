package com.khazoda.rosegoldtier.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SteelBlendBlock extends Block {
  public SteelBlendBlock() {
    super(Properties.of().strength(3f).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops());
  }
}
