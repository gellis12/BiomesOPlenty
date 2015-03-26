package biomesoplenty.common.biome.overworld;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.client.fog.IBiomeFog;
import biomesoplenty.common.biome.BOPOverworldBiome;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenBOPBigTree;
import biomesoplenty.common.world.features.trees.WorldGenOriginalTree;

public class BiomeGenSeasonalForest extends BOPOverworldBiome implements IBiomeFog
{
    private static final Height biomeHeight = new Height(0.7F, 1.4F);

    public BiomeGenSeasonalForest(int id)
    {
        super(id);

        this.setHeight(biomeHeight);
        this.setColor(12502092);
        this.setTemperatureRainfall(0.7F, 0.8F);

        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));

        this.theBiomeDecorator.treesPerChunk = 20;
        this.theBiomeDecorator.grassPerChunk = 8;
        this.theBiomeDecorator.flowersPerChunk = -999;

        this.theBiomeDecorator.bopFeatures.gravelPerChunk = 4;
        this.theBiomeDecorator.bopFeatures.toadstoolsPerChunk = 4;
        this.theBiomeDecorator.bopFeatures.shrubsPerChunk = 15;
        this.theBiomeDecorator.bopFeatures.waterReedsPerChunk = 4;
        this.theBiomeDecorator.bopFeatures.leafPilesPerChunk = 8;
        this.theBiomeDecorator.bopFeatures.deadLeafPilesPerChunk = 15;
        this.theBiomeDecorator.bopFeatures.algaePerChunk = 3;
        this.theBiomeDecorator.bopFeatures.flaxPerChunk = 1;

        this.theBiomeDecorator.bopFeatures.bopGrassPerChunk = 8;

        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPCBlocks.foliage, 10), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPCBlocks.foliage, 11), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 2), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 1), 1D);
    }

    @Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        return random.nextInt(2) == 0 ?  new WorldGenOriginalTree(Blocks.log2, BOPCBlocks.leaves2, 1, 3, false, 5, 3, false)
        : (random.nextInt(3) == 0 ? new WorldGenOriginalTree(Blocks.log, BOPCBlocks.leaves1, 2, 0, false, 5, 3, false) 
        : (random.nextInt(6) == 0 ? new WorldGenBOPBigTree(Blocks.log2, BOPCBlocks.leaves2, 1, 3)
        : (random.nextInt(6) == 0 ? new WorldGenBOPBigTree(Blocks.log, BOPCBlocks.leaves3, 0, 2)
        : (random.nextInt(3) == 0 ? new WorldGenOriginalTree(Blocks.log, BOPCBlocks.leaves3, 0, 2, false, 5, 3, false)
        : (random.nextInt(5) == 0 ? new WorldGenOriginalTree(Blocks.log, BOPCBlocks.leaves2, 0, 0, false, 5, 3, false)
        : (random.nextInt(6) == 0 ? worldGeneratorBigTree
                : worldGeneratorTrees))))));
    }

    @Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		super.decorate(world, random, chunkX, chunkZ);
		int var5 = 12 + random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(28) + 4;
			int z = chunkZ + random.nextInt(16);

			Block block = world.getBlock(x, y, z);

			if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
			{
				world.setBlock(x, y, z, BOPCBlocks.gemOre, 14, 2);
			}
		}
	}

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 11781186;
    }

    @Override
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        return 12502092;
        // return 12502595;
    }

    @Override
    public int getFogColour(int x, int y, int z)
    {
        return 16764548;
    }

    @Override
    public float getFogDensity(int x, int y, int z)
    {
        // TODO Auto-generated method stub
        return 1.0F;
    }
    
}
