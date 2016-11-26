/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.CarRegister.service;

import cz.muni.fi.pa165.CarRegister.dao.DriveDao;
import cz.muni.fi.pa165.CarRegister.entities.Drive;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Henrich
 */
@Service("driveService")
@Transactional
public class DriveServiceImpl implements DriveService
{
    @Inject
    private DriveDao driveDao;

    public void setCarDAO(DriveDao driveDao) {
        this.driveDao = driveDao;
    }
    
    @Override
    public Drive create(Drive drive)
    {
        driveDao.create(drive);
        return drive;
    }

    @Override
    public Drive update(Drive drive)
    {
        driveDao.update(drive);
        return drive;
    }

    @Override
    public void delete(Drive drive)
    {
        driveDao.delete(drive);
    }

    @Override
    public List<Drive> findAll()
    {
        return driveDao.findAll();
    }

    @Override
    public Drive findById(Long id)
    {
        return driveDao.findById(id);
    }   
}
