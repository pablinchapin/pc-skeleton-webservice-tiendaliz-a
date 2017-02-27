/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.controller;

import com.pablinchapin.tiendaliz.model.Idea;
import com.pablinchapin.tiendaliz.repository.IdeaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */
@RestController
@RequestMapping("/api/ideas")
public class IdeaController {
    
    @Autowired
    private IdeaRepository ideaRepository;
    
    
    //CREATE
    @RequestMapping(
            method = RequestMethod.POST
    )
    public Idea add(@RequestBody Idea idea){
        Idea model = new Idea();
        model.setCreatedAt(new Date());
        model.setTitle(idea.getTitle());
        model.setDescription(idea.getDescription());
        
        return ideaRepository.saveAndFlush(model);
    }
    
    //READ
    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Idea> findAll(){
        return ideaRepository.findAll();
    }
    
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public Idea findOne(@PathVariable long id){
        return ideaRepository.findOne(id);
    }
    
    //UPDATE
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT
    )
    public Idea update(@PathVariable long id, @RequestBody Idea idea){
        Idea model = ideaRepository.findOne(id);
        if(model != null){
            model.setTitle(idea.getTitle());
            model.setDescription(idea.getDescription());
            //model.setCreatedAt(idea.getCreatedAt());
            return ideaRepository.saveAndFlush(model);
        }
    return null;
    }
    
    
    //DELETE
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable long id){
        ideaRepository.delete(id);
    }
    
}
