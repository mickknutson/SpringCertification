package com.baselogic.tutorials.domain;

//import org.eclipse.persistence.config.DescriptorCustomizer;
//import org.eclipse.persistence.config.SessionCustomizer;
//import org.eclipse.persistence.descriptors.ClassDescriptor;
//import org.eclipse.persistence.descriptors.DescriptorEvent;
//import org.eclipse.persistence.descriptors.DescriptorEventAdapter;
//import org.eclipse.persistence.queries.InsertObjectQuery;
//import org.eclipse.persistence.queries.WriteObjectQuery;
//import org.eclipse.persistence.sessions.Session;
//import org.eclipse.persistence.sessions.changesets.ChangeRecord;
//import org.eclipse.persistence.sessions.changesets.DirectToFieldChangeRecord;

import java.util.Calendar;
import java.util.List;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Audit Listener
 * @since 2012
 *
 *  see org.eclipse.persistence.descriptors.DescriptorEventAdapter
 *  see org.eclipse.persistence.config.SessionCustomizer
 *  see org.eclipse.persistence.config.DescriptorCustomizer
 */
public class AuditListener
        //extends DescriptorEventAdapter
        //implements SessionCustomizer, DescriptorCustomizer
{
    public static ThreadLocal currentUser = new ThreadLocal();

    /** This will audit a specific class. */
//    @Override
//    public void customize(ClassDescriptor descriptor) {
//        descriptor.getEventManager().addListener(this);
//    }

    /** This will audit all classes. */
//    @Override
//    public void customize(Session session) {
//        for (ClassDescriptor descriptor : session.getDescriptors().values()) {
//            customize(descriptor);
//        }
//    }

//    @Override
//    public void aboutToInsert(DescriptorEvent event) {
//        processEvent(event, AuditOperation.INSERT_OPERATION);
//    }
//
//    @Override
//    public void aboutToUpdate(DescriptorEvent event) {
//        processEvent(event, AuditOperation.UPDATE_OPERATION);
//    }
//
//    @Override
//    public void aboutToDelete(DescriptorEvent event) {
//        processEvent(event, AuditOperation.DELETE_OPERATION);
//    }

//    @SuppressWarnings("unchecked")
//    public void processEvent(DescriptorEvent event, AuditOperation operation) {
//        Calendar calendar = Calendar.getInstance();
//        for (String table : (List<String>) event.getDescriptor().getTableNames()) {
//            event.getRecord().put(table + "." + JpaConstants.AUDIT_USER, (String) AuditListener.currentUser.get());
//            event.getRecord().put(table + "." + JpaConstants.AUDIT_TIMESTAMP, calendar);
//            if (operation == AuditOperation.UPDATE_OPERATION) {
//                processWriteEvent(event, operation, calendar, table);
//            } else {
//                processAuditEvent(event, operation, calendar, table);
//            }
//        }
//        calendar = null;
//    }
//
//    protected void processAuditEvent(DescriptorEvent event,
//                                     AuditOperation operation,
//                                     Calendar calendar,
//                                     String tableName) {
//        AuditEntry entry = createAuditEntry(event, operation, calendar, tableName);
//        InsertObjectQuery insertQuery = new InsertObjectQuery(entry);
//        event.getSession().executeQuery(insertQuery);
//    }
//
//    protected void processWriteEvent(DescriptorEvent event,
//                                     AuditOperation operation,
//                                     Calendar calendar,
//                                     String tableName) {
//        AuditEntry entry = createAuditEntry(event, operation, calendar, tableName);
//
//        Collection<AuditField> fields = new LinkedList<AuditField>();
//        WriteObjectQuery query = (WriteObjectQuery) event.getQuery();
//        List<ChangeRecord> changes = query.getObjectChangeSet().getChanges();
//
//        for (ChangeRecord change : changes) {
//            if (change instanceof DirectToFieldChangeRecord) {
//                DirectToFieldChangeRecord fieldChange = (DirectToFieldChangeRecord) change;
//                AuditField field = new AuditField();
//                field.setAuditEntry(entry);
//                field.setFieldName(fieldChange.getAttribute());
//                field.setFieldValue(fieldChange.getNewValue().toString());
//                fields.add(field);
//            }
//        }
//
//        entry.setFields(fields);
//
//        InsertObjectQuery insertQuery = new InsertObjectQuery(entry);
//        event.getSession().executeQuery(insertQuery);
//
//        for (AuditField field : fields) {
//            insertQuery = new InsertObjectQuery(field);
//            event.getSession().executeQuery(insertQuery);
//        }
//    }
//
//    protected AuditEntry createAuditEntry(DescriptorEvent event,
//                                          AuditOperation operation,
//                                          Calendar calendar,
//                                          String tableName) {
//        AuditEntry entry = new AuditEntry();
//        entry.setAuditUser((String) AuditListener.currentUser.get());
//        entry.setOperation(operation);
//        entry.setOperationTime(calendar);
//        entry.setEventId(Long.valueOf(event.getSource().hashCode()));
//        entry.setTableName(tableName);
//        return entry;
//    }

}
