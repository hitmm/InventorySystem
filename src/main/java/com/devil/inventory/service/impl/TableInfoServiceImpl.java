package com.devil.inventory.service.impl;


import com.devil.inventory.dao.impl.TableInfoDAO;
import com.devil.inventory.model.common.PageEntity;
import com.devil.inventory.model.dao.entity.TableInfoEntity;
import com.devil.inventory.service.service.ITableInfoService;
import com.devil.inventory.service.utils.SerializeUtil;
import org.apache.lucene.util.RamUsageEstimator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/6/20-13:47
 *  
 */
@Component
public class TableInfoServiceImpl implements ITableInfoService {
    private final static Logger log = LoggerFactory.getLogger(TableInfoServiceImpl.class);

    @Autowired
    private TableInfoDAO tableInfoDAO;

    public TableInfoServiceImpl(TableInfoDAO tableInfoDAO) {
        this.tableInfoDAO = tableInfoDAO;
    }

    @Override
    public TableInfoEntity queryTableInfo(Long id) throws Exception {
        return tableInfoDAO.queryTableInfoById(id);
    }

    @Override
    public List<TableInfoEntity> queryTableInfoByUserId(Long userId, PageEntity page) throws Exception {
        return tableInfoDAO.queryTableInfoByUserId(userId, page);
    }

    @Override
    public Integer countTableInfo() throws Exception {
        return tableInfoDAO.countTableInfo();
    }

    @Override
    public Long insertTableInfo(TableInfoEntity entity) throws Exception {
        byte[] serialize = SerializeUtil.serialize(entity);
        long size = RamUsageEstimator.sizeOf(serialize);
        entity.setTableSize(size);
        log.info("entitySize : " + size);
        return tableInfoDAO.insertTableInfo(entity);
    }

    @Override
    public Long insertOrUpdateTableInfo(TableInfoEntity entity) throws Exception {
        return tableInfoDAO.updateOrInsertTableInfo(entity);
    }

    @Override
    public Long updateTableInfo(TableInfoEntity entity) throws Exception {
        return tableInfoDAO.updateTableInfo(entity);
    }

    @Override
    public void deleteTableInfo(Long id) throws Exception {
        tableInfoDAO.deleteTableInfo(id);
    }

    public void setTableInfoDAO(TableInfoDAO tableInfoDAO) {
        this.tableInfoDAO = tableInfoDAO;
    }
}
