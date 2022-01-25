package logic;

import model.Account;

import java.util.Arrays;

public enum RequestInfoString {
    REGISTRATION(1, "Enter request: \n 1; name = user name; address = user address"),
    CREATEACCOUNT(2, "Enter information for user account: \n" +
            "2; userId = user Id; currency = type currency\n" +
            "the currency may be:" + Arrays.toString(Account.Currency.values())),
    ACCREPLENISHMENT(3, "Enter information for account replacement, for example: \n" +
            "3; accountId = account Id; amount = amount for addition\n" +
            "3; userId = user Id; currency = type currency; amount = amount for addition\n" +
            "the currency may be:" + Arrays.toString(Account.Currency.values())),
    ACCWITHDRAWAL(4, "Enter information for withdrawal from the account, for example:\n" +
            "4; accountId = account Id; amount = amount for withdrawal\n" +
            "4; userId = user Id; currency = type currency; amount = amount for withdrawal\n" +
            "the currency may be:" + Arrays.toString(Account.Currency.values()));

    private final int requestType;
    private final String infoString;

    RequestInfoString(int requestType, String requestInfoString) {
        this.requestType = requestType;
        this.infoString = requestInfoString;
    }

    public int getRequestType() {
        return requestType;
    }

    public String getInfoString() {
        return infoString;
    }

    @Override
    public String toString() {
        return infoString;
    }
}
