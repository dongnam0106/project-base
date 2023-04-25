package com.mon.projectbase.service.exportpdf;

public enum ExampleHeader implements Header {
    NAME("Name", "name", 2f, ""),
    CREATED_AT("Created Date", "createdAt", 2f, ""),
    UPDATED_AT("Update Date", "updatedAt", 2f, "");
    private final String japaneseName;
    private final String objectFieldName;
    private final float width;
    private final String appendString;

    ExampleHeader(String japaneseName, String objectFieldName, float width, String appendString) {
        this.japaneseName = japaneseName;
        this.objectFieldName = objectFieldName;
        this.width = width;
        this.appendString = appendString;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getObjectFieldName() {
        return objectFieldName;
    }

    public float getWidth() {
        return width;
    }

    public String getAppendString() {
        return appendString;
    }
}