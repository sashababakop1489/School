package com.knubisoft.base.reflection.model;

public class InheritedEntryModel extends EntryModel {

    private String la;
    private String lala;
    private String lalala;
    private String lalalala;

    public InheritedEntryModel(String tableName) {
        super(tableName);
    }

    public InheritedEntryModel(String tableName, String schemaName) {
        super(tableName, schemaName);
    }

    public InheritedEntryModel(String tableName, String schemaName, String version) {
        super(tableName, schemaName, version);
    }

    @Override
    public EntryModel builder() {
        return super.builder();
    }
}
