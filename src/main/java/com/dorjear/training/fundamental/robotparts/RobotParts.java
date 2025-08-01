package com.dorjear.training.fundamental.robotparts;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
We have a bin of robot parts in a factory. Each part goes to a robot with a specific, unique name. Each part will be described by a string, with the name of the robot and the part name separated by an underscore, like "Rosie_arm".

All robots are made of the same types of parts, and we have a string of all of the parts required to form a complete robot. Given a list of available parts, return the collection of robot names for which we can build at least one complete robot.

Sample Input:

all_parts = [
    "Rosie_claw",
    "Rosie_sensors",
    "Dustie_case",
    "Optimus_sensors",
    "Rust_sensors",
    "Rosie_case",
    "Rust_case",
    "Optimus_speaker",
    "Rosie_wheels",
    "Rosie_speaker",
    "Dustie_case",
    "Dustie_arms",
    "Rust_claw",
    "Dustie_case",
    "Dustie_speaker",
    "Optimus_case",
    "Optimus_wheels",
    "Rust_legs",
    "Optimus_sensors" ]

required_parts_1 = "sensors,case,speaker,wheels"
required_parts_2 = "sensors,case,speaker,wheels,claw"
required_parts_3 = "sensors,case,screws"

Expected Output (output can be in any order):

get_robots(all_parts, required_parts_1) => ["Optimus", "Rosie"]
get_robots(all_parts, required_parts_2) => ["Rosie"]
get_robots(all_parts, required_parts_3) => []

N: Number of elements in `all_parts`
P: Number of elements in `required_parts`
*/


public class RobotParts {
    public static void main(String[] argv) {
        String required_parts_1 = "sensors,case,speaker,wheels";
        String required_parts_2 = "sensors,case,speaker,wheels,claw";
        String required_parts_3 = "sensors,case,screws";

        String[] all_parts = {
                "Rosie_claw",
                "Rosie_sensors",
                "Dustie_case",
                "Optimus_sensors",
                "Rust_sensors",
                "Rosie_case",
                "Rust_case",
                "Optimus_speaker",
                "Rosie_wheels",
                "Rosie_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Optimus_case",
                "Optimus_wheels",
                "Rust_legs",
                "Optimus_sensors"};

        System.out.println(getRobots(List.of(all_parts), required_parts_1));
    }

    public static List<String> getRobots(List<String> allParts, String requiredParts) {
        Set<String> requiredSet = Arrays.stream(requiredParts.split(","))
                .collect(Collectors.toSet());

        // Step 1: Group robot parts by robot name
        Map<String, Set<String>> robotPartsMap = new HashMap<>();

        for (String part : allParts) {
            String[] split = part.split("_");
            if (split.length != 2) continue; // Skip malformed entries

            String robotName = split[0];
            String partName = split[1];

            robotPartsMap
                    .computeIfAbsent(robotName, k -> new HashSet<>())
                    .add(partName);
        }

        // Step 2: Filter robots that have all required parts
        List<String> result = robotPartsMap.entrySet().stream()
                .filter(entry -> entry.getValue().containsAll(requiredSet))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return result;
    }

}


