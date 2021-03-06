package com.example.madcompetition.backend.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConversationDatabaseOpenerHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    ConversationDatabaseContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    ConversationDatabaseContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ConversationDatabaseContract.FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_ACCOUNT_ID + " TEXT," +
                     ConversationDatabaseContract.FeedEntry.COLUMN_NAME_CONVERSATION_OBJECT + " NONE)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Conversation.db";

    public ConversationDatabaseOpenerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
