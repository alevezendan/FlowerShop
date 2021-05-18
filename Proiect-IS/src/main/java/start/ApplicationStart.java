package start;


import model.entity.Flower;
import model.entity.FlowerShop;
import model.entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.repository.FlowerRepo;
import model.repository.FlowerShopRepo;
import model.repository.UserRepo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
        Flower f4=new Flower(4,"Rose","Red",20.0,"Yes",35,fS2);
        Flower f5=new Flower(5,"Rose","Red",20.0,"Yes",35,fS3);
        Flower f6=new Flower(6,"Rose","Yellow",12.0,"Yes",15,fS3);
        Flower f7=new Flower(7,"Sunflower","Yellow",10.0,"Yes",20,fS3);
        Flower f8=new Flower(8,"Tulip","White",14.0,"Yes",20,fS3);
        Flower f9=new Flower(9,"Orchid","White",30.0,"Yes",35,fS1);
        Flower f10=new Flower(10,"Orchid","Pink",35.0,"Yes",10,fS2);
        Flower f11=new Flower(11,"Rose","Pink",25.0,"Yes",15,fS1);
        Flower f12=new Flower(12,"Rose","Pink",12.0,"Yes",15,fS2);
        ArrayList<Flower> list=new ArrayList<Flower>();
        list.add(f1);
        list.add(f2);
        list.add(f9);
        list.add(f11);
        ArrayList<Flower> list2=new ArrayList<Flower>();
        list2.add(f3);
        list2.add(f4);
        list2.add(f10);
        list2.add(f12);
        fS2.setFlowers(list2);
        ArrayList<Flower> list3=new ArrayList<Flower>();
        list3.add(f5);
        list3.add(f6);
        list3.add(f7);
        list3.add(f8);
        fS3.setFlowers(list3);
        fr.insertFlower(f1);
        fr.insertFlower(f2);
        fr.insertFlower(f3);
        fr.insertFlower(f4);
        fr.insertFlower(f5);
        fr.insertFlower(f6);
        fr.insertFlower(f7);
        fr.insertFlower(f8);
        fr.insertFlower(f9);
        fr.insertFlower(f10);
        fr.insertFlower(f11);
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
        User user4=new User(4,"Ilinca","Employee","ilinca123","haha",fS2);
        User user5=new User(5,"Dante","Administrator","danteteen","hihi",fS2);
        User user6=new User(6,"Mario","Employee","mario10","dada",fS3);
        User user7=new User(7,"Abbie","Employee","miu","nunu",fS3);
        User user8=new User(8,"Victoria","Administrator","vicneet","yaaas",fS3);
        ArrayList<User> list1=new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        fS1.setUsers(list1);
        ArrayList<User> listU2=new ArrayList<>();
        listU2.add(user3);
        listU2.add(user4);
        listU2.add(user5);
        fS2.setUsers(listU2);
        ArrayList<User> listU3=new ArrayList<>();
        listU3.add(user6);
        listU3.add(user7);
        listU3.add(user8);
        fS3.setUsers(listU3);
        for(User y: list1){
            System.out.println(y.getName());
        }
       ur.insertNewUser(user1);
        ur.insertNewUser(user2);
        ur.insertNewUser(user3);
        ur.insertNewUser(user4);
        ur.insertNewUser(user5);
        ur.insertNewUser(user6);
        ur.insertNewUser(user7);
        ur.insertNewUser(user8);
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
