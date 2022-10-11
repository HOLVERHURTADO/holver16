package com.holverReto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holverReto3.reto3.model.Admin;
import com.holverReto3.reto3.repository.AdminRepository;

@Service

public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdminAll() {
        return adminRepository.getAdminAll();
    }

    public Optional<Admin> getAdminId(Integer adminId) {
        return adminRepository.getAdminId(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if (adminAuxiliar.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
/* 
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>g= adminRepository.getAdmin(admin.getIdAdmin());
            if(!g.isEmpty()){
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                return adminRepository.save(g.get());
            }
        }
        return admin;
    }
    public boolean deleteAdmin(int adminId){
        Boolean d=getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }*/

}
