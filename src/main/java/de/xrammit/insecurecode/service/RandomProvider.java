package de.xrammit.insecurecode.service;

import java.util.Random;

public final class RandomProvider {
    private Random random;

    RandomProvider() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(1_000_000);
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
