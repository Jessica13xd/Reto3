package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Client;
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

    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> ms = messageRepository.getMessage(m.getIdMessage());
            if (!ms.isEmpty()) {
                if(m.getMessageText()!=null){
                    ms.get().setMessageText(m.getMessageText());
                }
                return messageRepository.save(ms.get());
            }
        }
        return m;
    }

    public boolean deleteMessage(int idMessage){
        boolean dm= getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return dm;
    }
}
