package com.fone.fonetesting.levelsdata

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.fone.fonetesting.architecture_components.MatchWordGame
import com.fone.fonetesting.architecture_components.MatchWordGameDao

class MatchWordsLevelsData(private val matchWordGameDao: MatchWordGameDao) {

    var levels_data = ArrayList<ArrayList<String>>()
    val level_completed : LiveData<List<Boolean>> = matchWordGameDao.getAllLevels()

    var nivel = ArrayList<String>()


    init {
        nivel.add("pa")
        nivel.add("ta")
        nivel.add("ap")
        nivel.add("la")
        //level_completed.add(false)

        //matchWordGameDao.insert(MatchWordGame(false))

        addLevel()

        nivel.add("pra")
        nivel.add("tla")
        nivel.add("apa")
        nivel.add("lalo")
        //level_completed.add(false)

        addLevel()

        nivel.add("prosa")
        nivel.add("porsa")
        nivel.add("lata")
        nivel.add("lala")
        //level_completed.add(false)

        addLevel()


    }

    /*suspend fun levelCompleted(): List<Boolean>{
        return matchWordGameDao.getAllLevels()
    }*/

    fun getLevelInfo(level: Int): ArrayList<String> {
        return levels_data[level]
    }

    fun addLevel() {
        levels_data.add(nivel.clone() as ArrayList<String>)
        //level_completed.add(false)

        nivel.clear()
    }

    @WorkerThread
    suspend fun insert(game: MatchWordGame){
        matchWordGameDao.insert(game)
    }

    @WorkerThread
    suspend fun nukeTable(){
        matchWordGameDao.nukeTable()
    }

    /*companion object {


        var instance: MatchWordsLevelsData? = null

        fun newInstance(matchWordGameDao: MatchWordGameDao): MatchWordsLevelsData? {
            if (instance != null) {
                return instance
            } else {

                instance = MatchWordsLevelsData(matchWordGameDao)
                return instance
            }
        }
    }*/
}