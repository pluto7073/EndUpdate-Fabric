package io.pluto.endupdate.features.end_spike;

import io.pluto.endupdate.EndUpdate;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

import java.util.List;
import java.util.Random;

public class EndSpikeGenerator {

    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
        pieces.add(new EndSpikePiece(manager, pos, getRandomSpike(), rotation));
    }

    public static Identifier getRandomSpike() {
        Random random = new Random();
        int i = random.nextInt(4);
        String id;
        if (i == 0) id = "end:end_spike/normal";
        else if (i == 1) id = "end:end_spike/tall_thin";
        else if (i == 2) id = "end:end_spike/short_wide";
        else id = "end:end_spike/dome";
        return new Identifier(id);
    }

    public static class EndSpikePiece extends SimpleStructurePiece {

        private final BlockRotation rotation;
        private final Identifier template;

        public EndSpikePiece(StructureManager structureManager, CompoundTag compoundTag) {
            super(EndUpdate.END_SPIKE_PIECE, compoundTag);
            this.template = new Identifier(compoundTag.getString("Template"));
            this.rotation = BlockRotation.NONE;
            this.initializeStructureData(structureManager);
        }

        public EndSpikePiece(StructureManager structureManager, BlockPos pos, Identifier template, BlockRotation rotation) {
            super(EndUpdate.END_SPIKE_PIECE, 0);
            this.pos = pos;
            this.rotation = rotation;
            this.template = template;

            this.initializeStructureData(structureManager);
        }

        private void initializeStructureData(StructureManager structureManager) {
            Structure structure = structureManager.getStructureOrBlank(this.template);
            StructurePlacementData placementData = (new StructurePlacementData())
                    .setRotation(this.rotation)
                    .setMirror(BlockMirror.NONE)
                    .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, placementData);
        }


        @Override
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random, BlockBox boundingBox) {

        }
    }


}
