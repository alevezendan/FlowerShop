package builder;

import entity.Flower;
import entity.FlowerShop;

public class FBulider implements  FlowerBuilder{
    private Flower flower;
    public FBulider(){
        this.flower=new Flower();
    }

    @Override
    public void buildId(int id) {
        flower.setId(id);
    }

    @Override
    public void buildName(String name) {
        flower.setName(name);
    }

    @Override
    public void buildPrice(double price) {
        flower.setPrice(price);
    }

    @Override
    public void buildColor(String color) {
        flower.setColor(color);
    }

    @Override
    public void buildAvailability(String avail) {
            flower.setAvailability(avail);
    }

    @Override
    public void buildQuantity(double quant) {
            flower.setQuantity(quant);
    }

    @Override
    public void buildFlowerShop(FlowerShop flowerShop) {
            flower.setFlowerShop(flowerShop);
    }

    @Override
    public Flower getFlower() {
        return this.flower;
    }
}
