package com.dorjear.training.fundamental.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class TradingEngine {

    private static class Position {
        // To store positions by Trader-Symbol (to net the trades)
        Map<String, Map<String, Integer>> nettedPositions = new HashMap<>();
        // To store trades by Trader-Symbol-Broker (to detect boxed positions)
        Map<String, Map<String, Map<String, Integer>>> boxedPositions = new HashMap<>();

        public Position(List<String> trades) {
            for (String trade : trades) {
                String[] parts = trade.split(",");
                String trader = parts[0];
                String broker = parts[1];
                String symbol = parts[2];
                int quantity = Integer.parseInt(parts[3]);

                // Netted positions (Trader-Symbol key)
                nettedPositions.putIfAbsent(trader, new HashMap<>());
                nettedPositions.get(trader).put(symbol, nettedPositions.get(trader).getOrDefault(symbol, 0) + quantity);

                // Boxed positions (Trader-Symbol-Broker key)
                boxedPositions.putIfAbsent(trader, new HashMap<>());
                boxedPositions.get(trader).putIfAbsent(symbol, new HashMap<>());
                boxedPositions.get(trader).get(symbol).put(broker, boxedPositions.get(trader).get(symbol).getOrDefault(broker, 0) + quantity);
            }
        }

        public List<String> createBoxedPositions() {
            List<String> result = new ArrayList<>();

            for (Map.Entry<String, Map<String, Map<String, Integer>>> traderEntry : boxedPositions.entrySet()) {
                String trader = traderEntry.getKey();
                for (Map.Entry<String, Map<String, Integer>> symbolEntry : traderEntry.getValue().entrySet()) {
                    String symbol = symbolEntry.getKey();
                    Map<String, Integer> brokerPositions = symbolEntry.getValue();

                    int longPosition = 0;
                    int shortPosition = 0;

                    for (int position : brokerPositions.values()) {
                        if (position > 0) {
                            longPosition += position;
                        } else {
                            shortPosition += position;
                        }
                    }

                    // If both long and short positions exist, it's a boxed position
                    if (longPosition > 0 && shortPosition < 0) {
                        int boxedQuantity = Math.min(longPosition, -shortPosition);
                        result.add(String.format("Boxed,%s,%s,%d", trader, symbol, boxedQuantity));
                    }
                }
            }
            return result;
        }

        public List<String> createNettedPositions() {
            List<String> result = new ArrayList<>();

            for (Map.Entry<String, Map<String, Integer>> traderEntry : nettedPositions.entrySet()) {
                String trader = traderEntry.getKey();
                for (Map.Entry<String, Integer> symbolEntry : traderEntry.getValue().entrySet()) {
                    String symbol = symbolEntry.getKey();
                    int netQuantity = symbolEntry.getValue();
                    result.add(String.format("Netted,%s,%s,%d", trader, symbol, netQuantity));
                }
            }
            return result;
        }

        public List<String> createBoxedAndNettedPositions() {
            List<String> result = createBoxedPositions();
            result.addAll(createNettedPositions());
            return result.stream().sorted().collect(Collectors.toList());
        }
    }

    public static List<String> calculate(List<String> trades) {
        return new Position(trades).createBoxedAndNettedPositions();
    }

    public static void main(String[] args) {
        List<String> trades = Arrays.asList(
                "Joe,ML,IBM,110",
                "Joe,DB,IBM,-150",
                "Joe,CS,IBM,30",
                "Mike,CS,AAPL,-100",
                "Mike,BC,AAPL,200",
                "Alan,DB,TSLA,-50",
                "Debby,BC,IBM,500"
        );

        List<String> result = calculate(trades);
        for (String position : result) {
            System.out.println(position);
        }
    }
}