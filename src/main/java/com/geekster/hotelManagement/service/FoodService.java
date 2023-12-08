package com.geekster.hotelManagement.service;

import com.geekster.hotelManagement.model.AuthenticationToken;
import com.geekster.hotelManagement.model.Food;
import com.geekster.hotelManagement.repo.IFoodRepo;
import com.geekster.hotelManagement.repo.ITokenRepo;
import com.geekster.hotelManagement.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;

    @Autowired
    ITokenRepo tokenRepo;

    public void addFood(List<Food> food, String token) {
        AuthenticationToken token1 = tokenRepo.findFirstByToken(token);
        if(token1.getUser().getRole().getRoleId()==1){
            foodRepo.saveAll(food);
        }
    }

    public void deleteFood(Long id, String token) {
        AuthenticationToken token1 = tokenRepo.findFirstByToken(token);
        if(token1.getUser().getRole().getRoleId()==1){
            foodRepo.deleteById(id);
        }
    }

    public List<Food> getAllFood(String foodName) {
        if(foodName==null){
            return foodRepo.findAll();
        }else{

            return foodRepo.findByFoodName(foodName);
        }
    }
}
