package aguilera.code.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val room = Room.databaseBuilder(this, DataBase::class.java, "usuarios.db").build()

        lifecycleScope.launch {
            //INSERT---------------------------------------------------------------------------
            room.userDao().insertUser(User("Usuario1", "User1", "123"))
            //room.userDao().insertUser(User("Usuario2", "User2", "456"))
            //room.userDao().insertUser(User("Usuario3", "User3", "789"))
            getUsers(room)

            //UPDATE---------------------------------------------------------------------------
            room.userDao().updateUser(User("Usuario1", "User1", "1234"))
            getUsers(room)

            //DELETE---------------------------------------------------------------------------
            room.userDao().deleteUser(User("Usuario1", "User1", "1234"))
            getUsers(room)

            getUser(room, "Usuario2")

        }
    }

    suspend fun getUsers(room: DataBase) {
        val users = room.userDao().getUsers()
        //var usuario=room.daoUsuario().obtenerUsuario("User2")
        users.forEach {
            Log.i("miapp", "${it.user}, ${it.name}, ${it.password}")
        }
    }

    suspend fun getUser(room: DataBase, user: String) {
        val user = room.userDao().getUser("$user")
        Log.i("miapp", "${user?.name}, ${user?.user}, ${user?.password}")

    }
}