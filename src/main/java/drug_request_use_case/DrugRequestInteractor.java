package drug_request_use_case;

import drug_request_entity.CommonDrugRequestGenerator;

public class DrugRequestInteractor implements DrugRequestInputBoundary {
    //consider making the below final
    DrugRequestDsGateway drugRequestDsGateway;
    CommonDrugRequestGenerator commonDrugRequestGenerator;

    public DrugRequestInteractor(DrugRequestDsGateway drugRequestDsGateway, CommonDrugRequestGenerator
            commonDrugRequestGenerator){
        this.drugRequestDsGateway = drugRequestDsGateway;
        this.commonDrugRequestGenerator = commonDrugRequestGenerator;
    }

    @Override
    public DrugRequestResponseModel create(DrugRequestInvokeModel drugRequestInvokeModel) {
        return null;
    }
}
