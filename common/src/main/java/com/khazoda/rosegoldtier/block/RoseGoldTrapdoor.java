package com.khazoda.rosegoldtier.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RoseGoldTrapdoor extends TrapDoorBlock {
  public RoseGoldTrapdoor() {
    super(BlockSetType.IRON, Properties.of().strength(3.5f).instrument(NoteBlockInstrument.IRON_XYLOPHONE).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion());
  }
}
