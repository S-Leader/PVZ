package keletu.pvzmod.penny;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class PennyTradeOffers {
    public static final int OFFER_COUNT = 6;

    private static final List<Entry> CARD_POOL = List.of(
            new Entry(PVZItems.SUN_FLOWER_CARD, 2, 1, TradeKind.CARD),
            new Entry(PVZItems.PEASHOOTER_CARD, 2, 1, TradeKind.CARD),
            new Entry(PVZItems.PUFF_SHROOM_CARD, 2, 1, TradeKind.CARD),
            new Entry(PVZItems.WALNUT_CARD, 3, 1, TradeKind.CARD),
            new Entry(PVZItems.SNOWPEA_CARD, 4, 1, TradeKind.CARD),
            new Entry(PVZItems.REPEATER_CARD, 4, 1, TradeKind.CARD),
            new Entry(PVZItems.POTATO_MINE_CARD, 4, 1, TradeKind.CARD),
            new Entry(PVZItems.SCAREDY_SHROOM_CARD, 5, 1, TradeKind.CARD),
            new Entry(PVZItems.FUME_SHROOM_CARD, 5, 1, TradeKind.CARD),
            new Entry(PVZItems.GATLING_PEA_CARD, 8, 1, TradeKind.CARD),
            new Entry(PVZItems.PUMPKIN_CARD, 8, 1, TradeKind.CARD),
            new Entry(PVZItems.PRIMAL_PEASHOOTER_CARD, 10, 1, TradeKind.CARD),
            new Entry(PVZItems.ELECTRIC_PEASHOOTER_CARD, 10, 1, TradeKind.CARD),
            new Entry(PVZItems.TALL_NUT_CARD, 10, 1, TradeKind.CARD),
            new Entry(PVZItems.SUPER_GATLING_PEA_CARD, 16, 1, TradeKind.CARD)
    );

    private static final List<Entry> TOOL_POOL = List.of(
            new Entry(PVZItems.GARDEN_SHOVEL, 6, 1, TradeKind.TOOL),
            new Entry(PVZItems.PLANT_KEY, 3, 1, TradeKind.TOOL)
    );

    private static final List<Entry> BOX_POOL = List.of(
            new Entry(PVZItems.PLANT_BOX, 10, 1, TradeKind.BOX),
            new Entry(PVZItems.CARTON, 2, 4, TradeKind.BOX)
    );

    private static final List<Entry> MATERIAL_POOL = List.of(
            new Entry(PVZItems.PEA, 1, 8, TradeKind.MATERIAL),
            new Entry(PVZItems.SUN, 1, 16, TradeKind.MATERIAL),
            new Entry(PVZItems.POT, 2, 2, TradeKind.MATERIAL),
            new Entry(PVZItems.SOFA, 4, 1, TradeKind.MATERIAL)
    );

    private static final List<TradeKind> KIND_TEMPLATE = List.of(
            TradeKind.CARD,
            TradeKind.CARD,
            TradeKind.TOOL,
            TradeKind.BOX,
            TradeKind.MATERIAL,
            TradeKind.MATERIAL
    );

    private PennyTradeOffers() {
    }

    public static List<PennyTradeOffer> roll(RandomSource random) {
        return roll(random, List.of());
    }

    public static List<PennyTradeOffer> roll(RandomSource random, List<PennyTradeOffer> previousOffers) {
        List<TradeKind> layout = buildLayout(random, previousOffers);
        List<Entry> cards = new ArrayList<>(CARD_POOL);
        List<Entry> tools = new ArrayList<>(TOOL_POOL);
        List<Entry> boxes = new ArrayList<>(BOX_POOL);
        List<Entry> materials = new ArrayList<>(MATERIAL_POOL);
        List<PennyTradeOffer> offers = new ArrayList<>();

        for (int slot = 0; slot < OFFER_COUNT; slot++) {
            TradeKind kind = layout.get(slot);
            List<Entry> pool = poolForKind(kind, cards, tools, boxes, materials);
            Entry chosen = pickEntry(pool, random, previousOffers, slot);
            offers.add(new PennyTradeOffer(new ItemStack(chosen.item().get(), chosen.count()), chosen.price()));
        }

        return offers;
    }

    private static List<TradeKind> buildLayout(RandomSource random, List<PennyTradeOffer> previousOffers) {
        List<TradeKind> best = new ArrayList<>(KIND_TEMPLATE);
        int bestConflicts = Integer.MAX_VALUE;

        for (int attempt = 0; attempt < 80; attempt++) {
            List<TradeKind> candidate = new ArrayList<>(KIND_TEMPLATE);
            shuffleKinds(candidate, random);
            int conflicts = countKindConflicts(candidate, previousOffers);
            if (conflicts == 0) {
                return candidate;
            }
            if (conflicts < bestConflicts) {
                bestConflicts = conflicts;
                best = candidate;
            }
        }

        return best;
    }

    private static void shuffleKinds(List<TradeKind> kinds, RandomSource random) {
        for (int i = kinds.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            TradeKind kind = kinds.get(i);
            kinds.set(i, kinds.get(j));
            kinds.set(j, kind);
        }
    }

    private static int countKindConflicts(List<TradeKind> candidate, List<PennyTradeOffer> previousOffers) {
        int conflicts = 0;
        for (int slot = 0; slot < OFFER_COUNT && slot < previousOffers.size(); slot++) {
            TradeKind oldKind = kindOf(previousOffers.get(slot).stack());
            if (oldKind != null && candidate.get(slot) == oldKind) {
                conflicts++;
            }
        }
        return conflicts;
    }

    private static Entry pickEntry(List<Entry> pool, RandomSource random, List<PennyTradeOffer> previousOffers, int slot) {
        if (pool.isEmpty()) {
            throw new IllegalStateException("Penny trade pool is empty");
        }

        ItemStack previousStack = slot < previousOffers.size() ? previousOffers.get(slot).stack() : ItemStack.EMPTY;
        List<Entry> filtered = new ArrayList<>();
        for (Entry entry : pool) {
            if (previousStack.isEmpty() || !previousStack.is(entry.item().get())) {
                filtered.add(entry);
            }
        }

        List<Entry> choices = filtered.isEmpty() ? pool : filtered;
        Entry chosen = choices.get(random.nextInt(choices.size()));
        pool.remove(chosen);
        return chosen;
    }

    private static List<Entry> poolForKind(TradeKind kind, List<Entry> cards, List<Entry> tools, List<Entry> boxes, List<Entry> materials) {
        return switch (kind) {
            case CARD -> cards;
            case TOOL -> tools;
            case BOX -> boxes;
            case MATERIAL -> materials;
        };
    }

    private static TradeKind kindOf(ItemStack stack) {
        if (stack.isEmpty()) {
            return null;
        }

        for (Entry entry : CARD_POOL) {
            if (stack.is(entry.item().get())) {
                return TradeKind.CARD;
            }
        }
        for (Entry entry : TOOL_POOL) {
            if (stack.is(entry.item().get())) {
                return TradeKind.TOOL;
            }
        }
        for (Entry entry : BOX_POOL) {
            if (stack.is(entry.item().get())) {
                return TradeKind.BOX;
            }
        }
        for (Entry entry : MATERIAL_POOL) {
            if (stack.is(entry.item().get())) {
                return TradeKind.MATERIAL;
            }
        }
        return null;
    }

    private enum TradeKind {
        CARD,
        TOOL,
        BOX,
        MATERIAL
    }

    private record Entry(Supplier<? extends Item> item, int price, int count, TradeKind kind) {
    }
}
