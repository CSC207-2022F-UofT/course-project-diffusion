package drug_fulfill.drug_fulfill_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrugFulfillRequestModelTest {
    DrugFulfillRequestModel inputData = new DrugFulfillRequestModel("DrugA", 5,
            false, "Depot1", "Site1");

    @Test
    void getDrugName() {
        assertEquals(inputData.getDrugName(), "DrugA");
    }
    @Test
    void getDrugBottle() {
        assertEquals(inputData.getDrugBottle(), 5);
    }

    @Test
    void setDrugBottle() {
        inputData.setDrugBottle(10);
        assertEquals(inputData.getDrugBottle(), 10);
    }

    @Test
    void getDepot() {
        assertEquals(inputData.getDepot(), "Depot1");
    }

    @Test
    void getSite() {
        assertEquals(inputData.getSite(), "Site1");
    }

}