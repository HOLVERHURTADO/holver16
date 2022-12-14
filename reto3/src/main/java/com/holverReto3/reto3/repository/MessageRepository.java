package com.holverReto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.holverReto3.reto3.model.Message;
import com.holverReto3.reto3.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> getMessageAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessageId(Integer id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    /* 
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }*/

}


