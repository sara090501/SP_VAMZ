import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kvizzz.R
import com.example.kvizzz.data.Category
import com.example.kvizzz.data.CategoryViewModel
import com.example.kvizzz.databinding.FragmentAddCategoryBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddCategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAddCategoryBinding>(inflater,
            R.layout.fragment_add_category,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryViewModel = ViewModelProvider(requireActivity()).get(CategoryViewModel::class.java)

        val exit: ImageView = view.findViewById(R.id.exit)
        exit.setOnClickListener { requireActivity().finish() }

        val name: TextView = view.findViewById(R.id.fillCategoryName)

        val addCategory: Button = view.findViewById(R.id.addCategory)
        addCategory.setOnClickListener {
            if (isFieldEmpty(name.text.toString())) {
                val nameNotFilled = getString(R.string.nameNotFilled)
                name.error = nameNotFilled
                name.requestFocus()
            } else {
                showFinalAddCategoryDialog()
            }
        }
    }

    private fun insertDataToDatabase() {
        val name: TextView = requireView().findViewById(R.id.fillCategoryName)
//        val description: TextView = requireView().findViewById(R.id.fillCategoryDescription)

        val category = Category(0, name.text.toString(), "description.text.toString()")
        categoryViewModel.addCategory(category)
    }

    private fun showFinalAddCategoryDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.reallyAddCategory, "bla bla"))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yesAddCategory)) { _, _ ->
                categoryViewModel = ViewModelProvider(requireActivity()).get(CategoryViewModel::class.java)
                insertDataToDatabase()
                requireActivity().closeContextMenu()
                requireActivity().finish()
            }
            .setNegativeButton(getString(R.string.noAddCategory)) { _, _ ->
                requireActivity().closeContextMenu()
            }
            .show()
    }

    private fun isFieldEmpty(text: String): Boolean {
        return text.isEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
