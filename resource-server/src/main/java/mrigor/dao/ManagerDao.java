package mrigor.dao;

import mrigor.model.Manager;

import java.util.List;

/**
 * Created by Игорь on 18.07.2017.
 */
public interface ManagerDao {
    List<Manager> getAll();
    Manager get(int id);
    boolean delete(int id);
    Manager update(Manager manager);
    Manager create(Manager manager);
    Manager getByEmail(String email);
}
