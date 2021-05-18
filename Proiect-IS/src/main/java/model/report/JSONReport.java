package model.report;


import model.entity.Flower;
import model.entity.FlowerShop;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONReport extends Report{

    @Override
    public void generateReport(FlowerShop flowerShop) {
        JSONArray flowerList = new JSONArray();
        for (Flower fl : flowerShop.getFlowers()) {
            JSONObject jf = new JSONObject();
            jf.put("Flower type", fl.getName());
            jf.put("Price", fl.getPrice());
            jf.put("Color", fl.getColor());
            jf.put("Flower shop id", fl.getFlowerShop().getId());
            jf.put("Availability", fl.getAvailability());
            jf.put("Quantity", fl.getQuantity());
            JSONObject obj = new JSONObject();
            obj.put("Flowers", jf);
            flowerList.add(obj);
        }
    }
}
