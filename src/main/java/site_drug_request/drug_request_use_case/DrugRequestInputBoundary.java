package site_drug_request.drug_request_use_case;

import java.io.FileNotFoundException;

public interface DrugRequestInputBoundary {
    DrugRequestResponseModel create(DrugRequestInvokeModel drugRequestInvokeModel) throws FileNotFoundException;
}
