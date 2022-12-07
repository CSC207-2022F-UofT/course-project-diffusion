//package user_registration.frameworks_and_drivers;
//
//
////import user_registration.entity.CommonUserRegistrationFactory;
////import user_registration.frameworks_and_drivers.database_generator.UserRegistrationRecorder;
////import user_registration.frameworks_and_drivers.screens.UserRegistrationScreen;
////import user_registration.interface_adapters.UserRegistrationController;
////import user_registration.interface_adapters.UserRegistrationPresenter;
////import user_registration.ports.UserRegistrationGenerator;
////import user_registration.usecase_engine.database_generator.UserRegistrationDsGateway;
////import user_registration.usecase_engine.interactor.UserRegistrationInteractor;
//
//import javax.swing.*;
////import java.awt.*;
////import java.io.IOException;
//
//public class UserRegistrationFrame extends JFrame {
//    public UserRegistrationFrame(){
////        super("Drug Request Example");
////        JPanel panelCont = new JPanel();
////        CardLayout cl = new CardLayout();
////
////        //Before Adding components you now need an appropriate Layout manager
//////        setLayout(new CardLayout());
////
////        //Below are the parts for the use case entities engine
////        UserRegistrationDsGateway userRegistrationDsGateway;
////        try{
////            userRegistrationDsGateway = new UserRegistrationRecorder("./RegistrationList3.csv");
////
////        } catch (IOException e) {
////            throw new RuntimeException("Can't create file.");
////        }
////
//////        UserRegistrationDsGateway userRegistrationDsGateway = null;
////        UserRegistrationPresenter userRegistrationOutputBoundary = new UserRegistrationPresenter();
////        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();
////        UserRegistrationInteractor userRegistrationInteractor = new UserRegistrationInteractor(userRegistrationDsGateway,
////                userRegistrationOutputBoundary, userRegistrationGenerator);
////        UserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationInteractor);
////
////        //below is the DrugRequestScreen panel which is added to this JFrame Window
////        UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen(userRegistrationController);
////
//////        HomeScreen homeScreen = new HomeScreen();
//////        panelCont.getConte
//////        panelCont.setLayout(cl);
//////        panelCont.add(userRegistrationScreen, "1");
////
//////        panelCont.add(homeScreen, "2");
////        add(userRegistrationScreen);
////
////        userRegistrationOutputBoundary.setView(userRegistrationScreen);
////
//////        add(userRegistrationScreen);
////        cl.show(panelCont, "2");
////        //below makes the program stop running when you click close
////        setDefaultCloseOperation(EXIT_ON_CLOSE);
////
////        //below is the size of the JFram
////        setSize(600,500);
////
////        //below makes the program visible
////        setVisible(true);
//    }
//}
