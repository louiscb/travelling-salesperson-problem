package com.tsp.algorithms;

import com.tsp.domain.City;

import java.util.ArrayList;

public class AlgorithmsHelper {

   public static int totalDistance(ArrayList<City> cities) {
      int totalDistance = 0;

      for (int i = 0; i < cities.size() - 1; i++) {
         totalDistance += cities.get(i).distanceTo(cities.get(i + 1));
      }
      return totalDistance + cities.get(cities.size() - 1).distanceTo(cities.get(0));
   }

   public static int[][] createDistanceMatrix(ArrayList<City> cities) {
      int[][] matrix = new int[cities.size()][cities.size()];

      for (int i = 0; i < cities.size(); i++) {
         for (int j = i; j < cities.size(); j++) {
            int distance;
            if (i == j) {
               distance = 0;
            } else {
               distance = cities.get(i).distanceTo(cities.get(j));
            }

            matrix[i][j] = distance;
            matrix[j][i] = distance;
         }
      }

      return matrix;
   }

   public static void printMatrix(int[][] distanceMatrix, int n) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            System.out.print(distanceMatrix[i][j] + " ");
         }
         System.out.println("");
      }
   }

   public static void printCities(ArrayList<City> cities) {
      System.out.println("---");
      cities.forEach(city -> System.out.print(city.getId()+ ", "));
      System.out.println("---");
   }
}
