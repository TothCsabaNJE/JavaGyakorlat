package com.example.javagyakorlat;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

public interface eredmenyRepo extends CrudRepository<eredmeny,Integer> {
    @Query("select eredmeny.datum, pilota.nev, gp.nev, eredmeny.helyezes,eredmeny.hiba,eredmeny.csapat, " +
            "eredmeny.tipus, eredmeny.motor from eredmeny INNER join gp ON eredmeny.datum=gp.datum INNER JOIN pilota ON eredmeny.pilotaaz=pilota.az")
    public List<eredmeny> findAllJoined();
}
