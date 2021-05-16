package model;

public class InterfaceFactory extends  AbstractFactory {
    @Override
    ChangeInterface getInterface(String interfaceType) {
        if(interfaceType.equalsIgnoreCase("LogIn")){
            return new LoginInterfaceLanguage();
        }else if(interfaceType.equalsIgnoreCase("Employee")){
            return new EmployeeInterfaceLanguage();
        }else{
            if(interfaceType.equalsIgnoreCase("Admin")){
                return new AdminInterfaceLanguage();
            }
        }
        return null;
    }
}
