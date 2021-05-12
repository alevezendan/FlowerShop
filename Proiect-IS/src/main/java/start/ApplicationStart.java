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
        FlowerShop fS=new FlowerShop();
        fS.setName("florarie");
        fS.setId(2);
        fsr.insertNewFlowerShop(fS);
        Flower f1=new Flower();
        f1.setAvailability("Yes");
        f1.setColor("Red");

        f1.setFlowerShop(fS);
        f1.setName("Tulip");
        f1.setPrice(20.5);
        f1.setId(1);
        f1.setQuantity(12);
        ArrayList<Flower> list=new ArrayList<Flower>();
        list.add(f1);
        fr.insertFlower(f1);
        fS.setFlowers(list);

        User user = new User();
        user.setFlowerShop(fS);
        user.setName("Nati");
        user.setRole("Administrator");
        user.setPassword("nasuc");
        user.setUsername("nati");
        user.setId(3);

        ArrayList<User> list1=new ArrayList<>();
        list1.add(user);
        fS.setUsers(list1);
      // ur.insertNewUser(user);
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
