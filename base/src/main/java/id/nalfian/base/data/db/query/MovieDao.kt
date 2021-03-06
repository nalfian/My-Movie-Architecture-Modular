package id.nalfian.base.data.db.query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.nalfian.base.data.db.entity.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(movies: List<Movie>)

    @Query("select * from movie")
    fun getMovie(): List<Movie>

}