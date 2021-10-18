package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.messageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private messageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    public Message save (Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> paux=messageRepository.getMessage(m.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(m);
            }else {
                return m;
            }
        }
    }
}
