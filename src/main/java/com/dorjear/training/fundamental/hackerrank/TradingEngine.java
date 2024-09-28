package com.dorjear.training.fundamental.hackerrank;

import java.util.*;

public class TradingEngine {

    private static class Position {
        int netQuantity = 0;
        int totalLong = 0;
        int totalShort = 0;
        int boxedQuantity = 0;

        void updateNetPosition(int quantity) {
            netQuantity += quantity;
            if (quantity > 0) {
                totalLong += quantity;
            } else {
                totalShort += Math.abs(quantity);
            }
        }

        void updatePosition(int quantity) {
            updateNetPosition(quantity);
            updateBoxedQuantity();
        }

        private void updateBoxedQuantity() {
            if (totalLong > 0 && totalShort > 0) {
                boxedQuantity = Math.min(totalLong, totalShort);
            } else {
                boxedQuantity = 0;
            }
        }
    }

    public static List<String> calculate(List<String> trades) {
        Map<String, Map<String, Position>> traderPositions = new HashMap<>();

        for (String trade : trades) {
            String[] tradeParts = trade.split(",");
            String trader = tradeParts[0];
            String symbol = tradeParts[2];
            int quantity = Integer.parseInt(tradeParts[3]);

            traderPositions
                    .computeIfAbsent(trader, k -> new HashMap<>())
                    .computeIfAbsent(symbol, k -> new Position())
                    .updatePosition(quantity);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Map<String, Position>> traderEntry : traderPositions.entrySet()) {
            String trader = traderEntry.getKey();
            for (Map.Entry<String, Position> symbolEntry : traderEntry.getValue().entrySet()) {
                String symbol = symbolEntry.getKey();
                Position position = symbolEntry.getValue();

                if (position.boxedQuantity > 0) {
                    result.add(String.format("Boxed,%s,%s,%d", trader, symbol, position.boxedQuantity));
                }
                if (position.netQuantity != 0) {
                    result.add(String.format("Netted,%s,%s,%d", trader, symbol, position.netQuantity));
                }
            }
        }

        Collections.sort(result);
        return result;
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