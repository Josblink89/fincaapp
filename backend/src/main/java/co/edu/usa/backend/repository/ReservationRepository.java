package co.edu.usa.backend.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.backend.Interface.ReservationInterface;
import co.edu.usa.backend.model.Client;
import co.edu.usa.backend.model.Reservation;
import co.edu.usa.backend.reports.ClientReport;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface crud;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(Long id){
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    public void delete(Reservation reservation){
        crud.delete(reservation);
    }

    public List<Reservation> ReservacionStatus (String status){
        return crud.findAllByStatus(status);
    }
    
    public List<Reservation> ReservacionTiempo (Date a, Date b){
        return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
  
    public List<ClientReport> getTopClients(){
        List<ClientReport> res=new ArrayList<>();
        List<Object[]>report = crud.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new ClientReport((long)report.get(i)[1],(Client) report.get(i)[0] ));
        
        }
        return res;
    }
}