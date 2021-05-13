package start;

import entity.Flower;
import entity.FlowerShop;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import repository.FlowerRepo;
import repository.FlowerShopRepo;
import repository.UserRepo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ApplicationStart extends  Application {

    public Scene scene;
    public static void main(String[] args) {
        UserRepo ur = new UserRepo();
        FlowerShopRepo fsr=new FlowerShopRepo();
        FlowerRepo fr=new FlowerRepo();
        FlowerShop fS1=new FlowerShop();
        fS1.setName("The Flower Studio");
        fS1.setId(1);
        FlowerShop fS2=new FlowerShop();
        fS2.setName("Blossom House");
        fS2.setId(2);
        FlowerShop fS3=new FlowerShop();
        fS3.setName("Rose and Co");
        fS3.setId(3);
        fsr.insertNewFlowerShop(fS1);
        fsr.insertNewFlowerShop(fS2);
        fsr.insertNewFlowerShop(fS3);
        Flower f1=new Flower();
        f1.setAvailability("Yes");
        f1.setColor("Red");

        f1.setFlowerShop(fS1);
        f1.setName("Tulip");
        f1.setPrice(20.5);
        f1.setId(1);
        f1.setQuantity(12);
        Flower f2=new Flower();
        f2.setAvailability("Yes");
        f2.setColor("White");

        f2.setFlowerShop(fS1);
        f2.setName("Rose");
        f2.setPrice(15);
        f2.setId(2);
        f2.setQuantity(50);
        Flower f3=new Flower();
        f3.setAvailability("Yes");
        f3.setColor("Pink");

        f3.setFlowerShop(fS2);
        f3.setName("Tulip");
        f3.setPrice(10.2);
        f3.setId(3);
        f3.setQuantity(30);
        ArrayList<Flower> list=new ArrayList<Flower>();
        list.add(f1);
        list.add(f2);
        fr.insertFlower(f1);
        fr.insertFlower(f2);
        fr.insertFlower(f3);
        fS1.setFlowers(list);

        User user1 = new User();
        user1.setFlowerShop(fS1);
       // user1.setFlowerShopId(fS1.getId());
        user1.setName("Ale");
        user1.setRole("Administrator");
        user1.setPassword("alebale");
        user1.setUsername("aleb");
        user1.setId(1);
        User user2 = new User();
        user2.setFlowerShop(fS1);
       // user2.setFlowerShopId(fS1.getId());
        user2.setName("Nati");
        user2.setRole("Employee");
        user2.setPassword("nasuc");
        user2.setUsername("nati");
        user2.setId(2);
        User user3 = new User();
        user3.setFlowerShop(fS2);
        //user3.setFlowerShopId(fS2.getId());
        user3.setName("Alex");
        user3.setRole("Administrator");
        user3.setPassword("alexneet");
        user3.setUsername("miau");
        user3.setId(3);
        ArrayList<User> list1=new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        fS1.setUsers(list1);
        for(User y: list1){
            System.out.println(y.getName());
        }
       ur.insertNewUser(user1);
        ur.insertNewUser(user2);
        ur.insertNewUser(user3);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "src\\main\\java\\view\\login.fxml";
        FileInputStream fxmlStream = null;
        try {
            fxmlStream = new FileInputStream(fxmlDocPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        // Create the Pane and all Details
        VBox root = null;
        try {
            root = (VBox) loader.load(fxmlStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FlowerShop");
        stage.show();
    }
}
