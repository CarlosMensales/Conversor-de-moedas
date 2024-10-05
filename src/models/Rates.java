package models;

import java.util.Map;

public record Rates(Map<String, Float> conversion_rates) {
}
