package receive_request.receive_request_entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonValidRequest implements ValidRequest{
    final private String drugName;
    final private String drugBottle;

    public CommonValidRequest(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public String getName() { return drugName; }

    @Override
    public String getBottle() { return drugBottle; }
}