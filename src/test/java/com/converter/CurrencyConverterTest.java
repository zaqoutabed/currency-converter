package com.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {
	private static CurrencyConverter currencyConverter;
	@BeforeAll
	public static void setUp() {
		System.out.println("Setup Instance");
		currencyConverter = new CurrencyConverter();
	}
	@AfterAll
	public static void tearDown() {
		System.out.println("Clear Instance");
		currencyConverter = null;
	}
	
	@Test
	public void convertFromUSDTest() {
		// From USD => USD
		double result = currencyConverter.convert(15, "USD", "USD");
		Assertions.assertEquals(result, 15);
		
		// From USD => EUR
		result = currencyConverter.convert(10000, "USD", "EUR");
		Assertions.assertEquals(result, 82.665);
		
		// From USD => ILS
		result = currencyConverter.convert(30, "usd", "ILS");
		Assertions.assertEquals(result, 108.81);
	}
	
	@Test
	public void convertFromEURTest() {
		// From EUR => EUR
		double result = currencyConverter.convert(15, "EUR", "EUR");
		Assertions.assertEquals(result, 15);
		
		// From EUR => USD
		result = currencyConverter.convert(10000, "EUR", "USD");
		Assertions.assertEquals(result, 82.665);
		
		// From EUR => ILS
		result = currencyConverter.convert(30, "EUR", "ILS");
		Assertions.assertEquals(result, 108.81);
	}
	
	@Test
	public void convertFromILSTest() {
		// From ILS => ILS
		double result = currencyConverter.convert(15, "ils", "ILS");
		Assertions.assertEquals(result, 15);
		
		// From ILS => USD
		result = currencyConverter.convert(10000, "ILS", "USD");
		Assertions.assertEquals(result, 82.665);
		
		// From ILS => EUR
		result = currencyConverter.convert(30, "ILS", "EUR");
		Assertions.assertEquals(result, 108.81);
	}
	
	@Test
	public void invalidValuesConvertTest() {
		// From JOD => EUR
		// JOD not supported
		double result = currencyConverter.convert(15, "JOD", "EUR");
		Assertions.assertEquals(result, 15);
		
		// From ILS => EUR
		// Check negative value
		result = currencyConverter.convert(-15, "ILS", "EUR");
		Assertions.assertEquals(result, 15);
	}
}
