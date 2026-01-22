package com.khazoda.rosegoldtier.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class RoseGoldDoor extends DoorBlock {
  public RoseGoldDoor() {
    super(BlockSetType.IRON, Properties.of().strength(5.5f).noOcclusion()
        .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
        .pushReaction(PushReaction.DESTROY)
        .mapColor(MapColor.COLOR_RED)
        .sound(SoundType.METAL)
        .requiresCorrectToolForDrops());
  }
}
