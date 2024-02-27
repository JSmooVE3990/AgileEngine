package com.example.agileengine;

import java.util.*;

class VisitCounter {

    // Method to count visits for multiple sets of user statistics
    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> userVisitCounts = new HashMap<>();
        try{

            for (Map<String, UserStats> visit : visits) {
                for (Map.Entry<String, UserStats> entry : visit.entrySet()) {
                    String userIdStr = entry.getKey();
                    UserStats userStats = entry.getValue();

                    long userId = Long.parseLong(userIdStr);
                    if (userStats != null) {
                        Optional<Long> visitCountOptional = userStats.getVisitCount();
                        if (visitCountOptional.isPresent()) {
                            long visitCount = visitCountOptional.get();
                            userVisitCounts.put(userId, userVisitCounts.getOrDefault(userId, 0L) + visitCount);
                        } else {
                            System.out.println("Skipping entry with empty visitCount: " + userIdStr);
                        }
                    } else {
                        System.out.println("Skipping entry with null UserStats: " + userIdStr);
                    }

                }

            }            } catch (NumberFormatException  | NullPointerException e) {
            System.out.println("Skipping entry with invalid userId: ");
        }

        return userVisitCounts;
    }

class UserStats {

    public Optional<Long> getVisitCount() {
        return null;
    }

}