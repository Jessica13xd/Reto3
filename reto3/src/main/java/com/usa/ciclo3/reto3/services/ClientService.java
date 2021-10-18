package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private clientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    public Client save (Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> paux=clientRepository.getClient(c.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(c);
            }else {
                return c;
            }
        }
    }
}
