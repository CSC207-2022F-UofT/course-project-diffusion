package drug_search.frameworks_drivers;

import drug_search.use_case.DrugRequestDBEntry;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseAccessorTest {

    @Test
    void getDrugRequestList() throws FileNotFoundException {
        List<DrugRequestDBEntry> list = new DatabaseAccessor()
                .getDrugRequestList("./src/test/java/drug_search/DrugSearchTestFile.csv");

        assertEquals("1000", list.get(0).getRequestId());
        assertEquals("Site1", list.get(0).getSiteId());
        assertEquals("2000", list.get(0).getAccountId());
        assertEquals("SoylentGreen", list.get(0).getDrugName());
        assertEquals(7, list.get(0).getQuantity());
        assertEquals(LocalDateTime.parse("2022-12-08T16:43:49.015629"), list.get(0).getDate());
    }
}