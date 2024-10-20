package com.ergegananputra.jetpack_compose.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ergegananputra.jetpack_compose.domain.dao.PhotoDao
import com.ergegananputra.jetpack_compose.domain.entities.room.Photo

@Database(
    entities = [
        Photo::class
               ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatbase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "jc_database"
                )
                    .fallbackToDestructiveMigration() // TODO: Sesuaikan dengan kebutuhan
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}