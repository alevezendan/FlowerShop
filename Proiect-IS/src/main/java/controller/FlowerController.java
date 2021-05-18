package controller;

import model.service.FlowerService;
import model.service.UserService;
//import lombok.Data;

//@Data
public class FlowerController {

    private UserService userService;
    private FlowerService flowerService;

    public FlowerController(){
        this.userService=new UserService();
        this.flowerService=new FlowerService();
    }
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public FlowerService getFlowerService() {
        return flowerService;
    }

    public void setFlowerService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }
}
