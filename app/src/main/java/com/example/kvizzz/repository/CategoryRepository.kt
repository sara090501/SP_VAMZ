package com.example.kvizzz.repository

import android.app.Application
import com.example.kvizzz.activity.QuizDatabase
import com.example.kvizzz.dao.CategoryDao
import com.example.kvizzz.entity.CategoryEntity

class CategoryRepository(application: Application) {
    private val mWordDao: CategoryDao
//    private val mAllWords: LiveData<List<CategoryEntity>>

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    init {
        val db = QuizDatabase.getDatabase(application)
        mWordDao = db.categoryDao()
//        mAllWords = mWordDao.getAlphabetizedWords()
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    fun getAllWords(): LiveData<List<Word>> {
//        return mAllWords
//    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    fun insert(category: CategoryEntity) {
        QuizDatabase.databaseWriteExecutor.execute {
            mWordDao.insert(category)
        }
    }
}