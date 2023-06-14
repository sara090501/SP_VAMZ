import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kvizzz.data.Category
import com.example.kvizzz.data.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

//    val getAllCategories: LiveData<MutableList<Category>> = categoryRepository.getAllCategories()

    fun getCategory(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.getCategory(id)
        }
    }

    fun addCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.addCategory(category)
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.deleteCategory(category)
        }
    }
}
