package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.EnderecoDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEndereco(String cep){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
             enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
        } catch(Exception e){
            System.out.println(e);
        }
        return enderecoDto;
    }
}
