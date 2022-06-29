package aguilera.code.roomexample

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user")
    var user: String,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "password")
    var password: String?

)

