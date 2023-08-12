package com.converter;

public class CurrencyConverter {
    private double UsdToEurRate;
    private double UsdToILSRate;
    private double EurToILSRate;
    private double EurToUsdSRate;
    private double ILSToEurRate;
    private double ILSToUsdRate;

    public CurrencyConverter() {
        this.UsdToEurRate = 0.9185;
        this.UsdToILSRate = 3.627;
        this.EurToILSRate = 3.9483;
        this.EurToUsdSRate = 1.0887;
        this.ILSToEurRate = 0.2533;
        this.ILSToUsdRate = 0.2757;
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double result;
        switch (fromCurrency) {
            case "USD":
                result = convertFromUSD(amount, toCurrency);
                break;
            case "EUR":
                result = convertFromEUR(amount, toCurrency);
                break;
            case "ILS":
                result = convertFromILS(amount, toCurrency);
                break;
            default:
                throw new IllegalArgumentException("Invalid source currency: " + fromCurrency);
        }
        return result;
    }

    private double convertFromUSD(double amount, String toCurrency) {
        switch (toCurrency) {
            case "USD":
                return amount;
            case "EUR":
                return amount * UsdToEurRate;
            case "ILS":
                return amount * UsdToILSRate;
            default:
                throw new IllegalArgumentException("Invalid target currency: " + toCurrency);
        }
    }

    private double convertFromEUR(double amount, String toCurrency) {
        // Implement conversion from EUR to other currencies
        switch (toCurrency) {
            case "EUR":
                return amount;
            case "USD":
                return amount * EurToUsdSRate;
            case "ILS":
                return amount * EurToILSRate;
            default:
                throw new IllegalArgumentException("Invalid target currency: " + toCurrency);
        }
    }

    private double convertFromILS(double amount, String toCurrency) {
        // Implement conversion from ILS to other currencies
        switch (toCurrency) {
            case "ILS":
                return amount;
            case "USD":
                return amount * ILSToUsdRate;
            case "EUR":
                return amount * ILSToEurRate;
            default:
                throw new IllegalArgumentException("Invalid target currency: " + toCurrency);
        }
    }
}