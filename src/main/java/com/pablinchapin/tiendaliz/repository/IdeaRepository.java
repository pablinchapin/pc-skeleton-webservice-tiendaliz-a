/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.tiendaliz.repository;

import com.pablinchapin.tiendaliz.model.Idea;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pvargas
 */
public interface IdeaRepository extends JpaRepository<Idea, Long>{
    
}
