package drug_fulfill.drug_fulfill_entities;

import drug_fulfill.drug_fulfill_use_case.DrugFulfillRequestModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonDrugFulfillTest {
    CommonDrugFulfill DrugOrder  = new CommonDrugFulfill("DrugA", 5,
            false, "Depot1", "Site1");
    @Test
    void getDrugName() {
        assertEquals(DrugOrder.getDrugName(), "DrugA");
    }

    @Test
    void getDrugBottle() {
        assertEquals(DrugOrder.getDrugBottle(), 5);
    }

    @Test
    void getIsEmergency() {
        assertFalse(DrugOrder.getIsEmergency());
    }

    @Test
    void getDepotName() {
        assertEquals(DrugOrder.getDepotName(), "Depot1");
    }

    @Test
    void getSiteName() {
        assertEquals(DrugOrder.getSiteName(), "Site1");
    }
}