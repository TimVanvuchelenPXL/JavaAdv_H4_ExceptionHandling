package be.pxl.ja.exercise;

public class Pet {

    public final static int MAX_ENERGY = 100;
    public final static int MIN_ENERGY = 0;
    private int energy;

    public Pet(int energy) {
        setEnergy(energy);
    }

    private void setEnergy(int energy) {
        this.energy = Math.max(MIN_ENERGY, Math.min(energy, MAX_ENERGY));
    }

    public int getEnergy() {
        return energy;
    }

    public void feed(String food) {
        if ("chocolate".equals(food)) {
            throw new WrongFoodException(("dog die"));
        }
        setEnergy(energy + 20);
    }

    public void play() throws PetTiredException {
        if (energy < 20) {
            throw new PetTiredException("dog fatiguée");
        }
        setEnergy(energy - 30);

    }

    @Override
    public String toString() {
        return "Pets energy is" + energy;
    }
}
