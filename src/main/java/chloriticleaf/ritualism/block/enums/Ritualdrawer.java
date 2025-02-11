package chloriticleaf.ritualism.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum Ritualdrawer implements StringIdentifiable {
    CHALK("chalk"),
    GOLD("gold"),
    COPPER("copper"),
    AMETHYST("amethyst");

    private final String name;

    private Ritualdrawer(final String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
