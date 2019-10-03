package com.shawn.ss.lib.tools.db.impl.data_source;


//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class MasterSlaveDataSource extends AbstractDataSource implements DataSource, InitializingBean {

    List<DataSource> rdDataSources;
    DataSource wrDataSource;
    ResourceSchedule schedule;
    TableStategy stategy;


    public List<DataSource> getRdDataSources() {
        return rdDataSources;
    }

    public void setRdDataSources(List<DataSource> rdDataSources) {
        this.rdDataSources = rdDataSources;
    }

    public DataSource getWrDataSource() {
        return wrDataSource;
    }

    public void setWrDataSource(DataSource wrDataSource) {
        this.wrDataSource = wrDataSource;
    }

    public ResourceSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ResourceSchedule schedule) {
        this.schedule = schedule;
    }

    private DataSource chooseDataSource() {
        int round = getRound();
        boolean isRead = ResourceSwitch.testIsRead();
        if(isRead) {
            if (testUnchangableTableStategy()) {
                logger.debug("changeless table detected use rd data source:"+round );
                return rdDataSources.get(round);
            } else if (!testVolatileTableStategy()) {
                boolean active = TransactionSynchronizationManager.isActualTransactionActive();
                if (active) {
                    boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
                    logger.debug("in spring transactions ,readonly:" + isReadOnly);
                    if (isReadOnly) {
//                        if (!isRead) {
//                            throw new IllegalArgumentException("readonly transaction can't be used to update/insert/delete");
//                        }
                        logger.debug("using rd data source " + round);
//                if (testUnchangableTableStategy())
                        return rdDataSources.get(round);
                    } else {
                        logger.debug("using wr data source");
//                return wrDataSource;
                    }
                } else {

//                    int round = getRound();
                        logger.debug("using rd data source " + round);
//                if (testUnchangableTableStategy())
                        return rdDataSources.get(round);

                }
            }else{
                logger.debug("volatile table detected use wr data source" );
            }
        } else {
            logger.debug("using wr data source");
//                return wrDataSource;
        }
        return wrDataSource;
    }

    private boolean testVolatileTableStategy() {
        if (stategy != null) {
            Set<String> volatileTable = stategy.getVolatileTable();
            return ResourceSwitch.testIsCheckedTableExistInSet(volatileTable);
        }
        return false;
    }

    private boolean testUnchangableTableStategy() {
        if (stategy != null) {
            Set<String> changeLessTable = stategy.getChangeLessTable();
            return ResourceSwitch.testIsAllCheckTableInSet(changeLessTable);
        }
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
//        schedule.getRound();
//        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();

        return chooseDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
//        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
//        if(active) {
//            boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
//            if(isReadOnly ){
//                if(!ResourceSwitch.testIsRead()){
//                    throw new IllegalArgumentException("readonly transaction can't be used to update/insert/delete");
//                }
//                int round = getRound();
//                logger.debug("using rd data source "+round);
//                return rdDataSources.get(round).getConnection(username,password);
//            }else{
//                return wrDataSource.getConnection(username,password);
//            }
//        }else {
//            if (ResourceSwitch.testIsRead()) {
//                int round = getRound();
//                logger.debug("using rd data source " + round);
//                return rdDataSources.get(round).getConnection(username,password);
//            } else {
//                logger.debug("using wr data source");
//                return wrDataSource.getConnection(username,password);
//            }
//        }
        return chooseDataSource().getConnection(username, password);
    }

    private int getRound() {
        int rdResourceHint = ResourceSwitch.getRdResourceHint();
        if (rdResourceHint < 0) {
            rdResourceHint = schedule.getRound();
            ResourceSwitch.setRdResourceHint(rdResourceHint);
        }
        //schedule.getRound();
        return rdResourceHint;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (wrDataSource == null) {
            throw new IllegalArgumentException("no writable data source setted");
        }
        if (rdDataSources == null || rdDataSources.size() == 0) {
            throw new IllegalArgumentException("no readable data source setted,consider using wr data source directly?");
        }
        if (schedule == null) {
            schedule = new RoundRobinSchedule(rdDataSources.size());
        }
        if(stategy!=null){
            ResourceSwitch.hasTableStategy =true;
        }
//        logger = LogFactory.getLog(MasterSlaveDataSource.class.getSimpleName());
    }

    public TableStategy getStategy() {
        return stategy;
    }

    public void setStategy(TableStategy stategy) {
        this.stategy = stategy;
    }
}
