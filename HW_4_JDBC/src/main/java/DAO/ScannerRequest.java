package DAO;

import logic.RequestInfoString;
import model.User;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerRequest {


    /* writing the info string for user about type of request
     *
     */
    public static String getScannerRequest(){
            System.out.println("Input type of request: \n " +
                    "1 - registration of new user; \n" +
                    "2 - create new user account; \n" +
                    "3 - account replenishment; \n " +
                    "4 - withdrawal from the account;");

            RequestInfoString[] requestInfoString = RequestInfoString.values();
            for (RequestInfoString r: requestInfoString) {
                System.out.println(r.getInfoString());
            }
            return getRequestFromScanner();
    }

    /* getting the request from scanner
     *
     */
    public static String getRequestFromScanner() {
        Scanner inputPer = new Scanner(System.in);
        String request = null;
        List listForRequest = new ArrayList<String>();

        while (inputPer.hasNext()) {
            System.out.println("Enter request");
            listForRequest.add(inputPer.nextInt());
        }
        request = listForRequest.toString();
        System.out.println("request: " + request);
        return request;
    }
}
