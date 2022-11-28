//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill_use_case.DrugFulfillInteractor;
import drug_fulfill_use_case.DrugRequestPresenter;
import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import screens.DrugRequestController;
import screens.DrugRequestResponseFormatter;
import screens.FileDepotInventoryA;
import screens.RegisterScreen;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JFrame application = new JFrame("Order Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        FileDepotInventoryA depot;
        try {
            depot = new FileDepotInventoryA("./depotAInventory.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create file.");
        }

        DrugRequestPresenter presenter = new DrugRequestResponseFormatter();
        DrugFulfillFactory orderFactory = new CommonDrugFulfillFactory();
        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(depot, presenter, orderFactory);
        DrugRequestController drugRequestController = new DrugRequestController(interactor);
        RegisterScreen registerScreen = new RegisterScreen(drugRequestController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
    }
}
