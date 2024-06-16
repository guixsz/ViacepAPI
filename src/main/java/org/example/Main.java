package org.example;

import org.example.service.ApiService;


public class Main {
    public static void main(String[] args) {


        ApiService apiService = new ApiService();

        try {
            System.out.println(apiService.getEndereco("03107040"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}