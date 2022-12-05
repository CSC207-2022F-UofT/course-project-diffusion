package drug_search_interface_adapters;

import drug_search_use_case.DrugRequestDBEntry;

import java.util.ArrayList;
import java.util.List;

public class DrugSearchViewModel {
    public DrugSearchViewModel() {
        entryList = new ArrayList<>();
        message = "Congratulation! This message should never display. You are one lucky sport.";
    }

    /**
     * Gets the view model entry list.
     */
    public List<DrugRequestDBEntry> getEntryList() {
        return entryList;
    }
    /**
     * Sets the view model entry list.
     */
    public void setEntryList(List<DrugRequestDBEntry> entryList) {
        this.entryList = entryList;
    }
    /**
     * Gets the view model message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Sets the view model message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    private List<DrugRequestDBEntry> entryList;
    private String message;
}
