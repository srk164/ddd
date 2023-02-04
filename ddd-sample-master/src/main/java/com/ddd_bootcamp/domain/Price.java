package com.ddd_bootcamp.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price implements ValueObject<Price>{
    private BigDecimal value;
    private Currency currency;

    public Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Price reduceByPercent(int percentage) {
        return new Price(value.subtract(value.divide(new BigDecimal(percentage))), Currency.getInstance("USD"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value) &&
                Objects.equals(currency, price.currency);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public boolean sameValueAs(Price other) {
        if (this == other) return true;
        if (!value.equals(other.value)) return false;
        return currency.equals(other.currency);
    }


    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}