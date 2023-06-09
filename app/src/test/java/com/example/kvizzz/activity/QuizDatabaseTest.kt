package com.example.kvizzz.activity

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.kvizzz.QuizDatabaseDao
import com.example.kvizzz.entity.CategoryEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class QuizDatabaseTest {

    private lateinit var quizDatabaseDao: QuizDatabaseDao
    private lateinit var db: QuizDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        quizDatabaseDao = db.quizDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetCategory() {
        val category = CategoryEntity()
        quizDatabaseDao.insert(category)
        val tonight = quizDatabaseDao.get(1)
        assertEquals(tonight?.added, true)
    }
}