package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car audi;
    private Car ford;
    private Car bmw;

    @Before
    public void setup(){
        this.garage = new Garage();
        this.audi = new Car("Audi", 260, 60000);
        this.ford = new Car("Ford", 240, 35000);
        this.bmw = new Car("BMW", 250, 50000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarException(){
        garage.addCar(null);
    }

    @Test
    public void testAddCar(){
        garage.addCar(audi);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(ford);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test
    public void testGetCars(){
        garage.addCar(audi);
        garage.addCar(ford);
        Assert.assertEquals(audi.getBrand(), garage.getCars().get(0).getBrand());
        Assert.assertEquals(ford.getBrand(), garage.getCars().get(1).getBrand());
    }

    @Test
    public void testGetCount(){
        garage.addCar(audi);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(ford);
        Assert.assertEquals(2, garage.getCount());
        garage.addCar(bmw);
        Assert.assertEquals(3, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        garage.addCar(audi);
        garage.addCar(ford);
        garage.addCar(bmw);
        List<Car> maxSpeedCars = garage.findAllCarsWithMaxSpeedAbove(245);
        Assert.assertEquals(2, maxSpeedCars.size());
        Assert.assertEquals("Audi", maxSpeedCars.get(0).getBrand());
        Assert.assertEquals("BMW", maxSpeedCars.get(1).getBrand());
    }

    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(audi);
        garage.addCar(ford);
        garage.addCar(bmw);
        Assert.assertEquals("Audi", garage.getTheMostExpensiveCar().getBrand());
    }

    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(audi);
        garage.addCar(ford);
        garage.addCar(bmw);
        garage.addCar(ford);
        List<Car> allFords = garage.findAllCarsByBrand("Ford");
        Assert.assertEquals(2, allFords.size());
    }
}