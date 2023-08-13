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
		Assertions.assertEquals(result, (10000 * 0.9185));
		// From USD => ILS
		result = currencyConverter.convert(30, "usd", "ILS");
		Assertions.assertEquals(result, (30 * 3.627));
	}

	@Test
	public void convertFromEURTest() {
		// From EUR => EUR
		double result = currencyConverter.convert(150, "EUR", "EUR");
		Assertions.assertEquals(result, 150);
		// From EUR => USD
		result = currencyConverter.convert(900, "EUR", "USD");
		Assertions.assertEquals(result, (900 * 1.0887));
		// From EUR => ILS
		result = currencyConverter.convert(33, "EUR", "ILS");
		Assertions.assertEquals(result, (33 * 3.9483));
	}

	@Test
	public void convertFromILSTest() {
		// From ILS => ILS
		double result = currencyConverter.convert(60, "ils", "ILS");
		Assertions.assertEquals(result, 60);
		// From ILS => USD
		result = currencyConverter.convert(600, "ILS", "USD");
		Assertions.assertEquals(result, (600 * 0.2757));
		// From ILS => EUR
		result = currencyConverter.convert(350, "ILS", "EUR");
		Assertions.assertEquals(result, (350 * 0.2533));
	}

	@Test
	public void invalidAmountConvertTest() {
		// From ILS => EUR
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> currencyConverter.convert(-15, "ILS", "EUR"),
				"Negative Value"
		);
	}
	
	@Test
	public void invalidCurrencyConvertTest() {
		// From JOD => EUR
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> currencyConverter.convert(15, "JOD", "EUR"),
				"not supported currency"
		);
	}
}
