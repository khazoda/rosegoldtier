package com.khazoda.rosegoldtier.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class RoseGoldPressurePlate extends BasePressurePlateBlock {
  public static final MapCodec<RoseGoldPressurePlate> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter((pressurePlateBlock) -> pressurePlateBlock.type), propertiesCodec()).apply(instance, RoseGoldPressurePlate::new));
  public static final BooleanProperty POWERED;

  public RoseGoldPressurePlate(BlockSetType type, BlockBehaviour.Properties properties) {
    super(properties, type);
    this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
  }

  public RoseGoldPressurePlate() {
    this(BlockSetType.IRON, Properties.of().mapColor(MapColor.COLOR_RED).strength(0.5F).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.METAL));
  }

  @Override
  protected MapCodec<? extends BasePressurePlateBlock> codec() {
    return CODEC;
  }

  protected int getSignalForState(BlockState state) {
    return state.getValue(POWERED) ? 15 : 0;
  }

  protected BlockState setSignalForState(BlockState state, int signal) {
    return state.setValue(POWERED, signal > 0);
  }

  protected int getSignalStrength(Level level, BlockPos pos) {
    Class<? extends Entity> s;
    switch (this.type.pressurePlateSensitivity()) {
      case EVERYTHING -> s = Entity.class;
      case MOBS -> s = LivingEntity.class;
      default -> throw new MatchException(null, null);
    }

    Class<? extends Entity> class_ = s;
    return getEntityCount(level, TOUCH_AABB.move(pos), class_) > 0 ? 15 : 0;
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(POWERED);
  }

  static {
    POWERED = BlockStateProperties.POWERED;
  }
}
