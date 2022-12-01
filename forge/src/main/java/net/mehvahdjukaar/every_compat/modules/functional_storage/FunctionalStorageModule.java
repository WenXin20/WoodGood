package net.mehvahdjukaar.every_compat.modules.functional_storage;

import com.buuz135.functionalstorage.FunctionalStorage;
import com.mcwpaths.kikoz.MacawsPaths;
import com.mcwpaths.kikoz.init.BlockInit;
import com.mcwpaths.kikoz.objects.FacingPathBlock;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;


public class FunctionalStorageModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> OAK_DRAWER;

    public FunctionalStorageModule(String modId) {
        super(modId, "fs");
        CreativeModeTab tab = FunctionalStorage.TAB;


        OAK_DRAWER = SimpleEntrySet.builder(WoodType.class, "1",
                        BlockInit.OAK_PLANKS_PATH, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new FacingPathBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("drawer"), Registry.ITEM_REGISTRY)
                .setRenderType(() -> RenderType::cutout)
                .setTab(() -> tab)
                .defaultRecipe()
                .addTexture(modRes("blocks/oak_planks_path"))
                .addModelTransform(m -> m.replaceGenericType("oak", "blocks"))
                .build();

        this.addEntry(OAK_DRAWER);
    }
}
