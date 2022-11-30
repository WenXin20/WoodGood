package net.mehvahdjukaar.every_compat.modules.infinity_buttons;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.larsmans.infinitybuttons.block.InfinityButtonsBlocks;
import net.larsmans.infinitybuttons.block.custom.largebutton.WoodenLargeButton;
import net.larsmans.infinitybuttons.block.custom.secretbutton.PlankSecretButton;
import net.larsmans.infinitybuttons.item.InfinityButtonsItemGroup;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.every_compat.modules.farmersdelight.FarmersDelightModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;


public class InfinityButtonsModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> LARGE_BUTTONS;
    public final SimpleEntrySet<WoodType, Block> SECRET_BUTTONS;

    public InfinityButtonsModule(String modId) {
        super(modId, "infb");
        CreativeModeTab tab = InfinityButtonsItemGroup.INFINITYBUTTONS;


        LARGE_BUTTONS = SimpleEntrySet.builder(WoodType.class, "large_button",
                        () -> InfinityButtonsBlocks.OAK_LARGE_BUTTON, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new WoodenLargeButton((FabricBlockSettings) Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(BlockTags.WOODEN_BUTTONS, Registry.BLOCK_REGISTRY)
                .addTag(BlockTags.WOODEN_BUTTONS, Registry.ITEM_REGISTRY)
                .setTab(() -> tab)
                .defaultRecipe()
                .build();

        this.addEntry(LARGE_BUTTONS);

        SECRET_BUTTONS = SimpleEntrySet.builder(WoodType.class, "plank_secret_button",
                        () -> InfinityButtonsBlocks.OAK_PLANK_SECRET_BUTTON, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new PlankSecretButton(Utils.copyPropertySafe(w.planks)))
                .addTag(modRes("secret_buttons"), Registry.BLOCK_REGISTRY)
                .addTag(modRes("secret_buttons"), Registry.ITEM_REGISTRY)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(BlockTags.WOODEN_BUTTONS, Registry.BLOCK_REGISTRY)
                .addTag(BlockTags.WOODEN_BUTTONS, Registry.ITEM_REGISTRY)
                .addModelTransform(m -> m.replaceOakPlanks())
                .setTab(() -> tab)
                .defaultRecipe()
                .build();

        this.addEntry(SECRET_BUTTONS);
    }
}
