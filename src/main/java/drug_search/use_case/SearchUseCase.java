package drug_search.use_case;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Takes user-generated search request data and displays a list of drug items matching the given criteria.
 */
public class SearchUseCase implements ISearchRequestor {
    public SearchUseCase(ISearchResponder searchResponder, IDrugListAccessor drugListAccessor) {
        this.searchResponder = searchResponder;
        this.drugListAccessor = drugListAccessor;
    }

    /**
     * Searches the application database for {@link DrugRequestDBEntry} matching the criteria in the search request.
     *
     * @param request The data to search for.
     */
    public void searchFor(SearchRequest request) {
        SearchResponse response;

        try {
            List<DrugRequestDBEntry> db = drugListAccessor.getDrugRequestList();

            response = new SearchResponse(getMatchingEntries(db, request), null);
        }
        catch (FileNotFoundException e) {
            response = new SearchResponse(new ArrayList<>(),
                    "Could not find a search request database file!");
        }

        searchResponder.searchRespond(response);
    }

    /**
     * Finds all entries in the given list which match the given search request.
     */
    private List<DrugRequestDBEntry> getMatchingEntries(List<DrugRequestDBEntry> list, SearchRequest request) {
        ArrayList<DrugRequestDBEntry> listToReturn = new ArrayList<>();

        for (DrugRequestDBEntry entry : list) {
            if (isMatch(entry, request)) listToReturn.add(entry);
        }

        return listToReturn;
    }

    /**
     * Checks if a drug request database entry matches a given search request.
     */
    private boolean isMatch(DrugRequestDBEntry entry, SearchRequest request) {
        if (!isNullOrBlank(request.getAccountId()) && !entry.getAccountId().contains(request.getAccountId())) {
            return false;
        }
        if (!isNullOrBlank(request.getRequestId()) && !entry.getRequestId().contains(request.getRequestId())) {
            return false;
        }
        if (!isNullOrBlank(request.getSiteId()) && !entry.getSiteId().contains(request.getSiteId())) {
            return false;
        }
        if (!isNullOrBlank(request.getDrugName()) && !entry.getDrugName().contains(request.getDrugName())) {
            return false;
        }
        if (request.getQuantity() > 0 && entry.getQuantity() != request.getQuantity()) {
            return false;
        }
        if (request.isDateSearch()) {
            int trueRelativity = compareDate(entry.getDate(), request.getDate());

            System.out.println(trueRelativity);

            if (request.getRelativity() == 1 && trueRelativity <= 0) return false;
            if (request.getRelativity() == -1 && trueRelativity >= 0) return false;
            if (request.getRelativity() == 0) return trueRelativity == 0;
        }

        System.out.println("Found database entry matching search request");

        return true;
    }

    /**
     * See method name for documentation.
     */
    private boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    /**
     * Compares two {@link LocalDateTime}s, taking into account only the date and ignoring the time.
     * @return A positive integer if date1 is after date2, a negative integer if date1 is before date2, and 0 if
     * they are the same date.
     */
    private int compareDate(LocalDateTime date1, LocalDateTime date2) {
        if (date1.getYear() != date2.getYear())
            return date1.getYear() - date2.getYear();
        if (date1.getMonthValue() != date2.getMonthValue())
            return date1.getMonthValue() - date2.getMonthValue();
        return date1.getDayOfMonth() - date2.getDayOfMonth();
    }

    private final ISearchResponder searchResponder;
    private final IDrugListAccessor drugListAccessor;
}
