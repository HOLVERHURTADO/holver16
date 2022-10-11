package com.holverReto3.reto3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.holverReto3.reto3.model.Skate;
import com.holverReto3.reto3.repository.SkateRepository;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getSkateAll(){
        return skateRepository.getSkateAll();
    }
    
    public Optional <Skate> getSkateId(Integer id){
        return skateRepository.getSkateId(id);
    }

    public Skate save(Skate skate){
            if (skate.getId()==null){
                return skateRepository.save(skate);
            }
            else{
                Optional <Skate> skateAuxiliar=skateRepository.getSkateId(skate.getId());
                if (skateAuxiliar.isEmpty()){
                    return skateRepository.save(skate);
                }
                else{
                    return skate;
                }
            }
        }
    /* 
    public SkateService update(Skate skate){
        if(skate.getId()!=null){
            Optional<Skate>g= skateService.getSkateService(skate.getId());
            if(!g.isEmpty()){
                if(skate.getDescription()!=null){                    
                    g.get().setDescription(skate.getDescription());
                }
                if(skate.getName()!=null){
                    g.get().setName(skate.getName());
                }
                return skateRepository.save(g.get());
            }
        }
        return skate;
    }
    
    public boolean deleteSkate(int id){
        Boolean d= getSkate(id).map(skate -> {
                            SkateService.delete(skate);
                            return true;
                            }
          ).orElse(false);
        return d;
    }

    public boolean deleteSkate(int id) {
        boolean flag=false;
        Optional<Skate> c= SkateService.getSkate(id);
        if(c.isPresent()){
            SkateService.delete(c.get());
            flag=true;
        }
        return flag;
    }
*/
}